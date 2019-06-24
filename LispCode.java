package com.citi.cards;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LispCode {
	
	public static boolean isValidExpression(String expression) {
	    Stack<Character> stack = new Stack<Character>();
		try {
		    Map<Character, Character> openClosePair = new HashMap<Character, Character>();
		    openClosePair.put(')', '(');
		    for(char ch : expression.toCharArray()) {
		        if(openClosePair.containsKey(ch)) {
		            if(stack.pop() != openClosePair.get(ch)) {
		                return false;
		            }
		        } else if(openClosePair.values().contains(ch)) {
		            stack.push(ch); 
		        }
		    }
		} catch(Exception e) {
			return false;
		}
	    return stack.isEmpty();
	}

	public static void main(String[] args) {
		LispCode voiceTest= new LispCode();

		String str = "(defun rewind-count (rewindable)  (fill-pointer (rewind-store rewindable)))";
		boolean flag = voiceTest.isValidExpression(str);
		System.out.println("flag!!!"+flag);

	}

}
