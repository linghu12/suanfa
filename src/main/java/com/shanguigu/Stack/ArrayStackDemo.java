package com.shanguigu.Stack;

import javax.swing.plaf.PanelUI;
import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        //测试一下
        ArrayStack arrayStack = new ArrayStack(4);
        String key="";
        boolean loop=true;//控制是否退出菜单
        Scanner scanner=new Scanner(System.in);

        while (loop){
            System.out.println("show:显示栈");
            System.out.println("exit:退出栈");
            System.out.println("push:从栈取出数据（入栈）");
            System.out.println("pop:从栈中取出数据（出栈）");
            System.out.println("请输入你的选择:");
            key=scanner.next();
            switch (key){
                case "show":
                    arrayStack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数:");
                    int value=scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":
                    try {
                        int res=arrayStack.pop();
                        System.out.printf("出栈的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop=false;
                    break;
            }
        }
        System.out.println("程序退出");

    }

}
//定义一个ArrayStack表示栈
class ArrayStack{
    private int maxSize;//栈的大小
    private int[] stack;//数组，数组模拟栈，数据放在该数组
    private int top=-1;//top表示栈顶，初始化为-1

    //构造器
    public ArrayStack(int maxSize){
        this.maxSize=maxSize;
        stack=new int[this.maxSize];
    }

    //判断栈满
    public boolean isFull(){
        return top==maxSize-1;
    }

    //栈空
    public boolean isEmpty(){
        return top==-1;
    }
    //入栈
    public void push(int value){
        //判断栈满否
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top]=value;

    }

    //出栈pop
    public int pop(){
        //判断栈是否空
        if (isEmpty()){
            //抛出异常
            throw new RuntimeException("栈空");
        }
        int value=stack[top];
        top--;
        return value;
    }
    //显示栈的情况,遍历栈，从栈顶开始显示
    public void list(){
        if (isEmpty()){
            System.out.println("栈空，没有数据");
            return;
        }
        //需要从栈顶开始显示数据
        for (int i = top; i >=0 ; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }


}