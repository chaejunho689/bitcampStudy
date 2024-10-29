package com.jstl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
//@Getter
//@Setter
@Data //getter setter 대체 가능
public class personDTO {
	@NonNull
	private String name;
	private int age;


	
}
