package com.example.assignment2;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class DisplayController implements Initializable {
    @FXML
    private ListView lv;
    @FXML
    private TableView<ToDoList> table;
    @FXML
    private TableColumn<ToDoList,String> tcDate;
    @FXML
    private TableColumn<ToDoList,String> tcLocation;
    @FXML
    private TableColumn<ToDoList,String>tcTime;
    @FXML
    private TableColumn<ToDoList,String> tcSubject;
    @FXML
    private TableColumn<ToDoList,String>tcDescription;
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



    public  ArrayList<ToDoList> list = new ArrayList<ToDoList>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            FileReader fread = new FileReader("ToDoList.txt");
            BufferedReader bread = new BufferedReader(fread);

            String line;
            while ((line = bread.readLine()) != null) {
                if (line != null) {
                    String[] array = line.split(", ");
                    list.add(new ToDoList(array[0]+"   ", array[1]+"   ", array[2]+"   ", array[3]+"   ", array[4]+"   "));
                }
            }
        }
        catch(Exception e) {

        }
        lv.getItems().clear();
        lv.getItems().addAll(list);



    }}


