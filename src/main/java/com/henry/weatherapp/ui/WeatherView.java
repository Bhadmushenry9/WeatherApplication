/*
 * WeatherView - A user interface class for displaying and interacting with weather data.
 *
 * This class creates the UI layout for the weather app, allowing users to search
 * for current weather conditions based on location and view a history of past searches.
 * It includes fields to display temperature, humidity, wind speed, and condition,
 * as well as buttons to fetch new data and display history.
 *
 * Key Components:
 * - locationField (TextField): Input field for entering the location to search.
 * - tempLabel, humidityLabel, windSpeedLabel, conditionLabel (Labels): Display the fetched weather data.
 * - getView(): Returns the main UI layout (VBox) with all components.
 * - updateWeather(): Fetches weather data from the controller based on input location
 *   and updates the UI labels with the results.
 * - showHistory(): Displays a dialog with a formatted history of previous searches.
 *
 * Usage:
 * The WeatherView class provides the main user interface for the app. It can be
 * included in the primary stage of the JavaFX application to enable user interactions.
 */

package main.java.com.henry.weatherapp.ui;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import main.java.com.henry.weatherapp.model.WeatherData;

public class WeatherView {
    private final WeatherController controller = new WeatherController();
    private final TextField locationField = new TextField();
    private final Label tempLabel = new Label("Temperature: ");
    private final Label humidityLabel = new Label("Humidity: ");
    private final Label windSpeedLabel = new Label("Wind Speed: ");
    private final Label conditionLabel = new Label("Condition: ");

    // Returns the main layout (VBox) containing UI elements for displaying weather data.
    public VBox getView() {
        Button searchButton = new Button("Get Weather");
        searchButton.setOnAction(e -> updateWeather());

        Button historyButton = new Button("History");
        historyButton.setOnAction(e -> showHistory());

        VBox layout = new VBox(10, locationField, searchButton, historyButton, tempLabel, humidityLabel, windSpeedLabel, conditionLabel);
        layout.setStyle("-fx-padding: 10; -fx-alignment: center;");
        return layout;
    }

    // Fetches and displays weather data for the specified location.
    private void updateWeather() {
        String location = locationField.getText();
        WeatherData data = controller.fetchWeather(location);
        if (data != null) {
            tempLabel.setText("Temperature: " + data.getTemperature() + " °C");
            humidityLabel.setText("Humidity: " + data.getHumidity() + " %");
            windSpeedLabel.setText("Wind Speed: " + data.getWindSpeed() + " m/s");
            conditionLabel.setText("Condition: " + data.getCondition());
        }
    }

    // Displays a dialog with a history of past weather searches.
    private void showHistory() {
        StringBuilder historyText = new StringBuilder("Weather History:\n");

        for (WeatherData data : controller.getWeatherHistory().getHistory()) {
            historyText.append(String.format("Temp: %.1f °C, Humidity: %d%%, Wind: %.1f m/s, Condition: %s\n",
                    data.getTemperature(), data.getHumidity(), data.getWindSpeed(), data.getCondition()));
        }

        Alert historyAlert = new Alert(Alert.AlertType.INFORMATION);
        historyAlert.setTitle("Weather History");
        historyAlert.setHeaderText("Previous Weather Searches");
        historyAlert.setContentText(historyText.toString());
        historyAlert.show();
    }
}
