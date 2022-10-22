import customExceptions.*;

import java.util.HashMap;

public class EpicDoubleHashMap<K extends Number, V, T> {
    HashMap<K, V> firstMap;
    HashMap<K, T> secondMap;

    public EpicDoubleHashMap() {
        firstMap = new HashMap<>();
        secondMap = new HashMap<>();
    }

    //--------------ADD ITEM
    public void addFirstType(K key, V value) throws ExistingKeyException, ItemRepeatedThreeTimesException {
        if (firstMap.containsKey(key) || secondMap.containsKey(key)) {
            throw new ExistingKeyException("The value " + value + " couldn't be added because the key " + key + " already has a value assigned to it.");
        }

        firstMapItemRepeatedThreeTimes(key, value);
        firstMap.put(key, value);
    }

    public void addSecondType(K key, T value) throws ExistingKeyException, ItemRepeatedThreeTimesException {
        if (secondMap.containsKey(key) || firstMap.containsKey(key)) {
            throw new ExistingKeyException("The value " + value + " couldn't be added because the key " + key + " already has a value assigned to it.");
        }
        secondMapItemRepeatedThreeTimes(key, value);
        secondMap.put(key, value);
    }

    public void addTwoTypes(K key, V value1, T value2) throws ExistingKeyException, ItemRepeatedThreeTimesException {
        if (firstMap.containsKey(key) || secondMap.containsKey(key)) {
            throw new ExistingKeyException("The values " + value1 + " and " + value2 + " couldn't be added because the key " + key + " already has a value assigned to it.");
        }
        twoMapsItemRepeatedThreeTimes(key, value1, value2);
        firstMap.put(key, value1);
        secondMap.put(key, value2);
    }


    //--------------GET ITEM
    public V getFirstType(K key) throws NonExistentValueException {
        if (firstMap.get(key) == null) {
            throw new NonExistentValueException("The value associated to the key " + key + " couldn't be got because it doesn't exist.");
        }
        return firstMap.get(key);
    }

    public T getSecondType(K key) throws NonExistentValueException {
        if (secondMap.get(key) == null) {
            throw new NonExistentValueException("The value associated to the key " + key + " couldn't be got because it doesn't exist.");
        }
        return secondMap.get(key);
    }


    //-----------REMOVE ITEM
    public void removeFirstType(K key) throws RemoveItemWithNonExistentKeyException {
        if (!firstMap.containsKey(key)) {
            throw new RemoveItemWithNonExistentKeyException("The item couldn't be removed because the key " + key + " doesn't exist.");
        }
        firstMap.remove(key);
    }

    public void removeSecondType(K key) throws RemoveItemWithNonExistentKeyException {
        if (!secondMap.containsKey(key)) {
            throw new RemoveItemWithNonExistentKeyException("The item couldn't be removed because the key " + key + " doesn't exist.");
        }
        secondMap.remove(key);
    }

    public void removeTwoTypes(K key) throws RemoveItemWithNonExistentKeyException {
        if (!firstMap.containsKey(key) || !secondMap.containsKey(key)) {
            throw new RemoveItemWithNonExistentKeyException("The item couldn't be removed because the key " + key + " doesn't exist.");
        }
        firstMap.remove(key);
        secondMap.remove(key);
    }

    public HashMap<K, V> getFirstMap() {
        return this.firstMap;
    }

    public HashMap<K, T> getSecondMap() {
        return this.secondMap;
    }


    //-----------ItemRepeatedThreeTimes
    public void firstMapItemRepeatedThreeTimes(K key1, V value) throws ItemRepeatedThreeTimesException {
        int valueRepeated = 0;
        for (K key : firstMap.keySet()) {
            if (firstMap.get(key).equals(value) && !secondMap.containsKey(key)) {
                valueRepeated++;
            }
        }
        if (valueRepeated >= 2) {
            throw new ItemRepeatedThreeTimesException("The item with key: " + key1 + " and value: " + value + " can't be added a third time.");
        }
    }

    public void secondMapItemRepeatedThreeTimes(K key1, T value) throws ItemRepeatedThreeTimesException {
        int valueRepeated = 0;
        for (K key : secondMap.keySet()) {
            if (secondMap.get(key).equals(value) && !firstMap.containsKey(key)) {
                valueRepeated++;
            }
        }
        if (valueRepeated >= 2) {
            throw new ItemRepeatedThreeTimesException("The item with key: " + key1 + " and value: " + value + " can't be added a third time.");
        }
    }

    public void twoMapsItemRepeatedThreeTimes(K key1, V value1, T value2) throws ItemRepeatedThreeTimesException {
        int firstTypeValueRepeated = 0;
        int secondTypeValueRepeated = 0;
        for (K key : firstMap.keySet()) {
            if (firstMap.get(key).equals(value1) && secondMap.containsKey(key)) {
                firstTypeValueRepeated++;
            }
        }
        for (K key : secondMap.keySet()) {
            if (secondMap.get(key).equals(value2) && firstMap.containsKey(key)) {
                secondTypeValueRepeated++;
            }
        }
        if (firstTypeValueRepeated >= 2 && secondTypeValueRepeated >= 2) {
            throw new ItemRepeatedThreeTimesException("The item with key: " + key1 + " and values: " + value1 + ", " + value2 + " can't be added a third time.");
        }
    }

    //-----------AUX METHODS
    public String mapWithMoreValues() {
        if (firstMap.size() > secondMap.size()) {
            return "First Map has more values than second map.";
        } else if (firstMap.size() < secondMap.size()) {
            return "Second Map has more values than first map.";
        } else {
            return "Both maps has the same size";
        }
    }

    public String timesRepeatedValue(K key1) {
        int valueVRepeated = 0;
        int valueTRepeated = 0;
        V valueV = firstMap.get(key1);
        T valueT = secondMap.get(key1);
        for (K key : firstMap.keySet()) {
            if (firstMap.get(key).equals(valueV)) {
                valueVRepeated++;
            }
        }
        for (K key : secondMap.keySet()) {
            if (secondMap.get(key).equals(valueT)) {
                valueTRepeated++;
            }
        }
        return "The associated value to the key " + key1 + " is repeated " + (valueVRepeated + valueTRepeated - 1) + " times";
    }
}
