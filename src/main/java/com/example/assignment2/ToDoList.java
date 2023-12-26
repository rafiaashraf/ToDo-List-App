package com.example.assignment2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;


public class ToDoList {


    private String date;
    private String time;
    private String subject;
    private String description;
    private String location;

    //constructor to initialize the data memmbers
    public ToDoList(String _date, String _time, String _subject, String _description, String _location) {
        this.date = _date;
        this.time = _time;
        this.subject = _subject;
        this.description = _description;
        this.location = _location;
    }



    public String toString() {
        return date + ", " + time + ", " + subject + ", " + description + ", " + location + ", ";
    }

}
