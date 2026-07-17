class Atoi {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = 0;
        int n = s.length();

        // 1. Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Check if we've reached the end of the string after skipping spaces
        if (i == n) {
            return 0;
        }

        // 2. Check for sign
        int sign = 1;
        if (s.charAt(i) == '+') {
            i++;
        } else if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        // 3. Convert characters to integer and handle overflow
        int result = 0;
        while (i < n) {
            char ch = s.charAt(i);
            
            // If it's not a digit, stop processing immediately
            if (ch < '0' || ch > '9') {
                break;
            }

            int digit = ch - '0';

            // 4. Handle 32-bit signed integer overflow/underflow
            // Integer.MAX_VALUE / 10 is 214748364
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}