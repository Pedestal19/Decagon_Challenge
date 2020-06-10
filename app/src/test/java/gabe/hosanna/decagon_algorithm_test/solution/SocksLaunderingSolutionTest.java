package gabe.hosanna.decagon_algorithm_test.solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Author: Hosanna Gabe-Oji
 * Project: Decagon_Algorithm_Test
 * Date: 6/10/2020
 */
public class SocksLaunderingSolutionTest {

    @Test
    public void testGetMaximumPair() {

        assertEquals(1, socksLaunderingSolution.getMaxSocksPair(0,
                new int[]{1, 2, 1, 1},
                new int[]{1, 4, 3, 2, 4}));


        assertEquals(4, socksLaunderingSolution.getMaxSocksPair(5,
                new int[]{1, 2, 1, 1},
                new int[]{1, 4, 3, 2, 4}));
    }
}
