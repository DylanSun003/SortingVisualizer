package com.example.sortingproject;

import javafx.animation.PathTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

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

    public static Node[] GenerateNodesByList(int len, int startIdx, Node[] nodesArr, int totalNodeSize) {
        Node[] nodes = new Node[len];
        for (int i = 0; i < len; i++) {

            nodes[i] = new Node(nodesArr[i].getValue());
            nodes[i].setX(startIdx * (PANE_WIDTH / totalNodeSize) + X_GAP);
            startIdx++;
            nodes[i].setFill(NODE_ORI_COLOR);
            setNodeDimByOldNode(nodes[i], nodesArr[i]);
        }
        return nodes;
    }

    public static void setNodeDimByOldNode(Node node, Node oldNode) {
        node.setWidth(oldNode.getWidth());
        node.setHeight(oldNode.getHeight());
    }

    public static void setNodeDim(Node node, int len) {
        node.setWidth(PANE_WIDTH / len - X_GAP);
        node.setHeight(((PANE_HEIGHT) / len) * node.getValue());
    }

}

