public class Abbreviation {

    public static void main(String[] args) {
        System.out.println(isMatch("daBcd", "ABC"));
    }

    public static boolean isMatch(String a, String b) {
        int bLen = a.length();
        int aLen = b.length();
        if (aLen > bLen) return false;

        boolean isMatch = true;
        int j = 0, i;
        for (i = 0; i < a.length(); i++) {
            if (b.length() <= j) {
                if (i < a.length() && isUpper(a.charAt(i))){
                    return false;
                }else{
                    return true;
                }
            } else if (isLower(a.charAt(i))) {
                if (toUpper(a.charAt(i)) == b.charAt(j)) {
                    ++j;
                }
            } else if (a.charAt(i) == b.charAt(j)) {
                ++j;
            } else {
                isMatch = false;
                break;
            }

        }

        return isMatch && j >= b.length();
    }

    private static boolean isUpper(Character c) {
        return c.charValue() >= 'A' && c.charValue() <= 'Z';
    }

    private static boolean isLower(Character c) {
        return c.charValue() >= 'a' && c.charValue() <= 'z';
    }

    private static char toUpper(Character c) {
        return (char) (c.charValue() - 32);
    }

    private static char toLower(Character c) {
        return (char) (c.charValue() + 32);
    }


}
