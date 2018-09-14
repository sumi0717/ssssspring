-- 상품 테이블, 업데이트 (수정이 일어난다.
CREATE TABLE shop(
	num NUMBER PRIMARY KEY, --상품번호
	name VARCHAR2(30), --상품이름
	price NUMBER, --상품가격
	remainCount NUMBER CHECK(remainCount >= 0) --재고갯수 
);

CREATE TABLE reservation(
	kaoId VARCHAR2(100) PRIMARY KEY,
	phone VARCHAR2(100),
	dogSize VARCAHR(100),
	timeSlot VARCHAR2(100),
	cctv boolean	
);

-- 고객 계좌 테이블, 업데이트 (수정이 일어난다
CREATE TABLE client_account(
	id VARCHAR2(30) PRIMARY KEY, -- 고객의 아이디
	money NUMBER CHECK(money >= 0), -- 고객의 잔고 
	point NUMBER
);

-- 주문 테이블, 인설트( 로우가 1줄 늘어남
CREATE TABLE client_order(
	num NUMBER PRIMARY KEY, -- 주문번호
	id VARCHAR2(30), -- 주문 고객의 아이디
	code NUMBER, -- 주문한 상품의 번호 
	addr VARCHAR2(50) -- 배송 주소
);

--주문 테이블에 사용할 시퀀스
CREATE SEQUENCE client_order_seq;

--sample 데이터
INSERT INTO shop (num,name,price,remainCount)
VALUES(1, '사과', '1000', 5);

INSERT INTO shop (num,name,price,remainCount)
VALUES(2, '바나나', '2000', 5);

INSERT INTO shop (num,name,price,remainCount)
VALUES(3, '귤', '3000', 5);


INSERT INTO client_account (id, money, point)
VALUES('superman', 10000, 0);

INSERT INTO client_account (id, money, point)
VALUES('batman', 10000, 0);


SELECT * FROM CLIENT_ACCOUNT;

----- Users 테이블에 profile 이미지를 저장할 칼럽 추가
ALTER TABLE users ADD(profileImage VARCHAR2(100));

