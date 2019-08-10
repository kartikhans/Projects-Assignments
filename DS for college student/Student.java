import java.util.Iterator;

public class Student implements Student_ {
	String student;
	String entryno;
	String hostel;
	String department;
	String completedCredits;
	LinkedList<CourseGrade> stlist = new LinkedList<CourseGrade>();
	Iterator<Position_<CourseGrade>> cap;

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return this.student;
	}

	@Override
	public String entryNo() {
		// TODO Auto-generated method stub
		return this.entryno;
	}

	@Override
	public String hostel() {
		// TODO Auto-generated method stub
		return this.hostel;
	}

	@Override
	public String department() {
		// TODO Auto-generated method stub
		return this.department;
	}

	@Override
	public String completedCredits() {
		// TODO Auto-generated method stub
		cap = stlist.positions();
		CourseGrade_ co =null;
		double count=0;
		double mul=0;
		while(cap.hasNext()){
			co = cap.next().value();
			mul=mul+(3*co.grade().samantha());
			count=count+3;
		}
		double p = mul/count;
		return String.format("%.2f", p);
	}

	public String cgpa() {
		// TODO Auto-generated method stub
		return null;
	}
	public Iterator<CourseGrade_> courseList(){
		return null;
	}

	// @Override
	// public Iterator<CourseGrade_> courseList() {
	// 	// TODO Auto-generated method stub
	//
	// 	return new stditr();
	// }
	// public stditr implements Iterator<CourseGrade_>{
	// 	Position<CourseGrade_> current=slist.first;
	//
	// 	@Override
	// 	public boolean hasNext() {
	// 		// TODO Auto-generated method stub
	// 		return current.next != null;
	// 	}
	//
	// 	@Override
	// 	public CourseGrade_ next() {
	// 		// TODO Auto-generated method stub
	// 		Position<CourseGrade_> temp_ref = current;
	// 		current= (Position<CourseGrade_>) current.after();
	// 		return temp_ref.value();
	// 	}
	// }

}
