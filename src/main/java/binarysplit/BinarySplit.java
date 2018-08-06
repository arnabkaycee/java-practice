package binarysplit;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class BinarySplit {

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0};

    }

    private static Integer getBinary(int[] arr, int startIndex, int endIndex) {
        arr = Arrays.copyOfRange(arr, startIndex, endIndex);
        StringJoiner sj = new StringJoiner("");
        IntStream.of(arr).forEach(x -> sj.add(String.valueOf(x)));
        return Integer.parseInt(sj.toString(), 2);

    }
}
