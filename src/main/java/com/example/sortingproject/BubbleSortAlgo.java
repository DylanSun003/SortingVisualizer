package com.example.sortingproject;

import javafx.event.ActionEvent;

public class BubbleSortAlgo extends AlgorithmController {
    @Override
    public void startSort(ActionEvent event) {
        start.setDisable(true);
        pause.setDisable(false);
        System.out.println("Bubble sort!");
    }
    @Override
    public void stopSort(ActionEvent event) {
        start.setDisable(false);
        pause.setDisable(true);
        System.out.println("stop! Bubble sort!");
    }
}
