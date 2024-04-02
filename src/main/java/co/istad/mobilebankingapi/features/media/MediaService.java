package co.istad.mobilebankingapi.features.media;

import co.istad.mobilebankingapi.features.media.dto.MediaResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MediaService {
    MediaResponse uploadSingle(MultipartFile file , String folderName);
}
