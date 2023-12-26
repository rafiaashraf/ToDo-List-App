package com.example.assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class InsertController {
    private ArrayList<ToDoList> al = new ArrayList<ToDoList>();
    private int i=-1;
    @FXML
    private TextField tfDate,tfTime,tfDescription,tfLocation,tfSubject;
    @FXML
    private Label lblMessage;

    @FXML
    private MenuButton mbMain;

    @FXML
    private void initialize() throws IOException {
        reset();
    }

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


    public void handleResetButton(ActionEvent e){
        reset();

    }

    public void handleOkButton(ActionEvent e) throws IOException {
        if(tfDate.getText().length()==0||tfDescription.getText().length()==0||tfLocation.getText().length()==0||tfTime.getText().length()==0
                ||tfSubject.getText().length()==0)
        {
            lblMessage.setText("****PLease Fill all the fields****");
            return;
        }
        FileWriter fwrite = new FileWriter("ToDoList.txt", true);

        fwrite.write(tfDate.getText()+", ");
        fwrite.write(tfTime.getText() + ", ");
        fwrite.write(tfSubject.getText()+ ", ");
        fwrite.write(tfDescription.getText() + ", ");
        fwrite.write(tfLocation.getText()+ ", ");
        fwrite.write("\n");
        fwrite.close();
        Alert a=new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText("Inserted");
        a.setContentText("Data Added Successfully");
        a.show();

    }
    public void reset()
    {
        tfDate.setText("");
        tfDescription.setText("");
        tfTime.setText("");
        tfSubject.setText("");
        tfLocation.setText("");
    }

}