<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  
	<form action="./delete" method="get" >
		<table>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
				<td><input type="submit" value="확인"></td>
			</tr>
		</table>
		<a href="./list">메인으로 돌아가기</a>
		<br>
		<input type='hidden' name="no" value="${ requestScope.listNo }">
	</form>
	-->

	<form action="./delete" method="get">
		<table>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
				<td><input type="submit" value="확인"></td>
			</tr>
		</table>
		<c:if test="${ param.action eq 'fail' }">
			<p style="color:red;">비밀번호가 틀렸어임마~</p>
		</c:if>
		<a href="./list">메인으로 돌아가기</a> <br> 
		<input type='hidden' name="no" value="${ requestScope.listNo }">
	</form>



</body>
</html>