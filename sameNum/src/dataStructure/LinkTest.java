package dataStructure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LinkTest {
    static class Node{
        Node next;
        String value;

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

    }
    public static void reverseLink(Node node){
        if(node ==null || node.next==null){
            return;
        }
        Node nextNode = null;
        Node frontNode = null;
        while(node != null){
            nextNode = node.next;
            node.next = frontNode;
            frontNode = node;
            node = nextNode;
        }
    }

    //单链表的反转，递归
    public static Node reverseNode(Node node){
        if(node == null || node.next ==null){
            return node;
        }
       Node no =  reverseNode(node.next);
        node.getNext().setNext(node);
        node.setNext(null);
        return no;
    }

    public static boolean circleFound(Node node){
        if(node == null){
            return false;
        }
        Node a = node;
        Node b = node.next;
        while(b!= null && b.next != null){
            a = a.next;
            b = b.next.next;
            if(b == null){
                return false;
            }
            if(a == b){
                return true;
            }
        }
        return false;
    }

    static Map<Node,Integer> signMap = new HashMap<Node,Integer>();
    public static boolean circleFoundBySign(Node node, int i){
        if(node == null || node.next == null){
            return false;
        }
        if(signMap.keySet().contains(node)){
            return true;
        }
        signMap.put(node,i);
        return circleFoundBySign(node.next,i++);
    }
    
    //有序单链表的合并
    public static Node merge(Node node1,Node node2){
    	
    	if(node1 ==null && node2 == null){
    		return null;
    	}
    	if(node1 == null){
    		return node2;
    	}
    	if(node2 == null){
    		return node1;
    	}
    	Node node = new Node();
    	if(Integer.parseInt(node1.getValue())<Integer.parseInt(node2.getValue())){
    		node = node1;
    		merge(node.getNext(),node2);
    	}else{
    		node = node2;
    		merge(node,node2.getNext());
    	}
    	return node ;
    }

    public static void main(String[] args) {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(null);
        node1.setValue("node1");
        node2.setValue("node2");
        node3.setValue("node3");
        node4.setValue("node4");
        node5.setValue("node5");
        Node h = node1;
        while(h != null){
        	System.out.println(h.getValue());
        	h = h.getNext();
        }
        Node node = reverseNode(node1);
        while(node != null){
        	System.out.println(node.getValue());
        	node = node.getNext();
        }
    }
}
