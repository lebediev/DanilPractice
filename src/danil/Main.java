package graf;

public class Main {

    public static void main (String[] args){

        Uzel u1 = new Uzel();
        u1.setToArr(5);
        u1.setToArr(1);
        u1.setToArr(7);
        u1.setToArr(5);

        System.out.println(u1.arr);

        u1.delToArr(5);

        System.out.println(u1.arr);

    }

}
