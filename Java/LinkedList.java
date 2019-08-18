import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LinkedList<T> {

    private Node<T> head;
    private int size;

    public LinkedList() {}

    public int size()
    {
        return size;
    }

    public boolean empty()
    {
        return size == 0;
    }

    public Node<T> insert(T value, int index)
    {
        this.size++;
        if (this.head == null)
        {
            this.head = new Node<T>(value);
            return this.head;
        }

        int count = 1;
        Node<T> pointer = this.head;
        while (count < index && pointer.next != null)
        {
            pointer = pointer.next;
            count++;
        }
        pointer.next = new Node<T>(value, pointer.next);
        return pointer.next;
    }

    public Node<T> pushFront(T value)
    {
        this.size++;
        this.head = new Node<T>(value, this.head);
        return this.head;
    }

    public void prepend(T[] values)
    {
        for (int i = values.length-1; i >= 0; i--)
        {
            this.pushFront(values[i]);
        }
    }

    public Node<T> pushBack(T value)
    {
        this.size++;
        if (this.head == null)
        {
            this.head = new Node<T>(value);
            return this.head;
        }

        Node<T> pointer = this.head;
        while (pointer.next != null)
        {
            pointer = pointer.next;
        }
        pointer.next = new Node<T>(value);
        return pointer.next;
    }

    public void append(T[] values)
    {
        for (int i = 0; i < values.length; i++)
        {
            this.pushBack(values[i]);
        }
    }

    public T popFront()
    {
        this.size--;
        T val = null;
        if (this.head != null)
        {
            val = this.head.value;
            this.head = this.head.next;
        }
        return val;
    }

    public T popBack()
    {
        this.size--;
        T val = null;
        if (this.head == null)
        {
            return val;
        } else if (this.head.next == null)
        {
            val = this.head.value;
            this.head = null;
            return val;
        }

        Node<T> pointer = this.head;
        while (pointer.next.next != null)
        {
            pointer = pointer.next;
        }

        val = pointer.next.value;
        pointer.next = null;
        return val;
    }

    public Node<T> front()
    {
        return this.head;
    }

    public Node<T> back()
    {
        if (this.head == null)
        {
            return this.head;
        }
        Node<T> pointer = this.head;
        while (pointer.next != null)
        {
            pointer = pointer.next;
        }
        return pointer;
    }

    public T delete(int index)
    {
        this.size--;
        if (index >= size || index < 0)
        {
            return null;
        }

        T val = null;
        if (index == 0)
        {
            val = this.head.value;
            this.popFront();
            return val;
        }

        int count = 1;
        Node<T> prev = this.head;
        Node<T> pointer = this.head.next;
        while (count < index)
        {
            prev = prev.next;
            pointer = pointer.next;
            count++;
        }

        val = prev.next.value;
        prev.next = pointer.next;
        return val;
    }

    public void reverse()
    {
        Node<T> a = null, b = this.head, c = null;

        while (b != null)
        {
            c = b.next;
            b.next = a;
            a = b;
            b = c;
        }

        this.head = a;
    }

    public boolean equals(List<T> other)
    {
        var equivalent = other.size() == this.size();
        if (equivalent)
        {
            var pointer = this.head;
            for (var item : other)
            {
                if (item != pointer.value)
                {
                    equivalent = false;
                    break;
                }
                pointer = pointer.next;
            }
        }

        return equivalent;
    }

    public String toString()
    {
        return this.toList().toString();
    }

    public List<T> toList()
    {
        var list = new ArrayList<T>();
        var pointer = this.head;
        while (pointer != null)
        {
            list.add(pointer.value);
            pointer = pointer.next;
        }
        return list;
    }

    public static void main(String[] args)
    {
        System.out.println("--- Starting 'LinkedList' module tests ---");
        LinkedList<Integer> list = new LinkedList<Integer>();
        List<Integer> test = new ArrayList<Integer>();

        list.prepend(new Integer[]{1,2,3,4,5,6});
        list.append(new Integer[]{7,8,9,10,11});
        test.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11));
        if (!list.equals(test))
        {
            System.out.println(String.format("a. Expected %s, got %s", test.toString(), list.toString()));
        } 
        else 
        {
            System.out.println("a. OK");
        }

        list.popBack();
        list.popFront();
        list.popFront();
        test.remove(test.size()-1);
        test.remove(0);
        test.remove(0);
        if (!list.equals(test))
        {
            System.out.println(String.format("b. Expected %s, got %s", test.toString(), list.toString()));
        } 
        else 
        {
            System.out.println("b. OK");
        }

        list.delete(3);
        test.remove(3);
        list.delete(1);
        test.remove(1);
        if (!list.equals(test))
        {
            System.out.println(String.format("c. Expected %s, got %s", test.toString(), list.toString()));
        } 
        else 
        {
            System.out.println("c. OK");
        }

        list.reverse();
        Collections.reverse(test);
        if (!list.equals(test))
        {
            System.out.println(String.format("d. Expected %s, got %s", test.toString(), list.toString()));
        } 
        else 
        {
            System.out.println("d. OK");
        }
    }
}