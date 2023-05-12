package ps;
/*
Author: Srinivas A

Find the longest common substring between two inputs
 */

public class CommonSubstringBruteForce {

    public static void main(String[] args) {
        String input1 = "asamdfjkjkjkkjkjkjk";
        String input2 = "asamdfdfdfdfasamdfj";
        longestCommonSubsring(input1.toCharArray(), input2.toCharArray());
    }

    private static void longestCommonSubsring(char[] input1, char[] input2) {

        int l = 0;
        String output = null;

        for (int t = 1; t <= Math.min(input1.length,input2.length); t++) {
            for (int i = 0; i <= input1.length - t; i++) {
                for (int j = 0; j <= input2.length - t; j++) {
                    String s1 = String.copyValueOf(input1, i, t);
                    String s2 = String.copyValueOf(input2, j, t);
                    if (s1.equalsIgnoreCase(s2)) {
                        l = Math.max(l, s1.length());
                        output = s1;
                    }
                    //System.out.println("input1 is " + String.copyValueOf(input1, i, t));
                    //System.out.println("input2 is " + String.copyValueOf(input2, j, t));
                    //System.out.println("**********");
                }
            }
        }
        System.out.println("output is " + output);
    }
}
