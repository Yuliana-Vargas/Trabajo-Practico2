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

    public void removeFirstType(K key){
        FirstMap.remove(key);
    }

    public void removeSecondType(K key){
        SecondMap.remove(key);
    }

    public void removeTwoTypes(K key){
        FirstMap.remove(key);
        SecondMap.remove(key);
    }

    public HashMap<K, V> getFirstMap() {
        return this.FirstMap;
    }

    public HashMap<K, T> getSecondMap() {
        return this.SecondMap;
    }

    public String mapWithMoreValues(){
        if (FirstMap.size() > SecondMap.size()){
            return "First Map has more values than second map.";
        }
        else if (FirstMap.size() < SecondMap.size()){
            return "Second Map has more values than first map.";
        }
        else{
            return "Both maps has the same size";
        }
    }
}
