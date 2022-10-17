package com.shanguigu.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
     //先定义一个逆波兰表达式(3+4)*5-6
        //4*5-8+60+8/2   4 5 * 8 - 60 + 8 2 / +
        //为了方便，逆波兰表达式的数字和符号使用空格隔开
        //测试
//        String suffixExpression="30 4 + 5 * 6 -";
        String suffixExpression="4 5 * 8 - 60 + 8 2 / +";
        //思路
        //1.将字符串放到ArrayList中
        //2.将ArrayList传递给一个方法，遍历ArrayList,配合栈，完成计算

        List<String> list =getListString(suffixExpression);
        System.out.println("rpnList="+list);

        int res=calculate(list);
        System.out.println("计算的结果是："+res);


    }
    //将逆波兰表达式，依次将数据和运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression){
        //将suffixExpression分割
        String[] split = suffixExpression.split(" ");
        List<String> list=new ArrayList<>();
        for (String ele:split){
            list.add(ele);
        }
        return list;
    }

    //完成对逆波兰表达式的运算

    public static int calculate(List<String> ls){
        //创建一个栈，只需要一个即可
        Stack<String> stack = new Stack<>();
        //遍历 ls
        for (String item :ls){
            //这里使用正则表达式取出数
            if (item.matches("\\d+")){//匹配的是多位数
                //直接入栈
                stack.push(item);
            }else {
                //pop出两个数并运算，再入栈
                int num2=Integer.parseInt(stack.pop());
                int num1=Integer.parseInt(stack.pop());
                int res=0;
                if (item.equals("+")){
                    res=num1+num2;
                }else if (item.equals("-")){
                    res=num1-num2;
                }else if (item.equals("*")){
                    res=num1*num2;
                }else if (item.equals("/")){
                    res=num1/num2;
                }else {
                    throw new RuntimeException("运算符有误");
                }

                stack.push(""+res);
            }


        }
        //最后留在stack中的数据是运算结果
        return Integer.parseInt(stack.pop());


    }


}
