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
    }

    /**
     * Returns a string containing some initial information to be shown at the start.
     *
     * @return Initial information.
     */
    static String initialInformation() {
        return "Welcome to Tic-Tac-Toe!" +
                "\n\nX | O | " +
                "\n---------" +
                "\n  |   | O" +
                "\n---------" +
                "\nX |   | X" +
                "\n\nThis project is a simple Java implementation of the Tic-Tac-Toe game. This project has been " +
                "\nassigned as the final group project to the SSK3101 _ Java Programming 2 in the semester 1 " +
                "\n2022/2023 at Universiti Putra Malaysia (UPM)." +
                "\n\n*Although this implementation aims to provide a sample solution to my students, it should not " +
                "\nbe considered as a reference for standard coding as it is in no way optimized and does not follow " +
                "\nthe clean coding practices.* However, it has been tried to follow the basic principles of the " +
                "\nObject-Oriented Programming (OOP) and practice what we have discussed in our lab sessions in the " +
                "\nimplementation of this project." +
                "\n\nThis passion project has been done in my free time, and it serves the purpose of providing a " +
                "\nsample code for the final project of the SSK3101 course. Furthermore, it is hoped that this " +
                "\nimplementation can introduce fundamentals of AI to my students and show them what can be achieved " +
                "\nwith a bit of programming and AI." +
                "\n\nThe main features of this project include:" +
                "\n\t* Player vs. Player game;" +
                "\n\t* Player vs. Random Bot game;" +
                "\n\t* Player vs. learning AI Bot game;" +
                "\n\t* Training AI Bot against Random Bot;" +
                "\n\t* Training AI Bot against itself;" +
                "\n\t* Saving the Custom trained AI Bot in an external file;" +
                "\n\t* And loading a trained AI Bot with different difficulties (Easy, Medium, Hard, Custom) from " +
                "\n\texternal files." +
                "\n\nThis project is fully open-source. Anybody is free to use, study, modify, and distribute this " +
                "\nproject for any purpose. HOWEVER, MY STUDENTS ARE NOT ALLOWED TO COPY ANY PART OF THIS CODE IN " +
                "\nTHEIR PROJECT. For more information, feel free to read the license file." +
                "\n\nBy: Sina Abdipoor" +
                "\nFor more information, visit my website: https://sites.google.com/view/sina-abdipoor" +
                "\n\nEnjoy!" +
                "\n--------------------------------------------------------------------------------------------------";
    }
}