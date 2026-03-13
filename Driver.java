import java.io.*;
import java.util.*;

public class Driver {

    // history list for storing encrypted or decrypted strings during this run
    static ArrayList<String> history = new ArrayList<>();

    public static void main(String[] args) {

        // check if log file argument exists
        if (args.length != 1) {
            System.out.println("Usage: java Driver <logfile>");
            return;
        }

        String logFile = args[0];

        try {

            // starts with the logger process
            Process logger = new ProcessBuilder("java", "Logger", logFile).start();

            // starts with encryption
            Process encryptor = new ProcessBuilder("java", "EncryptionProgram").start();

            // streaming for logger
            BufferedWriter loggerInput =
                    new BufferedWriter(new OutputStreamWriter(logger.getOutputStream()));

            // streaming for the encryption program
            BufferedWriter encryptInput =
                    new BufferedWriter(new OutputStreamWriter(encryptor.getOutputStream()));

            BufferedReader encryptOutput =
                    new BufferedReader(new InputStreamReader(encryptor.getInputStream()));

            Scanner scanner = new Scanner(System.in);

            // log start
            loggerInput.write("START Driver started\n");
            loggerInput.flush();

            while (true) {

                System.out.println("\nCommands:");
                System.out.println("password");
                System.out.println("encrypt");
                System.out.println("decrypt");
                System.out.println("history");
                System.out.println("quit");

                System.out.print("> ");
                String command = scanner.nextLine().toLowerCase();

                // PASSWORD command
                if (command.equals("password")) {

                    System.out.print("Enter password: ");
                    String password = scanner.nextLine().toUpperCase();

                    if (!password.matches("[A-Za-z]+")) {
                        System.out.println("Error: letters only");
                        continue;
                    }

                    encryptInput.write("PASS " + password + "\n");
                    encryptInput.flush();

                    encryptOutput.readLine();

                    loggerInput.write("COMMAND password\n");
                    loggerInput.write("RESULT password set\n");
                    loggerInput.flush();
                }

                // ENCRYPT command
                else if (command.equals("encrypt")) {

                    System.out.print("Enter string: ");
                    String text = scanner.nextLine().toUpperCase();

                    if (!text.matches("[A-Za-z]+")) {
                        System.out.println("Error: letters only");
                        continue;
                    }

                    history.add(text);

                    encryptInput.write("ENCRYPT " + text + "\n");
                    encryptInput.flush();

                    String result = encryptOutput.readLine();

                    System.out.println(result);

                    if (result.startsWith("RESULT"))
                        history.add(result.substring(7));

                    loggerInput.write("COMMAND encrypt\n");
                    loggerInput.write(result + "\n");
                    loggerInput.flush();
                }

                // DECRYPT command
                else if (command.equals("decrypt")) {

                    System.out.print("Enter string: ");
                    String text = scanner.nextLine().toUpperCase();

                    if (!text.matches("[A-Za-z]+")) {
                        System.out.println("Error: letters only");
                        continue;
                    }

                    history.add(text);

                    encryptInput.write("DECRYPT " + text + "\n");
                    encryptInput.flush();

                    String result = encryptOutput.readLine();

                    System.out.println(result);

                    if (result.startsWith("RESULT"))
                        history.add(result.substring(7));

                    loggerInput.write("COMMAND decrypt\n");
                    loggerInput.write(result + "\n");
                    loggerInput.flush();
                }

                // HISTORY cmd
                else if (command.equals("history")) {

                    System.out.println("History:");

                    for (int i = 0; i < history.size(); i++) {
                        System.out.println((i + 1) + ": " + history.get(i));
                    }
                }

                // QUIT cmd
                else if (command.equals("quit")) {

                    encryptInput.write("QUIT\n");
                    encryptInput.flush();

                    loggerInput.write("EXIT Driver exiting\n");
                    loggerInput.write("QUIT\n");
                    loggerInput.flush();

                    break;
                }

                else {
                    System.out.println("Unknown command");
                }
            }

        } catch (Exception e) {
            System.out.println("Driver error: " + e.getMessage());
        }
    }
}