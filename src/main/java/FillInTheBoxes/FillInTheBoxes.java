package FillInTheBoxes;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class FillInTheBoxes {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int t = s.nextInt();
        //for each test case
        StringBuilder sb = new StringBuilder();
        while (t > 0) {
            //take input;
            getInput();
            sb.append(countFits());
            t--;
            if (t != 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int countFits() {
        int count = 0;
        for (int i = 0; i < ballWeights.length; i++) {
            Map.Entry<Integer, Integer> foundBox = boxCapacities.floorEntry(ballWeights[i] - extendedCapacity);
            if (foundBox != null && foundBox.getValue() > 0) {
                //found, now check fitment
                int boxCapacity = foundBox.getKey();
                if (ballWeights[i] <= boxCapacity + extendedCapacity) {
                    ++count;
                    boxCapacities.put(foundBox.getKey(), boxCapacities.get(foundBox.getKey()) - 1);
                }
            }
        }
        return count;
    }

    static int extendedCapacity;
    static TreeMap<Integer, Integer> boxCapacities = new TreeMap<>();
    static Integer[] ballWeights;

    private static void getInput() {
        int numberOfBoxes = s.nextInt();
        int numberOfBalls = s.nextInt();
        extendedCapacity = s.nextInt();
        ballWeights = new Integer[numberOfBalls];
        int i = 0;
        while (numberOfBoxes > 0) {
            int currCapacity = s.nextInt();
            if (boxCapacities.containsKey(currCapacity)) {
                boxCapacities.put(currCapacity, boxCapacities.get(currCapacity) + 1);
            } else {
                boxCapacities.put(currCapacity, 1);
            }
            numberOfBoxes--;
        }
        while (numberOfBalls > 0) {
            ballWeights[i++] = s.nextInt();
            numberOfBalls--;
        }
    }

}
