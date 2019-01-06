package kr.ac.hansung.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class InfoSemester {
	
	private int year;

	
	private int semester;

	
	private int totalGrade;
}
