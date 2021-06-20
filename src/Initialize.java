import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Initialize.java
 * <p>
 * This is a simple program that creates a list of numbers from 1-100000 from lowest to highest. Primary use of this
 * program will only be for backing up the check folder in case something goes wrong. In most cases this is only used
 * for beginning the program.
 * <p>
 *
 * @author Matthew McLaren
 * @version 06/19/2021
 */
public class Initialize {

    private static final String CHECKFILEPATH = "prog/check.txt";  // path for the check file
    private static final String RANDOMFILEPATH = "prog/random.txt";  // path for the random file
    private static final String CASEFILEPATH = "prog/case.txt";  // path for the case file

    /**
     * This static method creates the check.txt file in case something happens with it that shouldn't happen.
     *
     * @throws InvalidPathException if invalid path is given
     */
    public static void createCheckFile() throws InvalidPathException {
        // finds the file so it can override it
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CHECKFILEPATH))) {
            // adds the numbers from 1-10000000
            for (int i = 1; i <= 100000; i++) {
                bw.write(i + "\n"); // adds the number in
            }
            bw.close();
        } catch (IOException e) {
            // this should only print if the path is bad
            throw new InvalidPathException();
        }
    }

    /**
     * This is a static method that builds the random.txt file for sorting. Mostly will be used to initiate the tests.
     *
     * @param shuffleArray the shuffled array of numbers
     * @throws InvalidPathException if invalid path is given
     */
    public static void createRandomFile(ArrayList<Integer> shuffleArray) throws InvalidPathException {
        // finds the file so it can override it
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RANDOMFILEPATH))) {
            // adds the numbers from shuffled array list
            for (Integer i : shuffleArray) {
                bw.write(i + "\n");
            }
            bw.close();
        } catch (IOException e) {
            // this should only print if the path is bad
            throw new InvalidPathException();
        }
    }

    /**
     * This static method returns the check array needed to keep track of progress.
     *
     * @return the check array which remains unchanged
     */
    public static ArrayList<Integer> parseCheckArray() {
        ArrayList<Integer> checkArray = new ArrayList<>(); // initialize array list

        // grabs values
        try (BufferedReader br = new BufferedReader(new FileReader(CHECKFILEPATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                checkArray.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // returns array list
        return checkArray;
    }

    /**
     * This static method returns the random array needed to keep track of progress.
     *
     * @return the random array inside of the random.txt file
     */
    public static ArrayList<Integer> parseRandomArray() {
        ArrayList<Integer> randomArray = new ArrayList<>(); // initialize array list

        // grabs values
        try (BufferedReader br = new BufferedReader(new FileReader(RANDOMFILEPATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                randomArray.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // returns array list
        return randomArray;
    }

    /**
     * This static method will return a boolean for the result of how randomized the random.txt values are.
     *
     * @param array an array of numbers (starting at 1 to a limit)
     * @return boolean expression responding to how shuffled the array is
     */
    public static boolean compareShuffle(ArrayList<Integer> array) {
        // checks to make sure that the array is completely shuffled to start for max test results
        int i = 1;
        for (Integer number : array) {
            if (number == i) {
                return false;
            } else {
                i++;
            }
        }

        return true; // returns if the array is shuffled
    }

    /**
     * This static method will shuffle the numbers until everything is in a different spot from the original.
     *
     * @param array an array of numbers (starting at 1 to a limit)
     */
    public static void shuffleArray(ArrayList<Integer> array) {
        Collections.shuffle(array); // shuffles the array

        // checks to make sure that everything is shuffled
        while (!compareShuffle(array)) {
            Collections.shuffle(array); // shuffles the array again
            System.out.println("shuffled again");
        }
    }

}
