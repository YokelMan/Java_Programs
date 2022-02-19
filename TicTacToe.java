// a multiplayer program to play tictactoe with 2 people

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char [][]map = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
        Scanner sc = new Scanner(System.in);
        int row1 = 2, col1 = 2, row2 = -1, col2 = -1, turns = 0;
        boolean player1HasWon = false, player2HasWon = false;
        String player1Name, player2Name;
        System.out.println("Enter player 1's name:");
        player1Name = sc.nextLine();
        System.out.println("Enter player 2's name:");
        player2Name = sc.nextLine();
        while(!player1HasWon && !player2HasWon) {
            System.out.println("Enter the position of player 1's 'X':");
            String player1 = sc.next();
            switch(player1.charAt(0)) {
                case 'a':
                    row1 = 0;
                    break;
                case 'b':
                    row1 = 1;
                    break;
                case 'c':
                    row1 = 2;
                    break;
                default:
                    System.out.println("Invalid input!");
                    System.exit(0);
            } switch(player1.charAt(1)) {
                case '1':
                    col1 = 0;
                    break;
                case '2':
                    col1 = 1;
                    break;
                case '3':
                    col1 = 2;
                    break;
                default:
                    System.out.println("Invalid input!");
                    System.exit(0);
            }
            if (map[row1][col1] != '-') {
                System.out.println("Value is already taken.");
                System.exit(0);
            } else {
                map[row1][col1] = 'X';
                turns++;
            }
            // printing the current tictactoe map
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            // checking if player1 or player2 has won
            if((map[0][0] == map[1][0] && map[1][0] == map[2][0] && map[2][0] != '-')
            || (map[0][0] == map[0][1] && map[0][1] == map[0][2] && map[0][2] != '-')
            || (map[0][0] == map[1][1] && map[1][1] == map[2][2] && map[2][2] != '-')) {
                player1HasWon = map[0][0] == 'X' ? true : false;
                player2HasWon = player1HasWon ? false : true;
                break;
            } else if((map[0][1] == map[1][1] && map[1][1] == map[2][1] && map[2][1] != '-')
            || (map[1][0] == map[1][1] && map[1][1] == map[1][2] && map[1][2] != '-')
            || (map[2][0] == map[1][1] && map[1][1] == map[0][2] && map[0][2] != '-')) {
                player1HasWon = map[1][1] == 'X' ? true : false;
                player2HasWon = player1HasWon ? false : true;
                break;
            } else if((map[0][2] == map[1][2] && map[1][2] == map[2][2] && map[2][2] != '-')
            || (map[2][0] == map[2][1] && map[2][1] == map[2][2] && map[2][2] != '-')) {
                player1HasWon = map[2][2] == 'X' ? true : false;
                player2HasWon = player1HasWon ? false : true;
                break;
            }
            // if turns = 9, or if it's a draw, then get out of the loop
            if (turns == 9)
                break;
            System.out.println("Enter the position of player 2's 'O'");
            String player2 = sc.next();
            switch(player2.charAt(0)) {
                case 'a':
                    row2 = 0;
                    break;
                case 'b':
                    row2 = 1;
                    break;
                case 'c':
                    row2 = 2;
                    break;
                default:
                    System.out.println("Invalid input!");
                    System.exit(0);
            } switch(player2.charAt(1)) {
                case '1':
                    col2 = 0;
                    break;
                case '2':
                    col2 = 1;
                    break;
                case '3':
                    col2 = 2;
                    break;
                default:
                    System.out.println("Invalid input!");
                    System.exit(0);
            }
            if (map[row2][col2] != '-') {
                System.out.println("Value is already taken.");
                System.exit(0);
            } else {
                map[row2][col2] = 'O';
                turns++;
            }
            // printing the current tictactoe map
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
        if (player1HasWon)
            System.out.println("" + player1Name.toUpperCase() + " won the game! Well played!");
        else if (player2HasWon) 
            System.out.println("" + player2Name.toUpperCase() + " won the game! Well played!");
        else 
            System.out.println("It's a draw! Well played!");
        sc.close();
    }
}
