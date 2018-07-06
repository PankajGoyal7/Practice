/*
* @Author: pankajgoyal7
* @Date:   2018-06-07 17:13:35
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-06-07 18:37:21
*/
import java.util.HashMap;
import java.util.Map;


class CacheNode{
	int key;
	int value;
	CacheNode prev,next;

	CacheNode(int item,int value){
		key = item;
		value = value;
		prev = next = null;
	}
}
class LRUCache{

	int capacity;
	HashMap<Integer,CacheNode> map = new HashMap<Integer,CacheNode>();
	CacheNode head = null;
	CacheNode end  = null;

	public LRUCache(int capacity){
		this.capacity = capacity;
	}

	public int get(int key){
		if(map.containsKey(key)){
			CacheNode m = map.get(key);
			remove(m);
			setHead(m);
			return m.value;
		}
		return -1;
	}

	public void remove(CacheNode n){
		if(n.prev != null){
			n.prev.next = n.next;
		}else{
			head = n.next;
		}

		if(n.next != null){
			n.next.prev = n.prev;
		}else {
			end = n.prev;
		}
	}

	public void setHead(CacheNode n){
		n.next = head;
		n.prev = null;

		if(head != null)
			head.prev = n;
		head = n;
		
		if(end == null)
			end = head;

	}

	public void set(int key,int value){
		if(map.containsKey(key)){
			CacheNode old = map.get(key);
			old.value = value;
			remove(old);
			setHead(old);
		}else{
			CacheNode created = new CacheNode(key,value);
	
			if(map.size() >= capacity){
				map.remove(end.key);
				remove(end);
				setHead(created);
			}else{
				setHead(created);
			}
			map.put(key,created);
		}
	}

	public static void main(String[] args) {
		
		LRUCache cache = new LRUCache(4);
		cache.set(1,10);
		cache.set(2,20);

		System.out.println(cache.get(2));
	}
}