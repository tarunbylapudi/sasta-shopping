package com.team.sastashoppingbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.sastashoppingbackend.entity.Image;
import com.team.sastashoppingbackend.service.ImageService;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping
    public List<Image> getAllImages() {
        return imageService.getAllImages();
    }

    @GetMapping("/{id}")
    public Image getImageById(@PathVariable Long id) {
        return imageService.getImageById(id);
    }

    @PostMapping
    public Image createImage(@RequestBody Image image) {
        return imageService.createImage(image);
    }

    @PutMapping("/{id}")
    public Image updateImage(@PathVariable Long id, @RequestBody Image imageDetails) {
        return imageService.updateImage(id, imageDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }

}
