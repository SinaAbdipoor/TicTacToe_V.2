import java.util.ArrayList;

/**
 * This class represents the board for the Tic-Tac-Toe game. The board is represented using a char[9], which represents
 * the 3 * 3 game board. Each of these slots can be filled with 'X' or 'O' by the players.
 */
class TicTacToeGameBoard {

    private final char[] gameBoard;

    /**
     * Constructs and initiates an empty (' ') Tic-Tac-Toe game board.
     */
    TicTacToeGameBoard() {
        gameBoard = new char[9];
        for (int i = 0; i < gameBoard.length; i++)
            gameBoard[i] = ' ';
    }

    /**
     * Sets the value of the given index in the game board to the given label (value).
     *
     * @param value The label 'X' or 'O'.
     * @param index The desired index of the game board.
     * @throws IllegalArgumentException  If the given value is not 'X' or 'O', or if the given index of the game board
     *                                   is not empty.
     * @throws IndexOutOfBoundsException If the given index is out of the bounds of the game board (< 0 or > 8).
     */
    void setValue(char value, int index) throws IllegalArgumentException, IndexOutOfBoundsException {
        char upperCaseValue = Character.toUpperCase(value);
        if (!(upperCaseValue == 'X') || upperCaseValue == 'O')
            throw new IllegalArgumentException("The only acceptable labels as input values are: 'X' and 'O'.");
        if (gameBoard[index] != ' ')
            throw new IllegalArgumentException("This index of the game board is already occupied.");
        gameBoard[index] = upperCaseValue;
    }

    @Override
    public String toString() {
        return gameBoard[0] + " | " + gameBoard[1] + " | " + gameBoard[2]
                + "\n---------\n" + gameBoard[3] + " | " + gameBoard[4] + " | " + gameBoard[5]
                + "\n---------\n" + gameBoard[6] + " | " + gameBoard[7] + " | " + gameBoard[8];
    }

    /**
     * Returns the indexes of the empty slots in the game board.
     *
     * @return ArrayList<i>, where gameBoard[i] == ' '.
     */
    ArrayList<Integer> getEmptySlots() {
        ArrayList<Integer> emptySlots = new ArrayList<>();
        for (int i = 0; i < gameBoard.length; i++)
            if (gameBoard[i] == ' ') emptySlots.add(i);
        return emptySlots;
    }

    /**
     * Returns the current status of the game.
     *
     * @return -1 if the game is not over yet, 0 if it's a draw, 1 if 'X' has won, and 2 if 'O' has won.
     */
    int getGameStatus() {
        // Checking for horizontal winner
        for (int i = 0; i < gameBoard.length; i += 3)
            if (gameBoard[i] == gameBoard[i + 1] && gameBoard[i + 1] == gameBoard[i + 2]) {
                if (gameBoard[i] == 'X') return 1;
                if (gameBoard[i] == 'O') return 2;
            }
        // Checking for vertical winner
        for (int i = 0; i < 3; i++)
            if (gameBoard[i] == gameBoard[i + 3] && gameBoard[i + 3] == gameBoard[i + 6]) {
                if (gameBoard[i] == 'X') return 1;
                if (gameBoard[i] == 'O') return 2;
            }
        // Checking for diagonal winner
        if ((gameBoard[0] == gameBoard[4] && gameBoard[4] == gameBoard[8])
                || (gameBoard[2] == gameBoard[4] && gameBoard[4] == gameBoard[6])) {
            if (gameBoard[4] == 'X') return 1;
            if (gameBoard[4] == 'O') return 2;
        }
        // Checking for empty slots (game not over)
        for (char c : gameBoard)
            if (c == ' ') return -1;
        // Otherwise, it's a draw
        return 0;
    }
}