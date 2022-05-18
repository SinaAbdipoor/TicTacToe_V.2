import java.util.Random;

/**
 * This class represents a game of Tic-Tac-Toe with 2 players.
 */
class Game {

    private final Player player1, player2;
    private final TicTacToeGameBoard gameBoard;
    private int roundNo;
    private Player currentPlayer;

    /**
     * Constructs a game object with the given two players.
     *
     * @param player1 Player 1 of the game.
     * @param player2 Player 2 of the game.
     * @throws IllegalArgumentException If Player1.label = Player2.label.
     */
    Game(Player player1, Player player2) throws IllegalArgumentException {
        if (player1.getLabel() == player2.getLabel())
            throw new IllegalArgumentException("Player 1 and 2 have the same label.");
        this.player1 = player1;
        this.player2 = player2;
        gameBoard = new TicTacToeGameBoard();
        roundNo = 0;
    }

    /**
     * Returns the player 1 of the game.
     *
     * @return Player1.
     */
    Player getPlayer1() {
        return player1;
    }

    /**
     * Returns the player 2 of the game.
     *
     * @return Player2.
     */
    Player getPlayer2() {
        return player2;
    }

    /**
     * Returns the Tic-Tac_Toe board of this game.
     *
     * @return Game board.
     */
    TicTacToeGameBoard getGameBoard() {
        return gameBoard;
    }

    /**
     * Returns the current round number of the game.
     *
     * @return Round number.
     */
    int getRoundNo() {
        return roundNo;
    }

    /**
     * Returns the player who is supposed to make the next move.
     *
     * @return Current player.
     */
    Player getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public String toString() {
        return "Game{" + "player1=" + player1 + ", player2=" + player2 + ", gameBoard=\n" + gameBoard + "\n, roundNo="
                + roundNo + ", currentPlayer=" + currentPlayer + ", gameStatus=" + gameBoard.getGameStatus() + '}';
    }

    /**
     * Randomly chooses one of two players.
     *
     * @return Player1 or Player2.
     */
    private Player randomPlayer() {
        if (new Random().nextBoolean()) return player1;
        return player2;
    }

    /**
     * Changes the turn to the next player to play.
     */
    private void takeTurn() {
        if (currentPlayer == player1) currentPlayer = player2;
        else currentPlayer = player1;
    }

    /**
     * This method runs one round of the Tic-Tac-Toe game and returns the winner.
     *
     * @return Winner player, null if it's a draw.
     */
    Player run() {
        roundNo++;
        gameBoard.reset();
        System.out.println("\t\t\t\t\tROUND " + roundNo + "\n");
        System.out.println("Randomly choosing who to start the game ...\n");
        currentPlayer = randomPlayer();
        while (gameBoard.getGameStatus() == -1) {
            int playerMove = currentPlayer.makeMove(gameBoard);
            gameBoard.setValue(currentPlayer.getLabel(), playerMove);
            System.out.println(currentPlayer + " chose " + (playerMove + 1) + "\n");
            takeTurn();
        }
        if (gameBoard.getGameStatus() == 1) {                                                                           // If 'X' has won, return the corresponding player
            if (player1.getLabel() == 'X') return player1;
            return player2;
        }
        if (gameBoard.getGameStatus() == 2) {                                                                           // If 'O' has won, return the corresponding player
            if (player1.getLabel() == 'O') return player1;
            return player2;
        }
        return null;                                                                                                    // Return null if it's a draw
    }
}