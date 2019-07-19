package com.learn.linkedlist;

/**
 * 链表的基本操作
 */
public class LinkedList<E> {

    /** 容量 */
    private int count;

    /** 头结点 */
    private Node head;

    /** 尾节点 */
    private Node tail;

    private int size;

    public LinkedList (int count) {
        this.count = count;
        // 哨兵节点
        head = tail = new Node(null);
    }

    /**
     * 添加数据
     * @param data
     * @return
     */
    public boolean add (E data) {
        // 不可以为空
        checkIsNull(data);
        if (size == count) {
            throw new RuntimeException("链表已满!!!!!!!!!!!!!");
        }
        E oldData = find(data);
        // 以存在链表
        if (oldData != null) {
            remove(data);
        }
        // 尾部插入 更新尾节点
        tail.setNext(tail = new Node(data));
        size ++;
        return true;
    }

    /**
     * 查找
     * @param data
     * @return
     */
    public E find (E data) {
        checkIsNull(data);
        Node q = head,p;
        while ((p = q.getNext()) !=null) {
                if (data.equals(p.getIetm())) {
                    return (E) p.getIetm();
                }
                q = p;
        }
        return null;
    }

    /**
     * 删除某个节点
     * @param data
     * @return
     */
    public boolean remove (E data) {
        checkIsNull(data);
        Node q = head,p;
        while ((p = q.getNext()) !=null) {
            if (data.equals(p.getIetm())) {
                q.setNext(p.getNext());
                if ( p == tail) {
                    tail = q;
                }
                p = null;
                size --;
                return true;
            }
            q = p;
        }
        return false;
    }

    /**
     * 元素的个数
     * @return
     */
    public int size () {
        return size;
    }

    /**
     * 链表反转
     * @return 头结点
     */
    public Node<E> reversal () {
        Node newnode = null;
        Node q = head,p;
        while ((p = q.getNext()) != null) {
            Node node = new Node(p.getIetm());
            node.setNext(newnode);
            newnode = node;
            q = p;
        }
        return newnode;
    }

    /**
     * 查找中间节点
     * 方法：快慢节点法
     * @return
     */
    public Node intermediateNode () {
        Node q = head.getNext();
        Node p =head.getNext();
        // q 一次推进一个节点
        // p 一次推进两个节点
        // 当p到链表的结尾时，q刚好到中间节点
        Node intermediateNode = null;
        while (q != null && p != null) {
                q = q.getNext();
                if (p.getNext() == null) {
                    return intermediateNode;
                }
                p = p.getNext().getNext();
            intermediateNode = q;
        }
        return intermediateNode;
    }

    public void printAll (Node node) {
        Node q = head,p;
        if (node != null ) {
            q = node;
        }
        while ((p = q.getNext()) != null) {
            System.out.println(p.getIetm());
            q = p;
        }
    }

    public void checkIsNull (E data)throws NullPointerException {
        if (data == null) {
            throw new NullPointerException("data is null");
        }
    }
    // 链表节点
    static class Node<E> {

        E ietm;

        Node next;

        public Node (E data) {
            this.ietm = data;
        }

        public E getIetm() {
            return ietm;
        }

        public void setIetm(E ietm) {
            this.ietm = ietm;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    public static void main (String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>(20);
        for (int i = 0; i < 9; i++) {
            linkedList.add(String.valueOf(i));
        }
        linkedList.printAll(null);
        System.out.println("我是分割线--------------");
        Node<String> reversalNode = linkedList.reversal();
        linkedList.printAll(reversalNode);
        System.out.println("我是分割线--------------");
        Node node = linkedList.intermediateNode();
        System.out.println(node.getIetm());
        System.out.println();
    }

}
