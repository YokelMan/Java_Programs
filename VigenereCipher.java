public class VigenereCipher {
    // A = 65, Z = 90, a = 97, z = 122
    static String encrypt(String plainText, String key) {
        String cipherText = "";
        int letter, extraShift, noOfShift;
        plainText = plainText.toLowerCase();
        key = key.toLowerCase();
        for (int i = 0, j = 0; i < plainText.length(); i++, j++) {
            if (j == key.length())
                j = 0;
            letter = plainText.charAt(i);
            noOfShift = key.charAt(j) - 97;
            if (Character.isLetter(letter)) {
                if(letter + noOfShift > 'z') {
                    // calculating extra shift of the letter over and above 'z'
                    extraShift = (letter + noOfShift) - ('z' + 1);
                    // adding extra shift to 'a'
                    letter = 'a' + extraShift;
                } else
                    letter += noOfShift;
            } else {
                if (letter + noOfShift > '~') {
                    // calculating extra shift of the letter over and above '~'
                    extraShift = (letter + noOfShift) - ('~' + 1);
                    // adding extra shift to ' ' (whitespace)
                    letter = ' ' + extraShift;
                } else
                    letter += noOfShift;
            }
            cipherText += (char) letter;
        }
        return cipherText;
    }

    static public String decrypt(String cipherText, String key) {
        String plainText = "";
        int letter, extraShift, noOfShift;
        key = key.toLowerCase();
        for (int i = 0, j = 0; i < cipherText.length(); i++, j++) {
            if (j == key.length())
                j = 0;
            letter = cipherText.charAt(i);
            noOfShift = key.charAt(j) - 97;
            if (Character.isLetter(letter)) {
                if ((letter - noOfShift) < 'a') {
                    // calculating extra shift of the letter gone below 'a'
                    extraShift = ('a' - 1) - (letter - noOfShift);
                    // reducing the extra shift from 'z'
                    letter = 'z' - extraShift;
                } else
                    letter -= noOfShift;
            } else {
                if (letter - noOfShift < ' ') {
                    // calculating extra shift of the letter gone below ' ' (whitespace)
                    extraShift = (' ' - 1) - (letter - noOfShift);
                    // reducing extra shift from '~'
                    letter = '~' + extraShift;
                } else
                    letter -= noOfShift;
            }
            plainText += (char) letter;
        }
        return plainText;
    }
}
