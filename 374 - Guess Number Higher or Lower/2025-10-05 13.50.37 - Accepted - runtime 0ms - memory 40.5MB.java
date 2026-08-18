/* The guess API is defined in the parent class GuessGame.
   int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;  // prevent overflow
            int res = guess(mid);

            if (res == 0)
                return mid;       // found
            else if (res < 0)
                high = mid - 1;   // mid is too high
            else
                low = mid + 1;    // mid is too low
        }

        return -1; // should never reach here
    }
}
