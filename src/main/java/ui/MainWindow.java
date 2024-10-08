package ui;

import bot.Chicken;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Chicken chicken;

    private final Image userImage = new Image(this.getClass().getResourceAsStream("/images/guy2.png"));
    private final Image chickenImage = new Image(this.getClass().getResourceAsStream("/images/guy1.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /** Injects the Chicken instance */
    public void setChicken(Chicken chicken1) {
        chicken = chicken1;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Chcickens's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = chicken.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getChickenDialog(response, chickenImage)
        );
        userInput.clear();
    }
}
