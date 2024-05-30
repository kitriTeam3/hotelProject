<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>내 정보 조회</h2>
	<form name="form2" method="post">
		<table border="1" width="400px">
			<tr>
				<td>이름</td>
				<td><input name="ename" value="${emyinfo.ename}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input name="email" value="${emyinfo.email}"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input name="ephone" value="${emyinfo.ephone}"></td>
			</tr>
			<tr>
				<td>직급</td>
				<td><input name="position" value="${emyinfo.position}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>상태</td>
				<td><input name="status" value="${emyinfo.status}" readonly="readonly"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="수정" onclick="location.href='/projects/#'">
					<input type="button" value="확인" onclick="location.href='/projects/esuccess'">
				</td>
			</tr>
		</table>
	</form>
	
	
</body>
</html>