import java.util.ArrayList;
import java.util.Collections;

/**
 * Progress.java
 * <p>
 * This program will be the main testing environment for my research where I will look at sorting methods.
 * <p>
 *
 * @author Matthew McLaren
 * @version 06/19/2021
 */
public class Progress extends Initialize{

    public static void main(String[] args) {

        try {
            createCheckFile();
            ArrayList<Integer> checkArray = parseCheckArray();
            Collections.shuffle(checkArray);
            System.out.println(checkArray.get(0));
            System.out.println(checkArray.get(checkArray.size() - 1));
        } catch (InvalidPathException e) {
            e.printStackTrace();
        }
    }

}
