package com.example.sortingproject;

import javafx.event.ActionEvent;
import javafx.scene.paint.Color;

public class InsertionSortAlgo extends AlgorithmController {
    private static final Color CURRENT_COMPARE_NODE = Color.CRIMSON;
    @Override
    public void startSort(ActionEvent event) {
        whenPlaying();
        insertionSort();
        colorAllNodesAtSorted(nodes);
        st.play();
        st.getChildren().clear();
    }
    @Override
    public void stopSort(ActionEvent event) {
        whenPause();
        st.pause();
    }

    public void insertionSort() {
        for (int curIdx = 1; curIdx < nodes.length; curIdx++) {
            colorSingleNode(nodes[curIdx], CURRENT_COMPARE_NODE);
            int i = curIdx - 1;
            Node curNode = nodes[curIdx];
            while (i >= 0 && curNode.getValue() < nodes[i].getValue()) {
                swap(i + 1, i, nodes);
                colorNodeFromIdx(nodes,i + 1, curIdx, NODE_SORTED_COLOR);
                i--;
            }
            colorNodeFromIdx(nodes,0, curIdx, NODE_ORI_COLOR);
        }
    }
}
