public class Array
{
    public static int STARTING_CAPACITY = 16;
    public static int NOT_FOUND_INT = -1;
    
    private int size;
    private int capacity;
    private int[] vector;

    public Array()
    {
        this(STARTING_CAPACITY);
    }

    public Array(int capacity)
    {
        this.capacity = STARTING_CAPACITY;
        while (this.capacity < capacity)
        {
            this.capacity *= 2;
        }

        this.size = 0;
        this.vector = new int[this.capacity];
    }

    private void autoresize()
    {
        if (this.size > this.capacity / 2)
        {
            this.capacity = this.capacity * 2;
            this.transfer();

        } else if (this.size <= this.capacity / 4 && this.capacity > STARTING_CAPACITY) {
            this.capacity /= 2;
            this.transfer();
        }
    }

    private void transfer()
    {
        int[] newArray = new int[this.capacity];
        for (int i = 0; i < this.size; i++)
        {
            newArray[i] = this.vector[i];
        }
        this.vector = newArray;
    }

    public int size()
    {
        return this.size;
    }

    public int capacity()
    {
        return this.capacity;
    }

    public boolean isEmpty()
    {
        return this.size != 0;
    }

    public void insert(int elem, int index)
    {
        // throw index outofbounds exception if index is off
        // index < 0 || index > this.size
        for (int i = this.size++; i > index; i++)
        {
            this.vector[i] = this.vector[i-1];
        }
        this.vector[index] = elem;
        this.autoresize(); 
    }

    public void push(int elem)
    {
        this.insert(elem, this.size);
    }

    public int remove(int index)
    {
        // throw index outofbounds exception if index is off
        // index < 0 || index > this.size
        int elem = this.vector[index];
        for (int i = index; i < this.size; i++)
        {
            this.vector[i] = this.vector[i+1];
        }
        this.size--;
        this.autoresize();
        return elem;
    }

    public int pop()
    {
        return this.remove(this.size-1);
    }

    // Returns first index occurence of requested int found.
    public int find(int elem)
    {   
        for (int i = 0; i < this.size; i++)
        {
            if (this.vector[i] == elem)
            {
                return i;
            }
        }
        return NOT_FOUND_INT;
    }

    public static void main(String[] args)
    {
        System.out.println("--- Starting 'Array' module tests ---");
        System.out.println("1. Correct capacity on initial capacity.");
        int[] test1 = new int[] { 16, 5, 0, -1, 19, 182, 2016, 54 };
        int[] correct1 = new int[] { 16, 16, 16, 16, 32, 256, 2048, 64 };
        
        for (int i = 0; i < test1.length; i++)
        {
            Array arr = new Array(test1[i]);
            if (arr.capacity() != correct1[i])
            {
                System.out.println(String.format("xxx (%d) Expected %d, got %d", i, correct1[i], arr.capacity()));
            } else {
                System.out.println("- OK");
            }
        }

        System.out.println("2. Autoresize correctly on add conditions");
        int[] test2 = new int[] { 16, 5, 0, -1, 19, 182, 2016, 54, 99 };
        int correct2 = 32;
        Array arr2 = new Array();
        for (int i = 0; i < test2.length; i++)
        {
                arr2.push(test2[i]);
        }

        if (correct2 != arr2.capacity())
        {
            System.out.println(String.format("xxx Expected %d, got %d", correct2, arr2.capacity()));
        } else {
            System.out.println("- OK");
        }

        System.out.println("3. Autoresize correctly on remove conditions");
        int correct3 = 16;
        for (int i = 0; i < 2; i++)
        {
                arr2.pop();
        }
        if (correct3 != arr2.capacity())
        {
            System.out.println(String.format("xxx Expected %d, got %d", correct3, arr2.capacity()));
        } else {
            System.out.println("- OK");
        }

        System.out.println("4. Find functionality");
        int[] test4 = new int[] { 16, 5, 0, -1, 19, 182, 2016, 54, 99 };
        int[] correct4 = new int[] { 0, 1, 2, 3, 4, 5, 6, -1, -1 };
        for (int i = 0; i < test4.length; i++)
        {
            int result = arr2.find(test4[i]);
            if (result != correct4[i])
            {
                System.out.println(String.format("xxx (%d) Expected %d, got %d", i, correct4[i], result));
            } else {
                System.out.println("- OK");
            }
        }
    }
}