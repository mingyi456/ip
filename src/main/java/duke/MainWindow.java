package duke;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private GUI gui;

    private Image userImage = new Image("file:./DaUser.png");
    private Image dukeImage = new Image("file:./DaDuke.png");

    private static final String WELCOME_MESSAGE = "Welcome! I am Dude.";

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    public void setGUI(GUI g) {
        gui = g;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply
     * and then appends them to the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        if (input.strip() == "") {
            return;
        }
        String response = gui.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getDukeDialog(response, dukeImage)
        );
        userInput.clear();
    }

    public void welcome() {
        dialogContainer.getChildren().addAll(
                DialogBox.getDukeDialog(MainWindow.WELCOME_MESSAGE, dukeImage));
    }

    public static void main(String[] args) {
        Launcher.main(args);
    }
}