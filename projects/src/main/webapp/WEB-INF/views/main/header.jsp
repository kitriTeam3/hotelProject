<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
    <style type="text/css">
        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #f8f9fa;
            padding: 10px 20px;
        }
        .navbar .nav-left {
            display: flex;
            align-items: center;
        }
        .navbar .nav-left h2 {
            margin: 0 20px 0 0;
        }
        .navbar a {
            margin: 0 10px;
            text-decoration: none;
            color: black;
        }
        .navbar a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
	 <div class="navbar">
        <div class="nav-left">
            <h2><a href="#">사이트명</a></h2>
            <a href="#">객실</a>
            <a href="#">이벤트</a>
            <a href="#">문의하기</a>
        </div>
        <div class="nav-right">
             <c:choose>
                <c:when test="${not empty sessionScope.user}">
                    <a href="#">마이페이지</a>
                    <a href="#">장바구니</a>
                    <a href="#">로그아웃</a>
                </c:when>
                <c:otherwise>
                    <a href="#">장바구니</a>
                    <a href="#">로그인</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</body>
</html>