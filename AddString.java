class AddString {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        
        int i = num1.length() - 1; // Pointer for num1
        int j = num2.length() - 1; // Pointer for num2
        int carry = 0;             // Stores carry value

        // Loop while there are digits left to add or a carry remaining
        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            int totalSum = digit1 + digit2 + carry;
            
            // Append the last digit of totalSum
            result.append(totalSum % 10);
            
            // Update the carry for the next step
            carry = totalSum / 10;

            // Move pointers left
            i--;
            j--;
        }

        // Reverse to get the correct order (most significant digit first)
        return result.reverse().toString();
    }
}