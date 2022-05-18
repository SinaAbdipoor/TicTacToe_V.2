import java.util.Scanner;

/**
 * This is the main class of the project.
 */
public class Main {

    /**
     * This is the main method and the starting point of the project. It prints some initial information, initiates and
     * runs the code. Your journey to review and debug the code starts here. Start checking the code from here just
     * like we practiced in the class.
     *
     * @param args The initial arguments (parameters) necessary to run the project. In our case, we don't need any.
     */
    public static void main(String[] args) {
        System.out.println(initialInformation());
        final Game game = initiateGame(getGameMode());
        //TODO
    }

    /**
     * Returns a string containing some initial information to be shown at the start.
     *
     * @return Initial information.
     */
    static String initialInformation() {
        return "Welcome to Tic-Tac-Toe!"
                + "\n\nX | O | "
                + "\n---------"
                + "\n  |   | O"
                + "\n---------"
                + "\nX |   | X"
                + "\n\nThis project is a simple Java implementation of the Tic-Tac-Toe game. This project has been "
                + "\nassigned as the final group project to the SSK3101 _ Java Programming 2 in the semester 1 "
                + "\n2022/2023 at Universiti Putra Malaysia (UPM)."
                + "\n\n*Although this implementation aims to provide a sample solution to my students, it should not "
                + "\nbe considered as a reference for standard coding as it is in no way optimized and does not follow "
                + "\nthe clean coding practices.* However, it has been tried to follow the basic principles of the "
                + "\nObject-Oriented Programming (OOP) and practice what we have discussed in our lab sessions in the "
                + "\nimplementation of this project."
                + "\n\nThis passion project has been done in my free time, and it serves the purpose of providing a "
                + "\nsample code for the final project of the SSK3101 course. Furthermore, it is hoped that this "
                + "\nimplementation can introduce fundamentals of AI to my students and show them what can be achieved "
                + "\nwith a bit of programming and AI."
                + "\n\nThe main features of this project include:"
                + "\n\t* Player vs. Player game;"
                + "\n\t* Player vs. Random Bot game;"
                + "\n\t* Player vs. learning AI Bot game;"
                + "\n\t* Training AI Bot against Random Bot;"
                + "\n\t* Training AI Bot against itself;"
                + "\n\t* Saving the Custom trained AI Bot in an external file;"
                + "\n\t* And loading a trained AI Bot with different difficulties (Easy, Medium, Hard, Custom) from "
                + "\n\texternal files."
                + "\n\nThis project is fully open-source. Anybody is free to use, study, modify, and distribute this "
                + "\nproject for any purpose. HOWEVER, MY STUDENTS ARE NOT ALLOWED TO COPY ANY PART OF THIS CODE IN "
                + "\nTHEIR PROJECT. For more information, feel free to read the license file."
                + "\n\nBy: Sina Abdipoor"
                + "\nFor more information, visit my website: https://sites.google.com/view/sina-abdipoor"
                + "\n\nEnjoy!"
                + "\n-------------------------------------------------------------------------------------------------";
    }

    /**
     * Gets the game mode as an input from user.
     *
     * @return GameMode.
     */
    private static int getGameMode() {
        System.out.println("To start the game, first, choose your desired game mode:" + "\n1) Player vs. Player"
                + "\n2) Player vs. Random Bot" + "\n3) Player vs. AI Bot" + "\n4) Train the AI Bot");
        int gameMode;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Please choose the game mode slots (1-4): ");
            // Making sure the input is a number
            while (!scanner.hasNextInt()) {
                System.out.print("That's not a number! Try again: ");
                scanner.next();
            }
            gameMode = scanner.nextInt();
            // Making sure the input is in range
        } while (gameMode < 1 || gameMode > 4);
        return gameMode;
    }

    /**
     * Initiates a Tic-Tac-Toe game based on the given game mode.
     *
     * @param gameMode The game mode.
     * @return An initiated Tic-Tac-Toe game object.
     */
    private static Game initiateGame(int gameMode) {
        Player player1 = null, player2 = null;
        switch (gameMode) {
            case 1 -> {
                System.out.println("Selected game mode: 1) Play against a friend.");
                System.out.println("Player 1:");
                player1 = new HumanPlayer(getPlayerName(), getPlayerLabel());
                System.out.println("Player 2:");
                player2 = new HumanPlayer(getPlayerName(), getOppositeLabel(player1.getLabel()));
            }
            case 2 -> {
                System.out.println("Selected game mode: 2) Play against the stupid bot.");
                System.out.println("Player 1:");
                player1 = new HumanPlayer(getPlayerName(), getPlayerLabel());
                System.out.println("Player 2: StupidBot");
                player2 = new RandomBot(getOppositeLabel(player1.getLabel()));
            }
            case 3 -> throw new UnsupportedOperationException("Not implemented yet.");

//                break;
            case 4 -> throw new UnsupportedOperationException("Not implemented yet.");

//                break;
        }
        return new Game(player1, player2);
    }

    /**
     * Gets the player's name as an input.
     *
     * @return Player's name.
     */
    private static String getPlayerName() {
        System.out.print("Please enter your name (nickname): ");
        return new Scanner(System.in).next();
    }

    /**
     * Gets the player's label ('X' or 'O').
     *
     * @return Player's label ('X' or 'O').
     */
    private static char getPlayerLabel() {
        Scanner sc = new Scanner(System.in);
        char upperCaseLabel;
        do {
            System.out.print("Please enter your label (X or O): ");
            upperCaseLabel = Character.toUpperCase(sc.next().charAt(0));
        } while (upperCaseLabel != 'X' && upperCaseLabel != 'O');
        return upperCaseLabel;
    }

    /**
     * Returns the opposite label of the input label.
     *
     * @param label The input label.
     * @return 'X' if input label is 'O', 'O' if input label is 'X'.
     */
    private static char getOppositeLabel(char label) {
        if (Character.toUpperCase(label) == 'X') return 'O';
        return 'X';
    }
}