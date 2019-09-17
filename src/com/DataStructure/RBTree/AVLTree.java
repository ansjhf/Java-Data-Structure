package com.DataStructure.RBTree;

/**
 * @Author a
 * @create 2019-09-17 10:53
 */
public class AVLTree<T extends Comparable<T>> {

    private AVLTreeNode<T> mRoot;

    public AVLTree(){
        mRoot = null;
    }

    /**
     * 获取树的高度
     * @param tree
     * @return
     */
    private int height(AVLTreeNode<T> tree) {
        if (tree != null)
            return tree.height;
        return 0;
    }
    public int height(){
        return height(mRoot);
    }

    /**
     * 比较两个值的大小
     * @param a
     * @param b
     * @return
     */
    private int max(int a, int b) {
        return a > b ? a : b;
    }

    /**
     * 前序历遍
     * @param tree
     */
    private void preOrder(AVLTreeNode<T> tree) {
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
    private void inOrder(AVLTreeNode<T> tree) {
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
     * 后续历遍
     * @param tree
     */
    private void postOrder(AVLTreeNode<T> tree) {
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
     * (递归实现)查找树种键值为key的节点
     * @param x
     * @param key
     * @return
     */
    private AVLTreeNode<T> search(AVLTreeNode<T> x, T key) {
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
    public AVLTreeNode<T> search(T key) {
        return search(mRoot, key);
    }

    /**
     * (非递归实现)查找树种键值为key的节点
     * @param x
     * @param key
     * @return
     */
    private AVLTreeNode<T> iterativeSearch(AVLTreeNode<T> x, T key) {
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
    public AVLTreeNode<T> iterativeSearch(T key) {
        return iterativeSearch(mRoot, key);
    }

    /**
     * 查找树的最小节点
     * @param tree
     * @return
     */
    private AVLTreeNode<T> minimum(AVLTreeNode<T> tree) {
        if (tree == null)
            return null;
        while (tree.left != null)
            tree = tree.left;
        return tree;
    }
    public T minimum(){
        AVLTreeNode<T> p = minimum(mRoot);
        if (p != null)
            return p.key;
        return null;
    }

    /**
     * 查找树种最大节点
     * @param tree
     * @return
     */
    private AVLTreeNode<T> maximum(AVLTreeNode<T> tree) {
        if (tree == null)
            return null;
        while (tree.right != null)
            tree = tree.right;
        return tree;
    }
    public T maximum(){
        AVLTreeNode<T> p = maximum(mRoot);
        if (p != null)
            return p.key;
        return null;
    }

    /**
     *LL型失去平衡调整的旋转(左单旋转)
     * @param k2
     * @return 旋转后的根节点
     */
    private AVLTreeNode<T> LLRotation(AVLTreeNode<T> k2) {
        AVLTreeNode<T> k1;

        k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;

        k2.height = max(height(k2.left), height(k2.right)) + 1;
        k1.height = max(height(k1.left), k2.height) + 1;

        return k1;
    }

    /**
     * RR型失去平衡调整的旋转(右单旋转)
     * @param k1
     * @return
     */
    private AVLTreeNode<T> RRRotation(AVLTreeNode<T> k1) {
        AVLTreeNode<T> k2 = k1.right;

        k1.right = k2.left;
        k2.left = k1;

        k1.height = max(height(k1.left), height(k1.right)) + 1;
        k2.height = max(height(k2.right), k1.height) + 1;

        return k2;
    }

    /**
     * LR型失去平衡调整的旋转(左双旋转)
     * @param k3
     * @return
     */
    private AVLTreeNode LRRotation(AVLTreeNode<T> k3) {
        k3.left = RRRotation(k3.left);
        return LLRotation(k3);
    }

    /**
     * RL型失去平衡调整的旋转(右双旋转)
     * @param k1
     * @return
     */
    private AVLTreeNode<T> RLRotation(AVLTreeNode<T> k1) {
        k1.right = LLRotation(k1.right);
        return RRRotation(k1);
    }

    /**
     * 将节点插入到树中并返回根节点
     * @param tree
     * @param key
     * @return
     */
    private AVLTreeNode<T> insert(AVLTreeNode<T> tree, T key) {
        if (tree == null) {
            tree = new AVLTreeNode<T>(key, null, null);
            if (tree == null) {
                System.out.println("ERROR: create avltree node failed!");
                return null;
            }
        } else {
            int cmp = key.compareTo(tree.key);
            if (cmp < 0) {  //将key插入到tree左子树的情况
                tree.left = insert(tree.left, key);
                //插入节点后，若AVL树失去平衡，则进行相应的调整
                if (height(tree.left) - height(tree.right) == 2) {
                    if (key.compareTo(tree.left.key) < 0)
                        tree = LLRotation(tree);
                    else
                        tree = LRRotation(tree);
                }
            } else if (cmp > 0) {
                tree.right = insert(tree.right, key);
                if (height(tree.right) - height(tree.left) == 2) {
                    if (key.compareTo(tree.right.key) > 0)
                        tree = RRRotation(tree);
                    else
                        tree = RLRotation(tree);
                }   // cmp == 0
            } else {
                System.out.println("添加失败：不允许添加相同的节点！");
            }
        }
        tree.height = max(height(tree.left), height(tree.right));
        return tree;
    }
    public void insert(T key) {
        mRoot = insert(mRoot, key);
    }

    /**
     * 删除节点z并返回根节点
     * @param tree
     * @param z
     * @return
     */
    private AVLTreeNode<T> remove(AVLTreeNode<T> tree, AVLTreeNode<T> z) {
        if (tree == null || z == null)
            return null;
        int cmp = z.key.compareTo(tree.key);
        if (cmp < 0) { //待删除的节点在tree的左子树中
            tree.left = remove(tree.left, z);
            if (height(tree.right) - height(tree.left) == 2) {
                AVLTreeNode<T> r = tree.right;
                if (height(r.left) > height(r.right))
                    tree = RLRotation(tree);
                else
                    tree = RRRotation(tree);
            }
        } else if (cmp > 0) {   //待删除的节点在tree的右子树中
            tree.right = remove(tree.right, z);
            if (height(tree.left) - height(tree.right) == 2) {
                AVLTreeNode<T> l = tree.left;
                if (height(l.right) > height(l.left))
                    tree = LRRotation(tree);
                else
                    tree = LLRotation(tree);
            }
        } else {    //tree是对应要删除的节点
            //tree的左右子树都非空
            if ((tree.left != null) && (tree.right != null)) {
                if (height(tree.left) > height(tree.right)) {
                    // 如果tree的左子树比右子树高；
                    // 则(01)找出tree的左子树中的最大节点
                    //   (02)将该最大节点的值赋值给tree。
                    //   (03)删除该最大节点。
                    // 这类似于用"tree的左子树中最大节点"做"tree"的替身；
                    // 采用这种方式的好处是：删除"tree的左子树中最大节点"之后，AVL树仍然是平衡的。
                    AVLTreeNode<T> max = maximum(tree.left);
                    tree.key = max.key;
                    tree.left = remove(tree.left, max);
                } else {
                    // 如果tree的左子树不比右子树高(即它们相等，或右子树比左子树高1)
                    // 则(01)找出tree的右子树中的最小节点
                    //   (02)将该最小节点的值赋值给tree。
                    //   (03)删除该最小节点。
                    // 这类似于用"tree的右子树中最小节点"做"tree"的替身；
                    // 采用这种方式的好处是：删除"tree的右子树中最小节点"之后，AVL树仍然是平衡的。
                    AVLTreeNode<T> min = minimum(tree.right);
                    tree.key = min.key;
                    tree.right = remove(tree.right, min);
                }
            } else {
                AVLTreeNode<T> tmp = tree;
                tree = (tree.left != null) ? tree.left : tree.right;
                tmp = null;
            }

        }
        return tree;
    }
    public void remove(T key) {
        AVLTreeNode<T> z;
        if ((z = search(mRoot,key)) != null)
            mRoot = remove(mRoot, z);
    }

    /**
     * 销毁AVL树
     * @param tree
     */
    private void destroy(AVLTreeNode<T> tree) {
        if (tree == null)
            return;
        if (tree.left != null)
            destroy(tree.left);
        if (tree.right != null)
            destroy(tree.right);
        tree = null;
    }
    public void destory(){
        destroy(mRoot);
    }

    /*
     * 打印"二叉查找树"
     *
     * key        -- 节点的键值
     * direction  --  0，表示该节点是根节点;
     *               -1，表示该节点是它的父结点的左孩子;
     *                1，表示该节点是它的父结点的右孩子。
     */
    private void print(AVLTreeNode<T> tree, T key, int direction) {
        if(tree != null) {
            if(direction==0)    // tree是根节点
                System.out.printf("%2d is root\n", tree.key, key);
            else                // tree是分支节点
                System.out.printf("%2d is %2d's %6s child\n", tree.key, key, direction==1?"right" : "left");

            print(tree.left, tree.key, -1);
            print(tree.right,tree.key,  1);
        }
    }

    public void print() {
        if (mRoot != null)
            print(mRoot, mRoot.key, 0);
    }

    class AVLTreeNode<T extends Comparable<T>>{
        T key;
        int height;
        AVLTreeNode<T> left;
        AVLTreeNode<T> right;

        public AVLTreeNode(T key, AVLTreeNode<T> left, AVLTreeNode<T> right) {
            this.key = key;
            this.height = 0;
            this.left = left;
            this.right = right;
        }
    }
}

