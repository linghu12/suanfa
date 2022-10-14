package com.shanguigu.LinkLIst;

//定义HeroNode,每个HeroNode对象就是一个节点
public class HeroNode {
    int no;
    String name;
    String nickname;
    HeroNode next;//指向下一个节点

    //构造器
    public HeroNode(int hNo,String hName,String hNickName){
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
