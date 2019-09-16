package com.DataStructure.RBTree;

import com.sun.org.apache.regexp.internal.RE;
import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * @Author a
 * @create 2019-09-15 13:04
 */
public class RBTree<T extends Comparable<T>> {

    private RBTNode<T> mRoot;
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    public RBTree(){
        mRoot = null;
    }

    private RBTNode<T> parentOf(RBTNode<T> node) {
        return node != null ? node.parent : null;
    }

    private boolean colorOf(RBTNode<T> node) {
        return node != null ? node.color : BLACK;
    }

    private boolean isRed(RBTNode<T> node) {
        return ((node != null) && (node.color == RED)) ? true : false;
    }

    private boolean isBlack(RBTNode<T> node) {
        return !isRed(node);
    }

    private void setBlack(RBTNode<T> node) {
        if (node!=null)
            node.color = BLACK;
    }

    private void setRed(RBTNode<T> node) {
        if (node != null)
            node.color = RED;
    }

    private void setParent(RBTNode<T> node,RBTNode<T> parent) {
        if (node != null)
            node.parent = parent;
    }

    private void setColor(RBTNode<T> node, boolean color) {
        if (node != null)
            node.color = color;
    }

    /**
     * 前序历遍
     * @param tree
     */
    private void preOrder(RBTNode<T> tree) {
        if (tree != null) {
            System.out.print(tree.key+" ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }
    public void preOrder(){
        preOrder(mRoot);
    }

    /**
     * 中序历遍
     * @param tree
     */
    private void inOrder(RBTNode<T> tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.print(tree.key+" ");
            inOrder(tree.right);
        }
    }
    public void inOrder(){
        inOrder(mRoot);
    }

    /**
     * 后序历遍
     * @param tree
     */
    private void postOrder(RBTNode<T> tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.key+" ");
        }
    }
    public void postOrder(){
        postOrder(mRoot);
    }

    /**
     * (递归实现)查找红黑树x中键值为key的节点
     * @param x
     * @param key
     * @return
     */
    private RBTNode<T> search(RBTNode<T> x, T key) {
        if (x == null)
            return x;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return search(x.left, key);
        else if (cmp > 0)
            return search(x.right, key);
        else
            return x;

    }
    public RBTNode<T> search(T key) {
        return search(mRoot, key);
    }

