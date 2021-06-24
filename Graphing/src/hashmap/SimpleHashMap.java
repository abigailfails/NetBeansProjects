package hashmap;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Custom implementation of {@link Map} using a simple hash function of {@code key.hashCode() % size}, permitting null values.
 * <p>Collision-prone and should only be used for small maps.</p>
 *
 * @param <K> the type of key to store
 * @param <V> the type of value to store
 */
public class SimpleHashMap<K, V> implements Map<K, V>, Cloneable {
    private SimpleHashMap.Entry<K, V>[] entries;
    private final float loadFactor;
    private int count = 0;

    /**
     * Creates an empty map with a load factor of 0.75.
     * */
    public SimpleHashMap() {
        this(0);
    }

    /**
     * Creates a map with a specific initial capacity, which helps avoid time-intensive rehashing operations. Has a load
     * factor of 0.75.
     *
     * @param capacity the initial capacity of the map
     * */
    public SimpleHashMap(int capacity) {
        this(capacity, 0.75f);
    }

    /**
     * Creates a map with a specific initial capacity, which helps avoid time-intensive rehashing operations. Load factor
     * determined by {@code loadFactor}
     *
     * @param capacity the initial capacity of the map
     * @param loadFactor the load factor the map has to reach before resizing
     * */
    @SuppressWarnings("unchecked")
    public SimpleHashMap(int capacity, float loadFactor) {
        if (loadFactor <= 0 || loadFactor > 1)
            throw new IllegalArgumentException("Load factor must be between 0 (exclusive) and 1 (inclusive)");
        this.entries = (Entry<K, V>[]) Array.newInstance(Entry.class, capacity); //fml
        this.loadFactor = loadFactor;
    }

    /**
     * Private method to get the hash of a key, always returning the same hash for the same key. Not collision-safe.
     *
     * @param key the {@code int} key to get a hash for
     * @return the hash of {@code key}
     * */
    private int hash(Object key) {
        return key.hashCode() % this.entries.length;
    }

    /**
     * Private method to change the map's size
     *
     * @param newSize the new size of the map
     * */
    @SuppressWarnings("unchecked")
    private void rehash(int newSize) {
        Entry<K, V>[] oldEntries = this.entries.clone();
        entries = (Entry<K, V>[]) Array.newInstance(Entry.class, newSize);
        for (Entry<K, V> entry : oldEntries) {
            if (entry != null && entry.key.getClass() != Object.class) {
                int index = findIndex(entry.key, true);
                if (index > -1)
                    this.entries[index] =entry;
                else throw new IllegalStateException("Unable to grow map, something is very wrong.");
            }
        }
    }

    /**
     * Finds an index for a key. This either finds the position of the key if it already exists, or locates
     * an empty position to place the key at if {@code lookForEmpty} is true. If {@code lookForEmpty} is false and no
     * matching key is found, it returns -1.
     *
     * <p>On collision this method iterates through the map, looking for a key matching {@code key}, or an empty key </p>
     *
     * @param key the key to find the index for
     * @param lookForEmpty whether empty positions should be count as 'found'
     *
     * @return the index of {@code key} or an empty space, or -1 if no key exists and {@code lookForEmpty} is false
     * */
    private int findIndex(Object key, boolean lookForEmpty) {
        int start = hash(key);
        for (int i = start; i != start-1; i = (i + 1) % this.entries.length) {
            if (i == start) start++; //Ugly way of making it only check the start the first time
            Object currentKey = entries[i] == null ? null : entries[i].key;
            boolean spaceFree = currentKey == null || (lookForEmpty && currentKey.getClass() == Object.class);
            boolean keyMatches = Objects.equals(currentKey, key);
            if (keyMatches || spaceFree) {
                if (keyMatches || lookForEmpty)
                    return i;
                break;
            }
        }
        return -1;
    }

    /**
     * Attempts to add a new key-value pair to the map, or change the value of a pre-existing mapping.
     *
     * @param key the {@code int} key to add
     * @param value {@link V} the value to add
     *
     * @return the previous value stored with {@code key}, or {@code null} if none existed
     * */
    @Override
    public V put(K key, V value) {
        if ((this.entries.length)-(this.size()+1) < entries.length - ((int) (entries.length * loadFactor)))
            this.rehash(this.entries.length + 1);
        V previousValue = this.get(key);
        int index = findIndex(key, true);
        if (index > -1)
            entries[index] = new Entry<>(key, value);
        else throw new IllegalStateException("Map is full and cannot accept a new key-value pair, which should not be happening");
        count++;
        return previousValue;
    }

    /**
     * Attempts to find the value stored for a key
     *
     * @param key the {@code int} key to search for
     *
     * @return the {@link V} value corresponding to {@code key}, or {@code null} if none exists
     * */
    @Override
    public V get(Object key) throws IllegalArgumentException {
        int index = findIndex(key, false);
        return (index > -1) ? entries[index].value : null;
    }

