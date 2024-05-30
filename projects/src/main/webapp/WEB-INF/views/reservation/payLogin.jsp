<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"  pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인 페이지</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            max-width: 300px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .container label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        .container input[type="text"], .container input[type="password"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .container input[type="submit"] {
            width: 48%;
            padding: 10px;
            border: none;
            border-radius: 3px;
            background-color: #007bff;
            color: white;
            font-size: 16px;
            cursor: pointer;
            margin-right: 2%;
        }
        .container input[type="submit"]:last-child {
            margin-right: 0;
        }
    </style>
</head>
<body>

<div class="container">
    <form action="/projects/payLogin" method="POST">
    
    	<c:choose>
			<c:when test="${result eq 'no_id'}">
				<script type="text/javascript">
				alert('아이디가 존재하지 않습니다.');
				</script>
			</c:when>
	
			<c:when test="${result eq 'wrong_pw'}">
				<script type="text/javascript">
				alert('비밀번호가 일치하지 않습니다.');
				</script>
			</c:when>
       	</c:choose>
       	
       	
        <label for="cid">아이디 <span style="color: red;">*</span></label>
        <input type="text" id="cid" name="cid" required>

        <label for="cpw">비밀번호 <span style="color: red;">*</span></label>
        <input type="password" id="cpw" name="cpw" required>

        <input type="submit" value="로그인">
    </form>
</div>

</body>
</html>
