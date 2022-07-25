package com.example.sortingproject;

import javafx.event.ActionEvent;

public class MergeSortAlgo extends AlgorithmController {
    @Override
    public void startSort(ActionEvent event) {
        whenPlaying();
        System.out.println("Merge sort!");
    }
    @Override
    public void stopSort(ActionEvent event) {
        whenPause();
        System.out.println("stop! Merge sort!");
    }
}
