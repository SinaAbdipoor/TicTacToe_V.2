import java.util.Random;

/**
 * This class represents a random (stupid) bot.
 */
class RandomBot extends Player {

    /**
     * Constructs a random bot object.
     *
     * @param label The bot label ('X' or 'O').
     * @throws IllegalArgumentException If the given label is not 'X' or 'O'.
     */
    RandomBot(char label) throws IllegalArgumentException {
        super("Stupid Bot", label);
    }

    @Override
    int makeMove(TicTacToeGameBoard gameBoard) {
        return gameBoard.getEmptySlots().get(new Random().nextInt(gameBoard.getEmptySlots().size()));
    }
}