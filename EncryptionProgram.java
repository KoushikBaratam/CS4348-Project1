import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EncryptionProgram {

    static String key = null;

    // reading commands from standard input and processes PASS, ENCRYPT, DECRYPT, and QUIT
    public static void main(String[] args) {

        try {

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(System.in));

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.equals("QUIT")) {
                    break;
                }

                String[] parts = line.split(" ", 2);

                String command = parts[0];
                String argument = "";

                if (parts.length > 1)
                    argument = parts[1];

                if (command.equals("PASS")) {

                    key = argument;
                    System.out.println("RESULT");

                }

                else if (command.equals("ENCRYPT")) {

                    if (key == null) {
                        System.out.println("ERROR Password not set");
                    } else {
                        System.out.println("RESULT " + encrypt(argument));
                    }

                }

                else if (command.equals("DECRYPT")) {

                    if (key == null) {
                        System.out.println("ERROR Password not set");
                    } else {
                        System.out.println("RESULT " + decrypt(argument));
                    }

                }

                else {
                    System.out.println("ERROR Unknown command");
                }
            }

        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }

    // Encrypting a string using the Vigenere cipher with the current key
    static String encrypt(String text) {

        String result = "";

        for (int i = 0; i < text.length(); i++) {

            char t = text.charAt(i);
            char k = key.charAt(i % key.length());

            int value = (t - 'A' + k - 'A') % 26;

            result += (char) ('A' + value);
        }

        return result;
    }

    // Decrypting a string using the Vigenere cipher with the current key
    static String decrypt(String text) {

        String result = "";

        for (int i = 0; i < text.length(); i++) {

            char t = text.charAt(i);
            char k = key.charAt(i % key.length());

            int value = (t - 'A' - (k - 'A') + 26) % 26;

            result += (char) ('A' + value);
        }

        return result;
    }
}