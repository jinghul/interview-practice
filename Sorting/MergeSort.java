import java.util.Arrays;
import java.util.Random;

public class MergeSort
{
    public MergeSort() {}

    public static void sort(int[] arr)
    {
        sort(arr, 0, arr.length);
    }

    public static void sort(int[] arr, int start, int end)
    {
        if (end - 1 <= start) return;
        
        int mid = start + (end - start) / 2;
        sort(arr, start, mid);
        sort(arr, mid, end);
        merge(arr, start, mid, end);
    }

    public static void merge(int[] arr, int start, int mid, int end)
    {
        int[] left = new int[mid - start];
        for (int i = start; i < mid; i++) left[i-start] = arr[i];
        int[] right = new int[end - mid];
        for (int i = mid; i < end; i++) right[i-mid] = arr[i];

        int l = 0, r = 0;
        for (int i = start; i < end; i++)
        {
            if (l == left.length)
            {
                arr[i] = right[r++];
            } else if (r == right.length)
            {
                arr[i] = left[l++];
            } else if (left[l] < right[r])
            {
                arr[i] = left[l++];
            } else {
                arr[i] = right[r++];
            }
        }
    }

    public static void main(String[] args)
    {
        int NUM_TESTS = 1000;
        int MAX_NUM = 1000;
        System.out.println("--- MergeSort tests ---");
        
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
            MergeSort.sort(copy);

            boolean correct = true;
            for (int k = 0; k < testList.length; k++)
            {
                if (testList[k] != copy[k])
                {
                    System.out.println(Arrays.toString(testList) + "\n" + Arrays.toString(copy));
                    correct = false;
                    break;
                }
            }

            if (correct) count++;
        }

        System.out.println(String.format("%d out of %d correct", count, NUM_TESTS));
    }
}