import java.util.ArrayList;

/**
 * Progress.java
 * <p>
 * This program will be the main testing environment for my research where I will look at sorting methods.
 * <p>
 *
 * @author Matthew McLaren
 * @version 07/02/2021
 */
public class Main extends Initialize {

    public static void main(String[] args) {

        // initializes the project
        System.out.println("Setting up...");
        try {
            createCheckFile(1000); // makes the check file
            ArrayList<Integer> array = parseCheckArray(); // grabs the check array from file
            shuffleArray(array); // shuffles values
            createRandomFile(array); // sends it back to the random file
        } catch (InvalidPathException e) {
            e.printStackTrace();
        }
        System.out.println("Setup Complete.");

        // begin a test
        System.out.println("Beginning to sort...");
        BubbleSort bs = new BubbleSort(parseCheckArray(), parseRandomArray());
        System.out.println("Sorting is finished.");

        // results
        System.out.println("Algorithm Run Time: " + bs.getTimeInSeconds());
        System.out.println("Passes Made: " + bs.getPassCount());
        System.out.println("Comparisons Made: " + bs.getCompareCount());
        System.out.println("Array Accesses Made: " + bs.getArrayAccessCount());
    }

}
