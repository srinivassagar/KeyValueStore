package ps;

/*
Author Srinivas A

Using 2D array, trying DP style, to skip the substrings whose smaller length substring also failed
 */

public class CommonSubstringDp {

    public static void main(String[] args) {
        String input1 = "asamdfjkjkjkkjkjkjk";
        String input2 = "asamdfdfdfdfasamdfj";
        longestCommonSubsring(input1,input2,input1.toCharArray(), input2.toCharArray());
    }

    private static void longestCommonSubsring(String input1, String input2, char[] ic1, char[] ic2) {

        if(input1.equalsIgnoreCase(input2))
            System.out.println("Longest substring is "+input1);

        int[][] crossA = new int[ic1.length][ic2.length];
        int a=0;
        int l=0;

        for (int i = 0; i < ic1.length; i++) {
            for (int j = 0; j < ic2.length; j++) {
                if (ic1[i] == ic2[j]) {
                    if (i - 1 >= 0 && j - 1 >= 0)
                        crossA[i][j] = 1 + crossA[i - 1][j - 1];
                    else
                        crossA[i][j] = 1;
                }else{
                    crossA[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < crossA.length; i++) {
            for (int j = 0; j < crossA[0].length; j++) {
                System.out.println("crossA[i][j] "+crossA[i][j]);
                if(l < crossA[i][j]){
                    //System.out.println("i is "+i);
                    l = crossA[i][j];
                    //System.out.println("l is "+l );
                    a=i;
                }
            }
        }

        //System.out.println("l is "+l);
        System.out.println("Longest common substring is "+ input1.substring(a-(l-1),(a-(l-1))+l));

    }
}
