/*
 * WeatherAPI - A class for fetching weather data from an external API.
 *
 * This class connects to the OpenWeatherMap API to retrieve current weather
 * data based on a specified location. It constructs the API request URL with
 * the necessary query parameters, sends an HTTP GET request, and parses the
 * JSON response.
 *
 * Key Components:
 * - apiKey (String): API key for authentication with the OpenWeatherMap API.
 * - baseUrl (String): Base URL of the OpenWeatherMap weather endpoint.
 * - getWeatherData(String location): Constructs the API request URL, sends a request,
 *   and returns the response as a JSONObject. In case of an error, it prints the stack trace
 *   and returns null.
 *
 * Usage:
 * Instantiate the WeatherAPI class and call getWeatherData() with a location
 * (e.g., city name) to retrieve weather data in JSON format.
 */

package main.java.com.henry.weatherapp.api;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherAPI {
    private final String apiKey = "3afd10eb087f31ff13eef05153e67b18";
    private final String baseUrl = "https://api.openweathermap.org/data/2.5/weather";

    // Fetches weather data from OpenWeatherMap API for a specified location.
    public JSONObject getWeatherData(String location) {
        try {
            // Construct the API request URL with the location, API key, and metric units.
            String urlString = baseUrl + "?q=" + location + "&appid=" + apiKey + "&units=metric";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Read and build the response content.
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder content = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            // Parse the response content as JSON and return it.
            return new JSONObject(content.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Return null if there is an exception during the API call.
        }
    }
}
