package AlexAndHisString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class AlexAndHisString {

    private static TreeMap<Character, Integer> charMap = new TreeMap<>();
    private static int mapSize = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Integer k = Integer.parseInt(br.readLine());
        System.out.println(getAlexString(s,k));
    }

    private static String getAlexString(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int stringLen = s.length();
        int currCharIndex = 0;
        while (currCharIndex < stringLen) {
            do {
                addToMap(s.charAt(currCharIndex));
                ++currCharIndex;
            } while (mapSize < k);
            Character c = removeNextFromMap();
            sb.append(c);
        }
        while(charMap.size()>0){
            Character c = removeNextFromMap();
            sb.append(c);
        }
        return sb.toString();
    }

    private static void addToMap(Character c) {
        if (charMap.containsKey(c)) {
            charMap.put(c, charMap.get(c) + 1);
        } else {
            charMap.put(c, 1);
        }
        ++mapSize;
    }

    private static Character removeNextFromMap() {
        Character c = charMap.firstKey();
        Integer count = charMap.get(c);
        if (count > 1) {
            charMap.put(c, count - 1);
        } else {
            charMap.remove(c);
        }
        --mapSize;
        return c;
    }


}
