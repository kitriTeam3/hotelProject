<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>객실 등록</title>
	<link href="${path}/resource/css/goodsregister.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="form-container">
        <h2>객실 등록</h2>
        <form action="/hotelReservation/goodsregister" method="post" enctype="multipart/form-data">
            <fieldset>
                <legend>업체정보</legend>
                <div class="form-grid">
                    <div>
                        <label for="hotelname">업체명:</label>
                        <input type="text" id="hname" name="hname" value="${hotel.hphone}" readonly required>
                    </div>
                    <div>
                        <label for="location">지역:</label>
                        <select id="location" name="${update.location}" required>
                            <option value="">선택하세요</option>
                            <option value="Gangnam">서울시 강남구</option>
                            <option value="Jongro">서울시 종로구</option>
                            <option value="Mapo">서울시 마포구</option>
                            <option value="Seocho">서울시 서초구</option>
                            <option value="Songpa">서울시 송파구</option>
                        </select>
                    </div>
                    <div>
                        <label for="phoneNumber">전화번호:</label>
                        <input type="text" id="hphone" name="hphone" value="${hotel.hphone}" readonly required>
                    </div>
                    <div>
                        <label for="grade">등급:</label>
                        <select id="grade" name="${update.grade}" required>
                            <option value="">선택하세요</option>
                            <option value="1">1성급</option>
                            <option value="2">2성급</option>
                            <option value="3">3성급</option>
                            <option value="4">4성급</option>
                            <option value="5">5성급</option>
                        </select>
                    </div>
                </div>
            </fieldset>
            
            <fieldset>
                <legend>객실정보</legend>
                <div class="form-grid">
                    <div>
                        <label for="roomName">객실명:</label>
                        <input type="text" id="tname" name="${type.tname}" required>
                    </div>
                    <div>
                        <label for="capacity">인원:</label>
                        <select id="max" name="${type.max}" required>
                            <option value="">선택하세요</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </div>
                    <div>
                        <label for="price">가격:</label>
                        <input type="text" id="tprice" name="${type.tprice}" required>
                    </div>
                    <div>
                        <label for="roomCount">객실 수:</label>
                        <input type="text" id="amounts" name="${type.amounts}" required>
                    </div>
                </div>
            </fieldset>
            
            <div class="full-width">
                <label for="roomImage">객실사진:</label>
                <input type="file" id="tpicture" name="tpicture" required>
            </div>
            
            <div class="form-buttons">
                <input type="button" value="취소" onclick="history.back();">
                <input type="submit" value="등록">
            </div>
        </form>
    </div>
</body>
</html>
