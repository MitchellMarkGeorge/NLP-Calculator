/**
 * This class represents the View of the application. This includes the TextField and Label nodes. 
 * It also exposes methods for the Controller to use in conjunction with the View
* @author Mitchell Mark-George
 */

//All neccessary imports
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class View extends VBox {

    private TextField textField = new TextField();
    private Label label = new Label("0");

    
    //Constructor for the View class
    public View() {
        // sets the style for all of the view elements
        this.setStyle("-fx-background-color: WHITE;");
        this.label.setStyle("-fx-font-size: 50; -fx-text-fill: #47b881;");
        this.textField.setStyle("-fx-font-size: 20");
        this.textField.setAlignment(Pos.CENTER);
        // adds all the view elements to the layout
        this.getChildren().addAll(label, textField);
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
        

    }

    /**
     * A method that sets the action listener for the textField
     * @param value handler for the action listener
     */
    public void addTextFieldEvent(EventHandler<ActionEvent> value) {
        textField.setOnAction(value);
    }

    /**
     * A method that retuns the text in the textfieild
     * @return text in the textfield
     */
    public String getTextFieldText() {
        return textField.getText();
    }

    /**
     * A method to set the text of the label
     * @param value new value for the label
     */
    public void setLabelText(String value) {
        label.setText(value);
    }

    
    /**
     * A method to display an error dialog
     * @param message the message of the error dialog
     */
    public void displayError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
