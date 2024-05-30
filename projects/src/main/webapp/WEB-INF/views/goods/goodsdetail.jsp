<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>객실정보</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .header {
            text-align: center;
            margin: 20px 0;
            position: relative;
        }
        .header button {
            position: absolute;
            left: 20px;
            top: 20px;
            padding: 10px 20px;
            background-color: #3b78e7;
            color: white;
            border: none;
            cursor: pointer;
        }
        .content {
            width: 80%;
            margin: 0 auto;
            text-align: center;
        }
        .room-info {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-top: 20px;
        }
        .room-photo {
            width: 60%;
            height: 300px;
            background-color: #d3d3d3;
            display: flex;
            align-items: center;
            justify-content: space-between;
            position: relative;
        }
        .room-photo img {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }
        .arrow {
            width: 30px;
            height: 30px;
            background-color: #3b78e7;
            color: white;
            font-size: 18px;
            display: flex;
            align-items: center;
            justify-content: center;
            cursor: pointer;
        }
        .room-details {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-top: 50px;
        }
        .room-details-left {
            display: flex;
            flex-direction: row;
            align-items: center;
        }
        .room-details-right {
            display: flex;
            align-items: center;
        }
        .room-details-right > div, .buttons {
            display: flex;
            align-items: center;
        }
        .buttons button {
            margin: 0 10px;
            padding: 10px 20px;
            background-color: #3b78e7;
            color: white;
            border: none;
            cursor: pointer;
        }
        .room-description {
            border: 1px solid #ccc;
            padding: 20px;
            margin-top: 20px;
            text-align: left;
        }
        .room-service {
            border: 1px solid #ccc;
            padding: 20px;
            margin-top: 20px;
            text-align: left;
        }
    </style>
</head>
<body>

<div class="header">
    <button onclick="history.back();">이전</button>
    <h1>객실정보</h1>
</div>

<div class="content">
    <div class="room-info">
        <div class="arrow" onclick="previousPhoto()">←</div>
        <div class="room-photo">
            <img src="path/to/room_photo.jpg" alt="객실 사진">
        </div>
        <div class="arrow" onclick="nextPhoto()">→</div>
    </div>

    <div class="room-details">
        <div class="room-details-left">
            <h2><span id="room-name">${room.tname}</span></h2>
            <span id="room-capacity">${room.max}인실</span>
        </div>
        <div class="room-details-right">
            <b class="large_text">가격: <fmt:formatNumber value="${room.tprice}" pattern="#,###" />KWR</b>
            <div class="buttons">
                <button onclick="bookNow()">예약</button>
                <button onclick="addToCart()">장바구니</button>
            </div>
        </div>
    </div>

    <div class="room-description">
    	<h3>기본 정보</h3>
       	${details.exp}
    </div>
    <div class="room-service">
    	<h3>서비스</h3>
       	<pre>
베드구성: ${details.bedtype} ${details.bedno}개
객실전망: ${details.tview} View
흡연여부: ${details.smoke}
객실크기: ${details.tsize}㎡
욕실종류: ${details.bathtype}
조식여부: ${details.breakfast}
        </pre>
    </div>
</div>

<script>
    function previousPhoto() {
        // Implement photo navigation logic
    }

    function nextPhoto() {
        // Implement photo navigation logic
    }

    function bookNow() {
        // Implement booking logic
    }

    function addToCart() {
        // Implement add to cart logic
    }
</script>

</body>
</html>
