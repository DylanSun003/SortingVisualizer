package com.example.sortingproject;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;

public class QuickSortAlgo extends AlgorithmController {
    private static final Color PIVOT_COLOR = Color.CRIMSON;

    @Override
    public void startSort(ActionEvent event) {
        whenPlaying();
        quickSort(0, nodes.length - 1);
        colorAllNodesAtSorted(nodes);
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
            colorNodeFromIdx(nodes, low, pivotIdx - 1, NODE_SORTED_COLOR);
            quickSort(pivotIdx + 1, high);
            colorNodeFromIdx(nodes,pivotIdx + 1, high, NODE_SORTED_COLOR);
        }
    }
    // TODO: add randomly pick pivot feature later instead to just pick the last index as pivot
    public int partition(int low, int high) {
        int curPivotIdx = (low + high) / 2;
        colorSingleNode(nodes[curPivotIdx], PIVOT_COLOR);
        while (low <= high) {
            if (nodes[low].getValue() > nodes[curPivotIdx].getValue()) {
                if (nodes[high].getValue() <= nodes[curPivotIdx].getValue()) {
                    swap(low, high, nodes);
                    if (low == curPivotIdx) curPivotIdx = high;
                    else if (high == curPivotIdx) curPivotIdx = low;
                }
                else high--;
            }
            else low++;
        }
        swap(high, curPivotIdx, nodes);
        return high;
    }

}
