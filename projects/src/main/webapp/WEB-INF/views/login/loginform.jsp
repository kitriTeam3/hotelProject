<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="login-wrapper">
        <h2>회원</h2>
        <form method="post" action="/projects/cloginctrl" id="clogin-form">
            아이디:<input type="text" name="cid"><br/>
            비밀번호:<input type="password" name="cpw"><br/>
            <input type="submit" value="로그인"><br/>
            <a href="/projects/csignup">회원가입</a><br/>
        </form>
        <h2>사원</h2>
        <form method="post" action="/projects/eloginctrl" id="elogin-form">
            아이디:<input type="text" name="eid"><br/>
            비밀번호:<input type="password" name="epw"><br/>
            <input type="submit" value="로그인"><br/>
            <a href="/projects/esignup">회원가입</a><br/>
        </form>
        <h2>업체</h2>
        <form method="post" action="/projects/hloginctrl" id="hlogin-form">
            아이디:<input type="text" name="hid"><br/>
            비밀번호:<input type="password" name="hpw"><br/>
            <input type="submit" value="로그인"><br/>
            <a href="/projects/hsignup">회원가입</a><br/>
        </form>
    </div>
</body>
</html>