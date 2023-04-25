package io.github.rahulrajsonu.videoserver.services;

import io.github.rahulrajsonu.videoserver.domain.Video;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface VideoService {
    Video getVideo(String name);

    void saveVideo(MultipartFile file, String name) throws IOException;

    List<String> getAllVideoNames();
}
