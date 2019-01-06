<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr> 
			<td>년도</td>  
			<td>학기</td> 
			<td>이수학점</td> 
			<td>상세보기</td> 
		</tr>
		<tr> 
			<td>${Y2016_S1.year}</td>  
			<td>${Y2016_S1.semester}</td> 
			<td>${Y2016_S1.totalGrade}</td> 
			<td><a href="/helloSpringMVC/semester?year=2016&semester=1">클릭</a></td> 
		</tr>
		<tr> 
			<td>${Y2016_S2.year}</td>  
			<td>${Y2016_S2.semester}</td> 
			<td>${Y2016_S2.totalGrade}</td> 
			<td><a href="/helloSpringMVC/semester?year=2016&semester=2">클릭</a></td> 
		</tr>
		<tr> 
			<td>${Y2017_S1.year}</td>  
			<td>${Y2017_S1.semester}</td> 
			<td>${Y2017_S1.totalGrade}</td> 
			<td><a href="/helloSpringMVC/semester?year=2017&semester=1">클릭</a></td> 
		</tr>
		<tr> 
			<td>${Y2017_S2.year}</td>  
			<td>${Y2017_S2.semester}</td> 
			<td>${Y2017_S2.totalGrade}</td> 
			<td><a href="/helloSpringMVC/semester?year=2017&semester=2">클릭</a></td> 
		</tr>
		<tr> 
			<td>${Y2018_S1.year}</td>  
			<td>${Y2018_S1.semester}</td> 
			<td>${Y2018_S1.totalGrade}</td> 
			<td><a href="/helloSpringMVC/semester?year=2018&semester=1">클릭</a></td> 
		</tr>
		<tr> 
			<td>${Y2018_S2.year}</td>  
			<td>${Y2018_S2.semester}</td> 
			<td>${Y2018_S2.totalGrade}</td> 
			<td><a href="/helloSpringMVC/semester?year=2018&semester=2">클릭</a></td> 
		</tr>
	</table>


</body>
</html>