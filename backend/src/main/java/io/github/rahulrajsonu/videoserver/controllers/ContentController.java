package io.github.rahulrajsonu.videoserver.controllers;

import io.github.rahulrajsonu.videoserver.services.ContentService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/content/video")
@AllArgsConstructor
public class ContentController {

    private ContentService contentService;

    @PostMapping()
    public ResponseEntity<String> saveVideo(@RequestParam("file") MultipartFile file, @RequestParam("name") String name) throws IOException {

        contentService.saveVideo(file, name);
        return ResponseEntity.ok("Video saved successfully.");

    }

    @GetMapping("{name}")
    public ResponseEntity<Resource> getVideoByName(@PathVariable("name") String name){

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new ByteArrayResource(contentService.getVideo(name).getData()));

    }

    @GetMapping("all")
    public ResponseEntity<List<String>> getAllVideoNames(){

        return ResponseEntity
                .ok(contentService.getAllVideoNames());

    }

}
