import java.io.*;
import java.util.Iterator;

public class Assignment1 {

	public static LinkedList<Hostel> hostels= new LinkedList<Hostel>();
	public static LinkedList<Department> depart= new LinkedList<Department>();
	public static LinkedList<Course> Courses= new LinkedList<Course>();
	public static LinkedList<Student> students = new LinkedList<Student>();

	private static void getData(String file1, String file2) throws IOException{

		String ch [] = new String [4];
		String ch2 [] = new String [4];
		String l,l2;



		Iterator<Position_<Hostel>> itrH;
		Iterator<Position_<Department>> itrD;
		Iterator<Position_<Course>> itrC;
		Iterator<Position_<Student>> itrS;

		BufferedReader reader;
		reader = new BufferedReader(new FileReader(file1));
		String line = reader.readLine();
		while(line != null){
			ch=line.split(" ");

			itrH = hostels.positions();
			itrS = students.positions();

			Student stud = new Student();
			stud.student = ch[1];
			stud.entryno = ch[0];
			stud.hostel = ch[3];
			stud.department = ch[2];;

			Student wasim = null;
			while(itrS.hasNext()){
				wasim = itrS.next().value();
				if(wasim.entryNo().equals(ch[0])){
					break;
				}
				wasim = null;
			}
			if(wasim == null){
				students.add(stud);
			}

			Hostel host = null;
			while(itrH.hasNext()) {
				host = itrH.next().value();
				if (host.name().equals(ch[3])) {
					host.list_of_Stud.add(stud);
					break;
				}
				host = null;
			}
			if (host == null) {
				host = new Hostel(ch[3]);
				host.list_of_Stud.add(stud);
				hostels.add(host);
			}
			itrD = depart.positions();
			Department dep = null;
			while(itrD.hasNext()) {
				dep = itrD.next().value();
				if (dep.name().equals(ch[2])) {
					dep.list_of_Dep.add(stud);
					break;
				}
				dep = null;
			}
			if (dep == null) {
				dep = new Department(ch[2]);
				dep.list_of_Dep.add(stud);
				depart.add(dep);
			}
			line = reader.readLine();
		}
		reader.close();


		BufferedReader bf2 = new BufferedReader(new FileReader(file2));
		while((l2=bf2.readLine())!=null) {
			ch2=l2.split(" ",4);

			Student stud = new Student();
			CourseGrade grade = new CourseGrade();
			GradeInfo Grade_of_Stud = new GradeInfo(ch2[2]);
			grade.coursetitle = ch2[3];
			grade.coursenum = ch2[1];
			grade.grade = Grade_of_Stud;
			stud.entryno = ch2[0];
			stud.stlist.add(grade);
			itrC = Courses.positions();
			itrS = students.positions();

			Student wasim = null;

			while(itrS.hasNext()){
				wasim = itrS.next().value();
				if(wasim.entryNo().equals(ch2[0])){
					wasim.stlist.add(grade);
					break;
				}
				wasim = null;
			}
			if(wasim == null){
				students.add(stud);
			}

			Course co = null;
			while(itrC.hasNext()) {
				co = itrC.next().value();
				if (co.name().equals(ch2[3])) {
					co.list_of_subjects.add(stud);
					break;
				}
				co = null;
			}

			if (co == null) {
				co = new Course(ch2[3],ch2[1]);
				co.list_of_subjects.add(stud);
				Courses.add(co);
			}
		}

		bf2.close();

	}
	private static void answerQueries(String file1) throws IOException{
		String ch [] = new String [4];

		Iterator<Position_<Hostel>> itrH;
		Iterator<Position_<Department>> itrD;
		Iterator<Position_<Course>> itrC;
		Iterator<Position_<Student>> itrS;
		Iterator<Position_<CourseGrade>> uno;

		BufferedReader reader1;
		reader1 = new BufferedReader(new FileReader(file1));
		String line1 = reader1.readLine();
		int count=0;
		while(line1 != null){
			count++;
			line1 = reader1.readLine();

		}
		reader1.close();
		String[] suleman = new String[count];
		int sam = 0;
		BufferedReader reader;
		reader = new BufferedReader(new FileReader(file1));
		String line = reader.readLine();
		while(line != null){
			ch = line.split(" ");
			if(ch[0].equals("SHARE")){
				int flag = 0;
				itrC = Courses.positions();
				Course co = null;
				while(itrC.hasNext()){
					co = itrC.next().value();
					if(co.heading().equals(ch[2])){
						flag =1;
						String pkka;
						pkka = co.Print_EntryNo(ch[1]);
						suleman[sam] = pkka;
						sam++;
					}
				}
				if(flag==0){
					itrH = hostels.positions();
					Hostel com = null;
					while(itrH.hasNext()){
						com = itrH.next().value();
						if(com.name().equals(ch[2])){
							flag=1;
							String akka;
							akka = com.Print_EntryNo(ch[1]);
							suleman[sam] = akka;
							sam++;
						}
					}
				}
				if(flag == 0){
					itrD = depart.positions();
					Department comm = null;
					while(itrD.hasNext()){
						comm = itrD.next().value();
						if(comm.name().equals(ch[2])){
							flag=1;
							String jam;
							jam = comm.Print_EntryNo(ch[1]);
							suleman[sam] = jam;
							sam++;
						}
					}
				}
			}
			else if(ch[0].equals("INFO")){
				itrS = students.positions();
				Student italy = null;
				while(itrS.hasNext()){
					italy = itrS.next().value();
					if(italy.entryNo().equals(ch[1])){
						String jammer;
						jammer = italy.entryNo()+" "+italy.name()+" "+italy.department()+" "+italy.hostel()+" "+ italy.completedCredits()+" ";
						uno = italy.stlist.positions();
						int batla = 0;
						CourseGrade xe = null;
						while(uno.hasNext()){
							xe=uno.next().value();
							batla++;
						}
						CourseGrade[] ar = new CourseGrade[batla];
						int perfect =0;
						uno = italy.stlist.positions();
						CourseGrade x = null;
						while(uno.hasNext()){
							x = uno.next().value();
							ar[perfect] = x;
							perfect++;
						}
						for (int k = 0;k<batla-1;k++){
							for(int e = k+1;e<batla;e++){
								if(ar[k].coursenum().compareTo(ar[e].coursenum())>0){
									CourseGrade zoo = ar[k];
									ar[k] = ar[e];
									ar[e] = zoo;
								}
							}
						}
						for (int time=0;time<batla;time++){
							jammer = jammer + ar[time].coursenum() +" " + ar[time].grade.convert()+" ";
						}
						suleman[sam] = jammer;
						sam++;
					}
				}
			}
			else{
				itrC = Courses.positions();
				Course co = null;
				while(itrC.hasNext()) {
					co = itrC.next().value();
					if(co.heading().equals(ch[1])){
						suleman[sam] = co.name();
						sam++;
					}
				}
			}
			line = reader.readLine();
		}
		reader.close();
		for (int uber = count-1;uber>=0;uber--){
			System.out.println(suleman[uber]);
		}
	}
		public static void main(String args[]) throws IOException{
			getData(args[0],args[1]);
			answerQueries(args[2]);
		}
	}
