/*
 * WeatherHistory - A data model class for managing historical weather data records.
 *
 * This class provides a way to store and retrieve a history of weather data entries,
 * using a list of WeatherData objects. It supports adding new records and retrieving
 * the entire history, making it useful for tracking past weather information over time.
 *
 * Key Components:
 * - history (List<WeatherData>): A list storing each weather data entry as a WeatherData object.
 * - addRecord(WeatherData data): Adds a new WeatherData record to the history list.
 * - getHistory(): Returns a copy of the history list to prevent external modifications
 *   to the internal data.
 *
 * Usage:
 * The WeatherHistory class can be used to store and access weather data records
 * over time, which could be useful for displaying trends, summaries, or logs
 * within the application.
 */

package main.java.com.henry.weatherapp.model;

import java.util.ArrayList;
import java.util.List;

public class WeatherHistory {
    private final List<WeatherData> history = new ArrayList<>();

    // Adds a new weather data record to the history list.
    public void addRecord(WeatherData data) {
        history.add(data);
    }

    // Returns a copy of the history list to avoid direct modification from outside the class.
    public List<WeatherData> getHistory() {
        return new ArrayList<>(history);
    }
}
