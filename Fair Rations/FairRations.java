import java.util.Scanner;

public class FairRations {

    public static void main(String[] args) {

        //read in input (provided by HackerRank)
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int line[] = new int[N];
        for(int B_i=0; B_i < N; B_i++){
            line[B_i] = in.nextInt();
        }
        
        int loavesGiven = 0;
        int len = line.length - 1;
        
        //checks if each person besides the last in line has even or odd number of loaves
        for(int i = 0; i < len; i++){
            //if odd, give a loaf to the current person and person ahead of them
            if(line[i] % 2 != 0){
                line[i]++;
                line[i+1]++;
                loavesGiven += 2;
            }
        }
        
        //all people up to the last person are guaranteed to have an even amount
        //if the last person is even as well, then we have a solution
        if(line[len] % 2 == 0){
            System.out.println(loavesGiven);
        } else{
            System.out.println("NO");
        }
    }
}

