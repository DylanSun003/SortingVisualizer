package com.example.sortingproject;

import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.List;

import static com.example.sortingproject.Node.swap;

public class QuickSortAlgo extends AlgorithmController {
    private static final Color PIVOT_COLOR = Color.CRIMSON;
    private List<Transition> transitions;
    @Override
    public void startSort(ActionEvent event) {
        start.setDisable(true);
        pause.setDisable(false);
        System.out.println("Quick sort!");
        for (Node node : nodes) {
            System.out.println(node.getValue());
        }
        quickSort(0, nodes.length - 1);
        for (Node node : nodes) {
            System.out.println(node.getValue());
        }
    }
    @Override
    public void stopSort(ActionEvent event) {
        start.setDisable(false);
        pause.setDisable(true);
        System.out.println("stop! Quick sort!");
    }

    public void quickSort(int low, int high) {
        if (low < high) {
            int pivotIdx = partition(low, high);
            quickSort(low, pivotIdx - 1);
            quickSort(pivotIdx + 1, high);
        }
    }
    // TODO: add randomly pick pivot feature later instead to just pick the last index as pivot
    public int partition(int low, int high) {
        int curPivot = high;
        high--;
        while (low <= high) {
            if (nodes[low].getValue() > nodes[curPivot].getValue()) {
                if (nodes[high].getValue() <= nodes[curPivot].getValue()) {
                    swap(low, high, nodes);
                }
                else high--;
            }
            else low++;
        }
        swap(low, curPivot, nodes);
        return low;
    }

}
