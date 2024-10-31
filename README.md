

Programming Assignment Unit 8

Department of Computer Science, University of the People
CS 1103-01 Programming 2
Dr, Naeem Ahmed
October 31, 2024
 
Table of Contents
Table of Figures	3
Introduction	4
Task: Weather Application	4
Code Implementation	5
1. WeatherAPI.java	5
2. WeatherApp.java	6
3. Error Handling	6
Steps to Run:	7
Explanation:	10
Error Handling	11
Conclusion	13
References	14

 
Table of Figures
Figure 1: Weather Application	8
Figure 2: Get Weather	9
Figure 3: Weather History	10

 
Introduction
In this assignment, I have been tasked with developing a Weather Information Application using Java. This application allows users to retrieve and view current weather conditions for various locations around the world. By integrating a weather data API, users can enter a location and receive real-time weather updates, including details such as temperature, humidity, and weather conditions.
The primary objective of this assignment is to design and implement a user-friendly application that efficiently communicates with the weather API to fetch accurate weather data. The application emphasizes networking capabilities and API integration, featuring a clean and intuitive graphical user interface (GUI) that enhances the user experience. Through this project, I aim to deepen my understanding of Java programming while providing a valuable tool for users to stay informed about weather conditions.
Task: Weather Application
The key objectives of this assignment are as follows:
1.	API Integration: 
•	I will develop a WeatherAPI class that handles communication with a weather data API, enabling the retrieval of current weather information based on user input.
•	The application will send requests to the API and process the JSON responses to extract relevant weather data such as temperature, humidity, and weather conditions.


2.	User Interface: 
•	I plan to create a user-friendly graphical user interface (GUI) using either JavaFX or Swing. The interface will provide:
i.	An input field for users to enter their desired location
ii.	A display area for showing the retrieved weather information
iii.	A button to trigger the weather data retrieval process, providing a seamless experience for the user.
3.	Data Presentation: 
•	The application will format the retrieved weather data clearly and concisely, ensuring users can easily understand the current weather conditions.

Code Implementation
The core code for the Weather Application is organized into well-defined classes to ensure a modular, maintainable, and easy-to-extend structure. Each class is designed with specific responsibilities, focusing on core functionality and user interface aspects.
1. WeatherAPI.java
This class is responsible for managing API calls to the external weather service, such as OpenWeatherMap. It includes:
	API Key Setup.
	Data Fetching: Methods that handle HTTP requests to retrieve weather data based on location inputs.
	Data Parsing: Processes the raw JSON response to extract key information such as temperature, humidity, weather conditions, etc.
2. WeatherApp.java
WeatherApp serves as the main entry point of the application, with responsibilities including:
User Interface: Presents a simple and user-friendly UI for inputting location details and displaying weather results.
3. Error Handling
The application contains helper methods and error handling to ensure a smooth user experience. It manages scenarios like network issues, invalid API responses, or incorrect user inputs. 
Code Execution
Steps to Run:
1.	Clone the Repository:
git clone https://github.com/Bhadmushenry9/WeatherApplication.git
git checkout master
2.	Compile and Run:
cd WeatherApp/src
javac main/java/com/henry/weatherapp/WeatherApp.java
java main/java/com/henry/weatherapp.WeatherApp






 
Figure 1: Weather Application

 
Figure 2: Get Weather
 
Figure 3: Weather History

Explanation:
The Weather Information Application leverages Java's networking capabilities to seamlessly interact with a remote weather API, providing real-time weather data for user-entered locations. This is achieved through the coordinated use of two primary classes:

1.	WeatherAPI Class: This class handles all interactions with the weather API, including sending HTTP requests and parsing responses. It ensures that data requests are correctly formatted and efficiently processed, converting the raw JSON data into user-friendly information for the application's output.

2.	WeatherApp Class: Acting as the main interface, this class allows users to input location details and view corresponding weather data. The interface is designed to be intuitive, guiding users to enter valid locations while displaying concise and relevant weather information such as temperature, humidity, and conditions.

Error Handling
The application is equipped with robust error-handling mechanisms to ensure a smooth user experience, even in the face of potential issues. Key areas include:
1.	Network Errors: If the application encounters a connectivity issue while trying to access the API, it will display an error message alerting users to check their internet connection. This ensures users are informed of connection issues rather than experiencing silent failures.
2.	Invalid Input Handling: The application verifies location entries and prompts users to enter valid names if an invalid location is detected. This feature prevents unnecessary API calls for invalid data and helps users correct input errors quickly, enhancing usability and reliability.

These error-handling strategies contribute to a resilient and user-friendly experience, ensuring that the application remains responsive and informative regardless of connectivity or input challenges.



 
Conclusion
In conclusion, this assignment has been instrumental in deepening my understanding of API integration and GUI design within Java. Developing the Weather Information Application provided hands-on experience in retrieving, processing, and presenting real-time data, which allowed me to see the practical impact of bringing external data sources into an application. The project has strengthened my Java programming skills, particularly in handling HTTP requests and creating a responsive, user-friendly interface that meets real-world needs. Overall, this experience has equipped me with valuable tools and knowledge for building applications that leverage external APIs to deliver dynamic, data-driven solutions to users. 
References
Eck, D. J. (2022, May). Introduction to Programming Using Java. Hobart and William Smith Colleges.








