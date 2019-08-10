public class Position<T> implements Position_<T> {
	T data;
	Position<T> next;

	Position (T data){
		this.data=data;
		this.next=null;
	}

	public T value() {			// Return value at position
		// TODO Auto-generated method stub
		return data;
	}

	public Position_<T> after() {			// Returns the position after this position in its list
		// TODO Auto-generated method stub
		return this.next;
	}


}
