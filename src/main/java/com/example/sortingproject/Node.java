package com.example.sortingproject;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.Random;

public class Node extends Rectangle {
    private int val;
    public Node(int n) {
        val = n;
    }

    public int getValue() {
        return val;
    }

    public TranslateTransition moveX(int x) {
        TranslateTransition translation = new TranslateTransition();
        translation.setNode(this);
        translation.setDuration(Duration.millis(AlgorithmController.SPEED));
        translation.setByX(x);
        return translation;
    }
    public static Node[] GenerateRandomNodes(int len) {
        Node[] nodes = new Node[len];
        Random randomer = new Random();
        for (int i = 0; i < len; i++) {
            nodes[i] = new Node(1 + randomer.nextInt(len));
            nodes[i].setX(i * (500 / nodes.length) + 5);
            nodes[i].setFill(Color.BLUE);
            setNodeDim(nodes[i], nodes.length);
        }
        return nodes;
    }

    public static void setNodeDim(Node nodes, int len) {
        nodes.setWidth(600 / len - AlgorithmController.X_GAP);
        nodes.setHeight(((500 - 100) / len) * nodes.getValue());
    }

    public static void swap(int index1, int index2, Node[] nodes) {
        Node temp = nodes[index1];
        nodes[index1] = nodes[index2];
        nodes[index2] = temp;
    }
}

