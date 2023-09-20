import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MyExceptionGen {
    public static void main(String[] args)
            throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Integer flipped;

        try {
            
            flipped = numberFlip(Integer.parseInt(input));
            System.out.println(flipped.toString());

        } catch (Exception NumberFormatException) {
            System.out.println("Please enter a number.\n");
        }

    }

    private static Integer numberFlip(Integer number) {
        char[] split = number.toString().toCharArray();
        char[] out = new char[split.length];

        for (int i = split.length - 1; i >= 0; i--) {
            out[split.length - 1 - i] = split[i];
        }

        return Integer.parseInt(String.valueOf(out));
    }
}
