package dev.dawidlachor.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;

/**
 * Create by Dawid Lachor on 23/06/2020
 */
public class ControlPaneController {
    @FXML
    private Button previousButton;

    @FXML
    private ToggleButton playButton;

    @FXML
    private Button nextButton;

    @FXML
    private Slider volumeSlider;

    @FXML
    private Slider progressSlider;

    @FXML
    private TextField messageTextField;

    public Slider getVolumeSlider() {
        return volumeSlider;
    }

    public Slider getProgressSlider() {
        return progressSlider;
    }

    public Button getPreviousButton() {
        return previousButton;
    }

    public ToggleButton getPlayButton() {
        return playButton;
    }

    public Button getNextButton() {
        return nextButton;
    }

    public TextField getMessageTextField() {
        return messageTextField;
    }

    public void initialize() {
        System.out.println("Control controller created");
        configureButtons();
        configureVolume();
        configureSliders();
    }

    private void configureVolume() {
        volumeSlider.addEventFilter(MouseEvent.MOUSE_PRESSED, event ->
                System.out.println("Wciśnięto przycisk na suwaku głośności")
        );
    }
    private void configureSliders() {
        volumeSlider.valueProperty().addListener((observable, oldValue, newValue) ->
                System.out.println("Zmiana głośności " + newValue.doubleValue())
        );

        progressSlider.valueProperty().addListener(x ->
                System.out.println("Przesunięcie piosenki")
        );
    }

    private void configureButtons() {
        previousButton.setOnAction(event -> System.out.println("Poprzednia piosenka"));
        nextButton.setOnAction(x -> System.out.println("Następna piosenka"));
        playButton.setOnAction(event -> {
            if(playButton.isSelected()) {
                System.out.println("Play");
            } else {
                System.out.println("Stop");
            }
        });
    }
}
