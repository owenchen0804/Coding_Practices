package com.owen.Coding_Practices;

import BinaryTree.TreeNodeP;

public class Test3 {
    //  TreeNodeP[] 这个array，里面存的0号元素也是个reference， 比如one指向的是 @787 4；
    //  node1这个本身的地址是@789
    //  传到getDepth()的是pass by value，也就是node1的一个copy，在getDepth()里面是node
    //  node的地址也是@789, 且node[0]的本质也是个one一样的reference，且开始指向的也是指向one所指向的@787 4;
    //  但是！
    //  后面node[0]的变化都只是node[0]指向的元素不断在变，而one指向的始终没有变！
    public void lowestCommonAncestor(TreeNodeP one) {
        TreeNodeP[] node1 = {one};

        int depthOne = getDepth(node1);
        System.out.println(depthOne);

        System.out.println(node1[0]);
        System.out.println(one);

    }
    private int getDepth(TreeNodeP[] node) {
        int count = 1;
        while (node[0].parent != null) {
            node[0] = node[0].parent;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        TreeNodeP root = new TreeNodeP(1, null);
        TreeNodeP n1 = new TreeNodeP(2, root);
        TreeNodeP n2 = new TreeNodeP(3, root);
        root.left = n1;
        root.right = n2;
        TreeNodeP n3 = new TreeNodeP(4, n1);
        n1.left = n3;
        Test3 testOBJ = new Test3();
        testOBJ.lowestCommonAncestor(n3);

    }

}
