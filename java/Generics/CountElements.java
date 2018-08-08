import java.util.Arrays;
import java.util.Collection;

interface UnaryPredicate<T>{
	public boolean test(T obj);
}

class oddPredicate implements UnaryPredicate<Integer>{
	public boolean test(Integer i){
		return i %2 != 0;
	}
}

final class Algo{
	public static <T> int count(Collection<T> c,UnaryPredicate<T> p){
		int count = 0;
		for(T ele:c){
			if(p.test(ele))
				++count;
		}
		return count;
	}
}

public class CountElements{

	public static void main(String[] args){
		Collection<Integer> ci = Arrays.asList(1,2,3,4,5,6,7);
		int count  = Algo.count(ci,new oddPredicate());
		System.out.println(count);
	}
}