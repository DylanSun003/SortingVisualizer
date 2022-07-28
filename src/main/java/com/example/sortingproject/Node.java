package com.example.sortingproject;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.sortingproject.AlgorithmController.*;

public class Node extends Rectangle {
    private int val;

    public Node(int n) {
        val = n;
    }

    public int getValue() {
        return val;
    }

    public static Node[] GenerateRandomNodes(int len) {
        Node[] nodes = new Node[len];
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i < len + 1; i++) nums.add(i);
        Collections.shuffle(nums);
        for (int i = 0; i < len; i++) {
            nodes[i] = new Node(nums.get(i));
            nodes[i].setX(i * (PANE_WIDTH / nodes.length) + X_GAP);
            nodes[i].setFill(NODE_ORI_COLOR);
            setNodeDim(nodes[i], nodes.length);
        }
        return nodes;
    }

    public static void setNodeDim(Node node, int len) {
        node.setWidth(PANE_WIDTH / len - X_GAP);
        node.setHeight(((PANE_HEIGHT) / len) * node.getValue());
    }

}

