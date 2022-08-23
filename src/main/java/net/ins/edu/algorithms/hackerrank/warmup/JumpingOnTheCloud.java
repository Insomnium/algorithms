package net.ins.edu.algorithms.hackerrank.warmup;

import java.util.List;

/**
 * <a href="https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen">Jumping On The Cloud</a>
 */
public class JumpingOnTheCloud {

    public static int jumpingOnClouds(List<Integer> c) {
        int jumps = 0;
        for (int i = 0; i < c.size(); ) {
            if (c.size() - 1 >= i + 2 && c.get(i + 2) == 0)
                i += 2;
            else if (c.size() - 1 >= i + 1 && c.get(i + 1) == 0)
                i++;
            else
                break;

            jumps++;
        }

        return jumps;
    }

    public static void main(String[] args) {
        System.out.println(JumpingOnTheCloud.jumpingOnClouds(List.of(0, 0, 1, 0, 0, 1, 0)));
        System.out.println(JumpingOnTheCloud.jumpingOnClouds(List.of(0, 0, 1, 0, 0, 0, 0)));
        System.out.println(JumpingOnTheCloud.jumpingOnClouds(List.of(0, 0, 1, 0, 0, 0, 1)));
        System.out.println(JumpingOnTheCloud.jumpingOnClouds(List.of(0, 0, 1, 0, 0, 1, 1)));
    }
}
