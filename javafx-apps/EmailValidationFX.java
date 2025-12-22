import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EmailValidationFX extends Application {

    @Override
    public void start(Stage stage) {

        Label title = new Label("Email Validation");

        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email address");

        Button validateButton = new Button("Validate");

        Label resultLabel = new Label();

        validateButton.setOnAction(e -> {
            String email = emailField.getText().trim();

            String gmailRegex = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
            String yahooRegex = "^[a-zA-Z0-9._%+-]+@yahoo\\.com$";
            String eduRegex   = "^[a-zA-Z0-9._%+-]+@([a-zA-Z0-9-]+\\.)*edu\\.np$";

            if (email.matches(gmailRegex)) {
                resultLabel.setText(" Valid Gmail Address");
                resultLabel.setStyle("-fx-text-fill: green;");
            }
            else if (email.matches(yahooRegex)) {
                resultLabel.setText(" Valid Yahoo Address");
                resultLabel.setStyle("-fx-text-fill: green;");
            }
            else if (email.matches(eduRegex)) {
                resultLabel.setText(" Valid College / EDU.NP Address");
                resultLabel.setStyle("-fx-text-fill: green;");
            }
            else {
                resultLabel.setText(" Invalid Email Address");
                resultLabel.setStyle("-fx-text-fill: red;");
            }
        });

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(title, emailField, validateButton, resultLabel);

        Scene scene = new Scene(root, 360, 200);

        stage.setTitle("Email Validator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
