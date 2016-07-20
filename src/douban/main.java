package douban;

import java.util.*;

/**
 * Created by LiangJ on 2016/4/22.
 */
public class main {
    public static void main(String[] args){
        main main = new main();
        int[] a={1,2,3,4,5};
//        main.multiply(a);
//        main.getSubSet(4);
//        System.out.println(main.reverse("  dou   ban   com  aaaa  "));
    }
    public String reverse(String input){
        int len = input.length();
        int[] position = new int[len];
        StringBuffer temp = new StringBuffer();
        int index=0;
        int start=0;
        for(int i=0;i<len;i++){
            if(input.charAt(i)!=' '){
                temp.append(input.charAt(i));
                start++;
            } else {
                if(i==0||input.charAt(i-1)!=' '){
                    temp.append(input.charAt(i));
                    position[index++] = start;
                    start++;
                }
            }
        }
        String result = temp.toString();
        StringBuffer output = new StringBuffer();
//        if(result.charAt(0)!=' '){
            for(int j=position[0]-1;j>=0;j--){
                output.append(result.charAt(j));
            }
//        }
        output.append(' ');
        for(int i=1;i<index;i++){
            for(int j=position[i]-1;j>position[i-1];j--){
                output.append(result.charAt(j));
            }
            output.append(' ');
        }
        for(int i=result.length()-1;i>position[index-1];i--){
            output.append(result.charAt(i));
        }
        return output.toString();
    }


    public List<List<Integer>> subset(int n, int[] sub)

    {
        int s[][] = new int[1 << n][n];
        for (int i = 1; i < (1 << n) - 1; i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) == 0) {
                    s[i - 1][j] = 0;
                } else {
                    s[i - 1][j] = 1;
                }
            }

        }
        List<List<Integer>> subSet = new ArrayList<List<Integer>>();
        for (int i = 0; i < (1 << n) - 2; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                if (s[i][j] == 1)
                    temp.add(sub[j]);

            }
            subSet.add(temp);
        }

        return subSet;
    }

    public void getSubSet(int n){
        List result = new ArrayList();
        for(int i=1;i<n;i++){
            List temp = new ArrayList();

            Iterator iterator = result.listIterator();
            List back = new ArrayList();
            while (iterator.hasNext()){
                List content = new ArrayList((List)iterator.next());
                content.add(i);
                back.add(content);
            }
            result.addAll(back);
            temp.add(i);
            result.add(temp);
        }
        for(Object item:result){
            print((List)item);
            System.out.println();
        }
    }
    public void print(List item){
        Iterator iterator = item.listIterator();
        while (iterator.hasNext()){
            System.out.print((int)iterator.next());
        }
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        stack2.empty();
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int node = stack2.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return node;
    }

}
