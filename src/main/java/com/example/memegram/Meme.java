package com.example.memegram;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Meme {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @NotNull
    private String headline;

    @NotNull
    private String description;

    @NotNull
    private String headline2;


    private String image;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHeadline2() {
        return headline2;
    }

    public void setHeadline2(String headline2) {
        this.headline2 = headline2;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    //MEMEgram is a site that will allow a user to upload an image and add a caption to display above and below the image.


//You can download images at http://memebetter.com/generator (Links to an external site.)Links to an external site..
//Descriptions greater than 20 characters shall show 20 characters followed by an ellipsis
//Use Bootstrap or appropriate use of style sheets to make the site look professional




}

