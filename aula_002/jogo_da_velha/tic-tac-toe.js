class TicTacToe {
    constructor() {
        this.board = Array.from({ length: 3 }, () => ['', '', '']);
        this.currentPlayer = 'X';
        this.gameOver = false;
        this.messageElement = document.getElementById('message');
        this.initializeBoard();
    }

    initializeBoard() {
        const boardElement = document.getElementById('game-board');
        boardElement.innerHTML = '';

        for (let i = 0; i < 3; i++) {
            for (let j = 0; j < 3; j++) {
                const cell = document.createElement('div');
                cell.classList.add('cell');
                cell.dataset.row = i;
                cell.dataset.col = j;
                cell.addEventListener('click', () => this.play(i, j));
                boardElement.appendChild(cell);
            }
        }
    }

    play(row, col) {
        if (this.gameOver || this.board[row][col] !== '') {
            return;
        }

        this.board[row][col] = this.currentPlayer;
        this.updateBoard();

        if (this.checkWin()) {
            this.messageElement.textContent = `Jogador ${this.currentPlayer} venceu!`;
            this.gameOver = true;
        } else if (this.isBoardFull()) {
            this.messageElement.textContent = "O jogo terminou em empate!";
            this.gameOver = true;
        } else {
            this.switchToNextPlayer();
        }
    }

    updateBoard() {
        document.querySelectorAll('.cell').forEach(cell => {
            const { row, col } = cell.dataset;
            cell.textContent = this.board[row][col];
        });
    }

    checkWin() {
        const winningCombinations = [
            // Linhas
            [{ r: 0, c: 0 }, { r: 0, c: 1 }, { r: 0, c: 2 }],
            [{ r: 1, c: 0 }, { r: 1, c: 1 }, { r: 1, c: 2 }],
            [{ r: 2, c: 0 }, { r: 2, c: 1 }, { r: 2, c: 2 }],
            // Colunas
            [{ r: 0, c: 0 }, { r: 1, c: 0 }, { r: 2, c: 0 }],
            [{ r: 0, c: 1 }, { r: 1, c: 1 }, { r: 2, c: 1 }],
            [{ r: 0, c: 2 }, { r: 1, c: 2 }, { r: 2, c: 2 }],
            // Diagonais
            [{ r: 0, c: 0 }, { r: 1, c: 1 }, { r: 2, c: 2 }],
            [{ r: 0, c: 2 }, { r: 1, c: 1 }, { r: 2, c: 0 }],
        ];

        return winningCombinations.some(combination => 
            combination.every(({ r, c }) => this.board[r][c] === this.currentPlayer)
        );
    }

    isBoardFull() {
        return this.board.every(row => row.every(cell => cell !== ''));
    }

    switchToNextPlayer() {
        this.currentPlayer = this.currentPlayer === 'X' ? 'O' : 'X';
    }
}

// Inicia o jogo quando o documento é carregado
document.addEventListener('DOMContentLoaded', () => {
    new TicTacToe();
});
