package mc;

import java.util.Scanner;

/**
 * Created by LiangJ on 2016/4/6.
 */
public class three {
    int max = 0 ;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String line = in.nextLine();
            String[] line_temp = line.split(" ");
            int row = Integer.valueOf(line_temp[0]);
            int collumn = Integer.valueOf(line_temp[1]);
            int[][] maze = new int[row][collumn];
            for(int i=0;i<row;i++){
                String input = in.nextLine();
                for(int j=0;j<collumn;j++){
                    if(input.charAt(j)=='.'){
                        maze[i][j]=0;
                    } else {
                        maze[i][j]=1;
                    }
                }
            }
            int dp_right=0;
            int dp_down=0;
            int curr = 0;
            int start_x = 0;
            int start_y = 0;
            System.out.println(collumn+" "+row);
            three three = new three();
            three.find(maze,row,collumn,0,0,0,1);
            System.out.println(three.max);
        }
    }

    public void find(int[][] maze,int row,int column,int curr_x,int curr_y,int count,int direction){
        System.out.println(curr_x+" "+curr_y+" "+direction);
        if((curr_x==row-1&&curr_y==column-2)||(curr_x==row-2&&curr_y==column-1)||(curr_x==row-1&&curr_y==column-1)){
            max = Math.min(max,count);
            System.out.println("over");
            return;
        }
        if(direction==1){//right
            for(int i=curr_y;i<column;i++){
                if(i+1>column-1){
                    find(maze,row,column,curr_x,i,count,0);
                    break;
                } else {
                    if(maze[curr_x][i+1]==1){
                        if(curr_x+1<row){
                            System.out.println("down");
                            find(maze,row,column,curr_x,i,count,0);//down
                        }
                        System.out.println("right");
                        find(maze,row,column,curr_x,i+1,++count,1);//right
                        break;
                    }
                }
            }
        } else {//down
            for(int i=curr_x;i<row;i++){
                if(i+1>row-1){
                    find(maze,row,column,i,curr_y,count,1);
                    break;
                } else {
                    if(maze[i+1][curr_y]==1){
                        find(maze,row,column,i+1,curr_y,++count,0);//down
                        if(curr_y+1<column){
                            find(maze,row,column,i,curr_y,count,1);
                        }
                        break;
                    }
                }
            }
        }
    }
}
