/**
 * This class is the main starting point of the app. The View and Model are instantiated and passed to the 
 * controller. The class extends the 
 */

import javafx.application.Application;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class App extends Application {

    /**
     * Main entry of the app
     */
    @Override
    public void start(Stage primaryStage) {
        // creates the view and model and passes them to the controller
        View root = new View();
        Model model = new Model();
        new Controller(model, root);

        Scene scene = new Scene(root, 300, 250);
        // seting details of the stage (window) and showing it
        primaryStage.setTitle("NLP Calculator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(String[] args) {
        // launches the application
        launch(args);
    }

}
