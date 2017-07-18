import java.util.Arrays;
import java.util.Random;


public class HeapSortData {

    private int N;

    public int[] numbers;
    public int heapIndex;

    // 生成N个[0,randomBound)之间的随机数；nearlyOrdered控制随机数是否近乎有序
    public HeapSortData(int N, int randomBound, boolean nearlyOrdered){
        this.N = N;

        numbers = new int[N];
        heapIndex = N;

        for( int i = 0 ; i < N ; i ++)
            numbers[i] = (int)(Math.random()*randomBound) + 1;

        if(nearlyOrdered){
            Arrays.sort(numbers);
            int swapTime = (int)(0.02*N);
            for(int i = 0 ; i < swapTime; i ++){
                int a = (int)(Math.random()*N);
                int b = (int)(Math.random()*N);
                swap(a, b);
            }
        }
    }

    // 生成N个[lBound,rBound]之间的随机数
    public HeapSortData(int N, int lBound, int rBound){
        this.N = N;

        numbers = new int[N];
        heapIndex = N;

        for( int i = 0 ; i < N ; i ++)
            numbers[i] = (int)(Math.random()*(rBound-lBound+1)) + lBound;
    }

    public int N(){
        return N;
    }

    public int get(int index){
        if( index < 0 || index >= numbers.length)
            throw new IllegalArgumentException("Invalid index to access Sort Data.");

        return numbers[index];
    }

    public void swap(int i, int j) {
        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }
}