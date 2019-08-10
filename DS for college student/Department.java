import java.util.Iterator;

public class Department implements Entity_ {
	String departments;
	LinkedList<Student> list_of_Dep = new LinkedList<Student>();
	Iterator<Position_<Student>> itr_Sub;

	public Department(String name) {
		this.departments = name;
	}
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return this.departments;
	}

	@Override
	public Iterator<Student_> studentList() {
		// TODO Auto-generated method stub

		return new new_iter();
	}
	public String Print_EntryNo(String x){
		itr_Sub = list_of_Dep.positions();
		Student balak = null;
		int counting = 0;
		while(itr_Sub.hasNext()){
			balak = itr_Sub.next().value();
			if(!balak.entryNo().equals(x)){
				counting++;
			}
		}
		String[] repl = new String[counting];
		int t = 0;
		itr_Sub = list_of_Dep.positions();
		Student co = null;
		while(itr_Sub.hasNext()){
			co = itr_Sub.next().value();
			if(!co.entryNo().equals(x)){
				repl[t] = co.entryNo();
				t++;
				// System.out.print(co.entryNo()+" ");
			}
		}

		for (int i=0;i<counting-1;++i){
			for (int j=i+1;j<counting;++j){
				if(repl[i].compareTo(repl[j])>0){
					String temp = repl[i];
					repl[i] = repl[j];
					repl[j] = temp;
				}
			}
		}
		String str = "";
		for (int i=0;i<counting;i++){
			str = str + repl[i] +" ";
			// System.out.print(repl[i]+" ");
		}
		return str;
		// System.out.println("");
	}
	public class new_iter implements Iterator<Student_>{
		Position<Student> current = list_of_Dep.first;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current.next != null;
		}

		@Override
		public Student next() {
			// TODO Auto-generated method stub
			Position<Student> temp_ref = current;
			current= (Position<Student>) current.after();
			return temp_ref.value();
		}

	}
	public String toString() {
		return departments;
    }

}
