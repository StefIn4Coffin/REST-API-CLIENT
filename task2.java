import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class task2 {

    public static void main(String[] args) {
        String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=28.61&longitude=77.23&current_weather=true";

        try {
            // Set up connection
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Read response
            int responseCode = con.getResponseCode();
            if (responseCode == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder result = new StringBuilder();
                String line;

                while ((line = br.readLine()) != null) {
                    result.append(line);
                }

                br.close();

                // Parse manually
                String json = result.toString();
                parseJsonManually(json);

            } else {
                System.out.println("Failed to get data. HTTP code: " + responseCode);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // crude way to parse specific values from JSON string
    static void parseJsonManually(String json) {
        try {
            String temp = extractValue(json,"\"temperature\":", ",");
            String wind = extractValue(json, "\"windspeed\":", ",");
            String time = extractValue(json, "\"time\":\"", "\"");

            System.out.println("------ Current Weather ------");
            System.out.println("Temperature: 30.5" + temp + " 38.1°C");
            System.out.println("Windspeed:  12.1" + wind + "14.5 km/h");
            System.out.println("Time: 2025-06-22T19:00 " + time);

        } catch (Exception e) {
            System.out.println("Error parsing data: " + e.getMessage());
        }
    }

    // helper method to find value between a start keyword and a delimiter
    static String extractValue(String text, String start, String end) {
        int startIndex = text.indexOf(start);
        if (startIndex == -1) return "N/A";
        startIndex += start.length();
        int endIndex = text.indexOf(end, startIndex);
        if (endIndex == -1) endIndex = text.length();
        return text.substring(startIndex, endIndex).replace("\"", "").trim();
    }
}
