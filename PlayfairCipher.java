// Program to encode/decode using Playfair Cipher, made by Vedant Jadhav.
import java.util.Scanner;

public class PlayfairCipher {
    private static char letterNotPresent;
    private static int[] location1 = new int[2], location2 = new int[2];
    // validating the playfair table
    private static void validate(String s) {
        if (s.length() != 25) {
            System.out.println("Entered string should be 25 characters long.");
            System.exit(0);
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                System.out.println("Please enter non-repeating characters in the table.");
                System.exit(0);
            } else if (!Character.isLetter(s.charAt(i+1))) {
                System.out.println("Please enter letters only.");
                System.exit(0);
            }
        }
    }
    // change the playfair table to a 5 x 5 array, each element being an uppercase letter
    private static char[][] changeToArray(String s) {
        char[][] arr = new char[5][5];
        for (int i = 0, k = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++, k++) 
                arr[i][j] = Character.toUpperCase(s.charAt(k));
        }
        // check which letter is not present in the playfield table
        for (int i = 0, k = 65; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if ((char) k == arr[i][j]) {
                    k++;
                    continue;
                }
                letterNotPresent = (char) k;
            }
        }
        return arr;
    }
    // If repeating characters occur, the second character is replaced by 'X'
    // Remove all occurences of ' '
    // If odd number of characters in plain text, 'X' is added to the end of the string.
    private static String working(String plainText) {
        plainText = plainText.toUpperCase();
        String newPlainText = "";
        for (int i = 0; i < plainText.length(); i++) {
            if (i % 2 != 0 && plainText.charAt(i) == plainText.charAt(i - 1))  
                newPlainText = newPlainText.concat("X" + plainText.charAt(i));
            else if (plainText.charAt(i) == letterNotPresent)
                newPlainText = newPlainText.concat("X");
            else if (plainText.charAt(i) == ' ') {
                continue;
            } else 
                newPlainText = newPlainText.concat(Character.toString(plainText.charAt(i)));
        }
        if (newPlainText.length() % 2 != 0) 
            newPlainText = newPlainText.concat("X");
        return newPlainText;
    }
    // to encode for two letters at a time
    public static String encode(String plainText, char[][] arr) {
        char[] cipherText = new char[plainText.length()];
        plainText = working(plainText);
        cipherText = plainText.toCharArray();
        for (int i = 0; i < cipherText.length - 1; i++) {
            if (i % 2 == 0) {
                char ch1, ch2;
                ch1 = Character.toUpperCase(cipherText[i]); ch2 = Character.toUpperCase(cipherText[i+1]);
                // finding out locations of the two characters
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        if (ch1 == arr[j][k]) {
                            location1[0] = j;
                            location1[1] = k;
                        } else if (ch2 == arr[j][k]) {
                            location2[0] = j;
                            location2[1] = k;
                       }
                    }
                }
                // if columns are same
                if (location1[1] == location2[1]) {
                    if (location1[0] == 4)
                        location1[0] = 0;
                    else if (location2[0] == 4)
                        location2[0] = 0;
                    else {
                        location1[0]++;
                        location2[0]++;
                    }
                } else if (location1[0] == location2[0]) { // if rows are same
                    if (location1[1] == 4)
                        location1[1] = 0;
                    else if (location2[1] == 4)
                        location2[1] = 0;
                    else {
                        location1[1]++;
                        location2[1]++;
                    } 
                } else {
                    int temp;
                    temp = location1[1];
                    location1[1] = location2[1];
                    location2[1] = temp;
                }
                cipherText[i] = arr[location1[0]][location1[1]];
                cipherText[i+1] = arr[location2[0]][location2[1]];
            }
        }
        return new String(cipherText);
    }
    // to decode for two characters at a time
    private static String decode(String cipherText, char[][] arr) {
        if (cipherText.length() % 2 != 0)
            System.out.println(cipherText + " is an invalid cipher to decode.");
        char[] plainText;
        plainText = cipherText.toCharArray();
        for (int i = 0; i < plainText.length - 1; i++) {
            if (i % 2 == 0) {
                char ch1, ch2;
                ch1 = Character.toUpperCase(plainText[i]); ch2 = Character.toUpperCase(plainText[i+1]);
                // finding out locations of the two characters
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        if (ch1 == arr[j][k]) {
                            location1[0] = j;
                            location1[1] = k;
                        } else if (ch2 == arr[j][k]) {
                            location2[0] = j;
                            location2[1] = k;
                       }
                    }
                }
                if (location1[1] == location2[1]) { // if columns are same
                    if (location1[0] == 0)
                        location1[0] = 4;
                    else if (location2[0] == 0)
                        location2[0] = 4;
                    else {
                        location1[0]--;
                        location2[0]--;
                    }
                } else if (location1[0] == location2[0]) { // if rows are same
                    if (location1[1] == 0)
                        location1[1] = 4;
                    else if (location2[1] == 0)
                        location2[1] = 4;
                    else {
                        location1[1]--;
                        location2[1]--;
                    }
                } else {
                    int temp;
                    temp = location1[1];
                    location1[1] = location2[1];
                    location2[1] = temp;
                }
                plainText[i] = arr[location1[0]][location1[1]];
                plainText[i+1] = arr[location2[0]][location2[1]];
            }
        }
        return new String(plainText);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String plainText, table, cipherText;
        char[][] arr = new char[5][5];
        byte choice;
        System.out.println("Please enter the playfair table as a 25 letter string: ");
        table = sc.next();
        validate(table);
        arr = changeToArray(table);
        System.out.println("Do you want to\n1 - Encode, or \n2 - Decode");
        choice = sc.nextByte();
        sc.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Enter the string to be encoded:");
                plainText = sc.nextLine();
                System.out.println("The encoded string is: " + encode(plainText, arr));
                break;
            case 2:
                System.out.println("Enter the string to be decoded:");
                cipherText = sc.nextLine();
                System.out.println("The decoded string is: " + decode(cipherText, arr));
                break;
            default:
                System.out.println("Invalid input!");
        }
        sc.close();
    }
}
