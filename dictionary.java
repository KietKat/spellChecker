import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class dictionary{
    public SeparateChainingHashST<String, Integer> dictionary = new SeparateChainingHashST<>();

    //hash words into a hashing dictionary
    public void createDictionary(File file) throws FileNotFoundException
    {
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine())
        {
            String temp = scan.nextLine();
            dictionary.put(temp, 1);
        }
        scan.close();
    }

    //If find the word code, then run through the linked-list at that index
    public boolean check(String word) throws FileNotFoundException
    {
        if (dictionary.get(word) == null) return false;
        return true;
    }

    public class SequentialSearchST<Key, Value> 
    {
        private Node first; // first node in the linked list
        private class Node
        {   // linked-list node
            Key key;
            Value val;
            Node next;
            public Node(Key key, Value val, Node next)
            {
                this.key = key;
                this.val = val;
                this.next = next;
            }
        }

        public Value get(Key key)
        { // Search for key, return associated value.
            for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key)) return x.val; // search hit
            return null; // search miss
        }
        public void put(Key key, Value val)
        { // Search for key. Update value if found; grow table if new.
            for (Node x = first; x != null; x = x.next)
                if (key.equals(x.key)) { x.val = val; return; } // Search hit: update val.
            first = new Node(key, val, first); // Search miss: add new node.
        } 
    }
    public class SeparateChainingHashST<Key, Value> 
    {
        private int N; // number of key-value pairs
        private int M; // hash table size
        private SequentialSearchST<Key, Value>[] st; // array of ST objects
        public SeparateChainingHashST() { this(997); }
        public SeparateChainingHashST(int M)
        { // Create M linked lists.
            this.M = M;
            st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
            for (int i = 0; i < M; i++) st[i] = new SequentialSearchST();
        }
        public int code (Key key) { return key.hashCode(); }
        private int hash(Key key) {  return (key.hashCode() & 0x7fffffff) % M; }

        public Value get(Key key) { return (Value) st[hash(key)].get(key); }
        public void put(Key key, Value val) { st[hash(key)].put(key, val); } 

    }



}