    /**
     * (非递归实现) 查找红黑树x中键值为key的节点
     * @param x
     * @param key
     * @return
     */
    private RBTNode<T> iterativeSearch(RBTNode<T> x, T key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0)
                x = x.left;
            else if (cmp > 0)
                x = x.right;
            else
                return x;
        }
        return x;
    }
    public RBTNode<T> iterativeSearch(T key) {
        return iterativeSearch(mRoot, key);
    }

    /**
     * 查找最小节点
     * @param tree
     * @return
     */
    private RBTNode<T> minimum(RBTNode<T> tree) {
        if (tree == null)
            return null;
        while (tree.left != null)
            tree = tree.left;
        return tree;
    }
    public T minimum(){
        RBTNode<T> p = minimum(mRoot);
        if (p != null)
            return p.key;
        return null;
    }

    /**
     * 查找最大节点
     * @param tree
     * @return
     */
    private RBTNode<T> maximum(RBTNode<T> tree) {
        if (tree == null)
            return null;
        while (tree.right != null)
            tree = tree.right;
        return tree;
    }
    public T maximum(){
        RBTNode<T> p = maximum(mRoot);
        if (p != null)
            return p.key;
        return null;
    }

    /**
     * 查找x的后续节点，即查找"红黑树中数据值大于该节点"的"最小节点"
     * @param x
     * @return
     */
    public RBTNode<T> successor(RBTNode<T> x) {
        //如果x存在右节点，则"x的后续节点"为"以其右节点为根的子树的最小节点"
        if (x.right != null)
            return minimum(x.right);
        //如果x没有右节点，则有以下两种可能
        //x为左子节点，则x的后续节点为它的父节点
        //x为右子节点，则查找"x的最低的父结点且该父节点要具有左节点"，找到的这个"最低的父节点"就是"x的后继节点"
        RBTNode<T> y = x.parent;
        while ((y != null) && (x == y.right)) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    /**
     * 查找x节点的前驱节点，即查找红黑树中数据值小于该节点的最大节点
     * @param x
     * @return
     */
    public RBTNode<T> predecessor(RBTNode<T> x) {
        if (x.left != null)
            return maximum(x.left);
        RBTNode<T> y = x.parent;
        while ((y != null) && (x == y.left)) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    /**
     * 对红黑树的节点x进行左旋转
     * @param x
     */
    private void leftRotate(RBTNode<T> x) {
        //设置x的右子节点为y
        RBTNode<T> y = x.right;
        //将y的左子节点设为x的右子节点
        //如果y的左子节点为非空，将x设为y左子节点的父节点
        x.right = y.left;
        if (y.left != null)
            y.left.parent = x;
        //将x的父节点设为y的父节点
        y.parent = x.parent;
        if (x.parent == null) {
            this.mRoot = y; //如果x的父节点为空，则将y设为根节点
        } else {
            if (x.parent.left == x)
                x.parent.left = y;  //如果x是它的父节点的左子节点，则将y设为x的父节点的左子节点
            else
                x.parent.right = y; //如果x是它父节点的右子节点，则将y设为x父节点的右子节点
        }
        y.left = x; //将x设为y的左子节点
        x.parent = y;  //将x的父节点设为y
    }

    /**
     * 对红黑树的节点y进行右旋转
     * @param y
     */
    private void rightRotate(RBTNode<T> y) {
        RBTNode<T> x = y.left;
        y.left = x.right;
        if (x.right != null)
            x.right.parent = y;
        x.parent = y.parent;
        if (y.parent == null) {
            this.mRoot = x;
        } else {
            if (y.parent.right == y)
                y.parent.right = x;
            else
                y.parent.left = x;
        }
        x.right = y;
        y.parent = x;
    }

    /**
     * 红黑树插入修正函数
     * 在向红黑树中插入加点之后(树失去平衡)，再调用该函数
     * 目的是将他重新塑造成一颗红黑树
     * @param node
     */
    private void insertFixUp(RBTNode<T> node) {
        RBTNode<T> parent,gparent;

        //若父节点存在且父节点的颜色是红色
        while (((parent = parentOf(node)) != null) && isRed(parent)) {
            gparent = parentOf(parent);

            //若父节点是祖父节点的左节点
            if (parent == gparent.left) {

                RBTNode<T> uncle = gparent.right;
                //case1：uncle节点不为空且为红色
                if ((uncle != null) && isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }
                //case2：uncle是黑色且当前节点是右节点
                if (parent.right == node) {
                    RBTNode<T> tmp;
                    leftRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }
                //case3：uncle是黑色且当前节点是左节点
                setBlack(parent);
                setRed(gparent);
                rightRotate(gparent);
            } else {    //若父节点是祖父节点的右节点
                RBTNode<T> uncle = gparent.left;
                //case1：uncle不为空且为红色
                if ((uncle != null) && isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }
                //case2：uncle为黑色且当前节点是左子节点
                if (parent.left == node) {
                    RBTNode<T> tmp;
                    rightRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }
                //case3：uncle是黑色，且当前节点是右子节点
                setBlack(parent);
                setBlack(gparent);
                leftRotate(gparent);
            }
        }
        //将根节点设为黑色
        setBlack(this.mRoot);
    }

    /**
     * 将节点插入到红黑树中
     * @param node
     */
    private void insert(RBTNode<T> node) {
        int cmp;
        RBTNode<T> y = null;
        RBTNode<T> x = this.mRoot;

        //1.将红黑树当做二叉查找树，将节点添加到二叉查找树中
        while (x != null) {
            y = x;
            cmp = node.key.compareTo(x.key);
            if (cmp < 0)
                x = x.left;
            else
                x = x.right;
        }
        node.parent = y;
        if (y != null) {
            cmp = node.key.compareTo(y.key);
            if (cmp < 0)
                y.left = node;
            else
                y.right = node;
        } else {
            this.mRoot = node;
        }
        //2.设置节点的颜色为红色
        node.color = RED;
        //3.将它重新修正为一颗二叉查找树
        insertFixUp(node);
    }

    /**
     * 新建节点key并将其插入到红黑树中
     * @param key
     */
    public void insert(T key) {
        RBTNode<T> node = new RBTNode<T>(key, BLACK, null, null, null);
        if (node != null)
            insert(node);
    }

    /**
     * 红黑树删除修正函数
     * @param node
     * @param parent
     */
    private void removeFixUp(RBTNode<T> node, RBTNode<T> parent) {
        RBTNode<T> other;
        while (((node == null) || isBlack(node)) && (node != this.mRoot)) {
            if (parent.left == node) {
                other = parent.right;
                if (isRed(other)) {
                    setBlack(other);
                    setRed(parent);
                    leftRotate(parent);
                    other = parent.right;
                }
                if ((other.left == null || isBlack(other.left)) &&
                        (other.right == null || isBlack(other.right))) {
                    setRed(other);
                    node = parent;
                    parent = parentOf(node);
                } else {
                    if (other.right == null || isBlack(other.right)) {
                        setBlack(other.left);
                        setRed(other);
                        rightRotate(other);
                        other = parent.right;
                    }
                    setColor(other, colorOf(parent));
                    setBlack(parent);
                    setBlack(other.right);
                    leftRotate(parent);
                    node = this.mRoot;
                    break;
                }
            } else {
                other = parent.left;
                if (isRed(other)) {
                    setBlack(other);
                    setRed(parent);
                    rightRotate(parent);
                    other = parent.left;
                }
                if ((other.left == null || isBlack(other.left)) &&
                        (other.right == null || isBlack(other.right))) {
                    setRed(other);
                    node = parent;
                    parent = parentOf(node);
                } else {
                    if (other.left == null || isBlack(other.left)) {
                        setBlack(other.right);
                        setRed(other);
                        leftRotate(other);
                        other = parent.left;
                    }
                    setColor(other,colorOf(parent));
                    setBlack(parent);
                    setBlack(other.left);
                    rightRotate(parent);
                    node = this.mRoot;
                    break;
                }
            }
        }
        if (node != null)
            setBlack(node);
    }

    private void remove(RBTNode<T> node) {
        RBTNode<T> child,parent;
        boolean color;

        if ((node.left != null) && (node.right != null)) {
            RBTNode<T> replace = node;
            replace = replace.right;
            while (replace != null)
                replace = replace.left;
            if (parentOf(node) != null) {
                if (parentOf(node).left == node)
                    parentOf(node).left = replace;
                else
                    parentOf(node).right = replace;
            } else {
                this.mRoot = replace;
            }
            child = replace.right;
            parent = parentOf(replace);
            color = colorOf(replace);
            if (parent == node) {
                parent = replace;
            } else {
                if (child != null)
                    setParent(child,parent);
                parent.left = child;
                replace.right = node.right;
                setParent(node.right, replace);
            }
            replace.parent = node.parent;
            replace.color = node.color;
            replace.left = node.left;
            node.left.parent = replace;
            if (color == BLACK)
                removeFixUp(child, parent);
            node = null;
            return;
        }
        if (node.left != null) {
            child = node.left;
        } else {
            child = node.right;
        }
        parent = node.parent;
        color = node.color;
        if (child != null) {
            child.parent = parent;
        }
        if (parent != null) {
            if (parent.left == node)
                parent.left = child;
            else
                parent.right = child;
        } else {
            this.mRoot = child;
        }
        if (color == BLACK)
            removeFixUp(child,parent);
        node = null;
    }

    /**
     * 删除节点
     * @param key
     */
    public void remove(T key) {
        RBTNode<T> node;
        if ((node = search(mRoot,key)) != null )
            remove(node);
    }

    /**
     * 销毁红黑树
     * @param tree
     */
    private void destroy(RBTNode<T> tree) {
        if (tree == null)
            return;
        if (tree.left != null)
            destroy(tree.left);
        if (tree.right != null)
            destroy(tree.right);
        tree = null;
    }
    public void clear(){
        destroy(mRoot);
        mRoot = null;
    }

    /**
     * 打印红黑树
     * @param tree
     * @param key
     * @param direction
     */
    private void print(RBTNode<T> tree, T key, int direction) {
        if (tree != null) {
            if (direction == 0)
                System.out.printf("%2d(B) is root\n", tree.key);
            else
                System.out.printf("%2d(%s) is %2d's %6s child\n", tree.key, isRed(tree)?"R":"B", key, direction==1?"right" : "left");
            print(tree.left, tree.key, -1);
            print(tree.right,tree.key,1);
        }
    }
    public void print(){
        if (mRoot != null) {
            print(mRoot,mRoot.key,0);
        }
    }

    class RBTNode<T extends Comparable<T>>{
        boolean color;
        T key;
        RBTNode<T> left;
        RBTNode<T> right;
        RBTNode<T> parent;

        public RBTNode(T key, boolean color, RBTNode<T> parent, RBTNode<T> left, RBTNode<T> right) {
            this.key = key;
            this.color = color;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public T getKey(){
            return key;
        }

        public String toString(){
            return " " + key + (this.color == RED ? "(R)" : "B");
        }
    }


}
