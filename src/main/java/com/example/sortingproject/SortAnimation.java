package com.example.sortingproject;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class SortAnimation {
    public static final Color NODE_ORI_COLOR = Color.BLUE;
    private static final Color NODE_SORTED_COLOR = Color.MAROON;
    private static final Color FINISH_SORTED_COLOR = Color.SKYBLUE;

    // this field to manage all the transition animations
    public SequentialTransition st;

    private TranslateTransition moveX(int x, Node node) {
        TranslateTransition translation = new TranslateTransition();
        translation.setNode(node);
        translation.setDuration(Duration.millis(1000 / AlgorithmController.SPEED));
        translation.setByX(x);
        return translation;
    }
    private FillTransition fillTransition(Node node, Color color) {
        FillTransition f = new FillTransition();
        f.setShape(node);
        f.setToValue(color);
        f.setDuration(Duration.millis(AlgorithmController.SPEED));
        return f;
    }
    public void swap(int index1, int index2, Node[] nodes) {
        int X = AlgorithmController.PANE_WIDTH / AlgorithmController.NUM_OF_NODES;
        ParallelTransition p = new ParallelTransition();
        int dx = index2 - index1;
        p.getChildren().addAll(moveX(X * dx, nodes[index1]), moveX(-X * dx, nodes[index2]));
        Node temp = nodes[index1];
        nodes[index1] = nodes[index2];
        nodes[index2] = temp;
        st.getChildren().addAll(p);
    }

    public void colorAllNodes(Node[] nodes) {
        ParallelTransition p = new ParallelTransition();
        for (Node node: nodes) {
            p.getChildren().addAll(fillTransition(node, FINISH_SORTED_COLOR));
        }
        st.getChildren().addAll(p);
    }
    public void colorNodeFromIdx(Node[] nodes, int i, int j) {
        ParallelTransition p = new ParallelTransition();
        while (i <= j) {
            p.getChildren().addAll(fillTransition(nodes[i], NODE_SORTED_COLOR));
            i++;
        }
        st.getChildren().addAll(p);
    }
    public void colorSingleNode (Node node, Color color) {
        st.getChildren().add(fillTransition(node, color));
    }

}
