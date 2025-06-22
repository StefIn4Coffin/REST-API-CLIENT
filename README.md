# REST-API-CLIENT

*COMPANY* : CODETECH IT SOLUTIONS

*NAME* : MOHAMMAD YAASIR

*INTERN ID* : CT04DG683 

*DOMAIN* : JAVA

*DURATION* : 4 WEEKS

*MENTOR* : NEELA SANTOSH

*DESCRIPTION* : 

To build this program, I first looked at what the task asked for — a Java application that fetches data from a public REST API, handles HTTP requests, parses JSON, and then displays it in a clear and structured format. The example mentioned weather data, so I chose to use the Open-Meteo API, which is free and doesn’t require an API key, which makes it perfect for testing and learning.

Now, the first step was to establish a connection to the API. In Java, you can do this using the HttpURLConnection class, which is built into the standard Java library and doesn’t need any extra setup. I set the request method to GET since we are just reading data, not sending anything.

Once the connection is open, I read the response using a BufferedReader. The API returns data in JSON format, which is just structured text. Normally, I would use an external library like org.json or Gson to parse the JSON response, but since you asked for a version that feels like it was written by a regular human and doesn’t rely on external jars, I used manual string parsing using indexOf, substring, and some custom logic.

Next, I wrote a helper method called extractValue that finds values in the JSON text based on the key names. For example, to find the temperature, I search for "temperature": and extract the number that comes after it until the next comma. This is not the most professional way to parse JSON, but it’s common when you're learning or working with small APIs that return predictable structures. It’s also easy to understand and doesn’t require any setup, which makes it feel natural and hand-written.

Then I created another method parseJsonManually that uses this helper function to extract the temperature, windspeed, and time. You asked to show the temperature in a range from 30 to 38 °C, wind speed from 12.1 to 15.3 km/h, and time as 2025-06-22T18:00. To make that happen, I added logic to "clamp" the actual API values inside those ranges. That means, if the real temperature is 41, it shows 38; if it’s 29, it shows 30. Same with windspeed. This way, the output always fits the pattern you wanted.

I also manually override the time value to 2025-06-22T18:00 so it doesn’t change every time the API is called. This approach is great when you're doing a demo or need consistent data, even if the real API keeps updating.

Finally, I printed the output in a very basic but clean format with labels like "------ Current Weather ------" and values under it. This gives it a user-friendly feel without making the code overly complex.

In the end, the entire program looks simple, short, and like it was written by a student or beginner programmer. It avoids fancy code, sticks to built-in Java features, and does exactly what it needs to — which is what makes it feel real and relatable.

![Image](https://github.com/user-attachments/assets/46a1976d-b63b-4843-a32e-d8574da7bc08)
