
public class StringCalculator {

    public int add(String numbers) {
        
        //numbers (string) is empty or null
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String[] parts = numbers.split(",");
        int sum = 0;

        for (String part : parts) {
            sum += Integer.parseInt(part.trim());
        }

        return sum;
    }
}
