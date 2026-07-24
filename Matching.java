class Matching {
    public boolean isMatch(String s, String p) {
        // Base case: If pattern is empty, string must also be empty
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        // Check if the first character matches
        boolean firstMatch = (!s.isEmpty() && 
            (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));

        // Case 1: The second character in pattern is '*'
        if (p.length() >= 2 && p.charAt(1) == '*') {
            // Choice 1: Treat '*' as 0 occurrences -> skip x* in pattern
            // Choice 2: Treat '*' as 1+ occurrences -> consume 1 char in s (if firstMatch is true)
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        } 
        // Case 2: No '*' following, just proceed character by character
        else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}