class Straightline {
    public boolean checkStraightLine(int[][] coordinates) {
        // Step 1: Get the coordinates of the first two points
        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];
        
        // Step 2: Calculate the baseline change in x and y
        int dx = x1 - x0;
        int dy = y1 - y0;
        
        // Step 3: Check the slope for all other points
        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];
            
            // Using cross-multiplication: dy * (x - x0) != dx * (y - y0)
            if (dy * (x - x0) != dx * (y - y0)) {
                return false;
            }
        }
        
        return true;
    }
}