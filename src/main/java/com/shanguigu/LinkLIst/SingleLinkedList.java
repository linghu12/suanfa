package com.shanguigu.LinkLIst;

import java.util.Stack;

/**
 * 定义SingleLinkedList,管理我们的英雄
 */
public class SingleLinkedList {
    //先初始化一个头节点，头节点不要动 不存放具体的数据
    private HeroNode head=new HeroNode(0,"","");

    //返回头节点
    public HeroNode getHead(){
        return head;
    }

    //添加节点到单向链表
    //思路：当不考虑编号顺序时
    //1、找到当前链表的最后节点
    //2、将最后这个节点的next,指向新的节点
    public void add(HeroNode heroNode){

        //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode temp=head;
        //遍历链表，找到最后
        while (true){
            //找到链表的最后
            if (temp.next==null){
                break;
            }
            //没找到，将链表后移
            temp=temp.next;
        }
        //当退出循环时，temp就指向链表的最后
        //将最后的这个节点的next，指向新的节点
        temp.next=heroNode;
    }
    //查找单链表中的倒数第k个节点（新浪面试题）
    /*
    思路：
    1.编写一个方法，接收head节点,同时接收一个index
    2.index表示是倒数第index个节点
    3.先把链表从头到尾遍历，得到链表的总长度 getLength
    4.得到size后，我们从链表的第一个开始遍历（size-index）个
    5.如果找到了，则返回该节点，否则返回null
     */
    public static HeroNode findLastIndexNode(HeroNode head,int index){
        //判断如果链表为空，返回null
        if (head.next==null){
            return null;//没有找到
        }
        //第一个遍历得到链表的长度（节点个数）
        int size=getLength(head);
        //第二次遍历 size-index位置，就是我们倒数的第k个节点
        //先做一个index的校验
        if (index<=0||index>size){
            return null;
        }
        //定义个辅助变量,for循环定位到倒数的index
        HeroNode cur=head.next;//3
        for (int i=0;i<size-index;i++){
            cur=cur.next;
        }

        return cur;
    }

    //使用方式2 利用栈这个数据结构，将各个节点压入栈中，利用栈的先进后出的特点，实现逆序打印的效果
    public static void reversePrint(HeroNode head){
        if (head.next==null){
            System.out.println("空链表，无法打印");
            return;
        }
        //创建一个栈，将各个节点压入栈中
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur=head.next;
        //将链表的所有节点压入栈
        while (cur!=null){
            stack.push(cur);
            cur=cur.next;//cur后移,可以压入下一个节点
        }
        //将栈中的节点进行打印，pop出栈
        while (stack.size()>0){
            System.out.println(stack.pop());//逆序弹出 stack先进后出
        }

    }


    //将单链表进行反转
    public static void reverseList(HeroNode head){
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next==null||head.next.next==null){
            System.out.println("当前链表无需反转");
            return;
        }
        //定义一个辅助的指针(变量)，帮助我们遍历原来的链表
        HeroNode cur=head.next;
        HeroNode next=null;//指向当前节点[cur]的下一个节点
        HeroNode reverseHead=new HeroNode(0,"","");
        //遍历原来的链表
        //每遍历一个节点，就将其取出，并放在新的链表reverseHead的最前端
        while (cur!=null){
            next=cur.next;//先暂时保存当前节点的下一个节点
            cur.next=reverseHead.next;//将cur的下一个节点指向新的链表的最前端
            reverseHead.next=cur;//将cue连接到新的链表上
            cur=next;//让cur后移
        }
        //将head.next指向reversed.next，实现单链表的反转
        head.next=reverseHead.next;
    }




    //方法：获取到单链表的节点的个数（如果是带头节点的链表，需求不统计头节点）
    /**
     *
     * @param head 链表的头节点
      * @return 返回的就是有效节点的个数
     */
    public static int getLength(HeroNode head){
        if (head.next==null){//空链表
            return 0;
        }
        int length=0;
        //定义一个辅助的变量 这里我们没有统计头节点
        HeroNode cur=head.next;
        while (cur!=null){
            length++;
            cur=cur.next;//遍历
        }
        return length;

    }

    public void addByOrder(HeroNode heroNode){
        //因为头节点不能动，因此我们仍然通过一个辅助指针变量来帮助我们找到添加的位置
        //因为是单链表，因此我们找的temp是位于添加位置的前一个结点，否则添加不了
        HeroNode temp=head;
        boolean flag=false;//标志添加的编号是否存在，默认是false
        while (true){
            if (temp.next==null){//说明temp已经在链表的最后
                break;
            }
            if (temp.next.no> heroNode.no){//位置找到，就在temp的后面插入
                break;
            }else if(temp.next.no== heroNode.no){//说明希望添加的heroNode的编号已经存在
                flag=true;//说明编号存在
                break;
            }
            temp=temp.next;//后移，遍历当前的链表

        }
        if (flag){//不能添加，编号已经存在
            System.out.printf("准备插入的英雄的编号%d已经存在，不能加入\n",heroNode.no);
        }else {
            //插入到链表中
            heroNode.next=temp.next;
            temp.next=heroNode;
        }

    }

    //修改节点的信息，根据no编号来修改，即no编号不能改
    //说明：
    //1.根据newHeroNode的no来修改
    public void update(HeroNode newHeroNode){
        //判断链表是否为空
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode temp=head.next;
        boolean flag=false;//表示是否找到该节点
        while (true){
            if (temp==null){
                break;//已经遍历完这个链表 到链表的最后
            }
            if (temp.no== newHeroNode.no){
                //找到
                flag=true;
                break;
            }
            temp=temp.next;

        }
        //根据flag,判断是否找到要修改的节点
        if (flag){
            temp.name= newHeroNode.name;
            temp.nickname= newHeroNode.nickname;
        }else {//没有找到
            System.out.printf("没有找到编号为%d的节点，不能修改\n",newHeroNode.no);
        }

    }

    //删除节点
    //思路
    //1.head不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
    //2.说明我们在删除的时候，是temp.next.no和需要删除的节点的no比较
    public void del(int no){
        HeroNode temp=head;
        boolean flag=false;//标志是否找到待删除节点的
        while (true){
            if (temp.next==null){//已经到链表的最后
                break;
            }
            if (temp.next.no==no){
                //找到了待删除节点的前一个节点temp
                flag=true;
                break;
            }
            temp=temp.next;//temp后移，遍历


        }
        //判断flag
        if(flag){//找到
            //删除
            temp.next=temp.next.next;
        }else {
            System.out.printf("要删除的节点%d不存在\n",no);
        }

    }


    //显示链表【遍历】
    public void list(){
        //判断链表为空
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来循环
        HeroNode temp=head.next;
        while (true){
            //判断是否到链表的最后
            if(temp==null){
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将next后移，一定小心
            temp=temp.next;
        }
    }





}
