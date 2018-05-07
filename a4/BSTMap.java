import java.util.*;

public class BSTMap < K extends Comparable < K > , V > implements Map < K, V > {
    BinarySearchTree < K,
    V > tree;

    public BSTMap() {
        tree = new BinarySearchTree < K, V > ();
    }

    public boolean containsKey(K key) {
        try {
            tree.find(key);
            return true;
        } catch (KeyNotFoundException e) {
            return false;
        }
    }

    public V get(K key) throws KeyNotFoundException {
        return tree.find(key);
    }

    public List < Entry < K,V > > entryList() {
        return entryList();
    }

    public void put(K key, V value) {
        if (containsKey(key)) {
            tree.insert(key, value);
        } else {
            tree.insert(key, value);
                  }
    }

    public int size() {
        return tree.size();
    }
    public void clear() {
        tree.clear();
    }

    public int getGetLoopCount() {
        return tree.getFindLoopCount();
    }

    public int getPutLoopCount() {
        return tree.getInsertLoopCount();
    }

    public void resetGetLoops() {
        tree.findLoops = 0;
    }
    public void resetPutLoops() {
        tree.insertLoops = 0;
    }
}
