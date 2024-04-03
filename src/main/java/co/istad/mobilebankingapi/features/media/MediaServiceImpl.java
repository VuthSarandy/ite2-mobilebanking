package co.istad.mobilebankingapi.features.media;

import co.istad.mobilebankingapi.features.media.dto.MediaResponse;
import co.istad.mobilebankingapi.util.MediaUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class MediaServiceImpl implements MediaService {

    @Value("${media.server-path}")
    private String serverPath;

    @Value("${media.base-uri}")
    private String baseUri;


    @Override
    public MediaResponse uploadSingle(MultipartFile file, String folderName) {

        // Generate new unique name for file upload
        String newName = UUID.randomUUID().toString();

        // Extract extension from file upload
        // Assume profile.png
        int lastDotIndex = file.getOriginalFilename()
                .lastIndexOf(".");
        String extension = file.getOriginalFilename()
                .substring(lastDotIndex + 1);
        log.info("Extension: {}",extension);
        newName = newName + "." + extension;
        log.info("New name : {}",newName);

        // Copy file to server
        Path path = Paths.get(serverPath + folderName + "/" + newName );
        try {
            Files.copy(file.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getLocalizedMessage());
        }

        return MediaResponse.builder()
                .name(newName)
                .contentType(file.getContentType())
                .extension(extension)
                .size(file.getSize())
                .uri(String.format("%s%s/%s", baseUri, folderName, newName))
                .build();

    }

    @Override
    public List<MediaResponse> uploadMultiple(List<MultipartFile> files, String folderName) {

        List<MediaResponse> mediaResponses = new ArrayList<>();
        files.stream()
                .forEach(file -> {
                    MediaResponse mediaResponse = this.uploadSingle(file,folderName);
                    mediaResponses.add(mediaResponse);
                });

        return mediaResponses;
    }

    @Override
    public MediaResponse loadMediaByName(String mediaName, String folderName) {
        Path path = Paths.get(serverPath+folderName+"/"+mediaName);

        log.info("load path : {}",path.getFileName());

        try {
            Resource resource = new UrlResource(path.toUri());

            log.info("load resource : ",resource.getFilename());

            if(!resource.exists()){
                throw  new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Media not found!"
                );
            }

            return MediaResponse.builder()
                    .name(mediaName)
                    .contentType(Files.probeContentType(path))
                    .extension(MediaUtil.extractExtension(mediaName))
                    .size(resource.contentLength())
                    .uri(String.format("%s%s/%s", baseUri, folderName, mediaName))
                    .build();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public MediaResponse deleteMediaByName(String mediaName, String folderName) {
        Path path = Paths.get(serverPath+folderName+"/"+mediaName);

        log.info("load path : {}",path.getFileName());
        try {
            if (!Files.deleteIfExists(path)){
                throw  new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Media not found!"
                );
            }

            return MediaResponse.builder()
                    .name(mediaName)
                    .contentType(Files.probeContentType(path))
                    .extension(MediaUtil.extractExtension(mediaName))
                    .uri(String.format("%s%s/%s", baseUri, folderName, mediaName))
                    .build();

        } catch (IOException e) {
            throw  new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getLocalizedMessage()
            );
        }

    }

    @Override
    public List<MediaResponse> getAllMedia(String folderName) {
        return null;
    }

    @Override
    public ResponseEntity downloadMediaByName(String mediaName, String folderName) {
        Path path = Paths.get(serverPath + folderName + "\\" + mediaName);
        try {
            Resource resource = new UrlResource(path.toUri());
            if(!resource.exists()){
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Media has not been found!!"
                );
            }
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + mediaName);
            headers.add(HttpHeaders.CONTENT_TYPE, Files.probeContentType(path));
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(resource.contentLength())
                    .body(resource);
        } catch (MalformedURLException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    e.getLocalizedMessage()
            );
        } catch (IOException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    e.getLocalizedMessage()
            );
        }
    }
}
