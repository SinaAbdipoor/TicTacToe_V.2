import java.util.Scanner;

/**
 * This class represents a human player in the Tic-Tac-Toe game.
 */
class HumanPlayer extends Player {

    /**
     * Constructs a human player with the given name and label.
     *
     * @param name  The player name (nickname).
     * @param label The player label ('X' or 'O').
     * @throws IllegalArgumentException If the given label is not 'X' or 'O'.
     */
    HumanPlayer(String name, char label) throws IllegalArgumentException {
        super(name, label);
    }

    @Override
    int makeMove(TicTacToeGameBoard gameBoard) {
        int index;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print(this + ", it's your turn. Please choose one of the empty slots (1-9) as your next move: ");
            // Making sure the input is a number
            while (!scanner.hasNextInt()) {
                System.out.print("That's not a number! Try again: ");
                scanner.next();
            }
            index = scanner.nextInt() - 1;
            // Making sure the input index is an empty slot and is in range
        } while (!gameBoard.getEmptySlots().contains(index));
        return index;
    }
}