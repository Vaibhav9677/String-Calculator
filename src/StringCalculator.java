import java.util.ArrayList;
import java.util.List;


public class StringCalculator {

    int sum;

    public StringCalculator()
    {
        this.sum = 0;
    }

    public int add(String numbers) {   
        //numbers (string) is empty or null
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String delimiter = "[,\n]"; // default delimiters

        // Check if custom delimiter is defined
        if (numbers.startsWith("//")) {
            int newlineIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, newlineIndex); // get custom delimiter
            numbers = numbers.substring(newlineIndex + 1);   // rest of string
        }

        // Split using either default or custom delimiter
        String[] parts = numbers.split(delimiter);
        List<Integer> negatives = new ArrayList<>();

        for (String part : parts) {
            if (!part.trim().isEmpty()) {
                int value = Integer.parseInt(part.trim());
                if (value < 0) {
                    negatives.add(value);
                }
                sum += value;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: "+ negatives.toString().replaceAll("[\\[\\] ]",""));
        }

        return sum;
    }
}
