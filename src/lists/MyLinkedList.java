package lists;

import test.MyLinkedListTest;

import java.util.Iterator;

public class MyLinkedList <T> implements Iterable<T>{
    private Node<T> head;
    private Node<T> tail;
    private Integer size;

    public MyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Integer getSize(){
        return this.size;
    }

    public void AddtoFront(T data){
        Node<T> node = new Node<T>(data);
        if(isEmpty()){
            head = node;
            tail = node;
        }else{
            node.rightPtr = head;
            head.leftPtr = node;
            head = node;
        }
        this.size++;
    }

    public void AddToLast(T data){
        Node<T> node = new Node<T>(data);
        if(isEmpty()){
            head = node;
            tail = node;
        }else{
            node.leftPtr = tail;
            tail.rightPtr = node;
            tail = node;
        }
        this.size++;
    }

    public T removeFront(){
        if(isEmpty()){
            return  null;
        }
        T ret = head.data;
        head = head.rightPtr;
        if(head == null){
            tail = null;
        }else{
            head.leftPtr = null;
        }
        this.size--;
        return ret;
    }

    public T removeLast(){
        if(isEmpty()){
            return  null;
        }
        T ret = tail.data;
        tail = tail.leftPtr;
        if(tail == null){
            head = null;
        }else{
            tail.rightPtr = null;
        }
        this.size --;
        return ret;
    }

    public void Traverse(){
        Node<T> temp = head;
        while(temp != null){
            System.out.print("<-" + temp.data + "->");
            temp = temp.rightPtr;
        }
        System.out.println();
    }

    public void removeAtPost(T data){

        if(isEmpty()){
            return;
        }

        Node<T> front = head;
        Node<T> back = tail;


        int count = 0;
        while(front != back && count < getSize()){
            if(front.data == data){
                this.size--;
                if(front.leftPtr == null){
                    head = head.rightPtr;
                    head.leftPtr = null;
                    return;
                }
                front.leftPtr.rightPtr = front.rightPtr;
                front.rightPtr.leftPtr = front.leftPtr;
                return;
            }
            if(back.data == data){
                this.size--;
                if(back.rightPtr == null){
                   tail = tail.leftPtr;
                   tail.rightPtr = null;
                   return;
                }
                back.leftPtr.rightPtr = back.rightPtr;
                back.rightPtr.leftPtr = back.leftPtr;
                return;
            }
            front = front.rightPtr;
            back = back.leftPtr;
            count = count + 2;
        }

        if(front.data == data){
            this.size--;
            if(front.leftPtr != null && front.rightPtr != null){
                front.leftPtr.rightPtr = front.rightPtr;
                front.rightPtr.leftPtr = front.leftPtr;
            }else{
                head = null;
                tail = null;
            }
        }

    }

    public boolean isEmpty(){
        return (head == null && tail == null);
    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }
    private class MyLinkedListIterator implements Iterator<T>{
        private Node<T> temp;
        private int count = 0;
        public MyLinkedListIterator(){
            temp = head;
        }
        @Override
        public boolean hasNext() {
            if(count < getSize()){
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            count++;
            if(temp != null){
                T ret =  temp.data;
                temp = temp.rightPtr;
                return  ret;
            }
            return null;
        }
    }
}
