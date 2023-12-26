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

public class UpdateController {
    @FXML
    private Label lblMessage;

    @FXML
    private TextField tfUpdate, tfDate, tfTime, tfSubject, tfDescription, tfLocation;
    @FXML
    private MenuButton mbMain;
    public void Insert(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Insert.fxml"));
        Stage window=(Stage)mbMain.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        window.setScene(scene);
        window.setTitle("Insert Window");
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



    @FXML
    public void handleUpdateButton(ActionEvent actionevent) throws Exception {
        if (tfUpdate.getText().length() == 0) {
            lblMessage.setText("**Please Enter Subject to Update**");
            return;
        }

        FileReader fread = new FileReader("ToDoList.txt");
        BufferedReader bread = new BufferedReader(fread);
        boolean found = false;
        String lines;
        while ((lines = bread.readLine()) != null) {
            if (lines != null) {
                String[] array = lines.split(", ");
                if (array.length == 5) {
                    if (tfUpdate.getText().equalsIgnoreCase(array[2])) {
                        String oldString = array[0] + ", " + array[1] + ", " + array[2] + ", " + array[3] + ", " + array[4] + ", ";

                        bread.close();

                        if (tfDate.getText().length() == 0 || tfDescription.getText().length() == 0 || tfLocation.getText().length() == 0 || tfTime.getText().length() == 0
                                || tfSubject.getText().length() == 0) {
                            lblMessage.setText("*PLease Fill all the fields*");
                            return;
                        }


                        String newString = tfDate.getText() + ", " + tfTime.getText() + ", " + tfSubject.getText() + ", " + tfDescription.getText() + ", " + tfLocation.getText() + ", ";
                        File fileToBeModified = new File("ToDoList.txt");
                        String oldContent = "";
                        BufferedReader reader = null;
                        FileWriter writer = null;
                        reader = new BufferedReader(new FileReader(fileToBeModified));
                        //Reading all the lines of input text file into oldContent
                        String line = reader.readLine();
                        while (line != null) {
                            oldContent = oldContent + line + System.lineSeparator();
                            line = reader.readLine();
                        }
                        String newContent = oldContent.replaceAll(oldString, newString);
                        //Rewriting the input text file with newContent
                        writer = new FileWriter(fileToBeModified);
                        writer.write(newContent);

                        Alert a = new Alert(Alert.AlertType.INFORMATION);
                        //a.setHeaderText("");
                        a.setContentText("Data Updated Successfully!...");
                        a.show();

                        reader.close();
                        writer.close();

                    }
                } else {
                    System.out.println("Data is not approppriate");
                }
            }
        }
        if (!found) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            //a.setHeaderText("");
            a.setContentText("No Such Data Found!");
            a.show();
        }
    }
    }
