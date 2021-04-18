import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MainClass {
	public static void main(String[] args) {
		
		// Collection java 1.2
		// List
		// Set
		// Map
		// QUEUE
		// DEQUE -> R&D
		// ArrayList (your own datastructure)
		
		// capacity + capacity * 0.5
//		ArrayList<Integer> arrayList = new ArrayList<>();
//		arrayList.add(1);
//		arrayList.add(2);
//		
//		Iterator<Integer> it = arrayList.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		
//		
//		CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
//		copyOnWriteArrayList.add(12);
		
//		LinkedList<Integer> linkedList = new LinkedList<>();
//		linkedList.push(1);
//		linkedList.push(2);
//		linkedList.push(3);
//		
//		System.out.println(linkedList.pop());
//		System.out.println(linkedList.peek());
//		System.out.println(linkedList.peekLast());
//		
		// Set time O(1)
//		HashSet<Integer> hashSet = new HashSet<>();
//		hashSet.add(1);
//		hashSet.add(2);
//		hashSet.add(3);
//		hashSet.add(2);
//		
//		System.out.println(hashSet);
		
		// Red-black tree -> Log(n)
//		TreeSet<String> tree = new TreeSet<>();
//		tree.add("A");
//		tree.add("B");
//		tree.add("C");
//		
//		System.out.println(tree);
		
		// hashmap will accept null -> 
		// raw data 
		
//		HashMap<String, String> map = new HashMap<>();
//		map.put("1", "Aqib");
//		map.put("2", "Ali");
//		map.put("3", null);
//		map.put("3", "AP");
//		map.put(new String("3"), "POL");
//		System.out.println(map.get("3"));
		
//		ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
//		IdentityHashMap<String, String> identityHashMap = new IdentityHashMap<>();
//		identityHashMap.put("3", "AP");
//		identityHashMap.put(new String("3"), "POL");
//		System.out.println(identityHashMap);
		
//		WeakHashMap<Integer, Integer> weakHashMap = new WeakHashMap<>();
//		Integer i = Integer.valueOf(300);
//		weakHashMap.put(i, 11);
//		System.out.println(weakHashMap);
//		i = null;
//		System.gc();
//		System.out.println(weakHashMap);
		
		//
//		Queue<Integer> queue = new LinkedList<>();
//		queue.add(6);
//		queue.add(3);
//		queue.add(7);
//		
//		System.out.println(queue.poll());
//		System.out.println(queue.poll());
		
//		heap (min_heap, max_heap log(n)
//		Queue<Integer> min_heap = new PriorityQueue<>();
//		min_heap.offer(6);
//		min_heap.offer(3);
//		min_heap.offer(7);
//		System.out.println(min_heap.poll());
//		System.out.println(min_heap.poll());
//		System.out.println(min_heap.poll());
		
//		Queue<Integer> max_heap = new PriorityQueue<>(Comparator.reverseOrder());
//		max_heap.offer(6);
//		max_heap.offer(3);
//		max_heap.offer(7);
//		System.out.println(max_heap.poll());
//		System.out.println(max_heap.poll());
//		System.out.println(max_heap.poll());
		
		// DataStructure java 1.0
		// Vector
		// Stack
		// Hashtable
		// BitSet
		// Enumeration
		// Properties
		// Dictionary

		// Synchronised
		// int[] -> 10 (0-9 elements) [->10 existing[10 * 2]]
		// 41 -> 41 -> 39(space)
//		Vector<Integer> vector = new Vector<>();
//		for (int x = 0; x < 20; x++) {
//			vector.add(x);
//		}
//		
//		Enumeration<Integer> enumeration = vector.elements();
//		while(enumeration.hasMoreElements()) {
//			System.out.println(enumeration.nextElement());
//		}
		
//		
//		List<Integer> list = vector.stream()
//			  .filter(x -> x % 2 == 0)
//			  .collect(Collectors.toList());
//		
//		System.out.println(list);

//		vector.stream().filter(x -> x > 3).forEach(System.out::println);

//		vector.stream()
//			.filter(x -> x > 3)
//			.map(x -> x * x)
//			.forEach(System.out::println);

//		int limit = 3;
//		for(int value : vector) {
//			if(value > limit)
//				System.out.println(value);
//		}

//		System.out.println(vector.get(0));
//		System.out.println(vector.capacity());
//		System.out.println(vector.size());
//		System.out.println(vector.contains(Integer.valueOf(12)));
//		System.out.println(vector.containsAll(Arrays.asList(2, 3)));
//		System.out.println(vector.isEmpty());
//		System.out.println(vector.indexOf(Integer.valueOf(2)));
//		vector.remove(0);
//		Integer i = Integer.valueOf(3);
//		vector.remove(i);
//		System.out.println(vector);
		
		
		// Last-In First out
//		Stack<Integer> stack = new Stack<>();
//		stack.push(1);
//		stack.push(2);
//		stack.push(3);
//		
//		System.out.println(stack.peek());
//		System.out.println(stack.pop());
		
//		BitSet bitSet = new BitSet();
//		bitSet.set(1);
//		BitSet bitSet1 = new BitSet();
//		bitSet1.set(0);
//		bitSet1.set(1);
//		bitSet.or(bitSet1);
//		System.out.println(bitSet);
		
		//Hashtable will not accept null
//		Hashtable<Integer, String> hashtable = new Hashtable<>();
//		hashtable.put(1, "aqib");
//		hashtable.put(2, "ali");
//		hashtable.put(3, "ahmad");
//		hashtable.put(4, "arslan");
//		hashtable.put(5, null);
//		System.out.println(hashtable.get(1));
//		
//		List<String> values = hashtable.entrySet()
//				 .stream()
//				 .filter(entry -> entry.getKey() > 2)
//				 .map(entry -> entry.getValue())
//				 .collect(Collectors.toList());
//		
//		System.out.println(values);
		
//		Properties properties = new Properties();
//		properties.put(1, "hi");
			
		
	}
}
