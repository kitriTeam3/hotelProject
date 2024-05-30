<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>���� Ȯ�μ�</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            width: 300px;
            margin: 0 auto;
            border: 1px solid #ccc;
            padding: 20px;
        }
        .notification {
            background-color: #dff0d8;
            color: #3c763d;
            padding: 10px;
            margin-bottom: 20px;
        }
        .field {
            margin-bottom: 15px;
        }
        .label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }
        .input {
            width: 100%;
            padding: 5px;
            box-sizing: border-box;
        }
        .hotel-info {
            display: flex;
            align-items: center;
            margin-bottom: 15px;
        }
        .hotel-photo {
            width: 60px;
            height: 60px;
            background-color: #eee;
            margin-right: 10px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 12px;
            color: #aaa;
        }
        .hotel-details {
            flex-grow: 1;
        }
        .hotel-details .input {
            margin-bottom: 5px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="notification">
            ���� Ȯ�μ��� �߼۵Ǿ����ϴ�. �̸��� ���� �����Կ��� Ȯ���� �� ���� ��� ���� �����Ե� Ȯ���� ���ñ� �ٶ��ϴ�.
        </div>
        <div class="field">
            <label class="label">�����ȣ</label>
            <input type="text" class="input" name="reservation_number" 
            value="${rid}" readonly>
        </div>
        <div class="field">
            <label class="label">��������</label>
            <input type="text" class="input" name="reservation_date"
               value="${rdate}" readonly>
        </div>
        <div class="hotel-info">
            <div class="hotel-photo">
                ȣ�ڻ���
            </div>
            <div class="hotel-details">
                <div class="field">
                    <label class="label">ȣ�ڸ�</label>
                    <input type="text" class="input" name="hotel_name"
                        value="${hname}" readonly>
                </div>
                <div class="field">
                    <label class="label">��ġ</label>
                    <input type="text" class="input" name="hotel_location"
                     value="${location}" readonly>
                </div>
            </div>
        </div>
        <div class="field">
            <label class="label">�����ݾ�</label>
            <input type="text" class="input" name="payment_amount"
                  value="${tprice}" readonly>
        </div>
    </div>
</body>
</html>
