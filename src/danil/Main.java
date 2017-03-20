package graf;

public class Main {

    public static void main (String[] args){

        Uzel u1 = new Uzel();
        u1.setToArr(5);
        u1.setToArr(1);
        u1.setToArr(7);
        u1.setToArr(5);

        Uzel u2 = new Uzel();
        u2.setToArr(2);
        u2.setToArr(1);
        u2.setToArr(0);
        u2.setToArr(5);

        //System.out.println(u1.arr);

        u1.delToArr(5);

        //System.out.println(u1.arr);
        //System.out.println(u2.getArr());

        Cont cont = new Cont();
        cont.setToCont(1, u1);
        cont.setToCont(2, u2);

        System.out.println(cont.getCont());

    }

}
