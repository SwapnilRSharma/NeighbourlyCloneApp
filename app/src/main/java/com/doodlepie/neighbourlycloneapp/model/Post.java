package com.doodlepie.neighbourlycloneapp.model;

public class Post {

    private String Location;
    private String message;
    private String Name2;
    private String Likes;
    private String Name;


    public Post(String name, String location, String message, String name2, String likes) {
        Name = name;
        Location = location;
        this.message = message;
        Name2 = name2;
        Likes = likes;
    }



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName2() {
        return Name2;
    }

    public void setName2(String name2) {
        Name2 = name2;
    }

    public String getLikes() {
        return Likes;
    }

    public void setLikes(String likes) {
        Likes = likes;
    }


}
