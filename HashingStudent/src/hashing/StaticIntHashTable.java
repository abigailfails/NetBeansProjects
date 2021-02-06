package hashing;

import java.util.Objects;

/**
 * Static implementation of {@link IIntHashTable} using a simple hash function of {@code key % size}.
 * <p>Collision-prone and should only be used for small lists.</p>
 *
 * @author dw
 */
public class StaticIntHashTable<V> implements IIntHashTable<V> {
    private static final String ALREADY_CONTAINS_ERROR = "Map already contains key ";
    private static final String DOES_NOT_CONTAIN_ERROR = "Map does not contain key ";
    private static final String MAP_IS_FULL_ERROR      = "Map is full and cannot accept ";

    public final int MAX_SIZE;
    private final Object[] keys; //Object so it can hold deletion markers
    private final V[] values;
    private int count = 0;

    @SuppressWarnings("unchecked")
    public StaticIntHashTable(int maxSize) {
        MAX_SIZE = maxSize;
        keys = new Object[maxSize];
        values = (V[]) new Object[maxSize];
    }

    /**
     * Private method to get the hash of a key, always returning the same hash for the same key. Not collision-safe.
     *
     * @param key the {@code int} key to get a hash for
     * @return the hash of {@code key}
     * */
    private int hash(int key) {
        return key % MAX_SIZE;
    }

    /**
     * Finds an index for a {@code int} key. This either finds the position of the key if it already exists, or locates
     * an empty position to place the key depending on {@code shouldAlreadyContain}.
     * <p>On collision this method iterates through the map, looking for a key matching {@code key}, or an empty key </p>
     *
     * @param key the {@code int} key to find
     * @param shouldAlreadyContain whether it should be looking for a previously stored value, or for a new location to store.
     *
     * @return the index of {@code key}
     * @throws IllegalArgumentException if {@code shouldAlreadyContain} and the list doesn't contain the key,
     * or if {@code !shouldAlreadyContain} and the list already contains the key.
     * @throws UnsupportedOperationException if trying to find a position to add and the list is full
     * */
    private int findIndex(int key, boolean shouldAlreadyContain) throws IllegalArgumentException, UnsupportedOperationException {
        int start = hash(key);
        for (int i = start; i != start-1; i = (i + 1) % MAX_SIZE) {
            if (i == start) start++; //Ugly way of making it only check the start the first time
            Object currentKey = keys[i];
            boolean spaceFree = currentKey == null || (!shouldAlreadyContain && currentKey.getClass() == Object.class);
            boolean keyMatches = Objects.equals(currentKey, key);
            if (keyMatches || spaceFree) {
                if (shouldAlreadyContain != spaceFree)
                    return i;
                throw new IllegalArgumentException(shouldAlreadyContain ? DOES_NOT_CONTAIN_ERROR : ALREADY_CONTAINS_ERROR + key + ".");
            }
        }
        throw shouldAlreadyContain ? new IllegalArgumentException(DOES_NOT_CONTAIN_ERROR + key + ".") : new UnsupportedOperationException(MAP_IS_FULL_ERROR + key + ".");
    }

    /**
     * Puts all the values in the map into an array, using {@code null} for positions with no values.
     *
     * @return the array of values in the map
     * */
    public V[] asArray() {
        return values.clone();
    }

    /**
     * Attempts to add a new key-value pair to the map.
     *
     * @param key the {@code int} key to add
     * @param value {@link V} the value to add
     *
     * @throws IllegalArgumentException if the list already contains {@code key}
     * @throws UnsupportedOperationException if the list is full
     * */
    @Override
    public void add(int key, V value) throws IllegalArgumentException, UnsupportedOperationException {
        int index = findIndex(key, false);
        keys[index] = key;
        values[index] = value;
        count++;
    }

    /**
     * Attempts to find the value for an {@code int} key
     *
     * @param key the {@code int} key to search for
     *
     * @return the {@link V} value corresponding to {@code key}
     * @throws IllegalArgumentException if the list doesn't contain {@code key}
     * */
    @Override
    public V item(int key) throws IllegalArgumentException {
        return values[findIndex(key, true)];
    }

    /**
     * Attempts to remove a key-value pair from the map given an {@code int} key to remove
     *
     * @param key the {@code int} key to delete
     *
     * @throws IllegalArgumentException if the list doesn't contain {@code key}
     * */
    @Override
    public void delete(int key) throws IllegalArgumentException {
        int index = findIndex(key, true);
        keys[index] = new Object();
        values[index] = null;
        count--;
    }

    /**
     * Returns whether the map contains a key-value pair matching {@code key}
     *
     * @param key the {@code int} key to search for
     * @return whether the list contains {@code key}
     * */
    @Override
    public boolean contains(int key) {
        try {
            findIndex(key, true);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    /**
     * Returns how many key-value pairs are in the map, not including empty values
     *
     * @return the number of items in the map
     * */
    @Override
    public int length() {
       return count;
    }

    /**
     * Returns whether the list has no saved key-value pairs
     *
     * @return true if there are no items in the map, false if there is one or more
     * */
    @Override
    public boolean isEmpty() {
        return this.length() == 0;
    }

    /**
     * Returns whether the list is full (has no empty values and nothing more can be added)
     *
     * @return true if there are no null positions in the map, false if there is one or more
     * */
    @Override
    public boolean isFull() {
        return this.length() == this.MAX_SIZE;
    }
}
