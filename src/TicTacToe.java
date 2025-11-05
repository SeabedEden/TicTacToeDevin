import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char currentPlayer = 'X';
        boolean gameEnded = false;

        System.out.println("=== TIC TAC TOE ===");
        printBoard();

        while (!gameEnded) {
            System.out.println("Giliran pemain: " + currentPlayer);
            System.out.print("Masukkan baris (1-3): ");
            int row = input.nextInt() - 1;  // Konversi dari 1-3 ke 0-2
            System.out.print("Masukkan kolom (1-3): ");
            int col = input.nextInt() - 1;  // Konversi dari 1-3 ke 0-2

            // Validasi input
            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
                System.out.println("Posisi tidak valid, coba lagi!");
                continue;
            }

            board[row][col] = currentPlayer;
            printBoard();

            // Cek pemenang
            if (checkWinner(currentPlayer)) {
                System.out.println("Pemain " + currentPlayer + " MENANG!");
                gameEnded = true;
            } else if (isBoardFull()) {
                System.out.println("Permainan SERI!");
                gameEnded = true;
            } else {
                // Ganti pemain
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
        input.close();
    }

    // Menampilkan papan
    public static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Cek pemenang
    public static boolean checkWinner(char player) {
        // Cek baris dan kolom
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        // Cek diagonal
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }
        return false;
    }

    // Cek apakah papan penuh
    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}