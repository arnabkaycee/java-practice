package Replace0With5;

import java.util.Scanner;

public class Replace0With5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(replace(n));
    }

    private static int replace(int n){
        int result = 0, power = 0;
        while(n>0){
            int mod = n%10;
            if(mod == 0){
                result+=5*Math.pow(10,power);
            }else{
                result+=mod*Math.pow(10,power);
            }
            n/=10; ++power;
        }
        return result;

    }
}
