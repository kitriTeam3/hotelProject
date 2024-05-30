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
	<form name="form1" method="post">
		<table border="1" width="400px">
			<tr>
				<td>이름</td>
				<td><input name="cname" value="${cmyinfo.cname}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>영문 이름</td>
				<td><input name="firstname" value="${cmyinfo.firstname}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>영문 성</td>
				<td><input name="lastname" value="${cmyinfo.lastname}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input name="cmail" id="cmail" value="${cmyinfo.cmail}"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input name="cphone" id="cphone" value="${cmyinfo.cphone}"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="수정" onclick="location.href='/projects/updatecustomer'">
					<input type="button" value="확인" onclick="location.href='/projects/csuccess'">
				</td>
			</tr>
		</table>
	</form>
	
	
</body>
</html>