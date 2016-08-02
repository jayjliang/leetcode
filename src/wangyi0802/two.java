package wangyi0802;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by LiangJ on 2016/8/2.
 */
public class two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        two two = new two();
        while (in.hasNext()) {
            String[] first = in.nextLine().split(" ");
            int row = Integer.parseInt(first[0]);
            int colom = Integer.parseInt(first[1]);
            char[][] map = new char[row][colom];
            for(int i = 0;i< row;i++) {
                String temp = in.nextLine();
                for(int j = 0;j<colom;j++) {
                    map[i][j] = temp.charAt(j);
                }
            }
            int start_x = 0;
            int start_y = 0;
            String[] start = in.nextLine().split(" ");
            start_x = Integer.parseInt(start[0]);
            start_y = Integer.parseInt(start[1]);
            int allMap = Integer.parseInt(in.nextLine());
            int[] row_length = new int[allMap];
            int[] colom_length = new int[allMap];
            for(int i=0;i<allMap;i++){
                String temp = in.nextLine();
                String[] temp$ = temp.split(" ");
                row_length[i] = Integer.parseInt(temp$[0]);
                colom_length[i] = Integer.parseInt(temp$[1]);
            }
            System.out.println(two.solution(row,colom,map,start_x,start_y,allMap,row_length,colom_length));
        }
    }

    public int solution(int row,int colom,char[][] map,int start_x,int start_y,int allMap,int[] row_length,int[] colom_length){
        int end_x = row-1;
        int end_y = colom-1;
        Queue<Integer> road_x = new LinkedList<Integer>();
        Queue<Integer> road_y = new LinkedList<Integer>();
//        System.out.println(start_x+" "+start_y+" "+allMap);
        road_x.add(start_x);
        road_y.add(start_y);
        int result_count = -1;
        int index = 0;
        while (true) {
            if(index>=allMap||road_x.isEmpty()){
                break;
            }
            int x_length = Math.abs(row_length[index]);
            int y_length = Math.abs(colom_length[index]);
            Queue<Integer> road_x_temp = new LinkedList<Integer>();
            Queue<Integer> road_y_temp = new LinkedList<Integer>();
            while (!road_x.isEmpty()){
                road_x_temp.add(road_x.poll());
                road_y_temp.add(road_y.poll());
            }
            while (!road_x_temp.isEmpty()) {
                int current_x = road_x_temp.poll();
                int current_y = road_y_temp.poll();
//                System.out.println(current_x+" "+current_y);
                if(current_x==end_x&&current_y==end_y){
                    result_count = Math.max(result_count,index+1);
                }
                cal(row,colom,map,current_x,current_y,x_length,y_length,road_x,road_y);
            }
            index++;
        }
        return result_count;
    }

    public void cal(int row,int colom,char[][] map,int x,int y,int x_length,int y_length,Queue road_x,Queue road_y) {
            if(border(row,colom,x+x_length,0)&&check(map,x,y,x+x_length,y)){
                if(border(row,colom,y+y_length,1)&&check(map,x+x_length,y,x+x_length,y+y_length)){
                    if(!(x_length==0&&y_length==0)) {
                        road_x.add(x + x_length);
                        road_y.add(y + y_length);
                    }
                }
                if(border(row,colom,y-y_length,1)&&check(map,x+x_length,y,x+x_length,y-y_length)){
                    if(!(x_length==0&&y_length==0)) {
                        road_x.add(x + x_length);
                        road_y.add(y - y_length);
                    }
                }
            }
            if(border(row,colom,x-x_length,0)&&check(map,x,y,x-x_length,y)){
                if(border(row,colom,y+y_length,1)&&check(map,x-x_length,y,x-x_length,y+y_length)){
                    if(!(x_length==0&&y_length==0)) {
                        road_x.add(x - x_length);
                        road_y.add(y + y_length);
                    }
                }
                if(border(row,colom,y-y_length,1)&&check(map,x-x_length,y,x-x_length,y-y_length)){
                    if(!(x_length==0&&y_length==0)) {
                        road_x.add(x - x_length);
                        road_y.add(y - y_length);
                    }
                }
            }
    }



    public boolean border(int row,int colom,int value,int type){
        if(value<0) {
            return false;
        }
        if(type==0) {//row check
            if(value>=row){
                return false;
            }
        } else {
            if(value>=colom){
                return false;
            }
        }
        return true;
    }
    public boolean check(char[][] map,int x,int y,int x$,int y$) {
        if(x==x$) {
            int start;
            int end;
            if(y>y$){
                start = y$;
                end=y;
            } else {
                start = y;
                end=y$;
            }
            for(int i=start;i<=end;i++){
                if(map[x][i]=='X'){
                    return false;
                }
            }
        } else {
            int start;
            int end;
            if(x>x$){
                start = x$;
                end=x;
            } else {
                start = x;
                end=x$;
            }
            for(int i=start;i<=end;i++){
                if(map[i][y]=='X'){
                    return false;
                }
            }
        }
        return true;
    }
}
