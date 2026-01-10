import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

class Currency {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            try {
                // Input
                System.out.print("Enter base currency (USD, INR, EUR): ");
                String base = sc.next().toUpperCase();
                
                System.out.print("Enter target currency (USD, INR, EUR): ");
                String target = sc.next().toUpperCase();
                
                System.out.print("Enter amount to convert: ");
                double amount = sc.nextDouble();
                
                // API URL
                String apiUrl = "https://open.er-api.com/v6/latest/" + base;
                
                URL url = new URL(apiUrl);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                
                StringBuilder response;
                try (BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream())
                )) {
                    String line;
                    response = new StringBuilder();
                    while ((line = in.readLine()) != null) {
                        response.append(line);
                    }
                }
                
                String json = response.toString();
                
                // Extract rate for target currency
                String search = "\"" + target + "\":";
                int index = json.indexOf(search);
                
                if (index == -1) {
                    System.out.println("Invalid currency code.");
                    sc.close();
                    return;
                }
                
                int start = index + search.length();
                int end = json.indexOf(",", start);
                double rate = Double.parseDouble(json.substring(start, end));
                
                // Conversion
                double convertedAmount = amount * rate;
                
                // Output
                System.out.printf(
                        "\nConverted Amount:\n%.2f %s = %.2f %s\n",
                        amount, base, convertedAmount, target
                );
                
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error: Unable to fetch exchange rates.");
            }

            }
}
}
