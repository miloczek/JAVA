public class Main
{

    public static void main(String[] args)
    {
        int[] T = {4,2,1,5,6,55,9,120};

        MergeSort sort = new MergeSort(T, 0, 8); sort.start();

        try
        {
            sort.join();
        }
        catch(Exception e) {}

        for(int i = 0; i < 8; i++) System.out.println(T[i]);
    }
}