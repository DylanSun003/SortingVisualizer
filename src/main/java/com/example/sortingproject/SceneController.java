package com.example.sortingproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController extends Application {
    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;

    public static void main(String[] args) {
        launch();
    }

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
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMergeSortScene(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("MergeSort.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void switchToBubbleSortScene(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("BubbleSort.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void switchToInsertionSortScene(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("InsertionSort.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSelectionSortScene(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("SelectionSort.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}