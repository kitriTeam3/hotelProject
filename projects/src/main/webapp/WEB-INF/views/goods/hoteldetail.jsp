<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>사이트명</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .hotel-photo {
            background-color: #87CEEB;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 20px;
            margin: 20px 0;
        }
        .hotel-photo img {
            width: 50px;
            height: 50px;
        }
        .hotel-info {
            text-align: left;
            margin-bottom: 20px;
        }
        .hotel-info .hotel-details {
            display: flex;
            justify-content: left;
            align-items: center;
        }
        .hotel-info h1 {
            margin: 10px 10px 10px 0;
        }
        .hotel-info p {
            margin: 10px 0;
        }
        .room-list {
            width: 80%;
            margin: 0 auto;
            border: 1px solid #000;
        }
        .room-item {
            display: flex;
            align-items: center;
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }
        .room-item:last-child {
            border-bottom: none;
        }
        .room-item img {
            width: 100px;
            height: 100px;
            margin-right: 20px;
        }
        .room-details {
            display: flex;
            flex-direction: column;
            flex-grow: 1;
        }
        .room-details h3 {
            margin: 0;
        }
        .room-details p {
            margin: 5px 0;
        }
        .room-price {
            display: flex;
            flex-direction: column;
            align-items: flex-end;
        }
        .room-price p {
            margin: 0;
        }
        .room-price button {
            margin-top: 10px;
            padding: 5px 10px;
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
        }
        .room-price button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <%@ include file="../main/header.jsp" %>
    <div class="hotel-photo">
        <a href="#">
            <img src="left-arrow.png" alt="이전">
        </a>
        <h1>호텔 사진</h1>
        <a href="#">
            <img src="right-arrow.png" alt="다음">
        </a>
    </div>

    <div class="hotel-info">
        <div class="hotel-details">
            <h1>${hotel.hname}</h1>
            <p>${hotel.location} | ${hotel.grade}성급 | ${hotel.hphone}</p>
        </div>
    </div>

    <div class="room-list">
        <c:forEach var="room" items="${rooms}">
            <div class="room-item">
                <%-- <img src="${room.photo}" alt="객실 사진"> --%>
                <div class="room-details">
                	<h3><a href="/projects/goodsdetail?tcode=${room.tcode}">${room.tname}</a></h3>
                    <p>인원: ${room.max}인</p>
                    <p>재고수량: ${room.amounts}개 남음</p>
                </div>
                <div class="room-price">
                    <b class="large_text">가격: <fmt:formatNumber value="${room.tprice}" pattern="#,###" />KWR</b>
	                <button>예약</button>
                    <button>장바구니</button>
                </div>
            </div>
        </c:forEach>
    </div>
</body>
</html>
