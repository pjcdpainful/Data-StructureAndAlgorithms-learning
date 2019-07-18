package com.array;

/**
 * 实现数组的基本操作 查找，插入，删除
 */
public class ArrayUtils {

    /** 默认容量 */;
    private static int DEFAULT_CAPACITY = 16;

    /** 容量 */;
    private static int capacity;

    /** 元素个数 */;
    private static int size;

    /** 数组 */;
    private static int[] data;

    public ArrayUtils () {
        this(DEFAULT_CAPACITY);
    }

    public ArrayUtils (int capacity) {
        capacity = capacity;
        data = new int[capacity];
    }

    /**
     * 末尾添加
     * @return
     */
    public boolean add (int item) {
        if (size == capacity) {
            System.out.println("数组容量已满！！！！");
            return false;
        }
        data[++size] = item;
        return true;
    }

    /**
     * 指定位置添加
     * @return
     */
    public boolean add (int index,int item) {
        if (index >= capacity) {
            System.out.println("数组已满或者超容量");
            return false;
        }
        // 没有 走末尾添加
        if (data[index] == 0) {
            add(item);
        }else{
            for (int i = size; i > index; i --) {
                    data[i] = data[i-1];
            }
            data[index] = item;
        }
        size ++;
        return true;
    }

    /**
     * 查找通过索引
     * @param index
     * @return
     */
    public int  findByIndex (int index) {
        if (index < capacity) {
            System.out.println("索引越界");
            return -1;
        }
        return data[index];
    }

    /**
     * 查找通过item
     * @param item
     * @return
     */
    public int find (int item) {
        for (int i = 0; i < size; i ++) {
            if (item == data[i]) {
                return data[i];
            }
        }
        return -1;
    }


    public int size () {
        return size;
    }


    public static void main (String[] args) {
        ArrayUtils array = new ArrayUtils(2);
        array.add(1);
        array.add(2);
        array.add(3);
    }

}
