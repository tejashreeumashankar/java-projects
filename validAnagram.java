class validAnagram   {
    public boolean isAnagram(String s, String t) {
        //check if both strings have the same length
        if (s.length() != t.length()){
            return false;
        }

        //convert strings to character arrays
        char[]first = s.toCharArray();
        char[]second = t.toCharArray();

        //sort both arrays
        Arrays.sort(first);
        Arrays.sort(second);

        //compare the  sorted arrays
        return Arrays.equals(first, second);
    }
        
    
}