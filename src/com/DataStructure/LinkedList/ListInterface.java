package com.DataStructure.LinkedList;

public interface ListInterface {

    /**
     * Task: 往表的末尾插入新元素
     * @param newEntry 要插入的目标元素
     * @return 成功返回true，否则返回false
     */
    public boolean add(Object newEntry);

    /**
     * Task:往表中指定位置插入一个新元素
     * @param index
     * @param newEntry
     * @return
     */
//    public  void add(int index, Object newEntry);

    /**
     * Task:从表中删除指定位置的元素
     * @param index
     * @return
     */
    public Object remove(int index);

    /**
     * Task:删除表中所有的元素
     */
    public void clear();

    /**
     * Task:替换表中指定位置的元素
     * @param index 指定替换元素的位置
     * @param newEntry 用来替换givenP位置元素的对象
     * @return 替换成功返回true，否则返回false
     */
    public boolean set(int index, Object newEntry);

    /**
     * Task:检索表中指定位置的元素
     * @param index
     * @return
     */
    public Object get(int index);

    /**
     * Task:判断表中是否包含有给定的元素
     * @param anEntry
     * @return
     */


    public boolean contains(Object anEntry);

    /**
     * Task:获得表的长度
     * @return
     */
    public int size();

    /**
     * Task:判断表是否为空
     * @return
     */
    public boolean isEmpty();

}
