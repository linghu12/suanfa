package com.shanguigu.queue;

public class CircleArray {


    private int maxSize;//表示数组的最大容量
    //front变量的含义做了一个调整，front就指向队列的第一个元素，也就是arr[front]
    //front的初始值是=0
    private int front=0;//队列头

    //rear变量的含义做一个调整：rear指向队列的最后一个元素的后一个位置，因为希望空出一个位置
    //rear的初始值=0
    private int rear=0;//队列尾
    private int[] arr;//该数组用于存放数据

    public CircleArray(int arrMaxSize){
        maxSize=arrMaxSize;
        arr=new int[maxSize];
    }

    //判断队列是否已经满了
     boolean isFull(){

        return (rear+1)%maxSize==front;
    }

    //判断队列是否为空
     boolean isEmpty(){
        return front==rear;
    }

    //添加数据到队列
    void addQueue(int n){
        //判断队列是否满
        if (isFull()){
            System.out.println("队列满，无法加入数据");
            return;
        }
        //直接将数据加入
        arr[rear]=n;
        //将rear后移，这里必须考虑取模
        rear=(rear+1)%maxSize;


    }

    //获取队列的数据，出队列
     int getQueue(){
        //判断队列是否为空
        if(isEmpty()){
            //通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }

        //这里需要分析出front是指向队列的第一个元素
        //1.先把front对应的值保留到第一个临时变量
        //2.将front后移,考虑取模
        //3.将临时保存的变量返回
        int value=arr[front];
        front=(front+1)%maxSize;
        return value;
    }


    //显示队列的所有数据
    void showQueue(){
        //遍历
        if (isEmpty()){
            System.out.println("队列空的，没有数据。。。");
            return;
        }
        //思路：从front开始遍历，遍历多少个元素


        for (int i = front; i < front+size(); i++) {
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }

    }

    //求出当前队列有效数据的个数
    int size(){

        return (rear+maxSize-front)%maxSize;
    }

    //显示队列的头数据，注意不是取数据
    int headQueue(){
        //判断
        if (isEmpty()){
            throw new RuntimeException("队列为空，没有数据。。");
        }
        return arr[front];
    }
}
