package lists;

public class Node<T> {
    T data;
    Node leftPtr;
    Node rightPtr;

    public Node(T data){
        this.data = data;
        leftPtr = null;
    }
}
