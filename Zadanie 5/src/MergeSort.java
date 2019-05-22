class MergeSort extends Thread
{
    private static final int minMergeSortArraySize  =  2;    //Rozmiar tablicy

    int[] tab;
    int start;
    int end;

    public MergeSort(int[] a, int s, int e) { tab = a; start = s; end = e; }



    private void insertionSort()
    {
        for (int i = start; i < end; i++)  //Sortowanie przez wstawianie
        {
            int j, v = tab[i];

            for (j = i - 1; j >= 0; j--) {
                if (tab[j] <= v)
                    break;
                tab[j + 1] = tab[j];
            }

            tab[j + 1] = v;
        }
    }

    private void merge(int[] temp)
    {
        int i1;
        int i2;
        int tempi;

        i1 = start;
        i2 = end / 2;               //Dzielimy przez dwa aby uzyskać połowę
        tempi = 0;

        while (i1 < end / 2 && i2 < end) {   //Scalanie
            if (tab[i1] < tab[i2])
                temp[tempi++] = tab[i1++];
            else
                temp[tempi++] = tab[i2++];
        }

        while (i1 < end / 2) {
            temp[tempi++] = tab[i1++];
        }

        while (i2 < end) {
            temp[tempi++] = tab[i2++];
        }

        System.arraycopy(tab, start, temp, 0, end - start);
    }

    public void run()
    {
        int[] temp = new int[end];

        if ((end - start) < minMergeSortArraySize) {
            insertionSort();
            return;
        }

        MergeSort sort1 = new MergeSort(tab, start, start + ((end-start)/2));  //Tutaj wykonują się dwa równoległe wątki
        MergeSort sort2 = new MergeSort(tab, start + ((end-start)/2), end);

        sort1.start();
        sort2.start();
        try {
            sort1.join();
            sort2.join();
        }
        catch (Exception e) {}

        merge(temp);
    }
}