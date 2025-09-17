
public class StringCalculator {

    public int add(String numbers) {
        
        //numbers (string) is empty or null
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        // Split by comma OR newline
        String[] parts = numbers.split("[,\n]");
        int sum = 0;

        for (String part : parts) {
            if (!part.trim().isEmpty()) {
                sum += Integer.parseInt(part.trim());
            }
        }

        return sum;
    }
}
