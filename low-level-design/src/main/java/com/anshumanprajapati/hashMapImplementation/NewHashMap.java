package com.anshumanprajapati.hashMapImplementation;


public class NewHashMap<K, V> {
	
	public final int INITIAL_SIZE = 16; // 16
	
	Entry[] hashTable;
	
	
	NewHashMap(){

        hashTable= new Entry[INITIAL_SIZE];
    }
	
	
	
	class Entry<K, V>{
		K key;
		V value;
		Entry next;
		
		Entry(K k, V v){
			this.key = k;
			this.value=v;
		}
		
		K getKey =  this.key;
		
		void setKey(K k) { this.key =k; }
		
		V getValue(){
			return this.value;
		}
		
		void setValue(V v) { this.value=v; }
	}
	
	
	
	public void put(K key, V value) {
		
		int hashCode = key.hashCode() % hashTable.length;
		Entry node = hashTable[hashCode];
		
		if(node == null) {

            Entry newNode = new Entry(key, value);
            hashTable[hashCode] = newNode;
        }else {
        	Entry previousNode = node;
        	
        	while (node != null) {

                if (node.key == key) {
                    node.value = value;
                    return;
                }
                previousNode = node;
                node = node.next;
            }
            previousNode.next =  new Entry(key,value);
        	
        }
		
	}
	
	public V get(K key) {
		int hashCode = key.hashCode() % hashTable.length;
		Entry node = hashTable[hashCode];
		
		while(node != null) {
			if(node.key==key) {
				return (V)node.value;
			}
			node=node.next;
		}
		return null;
	}
	
	
	 public static void main(String args[]) {

	        NewHashMap<Integer, String> map = new NewHashMap<>();
	        map.put(1, "hi");
	        map.put(2, "my");
	        map.put(3, "name");
	        map.put(4, "is");
	        map.put(5, "Shrayansh");
	        map.put(6, "how");
	        map.put(7, "are");
	        map.put(8, "you");
		    map.put(8, "newyou");
	        map.put(9, "friends");
	        map.put(10, "?");

	        String value = map.get(8);
	        System.out.println(value);


	    }
}

