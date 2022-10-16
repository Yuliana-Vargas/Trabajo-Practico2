import java.util.HashMap;

public class EpicDoubleHashMap<K extends Number, V, T> {
    HashMap<K, V> FirstMap;
    HashMap<K, T> SecondMap;

    public EpicDoubleHashMap() {
        FirstMap = new HashMap<>();
        SecondMap = new HashMap<>();
    }

    public void addFirstType(K key, V value) {
        FirstMap.put(key, value);
    }

    public void addSecondType(K key, T value) {
        SecondMap.put(key, value);
    }

    public void addTwoTypes(K key, V value1, T value2) {
        FirstMap.put(key, value1);
        SecondMap.put(key, value2);
    }

    public HashMap<K, V> getFirstMap() {
        return this.FirstMap;
    }

    public HashMap<K, T> getSecondMap() {
        return this.SecondMap;
    }
}
