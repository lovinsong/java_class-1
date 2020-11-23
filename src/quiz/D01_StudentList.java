package quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import myobj.Student;

public class D01_StudentList {

	// 학생 클래스를 요소로 갖는 ArrayList를(group) 생성하고
	// 학생을 30명 추가해보세요 
	
	// 1. 30명의 점수가 자동으로 설정되도록 만들어보세요 
	
	// 2. 모든 학생의 총 점수와 평균 점수를 구해보세요
	
	// 3. 반 평균을 구해보세요 
	
	// 4. 이름 생성 규칙 
	//	 	테스트학생0000
	//		테스트학생0001
	//		테스트학생0002
	
	public static void main(String[] args) {
		ArrayList<Student> group01 = new ArrayList<>();
		
		int num_of_students = 30;
		
		double sum = 0;
		for (int i = 0; i < num_of_students; ++i) {
			group01.add(new Student());
			sum += group01.get(i).getAvg();
		}		
		
		// println 함수는 사실 해당 객체의 toString() 메서드를 호출한다
		System.out.println(group01);
		System.out.println("반 평균 : " + sum / (double)num_of_students);
	}
}















