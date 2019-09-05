package com.DataStructure.BinaryTree;

public class BinaryTree {

    private Node root;

    /**
     * Task:查找
     * @param key
     * @return
     */
    public Node find(int key) {
        Node current = root;
        while (current.iData != key) {
            if (key<current.iData)
                current = current.leftChild;
            else
                current = current.rightChild;

            if (current == null)
                return null;
        }
        return current;
    }

    /**
     * Task:插入
     * @param id
     */
    public void insert(int id) {
        Node newNode = new Node();
        newNode.iData = id;
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (id < current.iData) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }

            }
        }
    }


    /**
     * Task:中序历遍
     */
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.println(localRoot.iData + " ");
            inOrder(localRoot.rightChild);
        }
    }

    /**
     * Task:返回最小值
     * @return
     */
    public Node minNum(){
        Node current = root;
        Node last = null;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    /**
     * Task:返回最大值
     * @return
     */
    public Node MaxNum(){
        Node current = root;
        Node first = null;
        while (current != null) {
            first = current;
            current = current.rightChild;
        }
        return first;
    }

    /**
     * Task:删除值
     * 删除值分为三种情况：
     * 1、该节点是叶节点(没有子节点)
     * 2、该节点有一个子节点
     * 3、该节点有两个节点
     * @param key
     * @return
     */
    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;


        while (current.iData != key) {
            parent = current;
            if (key < current.iData) {
                isLeftChild = true;
                current = current.rightChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }

        //删除没有子节点的节点
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }

        //删除没有右子节点单节点
        else if (current.rightChild == null) {
            if (current == root)
                root = current.leftChild;
            else if (isLeftChild)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;
        }

        //删除没有左子节点单节点
        else if (current.leftChild == null) {
            if (current == root)
                root = current.rightChild;
            else if (isLeftChild)
                parent.leftChild = current.rightChild;
            else
                parent.rightChild = current.rightChild;
        }

        //删除有两个子节点的节点
        else {
            Node successor = getSuccessor(current);
            if (current == root)
                root = successor;
            else if(isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    /**
     * Task:找后续节点
     * @param delNode
     * @return 返回参delNode的后继节点(加上delNode有右子节点，因为已经判断过要删除的这个节点有两个子节点)
     */
    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

}

class Node {
    int iData;
    Node leftChild;
    Node rightChild;
}