    /**
     * Attempts to remove a key-value pair from the map given a key to remove
     *
     * @param key the {@code int} key to remove
     *
     * @return the value that was removed, or {@code null} if no key matching {@code key} existed
     * */
    @Override
    public V remove(Object key) throws IllegalArgumentException {
        int index = findIndex(key, false);
        if (index > -1) {
            Entry<K, V> entry = entries[index];
            V value = entry.getValue();
            entry.key = new Object();
            if ((this.entries.length) - (this.size() + 1) > entries.length - ((int) (entries.length * loadFactor)))
                this.rehash(this.entries.length - 1);
            this.count--;
            return value;
        }
        return null;
    }

    /**
     * Puts all of the mappings in another map into this map
     *
     * @param map the map to pull mappings from
     *
     * @see SimpleHashMap#put(K, V)
     * */
    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }

    /**
     * Removes all the mappings from the map.
     * */
    @Override
    public void clear() {
        Arrays.fill(this.entries, null);
        this.count = 0;
    }

    /**
     * Creates a set of all the keys in the map.
     *
     * @return a set of the map's keys
     * */
    @Override
    public Set<K> keySet() {
        HashSet<K> set = new HashSet<>();
        for (Entry<K, V> entry : this.entries) {
            if (entry != null && entry.key.getClass() != Object.class)
                set.add(entry.getKey());
        }
        return set;
    }

    /**
     * Creates a collection of all the values for the map's keys.
     *
     * @return a collections of the map's values
     * */
    @Override
    public Collection<V> values() {
        Collection<V> collection = new ArrayList<>();
        for (Entry<K, V> entry : this.entries) {
            if (entry != null && entry.key.getClass() != Object.class)
                collection.add(entry.getValue());
        }
        return collection;
    }

    /**
     * Creates a set of the map's {@link Map.Entry} instances, containing both their keys and their values.
     *
     * @return a set of the map's entries
     * */
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        HashSet<Map.Entry<K, V>> set = new HashSet<>();
        for (Entry<K, V> entry : this.entries) {
            if (entry != null && entry.key.getClass() != Object.class)
                set.add(entry);
        }
        return set;
    }

    /**
     * Returns how many key-value pairs are in the map, not including empty spaces in the internal array
     *
     * @return the number of items in the map
     * */
    @Override
    public int size() {
       return count;
    }

    /**
     * Returns whether the list has no saved key-value pairs
     *
     * @return true if there are no items in the map, false if there is one or more
     * */
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Returns whether the map contains a key-value pair matching {@code key}
     *
     * @param key the key to search for
     * @return whether the list contains {@code key}
     * */
    @Override
    public boolean containsKey(Object key) {
        return findIndex(key, false) > -1;

    }

    /**
     * Returns whether the map contains one or more keys that map to {@code value}
     *
     * @param value the value to search for
     * @return whether the list contains {@code value}
     * */
    @Override
    public boolean containsValue(Object value) {
        for (Entry<K, V> entry : this.entries) {
            if (entry != null && entry.getValue().equals(value)) return true;
        }
        return false;
    }

    /**
     * Implementation of {@link Map.Entry} that allows keys that aren't instances of {@code V} in order to indicate that
     * a key was deleted so that search operations still work.
     * */
    static class Entry<K, V> implements Map.Entry<K, V> {
        protected Object key; //Object so it can hold deletion markers
        protected V value;

        /**
         * Creates a new {@link Entry} with a specified key and value
         *
         * @param key the key to store
         * @param value the value to store
         * */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Returns the stored key, or throws an exception if it's been deleted.
         *
         * @return the key that was stored
         * @throws IllegalStateException if the stored key isn't an instance of {@link K}
         * */
        @SuppressWarnings("unchecked")
        @Override
        public K getKey() {
            if (this.key.getClass() == Object.class)
                throw new IllegalStateException("Entry does not store a key as it was removed");
            return (K) this.key;
        }

        /**
         * Returns the stored value.
         *
         * @return the value that was stored
         * */
        @Override
        public V getValue() {
            return this.value;
        }

        /**
         * Changes the stored value for the entry.
         *
         * @return the previously-stored value
         * */
        @Override
        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }

        @SuppressWarnings("rawtypes")
        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o instanceof Entry) {
                Entry entry = (Entry) o;
                return this.key.equals(entry.key) && this.value.equals(entry.value);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
        }
    }

    //Might collide too much
    @Override
    public int hashCode() {
        int code = 0;
        for (Entry<K, V> entry : this.entries) {
            code ^= entry == null ? 0 : entry.hashCode();
        }
        return code;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o instanceof SimpleHashMap) {
            SimpleHashMap map = (SimpleHashMap) o;
            return map.size() == this.size() && this.entrySet().containsAll(map.entrySet());
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected SimpleHashMap<K,V> clone() throws CloneNotSupportedException {
        return (SimpleHashMap<K, V>) super.clone();
    }
}
