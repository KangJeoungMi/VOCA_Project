-- 회원가입
-- 이름 		name
-- 아이디		id
-- 비밀번호	pw
-- 전화번호	tel
-- 이메일		email
CREATE TABLE Login(
	name 	VARCHAR2(100) NOT NULL,
	id		VARCHAR2(100) NOT NULL,
	pw		VARCHAR2(100) NOT NULL,
	tel		VARCHAR2(100) NOT NULL,
	email	VARCHAR2(100) NOT NULL
);

INSERT INTO Login VALUES ('강정미','exvoca','1234','01071426241','exvoca@email.com');
INSERT INTO Login VALUES ('관리자','admin','admin','null','null');
SELECT * FROM Login;
UPDATE Login SET name='강정미', id='exvoca', pw='1234', tel='010-7142-6241', email='exvoca@email.com' 
WHERE name='강정미'AND id='exvoca' AND  pw='1234' and tel='01071426241' and email='exvoca@email.com';
DELETE FROM login WHERE name='dd';
      


 SELECT DISTINCT CategoryName FROM category;
CREATE TABLE Category (
    CategoryName NVARCHAR2(100)	PRIMARY KEY
);
CREATE TABLE Word (
    KoreanWord NVARCHAR2(100),
    EnglishWord NVARCHAR2(100),
    CategoryName NVARCHAR2(100),
    FOREIGN KEY (CategoryName) REFERENCES Category(CategoryName)
);
SELECT * FROM word;
SELECT * FROM category;
SELECT KoreanWord, EnglishWord FROM Word WHERE CategoryName='초등단어';
SELECT KoreanWord, EnglishWord FROM Word WHERE CategoryName='중등단어';
SELECT * FROM WORd WHERE CategoryName='초등단어';
SELECT DISTINCT CategoryName FROM Word WHERE CategoryName='초등단어'; 
      
INSERT INTO Category (CategoryName) VALUES ('초등단어');
INSERT INTO Category (CategoryName) VALUES ('중등단어');
INSERT INTO Word (KoreanWord, EnglishWord, CategoryName) VALUES ('한글', 'korea', '초등단어');
INSERT INTO Word (KoreanWord, EnglishWord, CategoryName) VALUES ('영어', 'english', '초등단어');

INSERT INTO Word (KoreanWord, EnglishWord, CategoryName) VALUES('가방', 'bag','중등단어');
INSERT INTO Word (KoreanWord, EnglishWord, CategoryName) VALUES('공', 'ball','중등단어');

        
      