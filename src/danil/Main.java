public class Main {

    public static void main(String[] args) {

        Set<Integer> set = new TreeSet<Integer>();
        set.add(10);
        set.add(2);
        set.add(1);
        set.add(5);
        
        Integer[] arr = set.toArray(new Integer[set.size()]);
        
        for (int y = 0; y<arr.length; y++){
           if (arr[y+1]-arr[y] != 1) {
               int m = arr[y + 1] - arr[y] - 1;
               int[] arrF = new int[m];
               //System.out.println("M: "+m);
               for (int z = 0; z < m; z++) {
                   arrF[z] = arr[y] + 1;
                   arr[y]++;
                   System.out.println("arrFz: "+arrF[z]);
               }
           }
        }
    }
