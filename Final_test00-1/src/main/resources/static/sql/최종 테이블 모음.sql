-- 최종 테이블 모음(수정X)

-- 회원정보
drop table user_info CASCADE CONSTRAINTS;
create table user_info (
	userid			varchar2(100) not null,
	name			varchar2(50) not null,
	gender			varchar2(5) not null,
	age				number(2)	not null,
	password 		varchar2(60) not null,
	email			varchar2(100) not null,
	area_name		varchar2(100) not null,
	joindate		date not null,
	auth		 varchar2(50) not null,	
	primary key(userid)
);

select * from user_info;


-- 모임 정보
drop table group_info CASCADE CONSTRAINTS;
CREATE TABLE group_info (
   group_no   		number   		NOT NULL primary key,
   group_name   	varchar2(100)   NOT NULL,
   group_content   	varchar2(1000)  NOT NULL,
   group_original   varchar2(100)   NOT NULL,
   group_img   		varchar2(100)   NOT NULL,
   area_name   		varchar2(100)   NOT NULL,
   catename   		varchar2(100)   NOT NULL,
   opendate  		date   			NOT NULL,
   userid   		varchar2(100)   NOT NULL 
   					references user_info(userid)  
               		on delete cascade
);

select * from group_info;


-- 모임 내 역할
drop table group_user_role CASCADE CONSTRAINTS;
create table group_user_role (
	group_role_no	number not null,
	userid			varchar2(100) not null,
	group_no		number not null references group_info(group_no)  
					on delete cascade,
	group_role		number not null,
	primary key(group_role_no)
);

select * from group_user_role;



-- 모임 일정
drop table group_schedule CASCADE CONSTRAINTS;
create table group_schedule (
	calendar_no		number not null,
	group_no		number not null,
	title			varchar2(100) not null,
	subject			varchar2(100) not null,
	content			varchar2(1000) not null,
	startdate		date not null,
	location		varchar2(100) not null,
	xcoord			varchar2(100) null,
	ycoord			varchar2(100) null,
	primary key(calendar_no)
);

select * from group_schedule;


-- 가입 승인 요청
drop table group_join_request CASCADE CONSTRAINTS;
create table group_join_request (
	group_join_no	number	not null,
	userid			varchar2(100) not null,
	group_no		number not null,
	primary key(group_join_no)
);

select * from group_join_request;


--그룹 내 게시판
drop table Group_Board CASCADE CONSTRAINTS;
CREATE TABLE Group_Board(
	GROUP_NO 		NUMBER,
	BOARD_NUM       NUMBER,         --글 번호
	BOARD_NAME      VARCHAR2(30),   --작성자
	BOARD_PASS      VARCHAR2(30),   --비밀번호
	BOARD_SUBJECT   VARCHAR2(300),  --제목
	BOARD_CONTENT   VARCHAR2(4000), --내용
	BOARD_FILE      VARCHAR2(50),   --첨부 파일 명(가공)
	BOARD_ORIGINAL  VARCHAR2(50),   --첨부 파일 명
	BOARD_READCOUNT NUMBER,    --글의 조회수
	BOARD_DATE DATE,           --글의 작성 날짜
	PRIMARY KEY(BOARD_NUM)
);

select * from Group_Board;

--그룹 내 게시판 댓글
drop table comments CASCADE CONSTRAINTS;
create table comments(
  num          number       primary key,
  userid       varchar2(30), --references user_info(userid), 10/17일 수정사항
  content      varchar2(200),
  reg_date     date,
  board_num    number references Group_Board(board_num) 
               on delete cascade 
);
select * from comments;

-- 시퀀스
drop sequence JOIN_SEQ;

drop sequence role_seq;

drop sequence calendar_seq;

drop sequence com_seq;

create sequence JOIN_SEQ;

create sequence role_seq;

create sequence calendar_seq;

create sequence com_seq;


update user_info
set auth='ROLE_ADMIN'
where userid = 'admin';