
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
        // Split by comma OR newline
        String[] parts = numbers.split("[,\n]");

        for (String part : parts) {
            if (!part.trim().isEmpty()) {
                sum += Integer.parseInt(part.trim());
            }
        }

        return sum;
    }
}
