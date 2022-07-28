package com.example.sortingproject;

import javafx.event.ActionEvent;

public class MergeSortAlgo extends AlgorithmController {
    @Override
    public void startSort(ActionEvent event) {
        whenPlaying();
        mergeSort(0, nodes.length - 1);
        colorAllNodesAtSorted(nodes);
        st.play();
        st.getChildren().clear();
    }

    @Override
    public void stopSort(ActionEvent event) {
        whenPause();
        st.pause();
    }

    private void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    private void merge(int left, int mid, int right) {
        int leftPortionSize = mid - left + 1;
        int rightPortionSize = right - mid;

        Node[] sceneNodeUnsorted = new Node[leftPortionSize + rightPortionSize];

        Node[] leftPortionNodes = new Node[leftPortionSize];
        for (int i = 0; i < leftPortionSize; i++) {
            leftPortionNodes[i] = nodes[i + left];
            sceneNodeUnsorted[i] = leftPortionNodes[i];
        }
        Node[] rightPortionNodes = new Node[rightPortionSize];
        for (int i = 0; i < rightPortionSize; i++) {
            rightPortionNodes[i] = nodes[i + (mid + 1)];
            sceneNodeUnsorted[i + leftPortionSize] = rightPortionNodes[i];
        }

        int i = 0, j = 0, k = left;
        while (i < leftPortionSize && j < rightPortionSize) {
            if (leftPortionNodes[i].getValue() < rightPortionNodes[j].getValue()) {
                nodes[k] = leftPortionNodes[i];
                i++;
            } else {
                nodes[k] = rightPortionNodes[j];
                j++;
            }
            k++;
        }
        while (i < leftPortionSize) {
            nodes[k] = leftPortionNodes[i];
            i++;
            k++;
        }
        while (j < rightPortionSize) {
            nodes[k] = rightPortionNodes[j];
            j++;
            k++;
        }

        colorAllNodes(sceneNodeUnsorted, NODE_ORI_COLOR);
//        quickSort(0, sceneNodeUnsorted.length - 1, sceneNodeUnsorted);

        // an alter way, but not efficient
        for (int unsortedIdx = 0; unsortedIdx < sceneNodeUnsorted.length; unsortedIdx++) {
            if (!sceneNodeUnsorted[unsortedIdx].equals(nodes[unsortedIdx + left])) {
                for (int idxJ = unsortedIdx + 1; idxJ < sceneNodeUnsorted.length; idxJ++) {
                    if (sceneNodeUnsorted[unsortedIdx].equals(nodes[idxJ + left])) {
                        swap(unsortedIdx, idxJ, sceneNodeUnsorted);
                        unsortedIdx--;
                        break;
                    }
                }
            }
        }
        colorAllNodes(sceneNodeUnsorted, NODE_SORTED_COLOR);
    }

    private void quickSort(int low, int high, Node[] sceneNodeUnsorted) {
        if (low < high) {
            int pivotIdx = partition(low, high, sceneNodeUnsorted);
            quickSort(low, pivotIdx - 1, sceneNodeUnsorted);
            quickSort(pivotIdx + 1, high, sceneNodeUnsorted);
        }
    }

    private int partition(int low, int high, Node[] sceneNodeUnsorted) {
        int curPivotIdx = low;
        low = curPivotIdx + 1;
        while (low <= high) {
            if (sceneNodeUnsorted[low].getValue() > sceneNodeUnsorted[curPivotIdx].getValue()) {
                if (sceneNodeUnsorted[high].getValue() <= sceneNodeUnsorted[curPivotIdx].getValue()) {
                    if (!sceneNodeUnsorted[high].equals(sceneNodeUnsorted[curPivotIdx]))
                        swap(low, high, sceneNodeUnsorted);
                } else high--;
            } else low++;
        }
        if (!sceneNodeUnsorted[high].equals(sceneNodeUnsorted[curPivotIdx]))
            swap(high, curPivotIdx, sceneNodeUnsorted);
        return high;
    }
}

