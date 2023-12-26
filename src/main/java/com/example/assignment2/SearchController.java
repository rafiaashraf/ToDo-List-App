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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchController {
    @FXML
    private TextField tfSearch;
    @FXML
    private Label lblTime,lblDate,lblDescription,lblLocation,lblSubject,lblMessage;
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


    public void handleEnterButton(ActionEvent actionEvent) throws IOException {
        if(tfSearch.getText().length()==0)
        {
            lblMessage.setText("****Please Enter Subject to Search****");
            return;
        }
        FileReader fread = new FileReader("ToDoList.txt");
        BufferedReader bread = new BufferedReader(fread);
        boolean found = false;
        String line;
        while ((line = bread.readLine()) != null) {
            if (line != null) {
                String[] array = line.split(", ");
                if (array.length == 5) {
                    if (tfSearch.getText().equalsIgnoreCase(array[2])) {
                        lblDate.setText(array[0]);
                        lblTime.setText(array[1]);
                        lblSubject.setText(array[2]);
                        lblDescription.setText(array[3]);
                        lblLocation.setText(array[4]);

                        found = true;
                    }
                } else {
                    System.out.println("Data is not approppriate");
                }

            }
        }
        if (!found){
            Alert a=new Alert(Alert.AlertType.INFORMATION);
            //a.setHeaderText("");
            a.setContentText("No Such Data Found!");
            a.show();
        }

        bread.close();
    }
}
