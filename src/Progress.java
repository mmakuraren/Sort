import java.util.ArrayList;

/**
 * Progress.java
 * <p>
 * This program will be the main testing environment for my research where I will look at sorting methods.
 * <p>
 *
 * @author Matthew McLaren
 * @version 06/19/2021
 */
public class Progress extends Initialize {

    public static void main(String[] args) {

        // initializes the project
        try {
            createCheckFile(); // makes the check file
            ArrayList<Integer> array = parseCheckArray(); // grabs the check array from file
            shuffleArray(array); // shuffles values
            createRandomFile(array); // sends it back to the random file
        } catch (InvalidPathException e) {
            e.printStackTrace();
        }

        // begin a test
    }

}
