import java.util.Random;
import java.util.Arrays;

public class HeapSort
{
    // Default constructor
    public HeapSort() {}

    public static void sort(int[] arr)
    {
        build(arr);
        for (int i = arr.length - 1; i > 0; i--)
        {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr, 0, i);
        }
    }

    public static void build(int[] arr)
    {
        for (int i = arr.length / 2 - 1; i >= 0; i--)
        {
            heapify(arr, i, arr.length);
        }
    }

    public static void heapify(int[] arr, int node, int end)
    {
        while (node != -1)
        {
            int next = -1;
            int left = node * 2 + 1;
            int right = node * 2 + 2;

            if (right < end && (arr[right] > arr[node] && arr[right] > arr[left]))
            {
                next = right;
            } else if (left < end && arr[left] > arr[node]) {
                next = left;
            }

            if (next != -1)
            {
                int temp = arr[node];
                arr[node] = arr[next];
                arr[next] = temp;
            }

            node = next;
        }
    }

    public static void main(String[] args)
    {
        int NUM_TESTS = 1000;
        int MAX_NUM = 1000;
        System.out.println("--- HeapSort tests ---");
        
        int count = 0;
        Random random = new Random();
        for (int i = 0; i < NUM_TESTS; i++)
        {
            int[] testList = new int[random.nextInt(MAX_NUM)];
            for (int j = 0; j < testList.length; j++)
            {
                testList[j] = random.nextInt(MAX_NUM);
            }

            int[] copy = Arrays.copyOf(testList, testList.length);
            Arrays.sort(testList);
            HeapSort.sort(copy);

            boolean correct = true;
            for (int k = 0; k < testList.length; k++)
            {
                if (testList[k] != copy[k])
                {
                    correct = false;
                    break;
                }
            }

            if (correct) count++;
        }

        System.out.println(String.format("%d out of %d correct", count, NUM_TESTS));
    }
}