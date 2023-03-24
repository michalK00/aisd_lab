package L6.z2;

public class CountingSort {

    public int[] sort(int arr[], int min, int max) throws Exception {

        int numberOfAssignments = 0;
        float start = System.nanoTime();
        if(min<0 || min>max){
            throw new Exception("Error, wrong values");
        }else if (min == max){
            return arr;
        }
        int n=arr.length;
        int[] pos = new int[max-min + 1];
        int[] result = new int[n];
        int i,j;

        for(i=0;i<pos.length;i++)
            pos[i]=0;
        for(j=0; j<arr.length;j++){
            pos[arr[j]-min]++;
        }

        pos[0]--;
        for(i=1;i<pos.length;i++){
            pos[i]+=pos[i-1];
        }

        for(j=n-1;j>=0;j--)
        {
            numberOfAssignments++;
            result[pos[arr[j]-min]]=arr[j];
            pos[arr[j]-min]--;
        }
        float finish = System.nanoTime();
        float timeElapsed = finish - start;
        System.out.println("Counting sort");
        System.out.println("Number of elements: "+ arr.length);
        System.out.println("Time elapsed: " + timeElapsed/1000000000 +" s");
        System.out.println("Number of assignments: " + numberOfAssignments);
        return result;
    }

}
