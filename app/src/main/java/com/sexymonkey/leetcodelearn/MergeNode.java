package com.sexymonkey.leetcodelearn;


public class MergeNode {

    public static Node mergeNode(Node n1,Node n2){

        Node rNode = new Node(0);

        while (n1.next != null && n2.next != null){

            Node newNode = new Node(0);

            if(n1.value < n2.value){

                newNode.value = n1.value;

                n1 = n1.next;

            }else{

                newNode.value = n2.value;
                n2 = n2.next;
            }

            rNode.next = newNode ;

            rNode = rNode.next;

        }

        if(n1 != null){

            rNode.next = n1;

        }
        if(n2 != null){
            rNode.next = n2;
        }

        return rNode;

    }


}
