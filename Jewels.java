class Jewels {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;

        // Loop through each stone you have
        for (int i = 0; i < stones.length(); i++) {
            char stone = stones.charAt(i);

            // Check if this stone matches any of the jewels
            for (int j = 0; j < jewels.length(); j++) {
                char jewel = jewels.charAt(j);

                if (stone == jewel) {
                    count++;
                    break; // Found a match, no need to check other jewels for this stone
                }
            }
        }

        return count;
    }
}