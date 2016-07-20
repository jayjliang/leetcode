package NewCoder;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * Created by LiangJ on 2016/4/25.
 */
public class FirstAppearingOnce {
    public static void main(String[] args) {
        FirstAppearingOnce appearingOnce = new FirstAppearingOnce();
        appearingOnce.Insert('g');
        System.out.println(appearingOnce.FirstAppearingOnce());
    }
    String input="";
    public void Insert(char ch)
    {
        StringBuffer buffer = new StringBuffer(input);
        buffer.append(ch);
        input = buffer.toString();
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> position = new HashMap<>();
        int first = input.length();
        for(int i=0;i<input.length();i++){
            char temp = input.charAt(i);
            if(map.containsKey(temp)){
                map.put(temp,map.get(temp)+1);
            } else {
                map.put(temp,1);
                position.put(temp,i);
            }
        }
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            Character key = (Character)entry.getKey();
            Integer value = (Integer) entry.getValue();
            System.out.println(key+" "+value);
            if(value==1){
                first = Math.min(first,(Integer)position.get(key));
            }
        }
        if(first==input.length()){
            return '#';
        }
        return input.charAt(first);
    }
}
