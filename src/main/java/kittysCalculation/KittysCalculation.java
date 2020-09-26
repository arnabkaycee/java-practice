package kittysCalculation;

import java.io.*;
import java.math.BigInteger;
import java.util.*;


class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /**
     * call this method to initialize reader for InputStream
     */
    static void init(InputStream is) {
        reader = new BufferedReader(
                new InputStreamReader(is));
        tokenizer = new StringTokenizer("");
    }

    /**
     * get next word
     */
    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

}

public class KittysCalculation {


    private static class Pair {
        int srcVertex;
        int destVertex;

        Pair(int srcVertex, int destVertex) {
            this.srcVertex = srcVertex;
            this.destVertex = destVertex;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return srcVertex == pair.srcVertex &&
                    destVertex == pair.destVertex;
        }

        @Override
        public int hashCode() {
            return Objects.hash(srcVertex, destVertex);
        }
    }

    private static final HashMap<Integer, ArrayList<Integer>> adjacencyList = new HashMap<>();
    private static final Map<Pair, Integer> distancePair = new HashMap<>();
    private static final Set<Integer> visited = new HashSet<>();
    private static boolean found;
    private static final BigInteger modulo = BigInteger.TEN.pow(9).add(new BigInteger("7"));
    private static final Map<Pair, BigInteger> expressionStore = new HashMap<>();


    private static int[][] formPairs(int[] set) {
        long setLength = set.length;
        long outputPairSize = (setLength * (setLength - 1)) / 2;
        int[][] outputPairs = new int[(int)outputPairSize][];

        int outputPairCounter = 0;
        for (int i = 0; i < set.length; i++) {
            for (int j = i + 1; j < set.length; j++) {
                outputPairs[outputPairCounter] = new int[2];
                outputPairs[outputPairCounter][0] = set[i];
                outputPairs[outputPairCounter][1] = set[j];
                ++outputPairCounter;
            }
        }
        return outputPairs;
    }

    private static Integer checkDistanceExists(int srcVertex, int destVertex) {
        Pair formPair1 = new Pair(srcVertex, destVertex);
        if (distancePair.containsKey(formPair1)) return distancePair.get(formPair1);
        Pair formPair2 = new Pair(destVertex, srcVertex);
        if (distancePair.containsKey(formPair2)) return distancePair.get(formPair2);
        return null;
    }

    private static void putDistance(int srcVertex, int destVertex, int distance) {
        Pair formPair = new Pair(srcVertex, destVertex);
        distancePair.put(formPair, distance);
    }

    /**
     * Calculate the distance between the nodes
     *
     * @param srcVertex  source vertex
     * @param destVertex destination vertex
     * @param depth      depth
     * @return distance between {srcVertex} and {destination}
     */
    private static Integer getDistanceBetweenPairs(int srcVertex, int destVertex, int depth) {
        Integer distance = checkDistanceExists(srcVertex, destVertex);
        if (distance != null) {
            found = true;
            return distance;
        }

        visited.add(srcVertex);

        if (adjacencyList.get(srcVertex).contains(destVertex)) {
            putDistance(srcVertex, destVertex, depth);
            visited.add(destVertex);
            found = true;
            return depth;
        }

        for (int i = 0; i < adjacencyList.get(srcVertex).size(); i++) {
            int adjacentVertex = adjacencyList.get(srcVertex).get(i);

            if (visited.contains(adjacentVertex)) continue;

            Integer calculatedDistance = getDistanceBetweenPairs(adjacentVertex, destVertex, depth + 1);
            if (calculatedDistance != null) {
                putDistance(srcVertex, destVertex, calculatedDistance + 1);
                distance = calculatedDistance + 1;
                if (found) break;
            }
        }
        return distance;
    }

    private static BigInteger getExpression(int src, int dest, int distance) {
        Pair formPair1 = new Pair(src, dest);
        if (expressionStore.containsKey(formPair1)) return expressionStore.get(formPair1);
        Pair formPair2 = new Pair(dest, src);
        if (expressionStore.containsKey(formPair2)) return expressionStore.get(formPair2);

        BigInteger value = BigInteger.valueOf(src)
                .multiply(BigInteger.valueOf(dest))
                .multiply(BigInteger.valueOf(distance))
                .mod(modulo);

        expressionStore.put(formPair1, value);
        return value;
    }

    public static void main(String[] args) throws IOException {
//        Reader.init(System.in);
        Reader.init(new FileInputStream("/Users/arnab/IdeaProjects/java-practice/src/main/java/kittysCalculation/input.txt"));
        int n = Reader.nextInt();
        int q = Reader.nextInt();

        for (int i = 0; i < n - 1; i++) {
            int srcVertex = Reader.nextInt();
            int destVertex = Reader.nextInt();

            adjacencyList.computeIfAbsent(srcVertex, key -> new ArrayList<>());
            adjacencyList.get(srcVertex).add(destVertex);

            adjacencyList.computeIfAbsent(destVertex, key -> new ArrayList<>());
            adjacencyList.get(destVertex).add(srcVertex);

            putDistance(srcVertex, destVertex, 1);
        }


        for (int i = 0; i < q; i++) {
            int setSize = Reader.nextInt();
            int[] setElements = new int[setSize];
            for (int j = 0; j < setSize; j++) {
                setElements[j] = Reader.nextInt();
            }
            if (setSize == 1) {
                System.out.println("0");
                continue;
            }
            int[][] outputPairs = formPairs(setElements);
            BigInteger finalValue = BigInteger.ZERO;
            for (int[] outputPair : outputPairs) {
                visited.clear();
                found = false;
                int src = outputPair[0];
                int dest = outputPair[1];
                int distance = getDistanceBetweenPairs(src, dest, 0);
                finalValue = finalValue.add(getExpression(src, dest, distance));
            }
            System.out.println(finalValue);
        }
    }

    public static void main2(String[] args) {
        long x = 56056;
        long y = (x*(x-1))/2;
        System.out.println((int)y);
        System.out.println(Integer.MAX_VALUE);
    }
}
