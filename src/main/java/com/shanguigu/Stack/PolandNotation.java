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

        //将中缀表达式转为后缀表达式对应的list

        List<String> list =getListString(suffixExpression);
        System.out.println("rpnList="+list);

        int res=calculate(list);
        System.out.println("计算的结果是："+res);

        System.out.println("------------");
        String expression="1+((2+3)*4)-5";
        List<String> list1 = toInfixExpression(expression);
        System.out.println("中缀表达式对应的List:"+list1);//[1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
        List<String> list2 = parseSuffixExpressionList(list1);
        System.out.println("后缀表达式对应的List:"+list2);//[1, 2, 3, +, 4, *, +, 5, -]


        System.out.printf("expression=%d",calculate(list2));//16
    }

    //方法：
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        //定义两个栈
        Stack<String> s1 = new Stack<>();//符号栈
        //因为s2这个栈在整个转换过程中，没有pop操作，而且我们后面还需要逆序输出
        //因此比较麻烦，这里我们不用Stack<String>,直接使用List<String> s2
//        Stack<String> s2=new Stack<>();//存储中间结果的栈
        List<String> s2 = new ArrayList<>();//存储中间结果的List s2

        //遍历ls
        for (String item : ls) {
            //如果是一个数，加入s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();//将这个小括号弹出s1栈，消除小括号


            } else {
                //当item的优先级小于等于栈顶的运算符，将s1栈顶的运算符弹出并加入到s2中，
                //问题：缺少一个比较优先级高低的方法
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                //还需要将item压入栈中
                s1.push(item);
            }

        }

        //将s1中剩余的运算符依次弹出并加入s2
        while (s1.size()!=0){
            s2.add(s1.pop());
        }

        return s2;//因为是存放到List中，因此按顺序输出就是对应的后缀表达式对应的List
    }



    //方法： 将中缀表达式转成对应的List
    //s="1+((2+3)*4)-5"
    public static List<String> toInfixExpression(String s){
        //定义一个List,存放中缀表达式的内容
        ArrayList<String> lists = new ArrayList<>();
        int i=0;//这是一个指针，用于遍历中缀表达式字符串
        String str;//对多位数的拼接
        char c;//每遍历到一个字符，就放到c中
        do{
            if ((c=s.charAt(i))<48||(c=s.charAt(i))>57){//数字的范围是48<=x<=57
                //如果c是一个非数字，就需要加到list中
                lists.add(""+c);
                i++;//i需要后移

            }else{//如果是一个数，需要考虑多位数
                str="";//先将str置成""
                while (i<s.length()&&(c=s.charAt(i))>=48&&(c=s.charAt(i))<=57){
                    str+=c;//拼接
                    i++;
                }
                lists.add(str);
            }
        }while (i<s.length());

        return lists;
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

//编写一个类 Operation 可以返回一个运算符对应的优先级
class Operation{
    private static int ADD=1;
    private static int SUB=1;
    private static int MUL=2;
    private static int DIV=2;

    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation){
        int result=0;
        switch (operation){
            case "+":
                result=ADD;
                break;
            case "-":
                result=SUB;
                break;
            case "*":
                result=MUL;
                break;
            case "/":
                result=DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;

        }

        return result;
    }


}
