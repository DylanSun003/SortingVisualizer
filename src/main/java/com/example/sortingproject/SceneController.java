package com.example.sortingproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneController extends Application {
    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;

//    @FXML
//    private ComboBox<String> choiceAlg;

//    private final String[] algos = {"Quick Sort", "Merge Sort"};

//    public void initialize(URL arg0, ResourceBundle arg1) {
//        choiceAlg.getItems().addAll(algos);
//        choiceAlg.setOnAction(this::setChoicePage);
//    }
//    public void setChoicePage(ActionEvent event) {
//        if (choiceAlg.getValue() == "Quick Sort")
//            try {
//                switchToQuickSortScene(event);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//
//    }

    public static void main(String[] args) {launch();}

    @Override
    public void start(Stage stage) throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.setTitle("Sorting Visualizer");
        stage.setScene(scene);
        stage.show();
    }

    public void switchToQuickSortScene(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("QuickSort.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
    public void switchToMergeSortScene(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("MergeSort.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
    public void switchToBubbleSortScene(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("BubbleSort.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}