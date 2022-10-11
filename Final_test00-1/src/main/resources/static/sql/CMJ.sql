drop table Group_Board cascade constraints purge;

CREATE TABLE Group_Board(
	GROUP_NO number,
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

select * from 
		  ( select rownum rnum, b.*
		    from 
		         (select Group_Board.*, nvl(cnt,0) cnt
                  from 
                  Group_Board   left outer join (select board_num, count(*) cnt
                                            from COMMENTS
                                            group by board_num) c
                  on Group_Board.board_num = c.board_num
                  order by Group_Board.board_num desc) b
             where rownum <=10 
             and group_no = 4  
		   ) 
	     where rnum >= 1 and rnum  <=10


insert into GROUP_BOARD(BOARD_NUM, BOARD_NAME, BOARD_PASS, BOARD_SUBJECT, BOARD_CONTENT, BOARD_DATE)
VALUES (2, '관리자', 1234, '테스트2', '테스트2입니다.', sysdate)

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

<update id="boardModify">
	  update Group_Board
	  set 
		     BOARD_SUBJECT=#{BOARD_SUBJECT},
		     BOARD_CONTENT=#{BOARD_CONTENT},
		     BOARD_FILE=#{BOARD_FILE, jdbcType=VARCHAR}, 
		     BOARD_ORIGINAL=#{BOARD_ORIGINAL, jdbcType=VARCHAR}
	  where  BOARD_NUM=#{BOARD_NUM}
	</update>
	
	update group_board set board_subject='살려주세요2'
			where board_num=12;