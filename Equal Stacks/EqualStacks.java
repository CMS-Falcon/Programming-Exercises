import java.util.Scanner;
import java.util.HashSet;

public class EqualStacks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //variables to keep track of the total sum of each stack
        int h1sum = 0;
        int h2sum = 0;
        int h3sum = 0;

        //take in input, provided by HackerRank (except for the sum tracking in each for loop)
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();

        int h1[] = new int[n1];
        for(int h1_i=0; h1_i < n1; h1_i++){
            h1[h1_i] = in.nextInt();
            h1sum += h1[h1_i]; //keep track of the sum as we take in input
        }

        int h2[] = new int[n2];
        for(int h2_i=0; h2_i < n2; h2_i++){
            h2[h2_i] = in.nextInt();
            h2sum += h2[h2_i];
        }

        int h3[] = new int[n3];
        for(int h3_i=0; h3_i < n3; h3_i++){
            h3[h3_i] = in.nextInt();
            h3sum += h3[h3_i];
        }

        //get hash sets of all possible sums for each stack
        HashSet<Integer> sum1 = getSums(h1, h1sum);
        HashSet<Integer> sum2 = getSums(h2, h2sum);
        HashSet<Integer> sum3 = getSums(h3, h3sum);

        int max = 0;

        for(Integer i : sum1){
            //check if the current sum in stack 1 is greater than the max and also in 2/3
            if(i > max && sum2.contains(i) && sum3.contains(i)){
                max = i;
            }
        }

        System.out.println(max);
    }

    //fills a hash set with every possible sum of the stack
    private static HashSet<Integer> getSums(int[] stack, int initialSum){

        HashSet<Integer> hashSums = new HashSet<>();
        hashSums.add(initialSum);

        for(int i : stack){
            initialSum -= i;
            hashSums.add(initialSum);
        }

        return hashSums;
    }
}