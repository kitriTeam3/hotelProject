<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>객실 조회</title>
    <style type="text/css">
        body {
            font-family: Arial, sans-serif;
        }
        .search-bar {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            margin: 20px 0;
        }
        .search-bar .search-keyword {
            margin-bottom: 10px;
        }
        .search-bar input[type="text"] {
            width: 600px;
            padding: 5px;
        }
        .search-bar .search-filters {
            display: flex;
            align-items: center;
        }
        .search-bar input[type="date"], .search-bar select, .search-bar input[type="number"] {
            margin-left: 10px;
            padding: 5px;
        }
        .search-bar button {
            margin-left: 10px;
            padding: 5px 10px;
        }
        .hotel-list {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .hotel-item {
            display: flex;
            align-items: center;
            justify-content: space-between;
            width: 80%;
            margin: 10px 0;
            padding: 10px;
            border: 1px solid #ddd;
        }
        .hotel-item img {
            width: 100px;
            height: 100px;
            margin-right: 20px;
        }
        .hotel-item .hotel-info {
            display: flex;
            flex-direction: column;
        }
        .hotel-item .hotel-info h3 {
            margin: 0;
        }
        .hotel-item .hotel-info p {
            margin: 5px 0;
        }
        .hotel-item .hotel-price {
            display: flex;
            flex-direction: column;
            align-items: flex-end;
        }
        .hotel-item .hotel-price button {
            margin-top: 10px;
        }
        .pagination {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }
        .pagination button {
            margin: 0 5px;
            padding: 5px 10px;
        }
    </style>
</head>
<body>
	<%@ include file="../main/header.jsp" %>
	<form action="/projects/findhotel" method="post" >
	    <div class="search-bar">
	        <div class="search-keyword">
	            <input type="text" placeholder="검색어 입력창">
	        </div>
	        <div class="search-filters">
	            <input type="date" id="checkIn" name="checkIn" required>
	            <input type="date" id="checkOut" name="checkOut" required>
	            <select id=location name="location" required>
	                <option>지역명</option>
	                <option value="seoul_gangnam">서울시 강남구</option>
	                <option value="seoul_jongno">서울시 종로구</option>
	                <option value="seoul_mapo">서울시 마포구</option>
	                <option value="seoul_seocho">서울시 서초구</option>
	                <option value="seoul_songpa">서울시 송파구</option>
	            </select>
	            <input type="text" id="max" name="max" placeholder="인원 수" required>
	            <input type="submit" value="검색">
	        </div>
	    </div>
    </form>
    <div class="hotel-list">
        <c:forEach var="hotel" items="${searchResult}">
	    	<div class="hotel-item">
	        	<%-- <img src="${hotel.tpicture}" alt="대표사진"> --%>
	            <div class="hotel-info">
	            	<h3><a href="/projects/hoteldetail">${hotel.hname}</a></h3>
	                <p>${hotel.grade}성급</p>
	            </div>
	            <div class="hotel-price">
	            	<b class="large_text"><fmt:formatNumber value="${hotel.tprice}" pattern="#,###" />KWR~</b>
	                <button>예약</button>
	                <button>장바구니</button>
	            </div>
	    	</div>
        </c:forEach>
    </div>

    <div class="pagination">
        <button>1</button>
    </div>
</body>
</html>