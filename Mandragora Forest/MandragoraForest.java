import java.util.Scanner;
import java.util.PriorityQueue;

public class MandragoraForest {

    public static void main(String[] args) {
        
        PriorityQueue<Integer> enemies = new PriorityQueue<>(); //used to sort health as it is read in
        int numEnemies, health, strength;
        long sum, maxSum, originalSum;
        
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        
        for(int i = 0; i < cases; i++){
            numEnemies = scan.nextInt();
            originalSum = 0;
            strength = 2;
            
            //read input into pq and calculate the sum
            for(int p = 0; p < numEnemies; p++){
                health = scan.nextInt();
                enemies.add(health);
                originalSum += health;
            }
            
            maxSum = originalSum;
            
            //get the sum of each eat/battle combo and track the max
            for(int p = 0; p < numEnemies; p++){

                //determines the new sum each time a mandragora is eaten
                originalSum -= enemies.poll();
                sum = originalSum * strength;
                
                if(sum > maxSum){
                    maxSum = sum;
                    strength++;
                } else break; //all further will be lower than max, so we have a solution
            }
            
            System.out.println(maxSum);            
            enemies.clear();
        }
    }
}