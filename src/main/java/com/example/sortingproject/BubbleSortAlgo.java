package com.example.sortingproject;

import javafx.event.ActionEvent;
import javafx.scene.paint.Color;

public class BubbleSortAlgo extends AlgorithmController {
    private static final Color CURRENT_COMPARE_NODE = Color.CRIMSON;

    @Override
    public void startSort(ActionEvent event) {
        whenPlaying();
        bubbleSort();
        colorAllNodesAtSorted(nodes);
        st.play();
        st.getChildren().clear();
    }

    @Override
    public void stopSort(ActionEvent event) {
        whenPause();
        st.pause();
    }

    private void bubbleSort() {
        int lastIdx = nodes.length - 1;
        while (lastIdx >= 0) {
            int left = 0, right = left + 1;
            while (left < lastIdx) {
                colorSingleNode(nodes[left], CURRENT_COMPARE_NODE);
                colorSingleNode(nodes[right], CURRENT_COMPARE_NODE);
                if (nodes[left].getValue() >= nodes[right].getValue())
                    swap(left, right, nodes);
                colorSingleNode(nodes[left], NODE_ORI_COLOR);
                colorSingleNode(nodes[right], NODE_ORI_COLOR);
                left++;
                right = left + 1;
            }
            colorSingleNode(nodes[lastIdx], NODE_SORTED_COLOR);
            lastIdx--;
        }
    }
}
