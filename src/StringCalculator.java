import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class StringCalculator {

    int sum;
    public static int count = 0;

    public StringCalculator()
    {
        this.sum = 0;
    }

    public int GetCalledCount(){
        return count;
    }

    public int add(String numbers) {   
    
        count++;
        //numbers (string) is empty or null
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String delimiter = "[,|\n]"; // default delimiters

        // Check if custom delimiter is defined
        if (numbers.startsWith("//")) {
            int newlineIndex = numbers.indexOf("\n");
            String multiDelimiters = numbers.substring(2, newlineIndex); // get custom delimiter
            numbers = numbers.substring(newlineIndex + 1);   // rest of string

            if(multiDelimiters.startsWith("["))
            {
                //store multiple delimiters
                List<String> delimiters = new ArrayList<>();

                //find the group of the those multiple delimiters
                Matcher tokens = Pattern.compile("\\[(.*?)]").matcher(multiDelimiters);

                while(tokens.find())
                {
                    delimiters.add(Pattern.quote(tokens.group(1)));
                }

                delimiter = String.join("|", delimiters);
            }
            else
            {
                delimiter = Pattern.quote(multiDelimiters);
            }
        }
        // Split using either default or custom delimiter
        String[] parts = numbers.split(delimiter);
        List<Integer> negatives = new ArrayList<>();

        sum = 0;
        for (String part : parts) {
            if (!part.trim().isEmpty()) {
                int value = Integer.parseInt(part.trim());
                if (value < 0) {
                    negatives.add(value);
                }
                else if(value <= 1000)
                {
                    sum += value;
                }
                
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: "+ negatives.toString().replaceAll("[\\[\\] ]",""));
        }

        return sum;
    }
}
