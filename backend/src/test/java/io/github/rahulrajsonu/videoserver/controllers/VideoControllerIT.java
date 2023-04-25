package io.github.rahulrajsonu.videoserver.controllers;

import io.github.rahulrajsonu.videoserver.services.VideoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import static org.mockito.Mockito.*;

@SpringBootTest
class VideoControllerIT {

    @Autowired
    VideoController controller;
    @Autowired
    VideoService service;
    MultipartFile file = mock(MultipartFile.class);

    @Test
    void saveVideo(){

        

    }

}