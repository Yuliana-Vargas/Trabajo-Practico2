import customExceptions.ExistingKeyException;
import customExceptions.RemoveItemWithNonExistentKeyException;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws ExistingKeyException, RemoveItemWithNonExistentKeyException {
        EpicDoubleHashMap<Integer, Integer, String> map = new EpicDoubleHashMap<>();
        try {
            //-------ADD - ExistingKeyException
            map.addFirstType(1, 6);
            //map.addFirstType(1,2); //The value 2 couldn't be added because the key 1 already has a value assigned to it.
            //map.addSecondType(1,"cow"); //The value cow couldn't be added because the key 1 already has a value assigned to it.

            map.addSecondType(2, "cat");
            //map.addSecondType(2,"dog"); //The value dog couldn't be added because the key 2 already has a value assigned to it.
            //map.addFirstType(2,1); //The value 1 couldn't be added because the key 2 already has a value assigned to it.

            map.addTwoTypes(3, 1, "snake");
            //map.addTwoTypes(3,2,"bee"); //The values 2 and bee couldn't be added because the key 3 already has a value assigned to it.
            //map.addFirstType(3,1); //The value 1 couldn't be added because the key 3 already has a value assigned to it.
            //map.addSecondType(3,"horse"); //The value horse couldn't be added because the key 3 already has a value assigned to it.


            //---------GET
            System.out.println(map.getFirstType(1));
            System.out.println(map.getFirstType(3));
            System.out.println(map.getSecondType(2));
            System.out.println(map.getSecondType(3));


            //---------REMOVE - RemoveItemWithNonExistentKey
            map.addFirstType(4, 4);
            map.addSecondType(5, "pig");
            map.addTwoTypes(6, 5, "lion");

            map.removeFirstType(4);
            //map.removeFirstType(4); //The item couldn't be removed because the key 4 doesn't exist.

            map.removeSecondType(5);
            //map.removeSecondType(5);//The item couldn't be removed because the key 5 doesn't exist.

            map.removeTwoTypes(6);
            //map.removeTwoTypes(6); //The item couldn't be removed because the key 6 doesn't exist.


        } catch (ExistingKeyException | RemoveItemWithNonExistentKeyException e) {
            System.out.println(e.getMessage());
        }

        HashMap<Integer, Integer> h = map.getFirstMap();
        System.out.println("values of the first map: ");
        for (Integer i : h.keySet()) {
            System.out.print(h.get(i) + " ");
        }

        HashMap<Integer, String> h2 = map.getSecondMap();
        System.out.println("\nvalues of the second map: ");
        for (Integer i : h2.keySet()) {
            System.out.print(h2.get(i) + " ");
        }
    }

}
