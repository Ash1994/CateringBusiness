package com.catering.in.CateringBusinessLogin.menu_gallery.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "menu_gallery")
@Setter
@Getter
public class Gallery
{
    @Id
    private String id;
    private String title;
    private Binary image;
    private String menu_name;
    private String serve_stage_list;
}
