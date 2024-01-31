CREATE TABLE USER_TBL (
	user_id	NUMBER	NOT NULL PRIMARY KEY,
	email VARCHAR2(30) NOT NULL UNIQUE,	
	nickname VARCHAR2(30) NOT NULL UNIQUE,	
	profile_image	VARCHAR2(30) NULL,
	status	VARCHAR2(3)	NOT NULL,
	regdate	DATE NOT NULL,
	birth DATE NOT NULL
);
CREATE TABLE SERVER_TBL (
	server_id NUMBER NOT NULL PRIMARY KEY,
	user_id NUMBER NOT NULL,
	server_name	VARCHAR2(50) NOT NULL,
	regdate	DATE NOT NULL,
	user_total	NUMBER NOT NULL	,
	CONSTRAINT fk_user_id foreign key(user_id) references USER_TBL (user_id)
);
CREATE TABLE USER_SERVER_TBL (
	server_id NUMBER NOT NULL,	
	user_id	NUMBER	NOT NULL,
	CONSTRAINT fk_user_server_id foreign key(user_id) references USER_TBL (user_id),
	CONSTRAINT fk_user_server_sid foreign key(server_id) references SERVER_TBL (server_id)
);

CREATE TABLE CHANNEL_TBL (
	channel_id	NUMBER NOT NULL	PRIMARY KEY,
	user_id NUMBER NOT NULL,
	channel_name VARCHAR2(50) NOT NULL,
	CONSTRAINT fk_CHANNEL_id foreign key(user_id) references USER_TBL (user_id)
);

CREATE TABLE USER_CHANNEL_TBL (
	user_id	NUMBER	NOT NULL ,
	channel_id	NUMBER	NOT NULL,
	CONSTRAINT fk_user_channel_id foreign key(user_id) references USER_TBL (user_id),
	CONSTRAINT fk_user_channel_cid foreign key(channel_id) REFERENCES CHANNEL_TBL(channel_id)
);
BEGIN
  FOR i IN 1..10 LOOP
    INSERT INTO USER_TBL (user_id, email, nickname, profile_image, status, regdate, birth)
    VALUES (i, 'user' || i || '@example.com', 'user' || i, 'profile' || i || '.jpg', 'no', SYSDATE, TO_DATE('19900101', 'YYYYMMDD'));
  END LOOP;
END;
-- SERVER_TBL에 더미 데이터 삽입
BEGIN
  FOR i IN 1..10 LOOP
    INSERT INTO SERVER_TBL (server_id, user_id, server_name, regdate, user_total)
    VALUES (i, i, 'server' || i, SYSDATE, 100);
  END LOOP;
END;
-- USER_SERVER_TBL에 더미 데이터 삽입
BEGIN
  FOR i IN 1..10 LOOP
    INSERT INTO USER_SERVER_TBL (server_id, user_id)
    VALUES (i, i);
  END LOOP;
END;
-- CHANNEL_TBL에 더미 데이터 삽입
BEGIN
  FOR i IN 1..10 LOOP
    INSERT INTO CHANNEL_TBL (channel_id, user_id, channel_name)
    VALUES (i, i, 'channel' || i);
  END LOOP;
END;

-- USER_CHANNEL_TBL에 더미 데이터 삽입
BEGIN
  FOR i IN 1..10 LOOP
    INSERT INTO USER_CHANNEL_TBL (user_id, channel_id)
    VALUES (i, i);
  END LOOP;
END;

