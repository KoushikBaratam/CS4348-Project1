import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    public static void main(String[] args) {
        
        if (args.length != 1) {
            System.out.println("Usage: java Logger <logfile>");
            return;
        }

        String logFile = args[0];

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            PrintWriter writer = new PrintWriter(new FileWriter(logFile, true));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            String line;

            while (true) {

                line = reader.readLine();

                if (line.equals("QUIT")) {
                    break;
                }

                String time = LocalDateTime.now().format(formatter);

                String action = "";
                String message = "";

                int spaceIndex = line.indexOf(" ");

                if (spaceIndex == -1) {
                    action = line;
                } else {
                    action = line.substring(0, spaceIndex);
                    message = line.substring(spaceIndex + 1);
                }

                writer.println(time + " [" + action + "] " + message);

                writer.flush();
            }

            writer.close();

        } catch (Exception e) {
            System.out.println("Logger error: " + e.getMessage());
        }
    }
}