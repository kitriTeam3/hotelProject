<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>업체 정보 조회</h2>
	<form name="form3" method="post">
		<table border="1" width="400px">
			<tr>
				<td>업체명</td>
				<td><input name="hname" value="${hmyinfo.hname}"></td>
			</tr>
			<tr>
				<td>등급</td>
				<td><input name="grade" value="${hmyinfo.grade}"></td>
			</tr>
			<tr>
				<td>위치</td>
				<td><input name="location" value="${hmyinfo.location}"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input name="hmail" value="${hmyinfo.hmail}"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input name="hphone" value="${hmyinfo.hphone}"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="수정" onclick="location.href='/projects/#'">
					<input type="button" value="확인" onclick="location.href='/projects/hsuccess'">
				</td>
			</tr>
		</table>
	</form>
	
	
</body>
</html>