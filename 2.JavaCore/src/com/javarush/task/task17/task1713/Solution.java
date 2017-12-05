package com.javarush.task.task17.task1713;

import java.util.*;
import java.util.function.UnaryOperator;

/* 
Общий список
*/

public class Solution implements List<Long>{
    private ArrayList<Long> original = new ArrayList<Long>();

    @Override
    public synchronized Spliterator spliterator() {
        return original.spliterator();
    }

    @Override
    public synchronized void add(int i, Long o) {
        original.add(i, o);
    }

    @Override
    public synchronized Long remove(int i) {
        return original.remove(i);
    }

    @Override
    public synchronized int lastIndexOf(Object o) {
        return original.lastIndexOf(o);
    }

    @Override
    public synchronized boolean remove(Object o) {
        return original.remove(o);
    }

    @Override
    public synchronized boolean containsAll(Collection collection) {
        return original.containsAll(collection);
    }

    @Override
    public synchronized int indexOf(Object o) {
        return original.indexOf(o);
    }

    public synchronized void trimToSize() {
        original.trimToSize();
    }

    public synchronized void ensureCapacity(int i) {
        original.ensureCapacity(i);
    }

    @Override
    public synchronized <T> T[] toArray(T[] ts) {
        return original.toArray(ts);
    }

    @Override
    public synchronized boolean addAll(Collection<? extends Long> collection) {
        return original.addAll(collection);
    }

    @Override
    public synchronized boolean addAll(int i, Collection<? extends Long> collection) {
        return original.addAll(i, collection);
    }

    @Override
    public synchronized boolean removeAll(Collection<?> collection) {
        return original.removeAll(collection);
    }

    @Override
    public synchronized boolean retainAll(Collection<?> collection) {
        return original.retainAll(collection);
    }

    @Override
    public synchronized void replaceAll(UnaryOperator<Long> unaryOperator) {
        original.replaceAll(unaryOperator);
    }

    @Override
    public synchronized void sort(Comparator<? super Long> comparator) {
        original.sort(comparator);
    }

    @Override
    public synchronized boolean isEmpty() {
        return original.isEmpty();
    }

    @Override
    public synchronized List subList(int i, int i1) {
        return original.subList(i, i1);
    }

    @Override
    public synchronized ListIterator listIterator(int i) {
        return original.listIterator(i);
    }

    @Override
    public synchronized int size() {
        return original.size();
    }

    @Override
    public synchronized boolean contains(Object o) {
        return original.contains(o);
    }

    @Override
    public synchronized void clear() {
        original.clear();
    }

    @Override
    public synchronized Long set(int i, Long o) {
        return original.set(i, o );
    }

    @Override
    public synchronized boolean add(Long o) {
        return original.add(o);
    }

    @Override
    public synchronized Iterator iterator() {
        return original.iterator();
    }

    @Override
    public synchronized ListIterator listIterator(){
        return original.listIterator();
    }

    @Override
    public synchronized Object[] toArray () {
        return original.toArray();
    }

    @Override
    public synchronized Long get(int i) {
        return original.get(i);
    }

    public static void main(String[] args) {

    }
}
