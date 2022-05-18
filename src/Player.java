abstract class Player {

    private final String name;
    private final char label;                                                                                           // Player label: 'X' or 'O'
    private int score;

    /**
     * Constructs a player object with the given name and label.
     *
     * @param name  The name, or nickname, of the player.
     * @param label The label of the player ('X' or 'O').
     * @throws IllegalArgumentException If the given label is not 'X' or 'O'.
     */
    Player(String name, char label) throws IllegalArgumentException {
        this.name = name;
        char upperLabelValue = Character.toUpperCase(label);
        if (!(upperLabelValue == 'X' || upperLabelValue == 'O'))
            throw new IllegalArgumentException("The player's label can only be 'X' or 'O'");
        this.label = upperLabelValue;
        score = 0;
    }

    /**
     * Returns the name of the player.
     *
     * @return Player name.
     */
    String getName() {
        return name;
    }

    /**
     * Returns the label of the player ('X' or 'O').
     *
     * @return Player label.
     */
    char getLabel() {
        return label;
    }

    /**
     * Returns the current score of the player.
     *
     * @return Player score.
     */
    int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return name + " (" + label + ")";
    }

    /**
     * Adds 1 point to the current score of the player.
     */
    void addScore() {
        score++;
    }

    /**
     * Asks the player to make their next move and returns the index of the chosen game board slot.
     *
     * @param gameBoard The current Tic-Tac-Toe game board for the player to make their next move on.
     * @return The index of the chosen game board slot.
     */
    abstract int makeMove(TicTacToeGameBoard gameBoard);
}