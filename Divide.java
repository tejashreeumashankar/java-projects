class Divide {
    public int divide(int dividend, int divisor) {
        // 1. Handle overflow edge case: -2147483648 / -1 would be 2147483648 (out of 32-bit range)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // 2. Determine the sign of the result
        // If one is negative and the other is positive, the result is negative
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // 3. Convert numbers to long to easily handle overflow/absolute values
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);

        long quotient = 0;

        // 4. Perform division using repeated addition/subtraction
        while (lDividend >= lDivisor) {
            long tempDivisor = lDivisor;
            long multiple = 1;

            // Keep doubling the divisor as long as it fits inside the dividend
            while (lDividend >= (tempDivisor + tempDivisor)) {
                tempDivisor += tempDivisor; // Double the divisor
                multiple += multiple;       // Double the count
            }

            // Subtract the largest accumulated divisor chunk from dividend
            lDividend -= tempDivisor;
            // Add the corresponding count to our final quotient
            quotient += multiple;
        }

        // 5. Apply the correct sign and return
        return isNegative ? (int) -quotient : (int) quotient;
    }
}