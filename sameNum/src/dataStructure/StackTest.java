package dataStructure;

import java.util.*;

 public class StackTest {

	public char[] op = {'+','-','*','/','(',')'};
	public String[] strOp = {"+","-","*","/","(",")"};
	public boolean isDigit(char c){
		if(c>='0'&&c<='9'){
			return true;
		}
		return false;
	}
	public boolean isOp(char c){
		for(int i=0;i<op.length;i++){
			if(op[i]==c){
				return true;
			}
		}
		return false;
	}
	public boolean isOp(String s){
		for(int i=0;i<strOp.length;i++){
			if(strOp[i].equals(s)){
				return true;
			}
		}
		return false;
	}
	/**
	 * ��������ļ���ʽ
	 * @param str
	 * @return
	 */
	public List<String> work(String str){
		List<String> list = new ArrayList<String>();
		char c;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<str.length();i++){
			c = str.charAt(i);
			if(isDigit(c)){
				sb.append(c);
				
			}
			if(isOp(c)){
				if(sb.toString().length()>0){
					list.add(sb.toString());
					sb.delete(0, sb.toString().length());
				}
				list.add(c+"");
			}
		}
		if(sb.toString().length()>0){
			list.add(sb.toString());
			sb.delete(0, sb.toString().length());
		}
		return list;
	}
	public void printList(List<String> list){
		for(String o:list){
			System.out.print(o+" ");
		}
	}
	/**
	 * ��׺���ʽת��Ϊ��׺���ʽ
	 * 1,�����������
	 * 2,���������ȼ���ȫ����ջ
	 * 3,���ȫ����ջ
	 */
	public List<String> InfixToPostfix(List<String> list){
		List<String> Postfixlist = new ArrayList<String>();//��ź�׺���ʽ
		Stack<String> stack = new Stack<String>();//�ݴ������
		//stack.push('#');
		for(int i=0;i<list.size();i++){
			
			String s = list.get(i);
			if(s.equals("(")){
				stack.push(s);
			}else if(s.equals("*")||s.equals("/")){
				stack.push(s);
			}else if(s.equals("+")||s.equals("-")){
				if(!stack.empty()){
					while(!(stack.peek().equals("("))){
						Postfixlist.add(stack.pop());
						if(stack.empty()){
							break;
						}
					}
					stack.push(s);
				}else{
					stack.push(s);
				}
			}else if(s.equals(")")){
				while(!(stack.peek().equals("("))){
					Postfixlist.add(stack.pop());
				}
				stack.pop();
			}else{
				Postfixlist.add(s);
			}
			if(i==list.size()-1){
				while(!stack.empty()){
					Postfixlist.add(stack.pop());
				}
			}
		}
		return Postfixlist;
	}
	/**
	 * ��׺���ʽ����
	 */
	public int doCal(List<String> list){
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<list.size();i++){
			String s = list.get(i);
			int t=0;
			if(!isOp(s)){
			    t = Integer.parseInt(s);
				stack.push(t);
			}else{
				if(s.equals("+")){
					int a1 = stack.pop();
					int a2 = stack.pop();
					int v = a2+a1;
					stack.push(v);
				}else if(s.equals("-")){
					int a1 = stack.pop();
					int a2 = stack.pop();
					int v = a2-a1;
					stack.push(v);
				}else if(s.equals("*")){
					int a1 = stack.pop();
					int a2 = stack.pop();
					int v = a2*a1;
					stack.push(v);
				}else if(s.equals("/")){
					int a1 = stack.pop();
					int a2 = stack.pop();
					int v = a2/a1;
					stack.push(v);
				}
			}
		}
		return stack.pop();
	}
	public static void main(String[] args) {
		StackTest lt = new StackTest();
		String str = "9+(3-1)*3+10/2";
		List<String> list = lt.work(str);
		List<String> list2 = lt.InfixToPostfix(list);
		System.out.println("ԭʽΪ��"+str);
		System.out.print("��׺���ʽΪ��");
		lt.printList(list2);
		System.out.println(" ");
		System.out.println("������Ϊ��"+lt.doCal(list2));
		
		
		
	}
}

