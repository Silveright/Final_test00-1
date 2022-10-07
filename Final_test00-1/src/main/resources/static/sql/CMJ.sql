drop table Group_Board cascade constraints purge;

CREATE TABLE Group_Board(
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

insert into GROUP_BOARD(BOARD_NUM, BOARD_NAME, BOARD_PASS, BOARD_SUBJECT, BOARD_CONTENT)
VALUES (1, '관리자', 1234, '테스트1', '테스트1입니다.')

delete from group_board

select * from Group_Board;

delete Group_Board where BOARD_NUM = 20;

drop table comments cascade constraints purge;

create table comments(
  num          number       primary key,
  userid           varchar2(30) references user_info(userid),
  content      varchar2(200),
  reg_date     date,
  board_num    number references Group_Board(board_num) 
               on delete cascade 
  );
drop sequence com_seq;
create sequence com_seq;

select * from comments;