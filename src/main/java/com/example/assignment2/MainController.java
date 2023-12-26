package com.example.assignment2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class MainController{
    public static ArrayList<ToDoList> al = new ArrayList<ToDoList>();
    private int i=-1;
    @FXML
    private void initialize() throws IOException {
        File file = new File("ToDoList.txt");
        //  System.out.println(file.getAbsolutePath());
        file.createNewFile();   //creates a file
        FileReader fread = new FileReader("ToDoList.txt");
        BufferedReader bread = new BufferedReader(fread);

        //read the existing data from file and store it in array list
        String line;
        while((line = bread.readLine())!=null){
            if(line!=null)
            {
                String[] array = line.split(", ");
                if(array.length==5)
                {
                    al.add(new ToDoList(array[0], array[1], array[2], array[3], array[4]));
                    i++;
                }
            }

        }
        bread.close();


    }
    @FXML
    private MenuItem miInsert,miUpdate,miDisplay,miSearch,miRemove;
    @FXML
    private MenuButton mbMain;
    public void Insert(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Insert.fxml"));
        Stage window=(Stage)mbMain.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        window.setScene(scene);
        window.setTitle("Insert Window");
        // window.setScene(scene);
        window.show();
    }

    public void Update(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Update.fxml"));
        Stage window=(Stage)mbMain.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        window.setScene(scene);
        window.setTitle("Update Window");
        // window.setScene(scene);
        window.show();
    }

    public void Display(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Display1.fxml"));
        Stage window=(Stage)mbMain.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        window.setScene(scene);
        window.setTitle("Display Window");
        // window.setScene(scene);
        window.show();

    }

    public void Search(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Search.fxml"));
        Stage window=(Stage)mbMain.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        window.setScene(scene);
        window.setTitle("Search Window");
        // window.setScene(scene);
        window.show();
    }

    public void Remove(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Remove.fxml"));
        Stage window=(Stage)mbMain.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        window.setScene(scene);
        window.setTitle("Remove Window");
        // window.setScene(scene);
        window.show();
    }



}