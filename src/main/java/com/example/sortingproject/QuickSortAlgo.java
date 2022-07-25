package com.example.sortingproject;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;

public class QuickSortAlgo extends AlgorithmController {
    private static final Color PIVOT_COLOR = Color.CRIMSON;

    @Override
    public void startSort(ActionEvent event) {
        whenPlaying();
        quickSort(0, nodes.length - 1);
        colorAllNodes(nodes);
        st.play();
        st.getChildren().clear();
    }
    @Override
    public void stopSort(ActionEvent event) {
        whenPause();
        st.pause();
    }
    public void quickSort(int low, int high) {
        if (low < high) {
            int pivotIdx = partition(low, high);
            colorSingleNode(nodes[pivotIdx], NODE_ORI_COLOR);
            quickSort(low, pivotIdx - 1);
            colorNodeFromIdx(nodes, low, pivotIdx - 1);
            quickSort(pivotIdx + 1, high);
            colorNodeFromIdx(nodes,pivotIdx + 1, high);
        }
    }
    // TODO: add randomly pick pivot feature later instead to just pick the last index as pivot
    public int partition(int low, int high) {
        int curPivotIdx = high;
        colorSingleNode(nodes[curPivotIdx], PIVOT_COLOR);
        high--;
        while (low <= high) {
            if (nodes[low].getValue() > nodes[curPivotIdx].getValue()) {
                if (nodes[high].getValue() <= nodes[curPivotIdx].getValue()) {
                    swap(low, high, nodes);
                }
                else high--;
            }
            else low++;
        }
        swap(low, curPivotIdx, nodes);
        return low;
    }

}
