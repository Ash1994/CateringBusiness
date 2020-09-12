package com.catering.in.CateringBusinessLogin.menu_gallery;

import com.catering.in.CateringBusinessLogin.menu_gallery.model.Gallery;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class GalleryService
{
    @Autowired
    private GalleryRepository galleryRepository;

    public String createGallery(Gallery gallery, MultipartFile file) throws IOException {
        gallery.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        gallery = galleryRepository.insert(gallery);
        return gallery.getId();
    }

    public Gallery getGallery(String id) {
        return galleryRepository.findById(id).get();
    }
}
