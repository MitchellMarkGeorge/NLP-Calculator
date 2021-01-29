/** This class represents the Controller for the application. It connects the view and model togther
 *  @author
 * 
 */
import javafx.event.ActionEvent;

public class Controller {
    private Model model;
    private View view;

    /**
     * A constructor that accepts the modle and view and sets an event listener for the textfield
     * @param model
     * @param view
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.addTextFieldEvent(this::onFieldEnter);
    }

    /**
     * A method that gets the string expression from the view and evluated it using the model
     * @param value the event object from the handler.
     *
     */
    public void onFieldEnter(ActionEvent value) {
        String expression = this.view.getTextFieldText().trim().toLowerCase();
        if (expression.isEmpty()) {
            this.view.setLabelText("0");
            return;
        }
        try {
            this.model.evaluateExpression(expression);
            double result = this.model.getCalculationResult();
            this.view.setLabelText(Double.toString(result));
        } catch (Exception e) {
            // if there is an error, it will show an error dialog
            this.view.displayError("Uh-Oh! An error occured! Check your expression");
        }

    }
}
