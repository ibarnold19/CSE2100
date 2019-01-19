
public interface AdaptablePriorityQueue<K,V> {
	
	public void remove(Entry<K,V> entry);
	public void replaceKey(Entry<K,V> entry, K key);
	public void replaceValue(Entry<K,V> entry, V value);
	
}
