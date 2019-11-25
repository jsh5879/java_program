package edu.pnu.edit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import edu.pnu.shape.AreaComputable;

public class Editor {
	private ArrayList<AreaComputable> list = new ArrayList<>();
	
	public void add( AreaComputable newShape ) {
		list.add(newShape) ;
	}
	
	public void clear() {
		list.clear() ;
	}
	
	public void list(){
		System.out.print(list + "  \n");
	}
	
	public void sort(final SortKind kind ){
		Comparator<AreaComputable> comparator = null;
		
		if(kind.equals(SortKind.ASCENDING))
			comparator = new sorta();
		else if(kind.equals(SortKind.DESCENDING))
			comparator = new sortd();
		
		Collections.sort(list, comparator);
	}
	
	private class sorta implements Comparator<AreaComputable>{

		@Override
		public int compare(AreaComputable o1, AreaComputable o2) {
			AreaComputable Area1 = (AreaComputable) o1;
			AreaComputable Area2 = (AreaComputable) o2;
			
			double area1 = Area1.getArea() ;
			double area2 = Area2.getArea() ;
			
			if ( area1 == area2 ) return 0 ;
			else if ( area1 > area2 ) return 1;
			return -1 ;
		}
		
	}
	
	private class sortd implements Comparator<AreaComputable>{
		@Override
		public int compare(AreaComputable arg0, AreaComputable arg1) {
			AreaComputable Area1 = (AreaComputable) arg0;
			AreaComputable Area2 = (AreaComputable) arg1;
			
			double area1 = Area1.getArea() ;
			double area2 = Area2.getArea() ;

			if ( area1 == area2 ) return 0 ;
			else if ( area1 < area2 ) return 1;
			return -1 ;
		}
	}

}