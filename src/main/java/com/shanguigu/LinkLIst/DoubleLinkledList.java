package com.shanguigu.LinkLIst;

public class DoubleLinkledList {
    //先初始化一个头节点，头节点不要动 不存放具体的数据
    private HeroNode2 head=new HeroNode2(0,"","");
    //返回头节点
    public HeroNode2 getHead(){
        return head;
    }

    //遍历双向链表
    //显示链表【遍历】
    public void list(){
        //判断链表为空
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来循环
        HeroNode2 temp=head.next;
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

    //添加节点到单向链表
    //思路：当不考虑编号顺序时
    //1、找到当前链表的最后节点
    //2、将最后这个节点的next,指向新的节点
    public void add(HeroNode2 heroNode){

        //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode2 temp=head;
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
        //形成一个双向链表，
        temp.next=heroNode;
        heroNode.pre=temp;
    }

    //修改一个节点的内容
    //修改节点的信息，根据no编号来修改，即no编号不能改
    //说明：
    //1.根据newHeroNode的no来修改
    //双向链表的节点内容修改和之前一样，只是类型改变
    public void update(HeroNode2 newHeroNode){
        //判断链表是否为空
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode2 temp=head.next;
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

    //对于双向链表可以直接找到要删除的节点，找到后直接自我删除
    public void del(int no){

        //判断当前链表是否为空
        if (head.next==null){
            System.out.println("链表为空，无法删除");
            return;
        }


        HeroNode2 temp=head.next;//辅助变量(指针)
        boolean flag=false;//标志是否找到待删除节点的
        while (true){
            if (temp==null){//已经到链表的最后
                break;
            }
            if (temp.no==no){
                //找到了待删除节点的前一个节点temp
                flag=true;
                break;
            }
            temp=temp.next;//temp后移，遍历
        }
        //判断flag
        if(flag){//找到
            //删除
//            temp.next=temp.next.next;
            temp.pre.next=temp.next;
            //这里我们的代码有问题？
            //如果是最后一个节点，就不需要执行最后一句话，否则出现空指针
            if(temp.next!=null){
                temp.next.pre=temp.pre;
            }
        }else {
            System.out.printf("要删除的节点%d不存在\n",no);
        }

    }

    public void addByOrder(HeroNode2 heroNode){
        //因为头节点不能动，因此我们仍然通过一个辅助指针变量来帮助我们找到添加的位置
        //因为是单链表，因此我们找的temp是位于添加位置的前一个结点，否则添加不了
        HeroNode2 temp=head;
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
            temp.next.pre=heroNode;
            heroNode.next=temp.next;
            heroNode.pre=temp;
            temp.next=heroNode;

        }

    }


}
