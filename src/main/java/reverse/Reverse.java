package reverse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Reverse {

//    public static void main(String args[] ) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String s = br.readLine();
//        s = s.replaceAll("\t", " ");
//        int indexOfDot = s.lastIndexOf('.');
//        if (indexOfDot>0){
//            s = s.substring(0,indexOfDot);
//        }
//        String[] parts = s.split(" ");
//        for (int i=parts.length-1; i>=0; i--){
//            System.out.print(parts[i]);
//            if(i == 0){
//                if (indexOfDot>0) {
//                    System.out.print(".");
//                }
//            }else
//                System.out.print(" ");
//        }
//    }

//    public static void main(String args[] ) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String s = br.readLine();
//        String[] strArray = s.split(", ");
//        List<BigDecimal> list = Arrays.stream(strArray).map(str -> new BigDecimal(str)).collect(Collectors.toList());
//        Collections.sort(list);
//        BigDecimal median;
//        if (list.size() % 2 == 0)
//            median = (list.get(list.size()/2).add(list.get(list.size()/2 - 1)).divide(new BigDecimal("2")));
//        else
//            median = list.get(list.size()/2);
//        System.out.println(median);
//        int sum = 0;
//        for (int i = 1; i <=29 ; i++) {
//            sum+=i;
//        }
//        System.out.println(sum % 9);
//    }

//    public static void main(String args[] ) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String s = br.readLine();
//        String[] strArray = s.split("\\.");
//        Pattern pattern = Pattern.compile(" ");
//        int maxMatchCount = 0;
//        int maxMatchIndex = 0;
//        for (int i = 0; i < strArray.length; i++) {
//            String currLine = strArray[i];
//            Matcher matcher = pattern.matcher(currLine);
//            int count = 0;
//            while (matcher.find())
//                count++;
//            if (count > maxMatchCount) {
//                maxMatchCount = count;
//                maxMatchIndex = i;
//            }
//        }
//        System.out.println(strArray[maxMatchIndex].trim()+".");
//    }
public static void main(String[] args) {

        LinkedList obj = new LinkedList();
        obj.add("A");
        obj.add("B");
        obj.add("C");
        obj.addFirst("D");
        System.out.println(obj);

}
}
