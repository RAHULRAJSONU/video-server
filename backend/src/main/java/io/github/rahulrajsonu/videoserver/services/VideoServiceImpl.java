package io.github.rahulrajsonu.videoserver.services;

import io.github.rahulrajsonu.videoserver.exceptions.VideoAlreadyExistsException;
import io.github.rahulrajsonu.videoserver.exceptions.VideoNotFoundException;
import io.github.rahulrajsonu.videoserver.domain.Video;
import io.github.rahulrajsonu.videoserver.repo.VideoRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class VideoServiceImpl implements VideoService {

    private VideoRepo repo;

    @Override
    public Video getVideo(String name) {
        if(!repo.existsByName(name)){
            throw new VideoNotFoundException();
        }
        return repo.findByName(name);
    }

    @Override
    public List<String> getAllVideoNames() {
        return repo.getAllEntryNames();
    }

    @Override
    public void saveVideo(MultipartFile file, String name) throws IOException {
        if(repo.existsByName(name)){
            throw new VideoAlreadyExistsException();
        }
        Video newVid = new Video(name, file.getBytes());
        repo.save(newVid);
    }

}
