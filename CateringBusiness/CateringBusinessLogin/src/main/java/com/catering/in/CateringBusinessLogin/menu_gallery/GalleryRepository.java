package com.catering.in.CateringBusinessLogin.menu_gallery;

import com.catering.in.CateringBusinessLogin.menu_gallery.model.Gallery;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GalleryRepository extends MongoRepository<Gallery, String>
{ }
