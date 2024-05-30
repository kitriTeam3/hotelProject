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
        /* 스타일링을 위한 간단한 CSS */
		body {
            font-family: Arial, sans-serif;
        }
        form {
        	display: flex;
            flex-direction: column;
            align-items: center;
            height: 30vh;
            margin: 0;
        }
        .search-bar {
            border: 2px solid #ccc;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            margin: 20px 0;
            padding: 20px;
            width: 80%;
            max-width: 800px;
        }
        .search-keyword, .search-filters {
            width: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .search-keyword input[type="text"], .search-filters input[type="date"], 
        .search-filters select, .search-filters input[type="number"] {
            flex: 1;
            padding: 10px;
            margin: 5px;
            box-sizing: border-box;
        }
        .search-filters button {
            padding: 10px 20px;
            margin: 5px;
        }
        .photo-container {
            display: flex;
            justify-content: space-around;
            margin: 20px;
        }
        .photo {
            width: 200px;
            height: 200px;
            background-color: #007bff;
            display: flex;
            justify-content: center;
            align-items: center;
            color: white;
            font-size: 18px;
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

    <div class="photo-container">
        <div class="photo">대표사진1</div>
        <div class="photo">대표사진2</div>
        <div class="photo">대표사진3</div>
        <div class="photo">대표사진4</div>
    </div>
</body>
</html>
