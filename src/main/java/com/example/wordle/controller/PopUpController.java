package com.example.wordle.controller;

import com.example.wordle.Application;
import javafx.fxml.FXML;

import java.io.IOException;

public class PopUpController {

    @FXML
    public void restartButton() throws IOException {
        Application.restart();
    }
}
