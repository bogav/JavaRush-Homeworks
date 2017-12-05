package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable{
    Entry<String> root = new Entry<String>("0");

    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
        System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }

    @Override
    public String get(int index)throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }
    public String set(int index, String element)throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }
    public void add(int index, String element)throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }
    public String remove(int index)throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }
    public List<String> subList(int fromIndex, int toIndex)throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }
    protected void removeRange(int fromIndex, int toIndex)throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }
    public boolean addAll(int index, Collection c)throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    public static class Entry<String> implements Serializable{
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<String> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public void checkChildren() {
            if (leftChild != null) this.availableToAddLeftChildren = false;
            if (rightChild != null) this.availableToAddRightChildren = false;
        }

        public boolean isAvailableToAddChildren() {
            return (this.availableToAddLeftChildren || this.availableToAddRightChildren);
        }

    }

    @Override
    public boolean add(String s) {
/*        if (s == null)
            return false;
*/
        Entry<String> rootElement;
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Entry<String> currentNode = queue.poll();
            currentNode.checkChildren();
            if (currentNode.isAvailableToAddChildren()) {
                if (currentNode.availableToAddLeftChildren){
                    currentNode.leftChild = new Entry<>(s);
                    currentNode.leftChild.parent = currentNode;
                    return true;
                } else if (currentNode.availableToAddRightChildren) {
                    currentNode.rightChild = new Entry<>(s);
                    currentNode.rightChild.parent = currentNode;
                    return true;
                }
            } else {
                if (currentNode.leftChild != null){
                    queue.offer(currentNode.leftChild);
                }
                if (currentNode.rightChild != null){
                    queue.offer(currentNode.rightChild);
                }
            }
                /*
Тут было решение, если вкратце, то нужно брать элемент из очереди, проверять его потомков,
и если какого-то нет, то ставить на его место новый элемент. Если все потомки есть, то добавлять их в очередь и делать тоже самое с ними
*/
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null)
            return false;
        String s = (String) o;
    /*        if (s.equals(root.elementName)) {
                root = null;
                return true;
            }*/
        Entry<String> rootElement;
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Entry<String> currentNode = queue.poll();
            if (currentNode.leftChild != null) {
                if (currentNode.leftChild.elementName.equals(s)){
                    currentNode.leftChild = null;
                    return true;
                }
                queue.offer(currentNode.leftChild);
            }
            if (currentNode.rightChild != null) {
                if (currentNode.rightChild.elementName.equals(s)){
                    currentNode.rightChild = null;
                    return true;
                }
                queue.offer(currentNode.rightChild);
            }
/*
Удаление элемента похоже на добавление, надо проверять потомков у текущего элемента из очереди и обнулять потомска с искомым именем
*/
        }
        return false;
    }

    public String getParent(String s) {
        if (root == null || s == null)
            return null;
        if (s.equals(root.elementName))
            return null;
        Entry<String> rootElement;
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Entry<String> currentNode = queue.poll();
            if (currentNode.elementName.equals(s)){
                return currentNode.parent.elementName;
            } else {
                if (currentNode.leftChild != null) {
                    queue.offer(currentNode.leftChild);
                }
                if (currentNode.rightChild != null) {
                    queue.offer(currentNode.rightChild);
                }
            }
//тоже берём первый элемент с очереди, если это искомый элемент, то возвращаем имя его родителя,
//иначе проверяем его детей, и если они есть, то добавляем их в очередь. И всё по новой
        }
        return null;
    }

    @Override
    public int size() {
        Entry<String> rootElement;
        Queue<Entry<String>> queue = new LinkedList<>();
        if (root.leftChild != null) queue.offer(root.leftChild);
        if (root.leftChild != null) queue.offer(root.rightChild);
        int count = 0;
        while (!queue.isEmpty()) {
            Entry<String> currentNode = queue.poll();
            count++;
            if (currentNode.leftChild != null) {
                queue.offer(currentNode.leftChild);
            }
            if (currentNode.rightChild != null) {
                queue.offer(currentNode.rightChild);
            }
//берём элемент из очереди, считаем его, потом добавляем в очередь существующих потомков, и всё по новой
        }
        return count;
    }


}
