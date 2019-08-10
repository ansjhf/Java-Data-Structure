package com.DataStructure.LinkedList;

public interface ListInterface {

    /**
     * Task: 往表的末尾插入新元素
     * @param newEntry
     * @return
     */
    public boolean add(Object newEntry);

    /**
     * Task:往表中指定位置插入一个新元素
     * @param newPosition
     * @param newEntry
     * @return
     */
    public boolean add(int newPosition, Object newEntry);

    /**
     * Task:从表中删除指定位置的元素
     * @param givenPosition
     * @return
     */
    public Object remove(int givenPosition);

    /**
     * Task:删除表中所有的元素
     */
    public void clear();

    /**
     * Task:替换表中指定位置的元素
     * @param givenPosition 指定替换元素的位置
     * @param newEntry 用来替换givenP位置元素的对象
     * @return 替换成功返回true，否则返回false
     */
    public boolean replace(int givenPosition, Object newEntry);

    /**
     * Task:检索表中指定位置的元素
     * @param givenPosition
     * @return
     */
    public Object getEntry(int givenPosition);

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
    public int getLength();

    /**
     * Task:判断表是否为空
     * @return
     */
    public boolean isEmpty();

}
