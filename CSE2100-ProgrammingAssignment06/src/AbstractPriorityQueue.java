import java.util.Comparator;

public class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V>{
	
	protected static class PQEntry<K,V> implements Entry<K,V> {
		private K k; // key
		private V v; // value
		public PQEntry(K key, V value) {
			k = key;
			v = value;
		}
		// methods of the Entry interface
		public K getKey( ) { return k; }
		public V getValue( ) { return v; }
		// utilities not exposed as part of the Entry interface
		protected void setKey(K key) { k = key; }
		protected void setValue(V value) { v = value; }
	} //----------- end of nested PQEntry class -----------

	// instance variable for an AbstractPriorityQueue

	private Comparator<K> comp;

	protected AbstractPriorityQueue(Comparator<K> c) { comp = c; }

	protected AbstractPriorityQueue( ) { this(new DefaultComparator<K>( )); }

	protected int compare(Entry<K,V> a, Entry<K,V> b) {
		return comp.compare(a.getKey( ), b.getKey( ));
	}

	protected boolean checkKey(K key) throws IllegalArgumentException {
		try {
			return (comp.compare(key,key) == 0); // see if key can be compared to itself
		} catch (ClassCastException e) {
			throw new IllegalArgumentException("Incompatible key");
		}
	}

	public boolean isEmpty( ) { return size( ) == 0; }

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry<K, V> min() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry<K, V> removeMin() {
		// TODO Auto-generated method stub
		return null;
	}
}
