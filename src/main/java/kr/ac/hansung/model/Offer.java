package kr.ac.hansung.model;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Offer {

	@NotNull(message="need not null")
	private int year;

	@NotNull(message="need not null")
	private int semester;

	@NotEmpty(message="need not empty")
	private String coursecode;

	@NotEmpty(message="need not empty")
	private String coursename;

	@NotEmpty(message="need not empty")
	private String division;

	@NotNull(message="need not null")
	private int grade;
	
	
	
	
}
