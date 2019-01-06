<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수강 신청하기</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">

</head>
<body>

<sf:form method="post" action="${pageContext.request.contextPath}/docreate" modelAttribute="offer">

	<table class="formtable">

		<tr><td class="label"> Year : </td> <td> <sf:input class="control" type="text" path="year" value="2019" /> <br/>
			<sf:errors path="year" class="error" /> </td> </tr>
		<tr><td class="label"> Semester : </td> <td> <sf:input class="control" type="text" path="semester" value="1" /> <br/>
			<sf:errors path="semester" class="error" /> </td> </tr>
		<tr><td class="label"> CourseCode : </td> <td> <sf:input class="control" type="text" path="coursecode" /> <br/>
			<sf:errors path="coursecode" class="error" /></td> </tr>
		<tr><td class="label"> CourseName : </td> <td> <sf:input class="control" type="text" path="coursename" /> <br/>
			<sf:errors path="coursename" class="error" /> </td> </tr>
		<tr><td class="label"> Division : </td> <td> <sf:input class="control" type="text" path="division" /> <br/>
			<sf:errors path="division" class="error" /> </td> </tr>
		<tr><td class="label"> Grade : </td> <td> <sf:input class="control" type="text" path="grade"/> <br/>
			<sf:errors path="grade" class="error" /></td> </tr>

	
		
		<tr><td class="label"> </td> <td> <input class="control" type="submit" value="수강신청" /> </td> </tr>
	</table>

</sf:form>


</body>
</html>