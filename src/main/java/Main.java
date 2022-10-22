import customExceptions.*;
import specificClasses.Game;
import specificClasses.Player;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws ExistingKeyException, RemoveItemWithNonExistentKeyException, NonExistentValueException, ItemRepeatedThreeTimesException {
        EpicDoubleHashMap<Integer, Player, Game> map = new EpicDoubleHashMap<>();
        try {
            Player p1 = new Player("Juan");
            Game g1 = new Game(100);
            Player p2 = new Player("Luna");
            Game g2 = new Game(200);


            //-------ADD - ExistingKeyException
            map.addFirstType(1, p1);
            //map.addFirstType(1,p1); //The value Juan couldn't be added because the key 1 already has a value assigned to it.
            //map.addSecondType(1,g1); //The value totalPoints: 100 couldn't be added because the key 1 already has a value assigned to it.

            map.addSecondType(2, g1);
            //map.addSecondType(2,g1); //The value totalPoints: 100 couldn't be added because the key 2 already has a value assigned to it.
            //map.addFirstType(2,p1); //The value Juan couldn't be added because the key 2 already has a value assigned to it.

            map.addTwoTypes(3, p2, g2);
            //map.addTwoTypes(3,p2,g2); //The values Luna and totalPoints: 200 couldn't be added because the key 3 already has a value assigned to it.
            //map.addFirstType(3,p2); //The value Luna couldn't be added because the key 3 already has a value assigned to it.
            //map.addSecondType(3,g2); //The value totalPoints: 200 couldn't be added because the key 3 already has a value assigned to it.


            //---------GET - NonExistentValueException
            System.out.println("The value is " + map.getFirstType(1));
            System.out.println("The value is " + map.getSecondType(2));
            System.out.println("The value is " + map.getSecondType(3));
            System.out.println("The value is " + map.getFirstType(3));
            //System.out.println(map.getFirstType(100)); //The value associated to the key 100 couldn't be got because it doesn't exist.
            //System.out.println(map.getSecondType(100)); //The value associated to the key 100 couldn't be got because it doesn't exist.


            //---------REMOVE - RemoveItemWithNonExistentKey
            map.addFirstType(4, new Player("Laura"));
            map.addSecondType(5, new Game(300));
            map.addTwoTypes(6, new Player("Pedro"), new Game(300));

            map.removeFirstType(4);
            //map.removeFirstType(4); //The item couldn't be removed because the key 4 doesn't exist.

            map.removeSecondType(5);
            //map.removeSecondType(5);//The item couldn't be removed because the key 5 doesn't exist.

            map.removeTwoTypes(6);
            //map.removeTwoTypes(6); //The item couldn't be removed because the key 6 doesn't exist.


            //-------------ItemRepeatedThreeTimesException
            Player p3 = new Player("Talia");
            Game g3 = new Game(500);

            map.addFirstType(7, p3);
            map.addFirstType(8, p3);
            map.addTwoTypes(9, p3, g3);
            map.addTwoTypes(10, p3, g3);
            //map.addFirstType(11,p3); //The item with key: 11 and value: Talia can't be added a third time.
            //map.addTwoTypes(15,p3,g3); //The item with key: 15 and values: Talia, totalPoints: 500 can't be added a third time.
            map.addSecondType(12, g3);
            map.addSecondType(13, g3);
            //map.addSecondType(14,g3); //The item with key: 14 and value: totalPoints: 500 can't be added a third time.


            //----------- AUX METHOD: timesRepeatedValue
            Player p4 = new Player("Kevin");
            map.addFirstType(20, p4);
            map.addFirstType(21, p4);
            map.addTwoTypes(22, p4, new Game(15));
            System.out.println(map.timesRepeatedValue(20));


            //----------- AUX METHOD: repeatedValues?
            System.out.println("Are there any repeated values? " + map.repeatedValues());


        } catch (ExistingKeyException | NonExistentValueException | RemoveItemWithNonExistentKeyException |
                 ItemRepeatedThreeTimesException e) {
            System.out.println(e.getMessage());
        }

        HashMap<Integer, Player> h = map.getFirstMap();
        System.out.println("values of the first map: ");
        for (Integer i : h.keySet()) {
            System.out.print(h.get(i) + " ");
        }

        HashMap<Integer, Game> h2 = map.getSecondMap();
        System.out.println("\nvalues of the second map: ");
        for (Integer i : h2.keySet()) {
            System.out.print(h2.get(i) + " ");
        }
    }

}
