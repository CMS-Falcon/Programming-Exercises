/**
 * Created by Candler on 6/9/2016.
 */

import java.util.Scanner;

public class Mirrors {

    private enum Direction {UP, DOWN, LEFT, RIGHT}

    public static void main(String[] args){

        String line, input;
        Direction dir;
        char[][] grid = new char[13][13];
        StringBuilder answer = new StringBuilder();

        Scanner scan = new Scanner(System.in);

        //populate grid
        for(int i = 0; i < 13; i++){
            line = scan.nextLine(); //read in entire line from input
            for(int j = 0; j < 13; j++){
                grid[i][j] = line.charAt(j); //add each character to the array
            }
        }

        input = scan.nextLine(); //get the encoded sequence

        char toAdd = ' ';
        char current;
        int index;

        //traverse the grid for each character in the input
        for(int i = 0; i < input.length(); i++){

            current = input.charAt(i);
            index = (int)current; //get ascii value

            //determine direction based on ascii value and start traversal
            if(current >= 'A' && current <= 'M'){
                index -= 65;
                dir = Direction.RIGHT;
                toAdd = traverse(grid, dir, index, 0);
            } else if(current >= 'N' && current <= 'Z'){
                index -= 78;
                dir = Direction.UP;
                toAdd = traverse(grid, dir, 12, index);
            } else if(current >= 'a' && current <= 'm'){
                index -= 97;
                dir = Direction.DOWN;
                toAdd = traverse(grid, dir, 0, index);
            } else if(current >= 'n' && current <= 'z'){
                index -= 110;
                dir = Direction.LEFT;
                toAdd = traverse(grid, dir, index, 12);
            }

            answer.append(toAdd);
        }

        System.out.println(answer.toString());
    }

    private static char traverse(char[][] grid, Direction dir, int x, int y){

        //check current direction and move in appropriate direction until we go out of bounds
        while(x > -1 && x < 13 && y > -1 && y < 13) {
            switch (dir) {
                case UP:
                    if(grid[x][y] == '/'){
                        dir = Direction.RIGHT;
                        y++;
                    } else if(grid[x][y] == '\\'){
                        dir = Direction.LEFT;
                        y--;
                    } else{
                        x--;
                    }
                    break;
                case DOWN:
                    if(grid[x][y] == '/'){
                        dir = Direction.LEFT;
                        y--;
                    } else if(grid[x][y] == '\\'){
                        dir = Direction.RIGHT;
                        y++;
                    } else{
                        x++;
                    }
                    break;
                case LEFT:
                    if(grid[x][y] == '/'){
                        dir = Direction.DOWN;
                        x++;
                    } else if(grid[x][y] == '\\'){
                        dir = Direction.UP;
                        x--;
                    } else{
                        y--;
                    }
                    break;
                case RIGHT:
                    if(grid[x][y] == '/'){
                        dir = Direction.UP;
                        x--;
                    } else if(grid[x][y] == '\\'){
                        dir = Direction.DOWN;
                        x++;
                    } else{
                        y++;
                    }
                    break;
            }
        }

        //check which direction we were moving and find the corresponding character to return
        switch(dir){
            case UP:
                return (char)(y + 97);
            case DOWN:
                return (char)(y + 78);
            case LEFT:
                return (char)(x + 65);
            case RIGHT:
                return (char)(x + 110);
            default:
                return ' ';
        }
    }
}
