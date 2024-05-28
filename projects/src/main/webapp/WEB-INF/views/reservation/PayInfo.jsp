<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"  pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Payment Form</title>
</head>
<body>
    <form action="payInfo" method="POST" >
        <%
         int price = (Integer)request.getAttribute("price");
        %>
        <p>[결제 가능] VISA Master American Express</p>

        <label for="cardco">결제 방법 선택</label><br>
        <select id="cardco" name="cardco">
            <option value="">카드 선택</option>
            <option value="VISA">VISA</option>
            <option value="MASTER">Master</option>
            <option value="AMEX">American Express</option>
        </select><br><br>

        <label for="cardno">카드 번호</label><br>
        <input type="text" id="cardno" name="cardNumber" required><br><br>

        <label for="expiredate">카드 만료일</label>
        <label for="cvc" style="margin-left: 60px;">CVC 번호</label><br>
        <input type="text" id="expiredate" name="expiredate" required style="width: 100px;">
        <input type="text" id="cvcno" name="cvcno" required style="width: 50px; margin-left: 10px;"><br><br>

        <label for="price">결제 총 금액</label>
      		<br>${price}<br> 원<br><br>

        <button type="submit">결제완료</button>
    </form>
</body>
</html>
