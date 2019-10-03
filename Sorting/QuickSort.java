import java.util.Random;
import java.util.Arrays;

public class QuickSort
{
    // Default constructor
    public QuickSort() {}

    public static void sort(int[] arr)
    {
        sort(arr, 0, arr.length);
    }

    public static void sort(int[] arr, int start, int end)
    {
        if (start >= end - 1) return;
        int bound = partition(arr, start, end);
        sort(arr, start, bound);
        sort(arr, bound+1, end);
    }

    public static int partition(int[] arr, int start, int end)
    {
        int x = arr[end-1];
        int pointer = start;
        for (int i = start; i < end-1; i++)
        {
            if (arr[i] <= x)
            {
                int temp = arr[pointer];
                arr[pointer++] = arr[i];
                arr[i] = temp;
            }
        }

        int temp = arr[--pointer];
        arr[pointer] = arr[end-1];
        arr[end] = temp;
        return pointer;
    }

    public static void main(String[] args)
    {
        int NUM_TESTS = 1000;
        int MAX_NUM = 1000;
        System.out.println("--- Quicksort tests ---");
        
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