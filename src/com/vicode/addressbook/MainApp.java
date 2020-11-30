package com.vicode.addressbook;

import java.io.IOException;

/*
 * @author Victor Fernandez
 * @since 1.0
 *
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("AdressBook");

		initRootLayout();

		showPersonDescription();

	}

	/*
	 * Inicializes the root layout
	 */
	private void initRootLayout() {

		try {

			//Load root layout fromfxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));

			rootLayout = (BorderPane) loader.load();

			//Show the scene containing the root layout
			Scene scane = new Scene(rootLayout);
			primaryStage.setScene(scane);
			primaryStage.show();

		} catch (IOException ex) {

			ex.printStackTrace();
			throw new RuntimeException(ex);

		}

	}

	/*
	 * Shows the person description inside the root layout.
	 */
	private void showPersonDescription() {

		try {

			//Load person description
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/PersonDescription.fxml"));
			AnchorPane personDescription = (AnchorPane) loader.load();

			//Set person description into the center of root layout
			rootLayout.setCenter(personDescription);

		} catch (IOException ex) {

			ex.printStackTrace();
			throw new RuntimeException(ex);
		}

	}

	/*
	 * Returns the main stage.
	 * @return
	 */
	public Stage getPrimaryStage(){

		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
