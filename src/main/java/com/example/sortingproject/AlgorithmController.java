package com.example.sortingproject;

import javafx.animation.SequentialTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import static com.example.sortingproject.Node.GenerateRandomNodes;

abstract public class AlgorithmController extends SortAnimation implements Initializable {
    public static final int X_GAP = 3;
    public static int NUM_OF_NODES = 20;
    public static int SPEED = 5;

    public Node nodes[];
    @FXML
    private Pane pane;
    @FXML
    public Button start;
    @FXML
    public Button pause;
    @FXML
    public Button reset;
    @FXML
    public Label speedLabel;
    @FXML
    public Slider speedSlider;
    @FXML
    public Slider nodeNumSlider;
    @FXML
    public Label nodeNumLabel;

    final static int PANE_WIDTH = 700;
    final static int PANE_HEIGHT = 430;

    abstract public void startSort(ActionEvent event);

    abstract public void stopSort(ActionEvent event);

    public void switchToMainScene(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        st = new SequentialTransition();
        generator();
        reset.setVisible(false);
        pause.setDisable(true);
        start.setOnAction(this::startSort);
        pause.setOnAction(this::stopSort);

        speedLabel.setText("Speed: " + SPEED);
        nodeNumLabel.setText("Node#: " + NUM_OF_NODES);
        speedSlider.setValue(SPEED);
        nodeNumSlider.setValue(NUM_OF_NODES);
        speedSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                SPEED = (int) speedSlider.getValue();
                speedLabel.setText("Speed: " + SPEED);
            }
        });
        nodeNumSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                NUM_OF_NODES = (int) nodeNumSlider.getValue();
                nodeNumLabel.setText("Node#: " + NUM_OF_NODES);
                generator();
            }
        });
        st.setOnFinished(this::stFinishEvent);
    }

    public void stFinishEvent(ActionEvent event) {
        reset.setVisible(true);
        start.setVisible(false);
        pause.setVisible(false);
        reset.setOnAction(this::resetEvent);
    }

    public void resetEvent(ActionEvent event) {
        reset.setVisible(false);
        generator();
        start.setVisible(true);
        pause.setVisible(true);
        start.setDisable(false);
        pause.setDisable(true);
        speedSlider.setDisable(false);
        nodeNumSlider.setDisable(false);
    }

    public void whenPlaying() {
        start.setDisable(true);
        pause.setDisable(false);
        speedSlider.setDisable(true);
        nodeNumSlider.setDisable(true);
    }

    public void whenPause() {
        start.setDisable(false);
        pause.setDisable(true);
        speedSlider.setDisable(true);
        nodeNumSlider.setDisable(true);
    }

    public void generator() {
        pane.getChildren().clear();
        nodes = GenerateRandomNodes(NUM_OF_NODES);
        pane.getChildren().addAll(Arrays.asList(nodes));
    }
}
