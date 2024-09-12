import java.util.Scanner;

// Classe que representa um nó da lista circular
class PlayerNode {
    char symbol;
    PlayerNode next;

    public PlayerNode(char symbol) {
        this.symbol = symbol;
        this.next = null;
    }
}

// Classe que representa a lista circular de jogadores
class CircularPlayerList {
    private PlayerNode current;

    public CircularPlayerList() {
        PlayerNode playerX = new PlayerNode('X');
        PlayerNode playerO = new PlayerNode('O');

        playerX.next = playerO;
        playerO.next = playerX;

        this.current = playerX;
    }

    public char getCurrentPlayer() {
        return current.symbol;
    }

    public void switchToNextPlayer() {
        current = current.next;
    }
}

// Classe que implementa o jogo da velha
public class TicTacToe {
    private char[][] board;
    private CircularPlayerList players;
    private Scanner scanner;

    public TicTacToe() {
        board = new char[3][3];
        players = new CircularPlayerList();
        scanner = new Scanner(System.in);

        // Inicializa o tabuleiro vazio
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void play() {
        while (true) {
            System.out.println("Jogador " + players.getCurrentPlayer() + ", é a sua vez.");
            int row, col;

            // Pega coordenadas válidas do jogador
            while (true) {
                System.out.print("Digite a linha (0, 1, 2): ");
                row = scanner.nextInt();
                System.out.print("Digite a coluna (0, 1, 2): ");
                col = scanner.nextInt();

                if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
                    break;
                } else {
                    System.out.println("Jogada inválida! Tente novamente.");
                }
            }

            // Marca o tabuleiro e imprime
            board[row][col] = players.getCurrentPlayer();
            printBoard();

            // Verifica se o jogador atual venceu
            if (checkWin()) {
                System.out.println("Jogador " + players.getCurrentPlayer() + " venceu!");
                break;
            }

            // Verifica se o tabuleiro está cheio (empate)
            if (isBoardFull()) {
                System.out.println("O jogo terminou em empate!");
                break;
            }

            // Alterna para o próximo jogador
            players.switchToNextPlayer();
        }
    }

    private boolean checkWin() {
        // Verifica linhas, colunas e diagonais
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == players.getCurrentPlayer() && board[i][1] == players.getCurrentPlayer() && board[i][2] == players.getCurrentPlayer()) {
                return true;
            }
            if (board[0][i] == players.getCurrentPlayer() && board[1][i] == players.getCurrentPlayer() && board[2][i] == players.getCurrentPlayer()) {
                return true;
            }
        }

        if (board[0][0] == players.getCurrentPlayer() && board[1][1] == players.getCurrentPlayer() && board[2][2] == players.getCurrentPlayer()) {
            return true;
        }

        if (board[0][2] == players.getCurrentPlayer() && board[1][1] == players.getCurrentPlayer() && board[2][0] == players.getCurrentPlayer()) {
            return true;
        }

        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }
}
