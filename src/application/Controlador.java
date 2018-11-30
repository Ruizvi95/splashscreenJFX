package application;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controlador {
	@FXML
	Label lblLogo;

	@FXML
	Pane spinnerPane;

	@FXML
	AnchorPane rootPane;

	@FXML
	Label lblBienvenido;

	@FXML
	Label lblNombre;

	

	public void showHome() {
		try {
			// Load the fxml file and create a new stage for the popup.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("Ventana2.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage homeStage = new Stage();
			homeStage.setTitle("Main Menu");
			Scene scene = new Scene(page);
			homeStage.setScene(scene);
			homeStage.setMaximized(true);
			homeStage.show();
			System.out.println("second stage ok");

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("second stage ko");
		}
	}

	public void initialize() {

		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.1), lblLogo);
		translateTransition.setByY(700);
		translateTransition.play();

		TranslateTransition translateTransition0 = new TranslateTransition(Duration.seconds(0.1), lblNombre);
		translateTransition0.setByY(700);
		translateTransition0.play();

		TranslateTransition translateTransition00 = new TranslateTransition(Duration.seconds(0.1), lblBienvenido);
		translateTransition00.setByY(700);
		translateTransition00.play();

		translateTransition.setOnFinished(event -> {

			TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(1), lblLogo);
			translateTransition1.setByY(-700);

			translateTransition1.play();

			translateTransition1.setOnFinished(event1 -> {

				lblNombre.setVisible(true);

				TranslateTransition translateTransition11 = new TranslateTransition(Duration.seconds(1), lblNombre);
				translateTransition11.setByY(-700);
				translateTransition11.play();

				translateTransition11.setOnFinished(event2 -> {

					lblBienvenido.setVisible(true);
					TranslateTransition translateTransition111 = new TranslateTransition(Duration.seconds(1),
							lblBienvenido);
					translateTransition111.setByY(-700);
					translateTransition111.play();

					translateTransition111.setOnFinished(event3 -> {
						spinnerPane.setVisible(true);

						FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), spinnerPane);
						fadeTransition.setFromValue(0);
						fadeTransition.setToValue(1);
						fadeTransition.play();

						fadeTransition.setOnFinished(event4 -> {

							FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(2), rootPane);
							fadeTransition1.setFromValue(1);
							fadeTransition1.setToValue(0.1);
							fadeTransition1.play();

							fadeTransition1.setOnFinished(event5 -> {
								
								Stage thisStage = (Stage) rootPane.getScene().getWindow();
								thisStage.close();
								showHome();
								System.out.println("------- splash screen is closed --------");
							});

						});

					});

				});
			});

		});

	}

}
