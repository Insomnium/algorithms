package net.ins.edu.algorithms.hackerrank.warmup;

/**
 * <a href="https://www.hackerrank.com/challenges/counting-valleys/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup&h_r=next-challenge&h_v=zen">Counting Valleys</a>
 */
public class CountingValleys {

    public static int countingValleys(int steps, String path) {
        int state = 0, prevState = 0, valleyCount = 0;
        for (char c : path.toCharArray()) {
            if (c == 'D') state--;
            else state++;

            if (prevState <= 0 && state == 0)
                valleyCount++;

            prevState = state;
        }

        return valleyCount;
    }

    public static void main(String[] args) {
        System.out.println(CountingValleys.countingValleys(8, "UDDDUDUU"));
    }
}
