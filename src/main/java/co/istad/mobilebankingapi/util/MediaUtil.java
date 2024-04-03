package co.istad.mobilebankingapi.util;

import org.springframework.web.multipart.MultipartFile;

public class MediaUtil {
    public static String extractExtension(String name){
        int lastDotIndex = name
                .lastIndexOf(".");

        return name
         .substring(lastDotIndex + 1);
    }
}
