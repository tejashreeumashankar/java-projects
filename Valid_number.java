class Valid_number {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenE = false;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
                seenDigit = true;
                
            } else if (ch == '+' || ch == '-') {
                // Signs can only appear at the very beginning or right after an 'e' or 'E'
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
                
            } else if (ch == '.') {
                // A dot is invalid if we've already seen another dot or an exponent ('e'/'E')
                if (seenDot || seenE) {
                    return false;
                }
                seenDot = true;
                
            } else if (ch == 'e' || ch == 'E') {
                // An exponent is invalid if we've already seen one, or if no digits came before it
                if (seenE || !seenDigit) {
                    return false;
                }
                seenE = true;
                // We reset seenDigit because an exponent must be followed by a new set of digits
                seenDigit = false;
                
            } else {
                // Any other character (like letters, spaces, or special characters) makes it invalid
                return false;
            }
        }
        
        // The string is valid only if it ended with a valid digit sequence
        return seenDigit;
    }
}