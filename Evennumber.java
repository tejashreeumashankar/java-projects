class Evennumber {
    public int findNumbers(int[] nums) {
        // Step 1: Create a variable to count how many numbers have an even number of digits
        int count = 0;
        
        // Step 2: Loop through every number in the array
        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            
            // Step 3: Convert the number to a String to find its length (number of digits)
            String numberAsString = String.valueOf(currentNumber);
            int numberOfDigits = numberAsString.length();
            
            // Step 4: Check if the number of digits is even (divisible by 2)
            if (numberOfDigits % 2 == 0) {
                count++; // If even, increase our counter by 1
            }
        }
        
        // Step 5: Return the final count
        return count;
    }
}