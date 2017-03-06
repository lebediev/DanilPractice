public static Set<Integer> findMissingNumbers(int... numbers)
    {
        
        Set<Integer> set = new TreeSet<Integer>();
        for( Integer i : numbers ){
            set.add(Integer.valueOf(i));
            }
        Integer[] arr = set.toArray(new Integer[set.size()]);

        Set<Integer> arrF1 = new TreeSet<Integer>();

        for (int y = 0; y < arr.length - 1; y++){
            if (arr[y+1]-arr[y] != 1) {
                int m = arr[y + 1] - arr[y] - 1;
               
                for (int z = 0; z < m; z++) {
                   
                    arrF1.add(Integer.valueOf(arr[y] + 1));
                    arr[y]++;
                   
                }
            }
        }
    return arrF1;
    }
