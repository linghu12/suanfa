package com.shanguigu.LinkLIst;

public class DoubledLinkedListDemo {
    public static void main(String[] args) {
        //测试 双向链表
        System.out.println("测试");
        HeroNode2 hero1=new HeroNode2(1,"松江","及时雨");
        HeroNode2 hero2=new HeroNode2(2,"卢俊义","玉麒麟");
        HeroNode2 hero3=new HeroNode2(3,"吴用","智多星");
        HeroNode2 hero4=new HeroNode2(4,"林冲","豹子头");

        //创建双向链表对象
        DoubleLinkledList doubleLinkledList = new DoubleLinkledList();

        doubleLinkledList.add(hero1);
        doubleLinkledList.add(hero2);
        doubleLinkledList.add(hero3);
        doubleLinkledList.add(hero4);

        doubleLinkledList.list();

        //修改
        HeroNode2 newHeroNode = new HeroNode2(4,"公孙胜","入云龙");
        doubleLinkledList.update(newHeroNode);
        System.out.println("修改后情况");
        doubleLinkledList.list();

        //删除
        doubleLinkledList.del(2);
        System.out.println("删除后的链表情况");
        doubleLinkledList.list();

        //顺序添加
        System.out.println("测试顺序添加");
        HeroNode2 newHeroNodeAdd = new HeroNode2(4, "小黑", "小飞机");
        doubleLinkledList.addByOrder(newHeroNodeAdd);
        doubleLinkledList.list();
    }
}
 class HeroNode2 {
    int no;
    String name;
    String nickname;
    HeroNode2 next;//指向下一个节点，默认为null
    HeroNode2 pre;//指向前一个节点 ，默认为null

    //构造器
    public HeroNode2(int hNo,String hName,String hNickName){
        this.no=hNo;
        this.name=hName;
        this.nickname=hNickName;
    }
    //为了显示方便


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}