<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>객실 정보</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
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
    <div class="navbar">
    	<div class="nav-left">
        	<button onclick="history.back();">이전</button>
        </div>
        <div class="nav-center">
        	<b>객실 정보</b>
        </div>
    </div>
    <div class="room-photo">
        <a href="#">
            <img src="left-arrow.png" alt="이전">
        </a>
        <h1>객실 사진</h1>
        <a href="#">
            <img src="right-arrow.png" alt="다음">
        </a>
    </div>

    <div class="room-type">
        <div class="room-info">
            <h1>${room.tname}</h1>
            <p>${room.max}명</p>
        </div>
        <div class="room-price">
              <b class="large_text">가격: <fmt:formatNumber value="${room.tprice}" pattern="#,###" />KWR</b>
	          <button>예약</button>
             <button>장바구니</button>
        </div>
    </div>

    <div class="room-detail">
        <c:set var="details" value="${details}">
            <div class="room-item">
            	<h3>객실 서비스</h3>
                <div class="room-details">
                    <p>${details.exp}</p>
                    <p>${details.bedtype}</p>
                    <p>${details.bedno}</p>
                    <p>${details.tview}</p>
                    <p>${details.smoke}</p>
                    <p>${details.tsize}</p>
                    <p>${details.bathtype}</p>
                    <p>${details.breakfast}</p>
                </div>
            </div>
        </c:set>
    </div>
</body>
</html>