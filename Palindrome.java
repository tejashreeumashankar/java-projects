class Palindrome {
    public boolean isPalindrome(int x) {
        // Negative numbers cannot be palindromes (e.g., -121 reversed is 121-)
        if (x < 0) {
            return false;
        }
        
        int original = x;
        int reversed = 0;
        
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            
            // Handle potential integer overflow before multiplying
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && pop > 7)) {
                return false;
            }
            
            reversed = reversed * 10 + pop;
        }
        
        return original == reversed;
    }
}