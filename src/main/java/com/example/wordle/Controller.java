package com.example.wordle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    private TextField guessInput;
    // riga 0
    @FXML
    private Label box00 = new Label();
    @FXML
    private Label box01 = new Label();
    @FXML
    private Label box02 = new Label();
    @FXML
    private Label box03 = new Label();
    @FXML
    private Label box04 = new Label();
    // riga 1
    @FXML
    private Label box10 = new Label();
    @FXML
    private Label box11 = new Label();
    @FXML
    private Label box12 = new Label();
    @FXML
    private Label box13 = new Label();
    @FXML
    private Label box14 = new Label();
    // riga 2
    @FXML
    private Label box20 = new Label();
    @FXML
    private Label box21 = new Label();
    @FXML
    private Label box22 = new Label();
    @FXML
    private Label box23 = new Label();
    @FXML
    private Label box24 = new Label();
    // riga 3
    @FXML
    private Label box30 = new Label();
    @FXML
    private Label box31 = new Label();
    @FXML
    private Label box32 = new Label();
    @FXML
    private Label box33 = new Label();
    @FXML
    private Label box34 = new Label();
    // riga 4
    @FXML
    private Label box40 = new Label();
    @FXML
    private Label box41 = new Label();
    @FXML
    private Label box42 = new Label();
    @FXML
    private Label box43 = new Label();
    @FXML
    private Label box44 = new Label();
    // riga 5
    @FXML
    private Label box50 = new Label();
    @FXML
    private Label box51 = new Label();
    @FXML
    private Label box52 = new Label();
    @FXML
    private Label box53 = new Label();
    @FXML
    private Label box54 = new Label();

    @FXML
    private Label DebugLabel;

    private Player player;
    private Word word;
    int row;

    public void initialize() {
        player = new Player();
        word = new Word();
        DebugLabel.setText("Write here a word");
        row = 0;
    }

    //Button click event
    @FXML
    protected void checkGuess() throws IOException {
        Label[] row = {box00, box01, box02, box03, box04};
        Label[][] matrix = {
                {box00, box01, box02, box03, box04},
                {box10, box11, box12, box13, box14},
                {box20, box21, box22, box23, box24},
                {box30, box31, box32, box33, box34},
                {box40, box41, box42, box43, box44},
                {box50, box51, box52, box53, box54}};
        String guess = guessInput.getText();
        if(!player.isOutOfIndex()){
            if(guess.length() != word.getWord().length()){
                DebugLabel.setText("Incorrect string length!");
            }
            else{   // Lunghezza della parola inserita corretta
                DebugLabel.setText("Write here a word");
                player.addAttempts(word.getWord(), guess);
                Attempt currentAttempt = player.getAttempts().get(player.getAttempts().size()-1);
                for(int i = 0; i < currentAttempt.getResult().length(); i++){
                    String letter = guess.substring(i,i+1);
                    row[i].setText(letter);
                    if(currentAttempt.getResult().charAt(i) == 'G'){    //lettera presente in posizione corretta
                        row[i].setStyle("-fx-background-color: #02a302");
                    }
                    else if(currentAttempt.getResult().charAt(i) == 'Y'){    //lettera presente in posizione errata
                        row[i].setStyle("-fx-background-color: #d9d904");
                    }
                    else if(currentAttempt.getResult().charAt(i) == 'R'){    //lettera assente
                        row[i].setStyle("-fx-background-color: white");
                    }
                }
                if(word.checkMatch(guess)){
                    DebugLabel.setText("Right Word");
                    FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/com/example/wordle/win-popup.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = new Stage();
                    stage.setTitle("WIN");
                    stage.setScene(scene);
                    stage.show();
                }
            }
        }
        else{
            DebugLabel.setText("Number of attempt out of bound!!");
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/com/example/wordle/lose-popup.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("LOST");
            stage.setScene(scene);
            stage.show();
        }
    }
}