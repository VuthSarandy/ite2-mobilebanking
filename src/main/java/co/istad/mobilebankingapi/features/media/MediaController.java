package co.istad.mobilebankingapi.features.media;

import co.istad.mobilebankingapi.features.media.dto.MediaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medias")
@RequiredArgsConstructor
public class MediaController {
    private final MediaService mediaService;

    @PostMapping("upload-single")
    MediaResponse uploadSingle(@RequestPart MultipartFile file){
        return mediaService.uploadSingle(file, "image");
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/upload-multiple")
    List<MediaResponse> uploadMultiple(@RequestPart List<MultipartFile> files ){
        return mediaService.uploadMultiple(files,"image");
    }
    @GetMapping("/{mediaName}")
    public MediaResponse loadMediaByName(@PathVariable String mediaName){
        return mediaService.loadMediaByName(mediaName,"image");
    }

    @DeleteMapping("/{mediaName}")
    MediaResponse deleteMediaByName(@PathVariable String mediaName){
        return mediaService.deleteMediaByName(mediaName, "image");
    }
    @GetMapping
    List<MediaResponse> findAllMedia(){
        return mediaService.getAllMedia("image");
    }
    @GetMapping("/download/{name}")
    ResponseEntity downloadByName (@PathVariable String name) {
        return mediaService.downloadMediaByName(name , "image");
    }
}
