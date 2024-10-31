/*
 * WeatherController - A controller class for managing the weather data flow in the app.
 *
 * This class serves as the intermediary between the user interface and the backend data.
 * It handles requests to fetch weather data for a specific location, parses the data into
 * a WeatherData object, manages a history of fetched data, and displays error messages
 * when needed.
 *
 * Key Components:
 * - weatherAPI (WeatherAPI): An instance of the WeatherAPI class to fetch data from the API.
 * - weatherHistory (WeatherHistory): An instance of WeatherHistory to store fetched weather data.
 * - fetchWeather(String location): Calls the API to fetch weather data, converts it into a
 *   WeatherData object, saves it to history, and returns it. Shows an error if the API call fails.
 * - getWeatherHistory(): Provides access to the stored weather history.
 * - showError(String message): Displays an error alert with the specified message.
 *
 * Usage:
 * The WeatherController class is used to handle user requests for weather data,
 * manage data history, and provide feedback in the UI when issues arise.
 */

package main.java.com.henry.weatherapp.ui;

import javafx.scene.control.Alert;
import main.java.com.henry.weatherapp.api.WeatherAPI;
import main.java.com.henry.weatherapp.model.WeatherData;
import main.java.com.henry.weatherapp.model.WeatherHistory;
import org.json.JSONObject;

public class WeatherController {
    private final WeatherAPI weatherAPI = new WeatherAPI();
    private final WeatherHistory weatherHistory = new WeatherHistory();

    // Fetches weather data for the specified location, converts it to a WeatherData object,
    // adds it to the history, and returns it. Shows an error if data retrieval fails.
    public WeatherData fetchWeather(String location) {
        JSONObject data = weatherAPI.getWeatherData(location);
        if (data != null) {
            WeatherData weatherData = new WeatherData();
            JSONObject main = data.getJSONObject("main");
            weatherData.setTemperature(main.getDouble("temp"));
            weatherData.setHumidity(main.getInt("humidity"));
            weatherData.setWindSpeed(data.getJSONObject("wind").getDouble("speed"));
            weatherData.setCondition(data.getJSONArray("weather").getJSONObject(0).getString("description"));

            // Add fetched data to history
            weatherHistory.addRecord(weatherData);
            return weatherData;
        }
        showError("Could not retrieve weather data.");
        return null;
    }

    // Returns the weather data history.
    public WeatherHistory getWeatherHistory() {
        return weatherHistory;
    }

    // Displays an error alert with the provided message.
    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.show();
    }
}
