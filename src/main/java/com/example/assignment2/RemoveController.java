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
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveController {
    @FXML
    private TextField tfDelete;
    @FXML
    private Label lblMessage;
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



    public void handleDeleteButton(ActionEvent actionEvent) throws IOException {
        if(tfDelete.getText().length()==0){
            lblMessage.setText("****Subject Required****");
            return;
        }
        FileReader fread = new FileReader("ToDoList.txt");
        BufferedReader bread = new BufferedReader(fread);
        boolean found = false;
        String _line;
        while ((_line = bread.readLine()) != null) {
            if (_line != null) {
                String[] array = _line.split(", ");
                if (array.length == 5) {
                    if (tfDelete.getText().equalsIgnoreCase(array[2])) {
                        found = true;
                        break;
                    }
                } else {
                    System.out.println("Data is not approppriate");
                }

            }

        }
        Alert a=new Alert(Alert.AlertType.INFORMATION);
        if (found) {
            File file = new File("ToDoList.txt");
            List<String> out = Files.lines(file.toPath())
                    .filter(line -> !line.contains(tfDelete.getText()))
                    .collect(Collectors.toList());
            Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            a.setContentText("Data Deleted Successfully");

        } else
            a.setContentText("No Such Data Found");
        a.show();
        bread.close();


    }
}
