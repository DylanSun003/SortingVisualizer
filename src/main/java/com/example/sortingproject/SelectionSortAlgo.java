package com.example.sortingproject;

import javafx.event.ActionEvent;
import javafx.scene.paint.Color;

public class SelectionSortAlgo extends AlgorithmController {
    private static final Color CURRENT_MIN_NODE = Color.CRIMSON;

    @Override
    public void startSort(ActionEvent event) {
        whenPlaying();
        SelectionSort();
        colorAllNodesAtSorted(nodes);
        st.play();
        st.getChildren().clear();
    }

    @Override
    public void stopSort(ActionEvent event) {
        whenPause();
        st.pause();
    }

    private void SelectionSort() {
        for (int i = 0; i < nodes.length; i++) {
            int curSortIdx = i;
            int curMinValIdx = i;
            colorSingleNode(nodes[curMinValIdx], CURRENT_MIN_NODE);
            for (int j = i + 1; j < nodes.length; j++) {
                if (nodes[curMinValIdx].getValue() > nodes[j].getValue()) {
                    colorSingleNode(nodes[curMinValIdx], NODE_ORI_COLOR);
                    curMinValIdx = j;
                    colorSingleNode(nodes[curMinValIdx], CURRENT_MIN_NODE);
                }
            }
            swap(curSortIdx, curMinValIdx, nodes);
            colorNodeFromIdx(nodes, 0, curSortIdx, NODE_SORTED_COLOR);
        }
    }
}
