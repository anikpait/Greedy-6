// Time Complexity : 
/*                      Approach 1 : Using Greedy: O(log n) where n is the difference between Y and X
                        Approach 2: Using BFS: O(n) where n is the difference between Y and X
// Space Complexity :
/*                      Approach 1 : O(1)
                        Approach 2: O(n) for queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Understanding the reason behind start from Y not X
/* Your code here along with comments explaining your approach: In approach 1, we are starting from the Y since we are able to distinguish on
what to do with Y if it is even, we keep it dividing by 2 and if it is odd, we add 1. We count the steps we are doing and if we have overshoot
we add the difference to the count. In approach 2, we use BFS where we parse level by level by maintaining the size pointer. If the level has 
the integer Y it means we have reached the destination.
*/
// APPROACH 1 : GREEDY
class Solution {
    public int brokenCalc(int X, int Y) {
        int count = 0;
        while(Y > X){                                                                           // Start from Y
            if(Y % 2 == 0)
                Y = Y/2;                                                                    // Y is even, keep on dividing
            else
                Y++;                                                                        // Y is odd, keep on adding
            count++;                                                                            // Number of steps
        }
        return count + (X-Y);                                                                       // If Y has undershoot X
    }
}
// APPROACH 2 : BFS
class Solution {
    public int brokenCalc(int X, int Y) {
        int count = 0;
        Queue<Integer> q = new LinkedList<>();                                                                  // Start BFS
        q.add(X);
        while(!q.isEmpty()){
            int size = q.size();                                                                 // level by level
            for(int i  = 0; i < size; i++){
                     int curr = q.poll();                                                       // Get the nodes
                if(curr  == Y) return count;                                                        // If Y is the destination
                    q.add(curr * 2);                                                            // Add the possibilities to the queue
                    q.add(curr - 1);
            }
            count++;                                                                        // Count the number of steps
        }
        return -1;                                                                          // Not possible
        }
}