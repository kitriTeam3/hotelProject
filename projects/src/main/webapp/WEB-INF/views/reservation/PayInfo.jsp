<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"  pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Payment Form</title>
 <style>
        body {
            font-family: Arial, sans-serif;
        }
        form {
            width: 300px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            background-color: #f9f9f9;
        }
        label {
            display: block;
            margin-top: 10px;
        }
        input[type="text"],
        select,
        textarea {
            width: calc(100% - 20px);
            padding: 8px 10px;
            margin-top: 5px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="text"].highlight {
            background-color: #e6f7ff;
        }
        textarea {
            height: 60px;
            resize: none;
        }
        button {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>

</head>
<body>
    <form action="payInfo" method="POST" >
    
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
        <input type="text" id="price" name="price" value="${price}" >\\<br><br>

        <button type="submit">결제완료</button>
    </form>
</body>
</html>
