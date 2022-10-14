package com.shanguigu.LinkLIst;

import java.util.Stack;

//演示stack的基本使用
public class TestStack {

    public static void main(String[] args) {
        Stack<Object> stack = new Stack<>();
        stack.add("jack");
        stack.add("tom");
        stack.add("smith");

        //取出 出栈
        while (stack.size()>0){
            System.out.println(stack.pop());//就是将栈顶的数据取出
        }


    }
}
