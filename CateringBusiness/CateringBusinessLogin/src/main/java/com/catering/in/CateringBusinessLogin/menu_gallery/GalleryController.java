package com.catering.in.CateringBusinessLogin.menu_gallery;

import com.catering.in.CateringBusinessLogin.menu_gallery.model.Gallery;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;

@Controller
public class GalleryController
{
    @Autowired
    GalleryService galleryService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/gallery/add")
    public ResponseEntity<?> addGallery(
            @RequestParam(value = "gallery", required = false) String gallery,
            @RequestParam("image") MultipartFile image) throws IOException {

        Gallery galleryObj = objectMapper.readValue(gallery, Gallery.class);
        String id = galleryService.createGallery(galleryObj, image);
        return new ResponseEntity("Gallery Record added successfully with ID - " + id, HttpStatus.OK);
    }

    @GetMapping("/gallery/{id}")
    public ResponseEntity<?> getGallery(@PathVariable String id) {
        Gallery gallery = galleryService.getGallery(id);
        return new ResponseEntity(gallery, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/galleryImage/{id}")
    public ResponseEntity<?> getGalleryImage(@PathVariable String id) {
        Gallery gallery = galleryService.getGallery(id);
        String b = Base64.getEncoder().encodeToString(gallery.getImage().getData());
        return new ResponseEntity(b.getBytes(), new HttpHeaders(), HttpStatus.OK);
    }
}
