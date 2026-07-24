import java.util.ArrayList;
import java.util.List;

class KeyboardRow {
    public String[] findWords(String[] words) {
        // Define the 3 rows of the keyboard (all lowercase)
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";
        
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            String lowerWord = word.toLowerCase();
            
            // Find which row the first character belongs to
            String targetRow = "";
            char firstChar = lowerWord.charAt(0);
            
            if (row1.indexOf(firstChar) != -1) {
                targetRow = row1;
            } else if (row2.indexOf(firstChar) != -1) {
                targetRow = row2;
            } else {
                targetRow = row3;
            }
            
            // Check if all other characters belong to the same target row
            boolean isValid = true;
            for (int i = 1; i < lowerWord.length(); i++) {
                char c = lowerWord.charAt(i);
                // indexOf returns -1 if the character is not found in targetRow
                if (targetRow.indexOf(c) == -1) {
                    isValid = false;
                    break;
                }
            }
            
            // If every letter matched the row, keep the word
            if (isValid) {
                result.add(word);
            }
        }
        
        // Convert the List back to a String array
        return result.toArray(new String[0]);
    }
}