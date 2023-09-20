import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Exercise6 {
    public static void main(String[] args)
            throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        System.out.println(converter(input));
    }

    private static ArrayList<String> Months = new ArrayList<String>(
            Arrays.asList("Jan", "Feb", "March", "April", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"));

    private static String converter(String in) {
        String[] split; // Day / Month / year
        split = in.split("/");

        Integer monthID = Integer.parseInt(split[1]) - 1;

        return split[0] + " " + Months.get(monthID) + " " + split[2];
    }
}
