package com.shanguigu.LinkLIst;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        //创建节点
        HeroNode hero1=new HeroNode(1,"松江","及时雨");
        HeroNode hero2=new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3=new HeroNode(3,"吴用","智多星");
        HeroNode hero4=new HeroNode(4,"林冲","豹子头");

        //创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入
       /* singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);*/

        //加入按照编号的顺序
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);

        singleLinkedList.list();
        //测试修改编号的代码
        HeroNode newheroNode = new HeroNode(2, "小鹿", "小飞机");
        System.out.println("修改后的链表情况：");
        singleLinkedList.update(newheroNode);
        //显示
        singleLinkedList.list();

        //删除一个节点
        /*singleLinkedList.del(1);
        singleLinkedList.del(4);
        singleLinkedList.del(3);
        singleLinkedList.del(2);
        System.out.println("删除后链表情况");
        singleLinkedList.list();*/


        //测试获取单链表中有效节点的个数
        System.out.println("有效节点个数是:"+SingleLinkedList.getLength(singleLinkedList.getHead()));

        //测试是否找到了倒数第k个节点
        HeroNode  res=SingleLinkedList.findLastIndexNode(singleLinkedList.getHead(),5);
        System.out.println("res="+res);

        System.out.println("------------");
        singleLinkedList.list();
        System.out.println("测试单链表的反转功能");
        SingleLinkedList.reverseList(singleLinkedList.getHead());
        singleLinkedList.list();

        System.out.println("测试逆序打印单链表。。。,没有改变链表的结构");
        SingleLinkedList.reversePrint(singleLinkedList.getHead());


    }
}
