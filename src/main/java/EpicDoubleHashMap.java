import customExceptions.ExistingKeyException;
import customExceptions.NonExistentValueException;
import customExceptions.RemoveItemWithNonExistentKeyException;

import java.util.HashMap;

public class EpicDoubleHashMap<K extends Number, V, T> {
    HashMap<K, V> firstMap;
    HashMap<K, T> secondMap;

    public EpicDoubleHashMap() {
        firstMap = new HashMap<>();
        secondMap = new HashMap<>();
    }

    //--------------ADD ITEM
    public void addFirstType(K key, V value) throws ExistingKeyException {
        if (firstMap.containsKey(key) || secondMap.containsKey(key)) {
            throw new ExistingKeyException("The value " + value +" couldn't be added because the key " + key + " already has a value assigned to it.");
        }
        firstMap.put(key, value);
    }
    public void addSecondType(K key, T value) throws ExistingKeyException {
        if (secondMap.containsKey(key) || firstMap.containsKey(key)) {
            throw new ExistingKeyException("The value " + value +" couldn't be added because the key " + key + " already has a value assigned to it.");
        }
        secondMap.put(key, value);
    }
    public void addTwoTypes(K key, V value1, T value2) throws ExistingKeyException{
        if (firstMap.containsKey(key) || secondMap.containsKey(key)) {
            throw new ExistingKeyException("The values " + value1 +" and "+ value2 +" couldn't be added because the key " + key + " already has a value assigned to it.");
        }
        firstMap.put(key, value1);
        secondMap.put(key, value2);
    }


    //--------------GET ITEM
    public V getFirstType(K key) throws NonExistentValueException {
        if (firstMap.get(key) == null) {
            throw new NonExistentValueException("The value associated to the key " + key +" couldn't be get because it doesn't exist.");
        }
        return firstMap.get(key);
    }
    public T getSecondType(K key) throws NonExistentValueException {
        if (secondMap.get(key) == null) {
            throw new NonExistentValueException("The value associated to the key " + key +" couldn't be get because it doesn't exist.");
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

    public String mapWithMoreValues() {
        if (firstMap.size() > secondMap.size()) {
            return "First Map has more values than second map.";
        } else if (firstMap.size() < secondMap.size()) {
            return "Second Map has more values than first map.";
        } else {
            return "Both maps has the same size";
        }
    }
    public String timesRepeatedValue(K key1){
        int valueVRepeated = 0;
        int valueTRepeated = 0;
        V valueV = firstMap.get(key1);
        T valueT = secondMap.get(key1);
        for( K key: firstMap.keySet()){
            if (firstMap.get(key).equals(valueV)) {
                valueVRepeated++;
            }
        }
        for( K key: secondMap.keySet()){
            if (secondMap.get(key).equals(valueT)) {
                valueTRepeated++;
            }
        }
        return "The associated value to the key " + key1 + " is repeated "+ (valueVRepeated+valueTRepeated-1) + " times";
    }
}
