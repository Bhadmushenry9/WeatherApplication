/*
 * WeatherApp - A JavaFX application for displaying weather information.
 *
 * This class serves as the entry point for the WeatherApp, extending JavaFX's
 * Application class to set up and launch the user interface. It creates a primary
 * stage (main window) and attaches a custom WeatherView component to display
 * weather data.
 *
 * Key components:
 * - WeatherView: A custom class for rendering the weather data UI.
 * - Scene and Stage: JavaFX components for setting up the window and layout.
 *
 * Usage:
 * The application can be launched by calling the main method, which triggers
 * JavaFX's launch method to initialize the UI environment.
 */

package main.java.com.henry.weatherapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.com.henry.weatherapp.ui.WeatherView;

public class WeatherApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Weather Information App"); // Set window title.

        WeatherView weatherView = new WeatherView(); // Create UI view for weather.
        Scene scene = new Scene(weatherView.getView(), 400, 600); // Set UI layout and dimensions.

        primaryStage.setScene(scene); // Attach scene to window.
        primaryStage.show(); // Display the window.
    }

    public static void main(String[] args) {
        launch(args); // Calls start() to initialize and show the app UI.
    }
}
