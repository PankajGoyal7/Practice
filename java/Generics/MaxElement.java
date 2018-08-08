import java.util.*;

final class Algorithm {
    public static <T extends Object & Comparable<? super T>> T max(List<? extends T> list, int begin, int end) {

        T maxElem = list.get(begin);

        for (++begin; begin < end; ++begin)
            if (maxElem.compareTo(list.get(begin)) < 0)
                maxElem = list.get(begin);
        return maxElem;
    }
}

public class MaxElement{

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(978,2,4,65,12,123,54,323);
		System.out.println(Algorithm.max(list,0,8));
	}
}