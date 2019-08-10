
public class GradeInfo implements GradeInfo_ {
	LetterGrade grade ;
	public GradeInfo(String grade){
		this.grade = LetterGrade.valueOf(grade);
	}
	public int samantha(){
		if (grade == LetterGrade.A) return 10;

		else if (grade == LetterGrade.Aminus) return 9;

		else if (grade == LetterGrade.B) return 8;

		else if (grade == LetterGrade.Bminus) return 7;

		else if (grade == LetterGrade.C) return 6;

		else if (grade == LetterGrade.Cminus) return 5;

		else if (grade == LetterGrade.D) return 4;

		else return 0;
	}
	public String convert() {
		return grade.toString();
	}
}
