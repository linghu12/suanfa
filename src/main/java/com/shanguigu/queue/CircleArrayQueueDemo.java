package com.shanguigu.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        //测试数组模拟环形数组的案例
        //创建一个队列
        CircleArray arrayQueue = new CircleArray(4);//说明设置4，其队列的有效数据最大是3
        char key=' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);//接收
        boolean loop=true;
        //输出一个菜单
        while(loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出队列");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):获取数据从队列");
            System.out.println("h(head):查看队列头的数据");
            key= scanner.next().charAt(0);//接受一个字符
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数:");
                    int value=scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g'://取出数据
                    try {
                        int res=arrayQueue.getQueue();
                        System.out.printf("取出的数据是:%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h'://查看队列头的数据
                    try{
                        int res=arrayQueue.headQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");


    }
}



