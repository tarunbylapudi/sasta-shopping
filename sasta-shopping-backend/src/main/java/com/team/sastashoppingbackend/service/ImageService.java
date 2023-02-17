package com.team.sastashoppingbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.sastashoppingbackend.entity.Image;
import com.team.sastashoppingbackend.exception.ResourceNotFoundException;
import com.team.sastashoppingbackend.repository.ImageRepository;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    public Image getImageById(Long id) {
        return imageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Image", "id", id));
    }

    public Image createImage(Image image) {
        return imageRepository.save(image);
    }

    public Image updateImage(Long id, Image imageDetails) {
        Image image = getImageById(id);
        image.setName(imageDetails.getName());
        image.setType(imageDetails.getType());
        image.setBytes(imageDetails.getBytes());
        image.setProduct(imageDetails.getProduct());
        return imageRepository.save(image);
    }

    public void deleteImage(Long id) {
        Image image = getImageById(id);
        imageRepository.delete(image);
    }

}
