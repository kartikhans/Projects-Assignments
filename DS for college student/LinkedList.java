import java.util.Iterator;

public class LinkedList<T> implements LinkedList_<T> {
	Position<T> first;
	Position<T> last;

	public Position_<T> add(T e) {
		Position<T> new_node = new Position<T>(e);
		if(first == null) {
			first = new Position<T>(e);
			last = first;
			return new_node;
		}
		new_node.next = null;
		last.next = new_node;
		last = new_node;
		return new_node;
	}

	public class new_iter implements Iterator<Position_<T>>{
		Position<T> current=first;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public Position_<T> next() {
			// TODO Auto-generated method stub
			Position<T> temp_ref = current;
			current= (Position<T>) current.after();
			return temp_ref;
		}

	}
	@Override
	public Iterator<Position_<T>> positions() {
		// TODO Auto-generated method stub
		return new new_iter();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		Position<T> CURRENT = first;
		int temp=0;
		while(CURRENT.next!=null)
			 temp++;
		return temp;
	}

	public void printList() {
		Position<T> currentposition = first;
		while(currentposition!=null) {
			System.out.print(currentposition.value() + " ");
			currentposition = (Position<T>) currentposition.after();
		}

	}

}
