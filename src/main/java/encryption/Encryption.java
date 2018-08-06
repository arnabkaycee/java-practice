package encryption;

public class Encryption {

    public static String encryption(String inputString) {
        StringBuilder sb = new StringBuilder();
        inputString = inputString.replaceAll(" ", "");
        int[] dimensions = getDimensions(inputString.length());
        int r = dimensions[0], c = dimensions[1];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                int positionOfCharToAppend = c * j + i;
                if (positionOfCharToAppend < inputString.length()) {
                    sb.append(inputString.charAt(positionOfCharToAppend));
                } else break;
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    public static int[] getDimensions(int length) {
        int[] dimensions = new int[2];
        int r = (int) Math.floor(Math.sqrt(length));
        int c = (int) Math.ceil(Math.sqrt(length));
        if (r * c >= length) {
            dimensions[0] = r;
            dimensions[1] = c;
        } else {
            if (r > c) {
                c++;
            } else {
                r++;
            }
            dimensions[0] = r;
            dimensions[1] = c;
        }
        return dimensions;
    }

    public static void main(String[] args) {
        //System.out.println(encryption("if man was meant to stay on the ground god would have given us roots"));
        System.out.println(encryption("chillout"));

    }

}
