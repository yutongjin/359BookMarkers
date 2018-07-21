package NewSoftValley.ood;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author : Yutong Jin
 * @date : 7/19/18
 * @Description :
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache( 2 /* capacity  );
        *
        *cache.put(1,1);
        *cache.put(2,2);
        *cache.get(1);       // returns 1
        *cache.put(3,3);    // evicts key 2
        *cache.get(2);       // returns -1 (not found)
        *cache.put(4,4);    // evicts key 1
        *cache.get(1);       // returns -1 (not found)
        *cache.get(3);       // returns 3
        *cache.get(4);       // returns 4
        */

public class _146_LRUCache {
    LinkedHashMap<Integer,Integer> lhm = new LinkedHashMap<>();;
    int _capacity;
    public _146_LRUCache(int capacity) {
        _capacity = capacity;
    }

    public int get(int key) {
        if(lhm.containsKey(key)){
            int tmp = lhm.get(key);
            lhm.remove(key);
            lhm.put(key,tmp);
            return lhm.get(key);
        }
        else return -1;
    }

    public void put(int key, int value) {
        if(lhm.containsKey(key)){
            lhm.remove(key);
        }
        else if(lhm.size() == _capacity){
            Iterator<Map.Entry<Integer,Integer>> iter = lhm.entrySet().iterator();
            iter.next();
            iter.remove();

        }

        lhm.put(key,value);
    }
}
