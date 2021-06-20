/*
1232. Check If It Is a Straight Line

You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

 

 

Example 1:



Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:



Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
 

Constraints:

2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.

*/

//slope   y2-y1 / x2-x1  

class Solution {
    public boolean checkStraightLine(int[][] cord) {
        if (cord.length<3)
            return true;
        int x2 = cord[1][0];
        int x1 = cord[0][0];
        int y2 = cord[1][1];
        int y1 = cord[0][1];
        
        for(int i = 1 ; i < cord.length-1 ; i++){
            int dx = cord[i+1][0];
            int dy = cord[i+1][1];

            if (((y2-y1) * (dx-x2)) != ((x2-x1) * (dy-y2)))
                return false;
        }
        return true;
    }
}
