import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;           // For Pattern and Matcher classes

public class StringCalculator {

    int sum;                        // Holds the running sum for the current operation
    public static int count = 0;    // Static counter to track how many times 'add()' was get called

    // Default Constructor initializes sum to 0
    public StringCalculator()
    {
        this.sum = 0;
    }

    // Returns how many times 'add' has been called (static across all instances)
    public int GetCalledCount(){
        return count;
    }

    // add method: takes a string of numbers and returns their sum
    public int add(String numbers) {   
        count++;

        //numbers (string) is empty or null return 0
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String delimiter = "[,|\n]"; // default delimiters

        // Check for custom delimiter syntax ("//... \n numbers")
        if (numbers.startsWith("//")) {

            //Get the index for first newline character
            int newlineIndex = numbers.indexOf("\n");

            //Extract the custom delimiter for main string
            String multiDelimiters = numbers.substring(2, newlineIndex);

            // rest of string
            numbers = numbers.substring(newlineIndex + 1);   

            // Case 1: Multiple or multi-character delimiters inside [ ]
            if(multiDelimiters.startsWith("["))
            {
                //store multiple delimiters
                List<String> delimiters = new ArrayList<>();

                // Use regex to find all delimiters inside square brackets
                Matcher tokens = Pattern.compile("\\[(.*?)]").matcher(multiDelimiters);

                // Add each delimiter to the list, quoted so regex meta chars don’t break
                while(tokens.find())
                {
                    delimiters.add(Pattern.quote(tokens.group(1)));
                }

                // Join delimiters with regex OR ("|") so split() can use all of them
                delimiter = String.join("|", delimiters);
            }
            else
            {
                // Case 2: Single character delimiter (like //;\n1;2) (default delimiters)
                delimiter = Pattern.quote(multiDelimiters);
            }
        }

        // Split using either default or custom delimiter
        String[] parts = numbers.split(delimiter);
        List<Integer> negatives = new ArrayList<>();        // Track negatives for exception

        sum = 0;
        for (String part : parts) {
            if (!part.trim().isEmpty()) {
                int value = Integer.parseInt(part.trim());

                //add to the negative number list
                if (value < 0) {
                    negatives.add(value);
                }
                else if(value <= 1000)              //Ignore numbers greater than 1000, add valid ones
                {
                    sum += value;
                }
                
            }
        }

        // If negatives exist, throw exception with formatted message
        if (!negatives.isEmpty()) {
            // Convert list to string, remove brackets and spaces
            throw new IllegalArgumentException("negatives not allowed: "+ negatives.toString().replaceAll("[\\[\\] ]",""));
        }

        //return the sum
        return sum;
    }
}
