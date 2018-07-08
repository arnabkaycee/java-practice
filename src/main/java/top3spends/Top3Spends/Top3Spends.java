package top3spends.Top3Spends;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;

public class Top3Spends {


    private static HashMap<String, BigInteger[]> spentMap;
    private static String topSpendingFestival;
    private static BigInteger topSpendingAmount;
    private static BufferedReader br;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t > 0) {
            sb.append(takeInput());
            --t;
            if (t != 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }


    private static String takeInput() throws IOException {
        spentMap = new HashMap<>();
        topSpendingFestival = null;
        topSpendingAmount = null;
        //br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("d:/input.txt"));
        int numOfSpends = Integer.parseInt(br.readLine());
        while (numOfSpends > 0) {
            String expense = br.readLine();
            int indexOfSpace = expense.indexOf(' ');
            String festival = expense.substring(0, indexOfSpace);
            BigInteger amount = new BigInteger(expense.substring(indexOfSpace + 1));
            addSpend(festival, amount);
            --numOfSpends;
        }
        return topSpendingFestival + " " + topSpendingAmount;
    }


    private static void addSpend(String festival, BigInteger spentAmount) {
        if (spentMap.containsKey(festival)) {
            BigInteger[] spends = spentMap.get(festival);

            Object[] result = replaceMin(spends, spentAmount);

            BigInteger[] spendsArray = (BigInteger[]) result[0];
            BigInteger totalAmountSpentTillNow = (BigInteger) result[1];

            if (topSpendingAmount.compareTo(totalAmountSpentTillNow) < 0) {
                topSpendingAmount = totalAmountSpentTillNow;
                topSpendingFestival = festival;
            } else if (topSpendingAmount.compareTo(totalAmountSpentTillNow) == 0 && topSpendingFestival.compareTo(festival) > 0) {
                topSpendingFestival = festival;
            }
            spentMap.put(festival, spendsArray);
        } else {
            if ((topSpendingFestival == null && topSpendingAmount == null)
                    || topSpendingAmount.compareTo(spentAmount) < 0) {
                topSpendingAmount = spentAmount;
                topSpendingFestival = festival;
            } else if (topSpendingAmount.compareTo(spentAmount) == 0 && topSpendingFestival.compareTo(festival) > 0) {
                topSpendingFestival = festival;
            }
            BigInteger[] newSpendsArray = new BigInteger[3];
            newSpendsArray[0] = spentAmount;
            spentMap.put(festival, newSpendsArray);
        }
    }

    private static BigInteger getSpentAmountOnFestival(String festival) {
        BigInteger totalAmountSpent = BigInteger.ZERO;
        BigInteger[] spends = spentMap.get(festival);
        for (BigInteger spentAmount : spends) {
            if (spentAmount != null) {
                totalAmountSpent = totalAmountSpent.add(spentAmount);
            }
        }
        return totalAmountSpent;
    }

    private static Object[] replaceMin(BigInteger[] arr, BigInteger currentNum) {

        BigInteger spentAmountOnCurrent = BigInteger.ZERO;

        //fill empty spaces first
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                arr[i] = currentNum;
                spentAmountOnCurrent = spentAmountOnCurrent.add(arr[i]);
                return new Object[]{arr, spentAmountOnCurrent};
            } else {
                spentAmountOnCurrent = spentAmountOnCurrent.add(arr[i]);
            }
        }

        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[minIndex].compareTo(arr[i]) > 0) minIndex = i;
        }
        if (arr[minIndex].compareTo(currentNum) < 0) {
            spentAmountOnCurrent = spentAmountOnCurrent.subtract(arr[minIndex]).add(currentNum);
            arr[minIndex] = currentNum;
        }
        return new Object[]{arr, spentAmountOnCurrent};
    }
}
