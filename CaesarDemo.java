package caesarcipher;
import java.util.Scanner;

public class CaesarDemo {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private int key;

    public static void main(String args[]) {
        CaesarDemo cd = new CaesarDemo();

        Scanner scr = new Scanner(System.in);

        System.out.println("Enter key: ");
        cd.key = nextIntLine(scr);

        System.out.println("Enter encoding text: ");
        String encodingText = scr.nextLine();
        String encodedText = cd.encrypt(encodingText);
        System.out.println(encodedText);

        System.out.println("Enter decoded text: ");
        String decodingText = scr.nextLine();
        String decodedText = cd.decrypt(decodingText);
        System.out.println(decodedText);
    }


    private static int nextIntLine(Scanner scr) {
        int result = scr.nextInt();
        scr.nextLine();

        return result;
    }

    private String encrypt(String input) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < ALPHABET.length(); j++) {
                if (input.charAt(i) == ALPHABET.charAt(j)) {
                    char c;
                    if ((j + key) < 26) {
                        c = ALPHABET.charAt(j + key);
                    } else {
                        c = ALPHABET.charAt(j + key - 26);
                    }

                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }

    private String decrypt(String output) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < output.length(); i++) {
            for (int j = 0; j < ALPHABET.length(); j++) {
                if (output.charAt(i) == ALPHABET.charAt(j)) {
                    char c;
                    if ((j - key) >= 0) {
                        c = ALPHABET.charAt(j - key);
                    } else {
                        c = ALPHABET.charAt(j - key + 26);
                    }

                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}
