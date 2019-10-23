package com.example.projectshop;

import java.util.ArrayList;
import java.util.List;

public class Person {
    //private int id;
    private String name;
    private String description;
    private int imageID;
    private String dateOfBirth;
    Person(String _name, String _description, String _dateOfBirth, int _imageID){
        //this.id=_id;
        this.name = _name;
        this.dateOfBirth = _dateOfBirth;
        this.description = _description;
        this.imageID = _imageID;
    }
    //public int getID() {return id;}
    public String getName(){ return name;}
    public String getDescription(){return description;}
    public int getImage(){return imageID;}
    public String getDateOfBirth(){return  dateOfBirth;}


}
