// Program to encode/decode using caesar cipher.
public class CaesarCipher {
    // lower limit " " - 32, upper limit "~" - 126
    static String encode(String oriWord, int noOfShift) {
        String cipherText = "";
        int letter, extraShift;
        for(int i = 0; i < oriWord.length(); i++) {
            letter = Character.toLowerCase(oriWord.charAt(i));
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

    static String decode(String oriWord, int noOfShift) {
        String plainText = ""; 
        plainText = encode(oriWord, 26 - noOfShift);
        return plainText;
    }
}
