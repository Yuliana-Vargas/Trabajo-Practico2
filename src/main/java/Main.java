import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        EpicDoubleHashMap<Integer,Integer,String> map = new EpicDoubleHashMap<>();
        map.addFirstType(5,6);
        map.addFirstType(3,2);
        map.addFirstType(9,16);
        map.addSecondType(5,"cow");
        map.addSecondType(2,"snake");
        map.addTwoTypes(7,1,"cat");

        HashMap<Integer,Integer> h = map.getFirstMap();
        System.out.println("values of the first map: ");
        for (Integer i : h.keySet()){
            System.out.print(h.get(i) + " ");
        }

        HashMap<Integer,String> h2 = map.getSecondMap();
        System.out.println("\nvalues of the second map: ");
        for (Integer i : h2.keySet()){
            System.out.print(h2.get(i)+ " ");
        }
    }

}
