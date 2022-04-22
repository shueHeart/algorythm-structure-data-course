import java.util.*;

public class LinkedList
{
    public Node head;
    public Node tail;

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                nodes.add(node);
            node = node.next;
        }
        // здесь будет ваш код поиска всех узлов
        return nodes;
    }

    public boolean remove(int _value)
    {
        Node node = this.head;
        while (node != null) {
            if (node.next.value == _value) {
                node.next = node.next.next;
                return true;
            }
            node = node.next
        }
        return false;
        // delete one
    }

    public void removeAll(int _value)
    {
        Node node = this.head;
        while (node != null) {
            if(node.next.value == _value)
                node.next == node.next.next;
            node = node.next
        }
        // здесь будет ваш код удаления всех узлов по заданному значению
    }

    public void clear()
    {
        this.head = null;
        this.tail = null;
        // здесь будет ваш код очистки всего списка
    }

    public int count()
    {
        int count = 0;
        Node node = this.head;
        while(node != null) {
            ++count;
            node = node.next
        }
        return count; // здесь будет ваш код подсчёта количества элементов в списке
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        // здесь будет ваш код вставки узла после заданного
        if(_nodeAfter != null) {
            Node node = this.head;
            while (node != null) {
                if (node.equals(_nodeAfter)) {
                    _nodeToInsert.next = node.next;
                    node.next = _nodeToInsert;
                    break;
                }
            }
        }else{
            _nodeToInsert.next = this.head;
            this.head = _nodeToInsert.next;
        }

        // если _nodeAfter = null ,
        // добавьте новый элемент первым в списке
    }

}

class Node
{
    public int value;
    public Node next;
    public Node(int _value)
    {
        value = _value;
        next = null;
    }
}