package com.example.sortingproject;

import javafx.event.ActionEvent;

public class MergeSortAlgo extends AlgorithmController {
    @Override
    public void startSort(ActionEvent event) {
        start.setDisable(true);
        pause.setDisable(false);
        System.out.println("Merge sort!");
    }
    @Override
    public void stopSort(ActionEvent event) {
        start.setDisable(false);
        pause.setDisable(true);
        System.out.println("stop! Merge sort!");
    }
}
