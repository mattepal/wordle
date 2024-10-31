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
    @FXML
    private Label DebugLabel;

    private Player player;
    private Word word;

    public void initialize() {
        player = new Player();
        word = new Word();
        DebugLabel.setText("Write here a word");

    }

    //Button click event
    @FXML
    protected void checkGuess() throws IOException {
        Label[] row = {box00, box01, box02, box03, box04};
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