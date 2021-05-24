package adHoc;

import java.util.*;

interface FilterPredicate<T>{
	boolean isMatching(T candidate);
}//end FilterPredicate

class Filter<T>{
	private List<T> sourceList;
	
	public Filter(List<T> sourcelist) {
		this.sourceList = sourcelist;
	}//end of cons
	
	List<T> filter(FilterPredicate<T> filterPredicate){
		ArrayList<T> resultlist = new ArrayList<T>();
		for( T elem : sourceList ) {
			if( filterPredicate.isMatching(elem)) {
				resultlist.add(elem);
			}//end if
		}//end for
		
		return resultlist;
	}//end filter
	
}//end class Filter

class PredicateShortName implements FilterPredicate<Person>{
	@Override
	public boolean isMatching(Person candidate) {
		return candidate.getName().length() < 5;
	}//end isMatching
}//end PredicateShortName


public class AH05_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
