package com.example.sortingproject;

import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;

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

    public void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    public void merge(int left, int mid, int right) {
        // use to record the index of the removed node;
        List<Integer> sceneNodeToBeRemoveIdx = new ArrayList<>();

        int leftPortionSize = mid - left + 1;
        int rightPortionSize = right - mid;

        Node[] sceneNodeUnsorted = new Node[leftPortionSize + rightPortionSize];

        Node[] leftPortionNodes = new Node[leftPortionSize];
        for (int i = 0; i < leftPortionSize; i++) {

//            colorNodesWithTime(nodes[i + left], Color.OLIVE, 5);
            leftPortionNodes[i] = nodes[i + left];
            System.out.println("nodeS: " + nodes.length);
            System.out.println("unos: " + sceneNodeUnsorted.length);
            System.out.println(i + left);
            sceneNodeUnsorted[i] = leftPortionNodes[i];

//            sceneNodeToBeRemoveIdx.add(i + left);
        }
        Node[] rightPortionNodes = new Node[rightPortionSize];
        for (int i = 0; i < rightPortionSize; i++) {
//            colorNodesWithTime(nodes[mid + 1], Color.CRIMSON, 5);
            rightPortionNodes[i] = nodes[i + (mid + 1)];
            sceneNodeUnsorted[i + leftPortionSize] = rightPortionNodes[i];

//            sceneNodeToBeRemoveIdx.add(i + (mid + 1));
        }

        int i = 0, j = 0, k = left;
        while (i < leftPortionSize && j < rightPortionSize) {
            if (leftPortionNodes[i].getValue() <= rightPortionNodes[j].getValue()) {
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

//        // record all the sorted node so that we can add it back to the pane
//        Node[] allTempSortedNode = new Node[leftPortionSize + rightPortionSize];
//        for (int sortedIdx = 0; sortedIdx < sceneNodeToBeRemoveIdx.size(); sortedIdx++)
//            allTempSortedNode[sortedIdx] = nodes[sortedIdx];
//        removeOldNodesAndAddSortedNodes(left, sceneNodeToBeRemoveIdx, allTempSortedNode);
    }

//    private void removeOldNodesAndAddSortedNodes(int start, List<Integer> sceneNodeToBeRemoveIdx, Node[] allTempSortedNode) {
//        // get all node previously so that we can locate the new nodes
//        int totalNodes = pane.getChildren().size();
//
//        // now remove all nodes
//        for (int i = sceneNodeToBeRemoveIdx.size() - 1; i >= 0; i--) {
//            int curRemoveIdx = sceneNodeToBeRemoveIdx.get(i) - start;
//            colorNodesWithTime(nodes[curRemoveIdx], Color.OLIVE, 5);
//            pane.getChildren().remove(curRemoveIdx);
//        }
//        // generate new nodes
//        Node[] nodes = GenerateNodesByList(allTempSortedNode.length, start, allTempSortedNode, totalNodes);
//
//        // add new nodes to the pane at front
//        for (int i = 0; i < nodes.length; i++) {
//            pane.getChildren().add(i, nodes[i]);
//            colorNodesWithTime((Node) pane.getChildren().get(i), NODE_SORTED_COLOR, 5.0);
//        }
//
//    }
}

