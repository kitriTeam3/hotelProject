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
        <form action="/hotelReservation/goodsdetailregister" method="post" enctype="multipart/form-data">
            <fieldset>
                <legend>객실정보</legend>
                <div class="form-grid">
                    <div>
                        <label for="roomName">객실명:</label>
                        <input type="text" id="tname" name="tname" value="${type.tname}" readonly required>
                    </div>
                    <div>
                        <label for="exp">소개:</label>
                        <input type="text" id="exp" name="${tdetails.exp}" required>
                    </div>
                    <div>
                        <label for="bedtype">침대종류:</label>
                        <select id="bedtype" name="${tdetails.bedtype}" required>
                            <option value="">선택하세요</option>
                            <option value="King_Twin">King_Twin</option>
                            <option value="King">King</option>
                            <option value="Queen">Queen</option>
                            <option value="Double">Double</option>
                            <option value="Single">Single</option>
                        </select>
                    </div>
                    <div>
                        <label for="bedno">침대수:</label>
                        <input type="text" id="bedno" name="${tdetails.bedno}" required>
                    </div>
                    <div>
                        <label for="tview">전망:</label>
                        <input type="text" id="tview" name="${tdetails.tview}" required>
                    </div>
                    <div>
                        <label for="smoke">흡연여부:</label>
                        <input type="radio" id="smokeY" name="${tdetails.smoke}" >Y
                        <input type="radio" id="smokeN" name="${tdetails.smoke}" checked>N
                    </div>
                    <div>
                        <label for="tsize">객실크기:</label>
                        <input type="text" id="tsize" name="${tdetails.tsize}" required>
                    </div>
                    <div>
                        <label for="bathtype">욕실종류:</label>
                        <input type="text" id="bathtype" name="${tdetails.bathtype}" required>
                    </div>
                    <div>
                        <label for="breakfast">조식여부:</label>
                        <input type="radio" id="breakfastY" name="${tdetails.breakfast}">Y
                        <input type="radio" id="breakfastN" name="${tdetails.breakfast}" checked>N
                    </div>
                </div>
            </fieldset>
            
            <div class="form-buttons">
                <input type="button" value="취소" onclick="history.back();">
                <input type="submit" value="등록">
            </div>
        </form>
    </div>
</body>
</html>
