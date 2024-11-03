package com.example.wordle.controller;

import com.example.wordle.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class PopUpController {
    @FXML
    private Label RightWord;

    public void setMessage(String msg) {
        RightWord.setText(" ");
        RightWord.setText(msg);
        RightWord.setStyle("-fx-text-fill: white");
    }

    @FXML
    public void restartButton() throws IOException {
        Application.restart();
    }
}
