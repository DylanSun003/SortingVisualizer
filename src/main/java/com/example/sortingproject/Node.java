package com.example.sortingproject;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

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
        Random randomer = new Random();
        for (int i = 0; i < len; i++) {
            nodes[i] = new Node(1 + randomer.nextInt(len));
            nodes[i].setX(i * (PANE_WIDTH / nodes.length) + X_GAP);
            nodes[i].setFill(NODE_ORI_COLOR);
            setNodeDim(nodes[i], nodes.length);
        }
        return nodes;
    }

    public static void setNodeDim(Node nodes, int len) {
        nodes.setWidth(PANE_WIDTH / len - X_GAP);
        nodes.setHeight(((PANE_HEIGHT) / len) * nodes.getValue());
    }

}

