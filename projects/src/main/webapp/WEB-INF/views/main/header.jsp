<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>HEADER</title>
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
            <h2><a href="/projects/homePage">사이트명</a></h2>
            <a href="/projects/findhotelPage">객실</a>
            <a href="#">이벤트</a>
            <a href="#">문의하기</a>
        </div>
        <div class="nav-right">
             <c:choose>
                <c:when test="${not empty sessionScope}">
                	<c:if test="${not empty sessionScope.cid}">
				        <a href="#">장바구니</a>
				    </c:if>
				    <c:if test="${not empty sessionScope.hid}">
				        <a href="/projects/goodsregisterPage">객실등록</a>
				    </c:if>
				    <c:if test="${not empty sessionScope.eid}">
				        <a href="#">관리자페이지</a>
				    </c:if>
                    <a href="#">마이페이지</a>
                    <a href="<c:url value='/logout' />"  class="logout-link">로그아웃</a>
                </c:when>
                <c:otherwise>
                    <a href="#">장바구니</a>
                    <a href="/projects/login">로그인</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</body>
</html>