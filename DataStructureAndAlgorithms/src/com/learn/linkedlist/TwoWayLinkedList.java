package com.learn.linkedlist;


/**
 * 双向链表
 */
public class TwoWayLinkedList<E> {

    /** 容量 */
    private int capacity;

    /** 头结点 */
    private SNode head;

    /** 尾节点 */
    private SNode tail;

    private int size;

    public TwoWayLinkedList (int capacity) {
        this.capacity = capacity;
        // 哨兵节点
        head = tail = new SNode(null);
    }

    /**
     * 添加
     * @param data
     * @return
     */
    public boolean add (E data) {
        checkIsNull(data);
        if (size == capacity) {
            throw new RuntimeException("链表已满！！！！");
        }
        // 存在就删除，再添加
        //remove(data);
        // 添加
        SNode sNode = new SNode(data);
        // 设置尾节点的下一个节点为新加入节点
        tail.setNext(sNode);
        // 新加入节点的上一个节点就是尾节点
        sNode.setPrev(tail);
        // 更新尾节
        tail = sNode;
        size ++;
        return true;
    }

    /**
     * 查找
     * @param data
     * @return
     */
    public SNode find (E data) {
        checkIsNull(data);
        SNode q = head,p;
        while ((p = q.getNext()) != null) {
                if (data.equals(p.getItem())) {
                    return p;
                }
                q = p;
        }
        return null;
    }

    public boolean remove (E data) {
        checkIsNull(data);
        SNode sNode = find(data);
        if (sNode == null) {
            return false;
        }
        // 删除节点前节点
        SNode prev = sNode.getPrev();
        // 删除节点的后节点
        SNode next = sNode.getNext();
        prev.setNext(next);
        // next == null 等于是最后一个节点
        if (next == null) {
            tail = prev;
        }else {
            next.setPrev(prev);
        }
        sNode = null;
        size --;
        return true;
    }

    public int size () {
        return size;
    }

    /**
     * 判断是否是回文字符串 例如  12321
     * @return
     */
    public boolean isPalindrome () {
        SNode hslow = head.getNext();
        SNode tslow = tail;
        SNode fast= head.getNext();
        // 从头到中间节点
        StringBuilder hstr = new StringBuilder();
        // 从尾到中间节点
        StringBuilder tstr = new StringBuilder();
        while (fast != null) {
            hstr.append(hslow.getItem());
            tstr.append(tslow.getItem());
            hslow = hslow.getNext();
            tslow = tslow.getPrev();
            if (fast .getNext() == null) {
                System.out.println(hstr.toString() +" ----------  "+tstr.toString());
                return hstr.toString().equals(tstr.toString());
            }
            fast = fast .getNext().getNext();
        }
        return false;
    }

    public void printAll () {
        SNode q = head,p;
        while ((p = q.getNext()) != null) {
            System.out.println(p.getItem());
            q = p;
        }
    }

    public void checkIsNull (E data)throws NullPointerException {
        if (data == null) {
            throw new NullPointerException("data is null");
        }
    }

    static class SNode<E> {

        E item;

        SNode prev;

        SNode next;

        public SNode (E item) {
           this.item = item;
        }

        public E getItem() {
            return item;
        }

        public void setItem(E item) {
            this.item = item;
        }

        public SNode getPrev() {
            return prev;
        }

        public void setPrev(SNode prev) {
            this.prev = prev;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }

    public static void main (String[] args) {
        TwoWayLinkedList<String> linkedList = new TwoWayLinkedList<String>(20);
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("3");
        linkedList.add("2");
        linkedList.add("1");
        linkedList.isPalindrome();
        /*for (int i = 0; i < 20; i ++) {
            linkedList.add(String.valueOf(i));
        }
        linkedList.remove("19");*/
        linkedList.printAll();
    }
}
