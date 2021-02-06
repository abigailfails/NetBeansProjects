/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashing;

/**
 * @author dw
 */
public interface IIntHashTable<V> {
    void add(int key, V value);
    void delete(int key);
    V item(int key);
    boolean contains(int key);
    int length();
    boolean isEmpty();
    boolean isFull();
}
