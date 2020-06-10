package gabe.hosanna.decagon_algorithm_test.solution;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Author: Hosanna Gabe-Oji
 * Project: Decagon_Algorithm_Test
 * Date: 6/10/2020
 */
public class socksLaunderingSolution {

    public static int getMaxSocksPair(int numberOfMachineWashs, int[] cleanPileOfSocks, int[] dirtyPileOfSocks) {

        HashMap<Integer, Integer> cleanPileOfSocksMap;
        cleanPileOfSocksMap = new HashMap<>();

        HashMap<Integer, Integer> dirtyPileOfSocksMap;
        dirtyPileOfSocksMap = new HashMap<>();

        int pairNumberFound = 0;

        for (int currentSock : cleanPileOfSocks) cleanPileOfSocksMap.put(currentSock, cleanPileOfSocksMap.getOrDefault(currentSock, 0) + 1);

        for (int currentSock : dirtyPileOfSocks) dirtyPileOfSocksMap.put(currentSock, dirtyPileOfSocksMap.getOrDefault(currentSock, 0) + 1);

        for (Iterator<Integer> iterator = cleanPileOfSocksMap.keySet().iterator(); iterator.hasNext(); ) {
            Integer sock = iterator.next();
            if (cleanPileOfSocksMap.get(sock) % 2 != 1) pairNumberFound += cleanPileOfSocksMap.get(sock) / 2;
            else {
                pairNumberFound = pairNumberFound + cleanPileOfSocksMap.get(sock) / 2;
                if (numberOfMachineWashs <= 0 || !dirtyPileOfSocksMap.containsKey(sock)) {
                } else {
                    pairNumberFound++;
                    dirtyPileOfSocksMap.put(sock, dirtyPileOfSocksMap.get(sock) - 1);
                    numberOfMachineWashs--;
                }
            }
        }

        if (numberOfMachineWashs <= 0) {
            return pairNumberFound;
        }
        int remainder = numberOfMachineWashs / 2;
        for (Integer currentSock : dirtyPileOfSocksMap.keySet())
            if (remainder > 0) {
                int res = Math.min(dirtyPileOfSocksMap.get(currentSock) / 2, remainder);
                pairNumberFound += res;
                remainder -= res;
            }

        return pairNumberFound;
    }
}
