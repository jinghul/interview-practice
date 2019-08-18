public class Node<T>
{
    public T value;
    public Node<T> next;

    public Node() {}

    public Node(T value)
    {
        this.value = value;
    }

    public Node(T value, Node<T> next)
    {
        this(value);
        this.next = next;
    }

    public String toString()
    {
        return value.toString();
    }
}