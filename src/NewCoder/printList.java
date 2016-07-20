package NewCoder;

import java.util.ArrayList;

/**
 * Created by LiangJ on 2016/4/26.
 */
public class printList {
    public static void main(String[] args) {
        printList list = new printList();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        System.out.println(list.printListFromTailToHead(node));
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList list = new ArrayList();
        if(listNode==null){
            return list;
        }
        ListNode next = listNode.next;
        boolean first=false;
        while(next!=null){
            ListNode temp = listNode;
            if(!first){
                temp.next=null;
                first = true;
            }
            listNode = next;
            next = listNode.next;
            listNode.next = temp;
//            System.out.println(temp.val+" "+next);

        }
        while(listNode!=null){
//            System.out.println(listNode.val);
            list.add(listNode.val);
            listNode = listNode.next;
        }
        return list;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
