--테이블 생성용 (수정x)
drop table user_info purge --CASCADE CONSTRAINTS;
create table user_info (
   userid         varchar2(100) not null,
   name         varchar2(50) not null,
   gender         varchar2(5) not null,
   age            number(2)   not null,
   password       varchar2(60) not null,
   email         varchar2(100) not null,
   area_name      varchar2(100) not null,
   joindate      date not null,
   auth       varchar2(50) not null,   
   primary key(userid)
);

create sequence role_seq

select * from group_user_role


update user_info
set auth='ROLE_ADMIN'
where userid = 'admin';

select * from user_info;

drop table group_info purge
delete from group_info
CREATE TABLE group_info (
	group_no	number	NOT NULL,
	group_name	varchar2(100)	NOT NULL,
	group_content	varchar2(1000)	NOT NULL,
	group_original	varchar2(100)	NOT NULL,
	group_img	varchar2(100)	NOT NULL,
	area_name	varchar2(100)	NOT NULL,
	catename	varchar2(100)	NOT NULL,
	opendate	date	NOT NULL,
	userid	varchar2(100)	NOT NULL
);

select * from group_user_role

drop table group_user_role CASCADE CONSTRAINTS;
create table group_user_role (
   group_role_no   number not null,
   userid         varchar2(100) not null,
   group_no       number not null references group_info(group_no)  
               on delete cascade ,
   group_role      number not null,
   primary key(group_role_no)
);

drop table group_join_request purge
CREATE TABLE group_join_request (
	group_join_no	number		NOT NULL,
	userid	varchar2(100)		NOT NULL,
	group_no	number		NOT NULL
);
select * from group_schedule
drop table group_schedule purge
drop sequence calendar_seq
create sequence calendar_seq
CREATE TABLE group_schedule (
	calendar_no	number		NOT NULL,
	group_no	number		NOT NULL,
	title	varchar2(100)		NOT NULL,
	subject	varchar2(100)		NOT NULL,
	content	varchar2(1000)		NOT NULL,
	startdate	date		NOT NULL,
	location	varchar2(100)		NOT NULL,
	xcoord	varchar2(100)		NULL,
	ycoord	varchar2(100)		NULL
);

drop table post_group purge
CREATE TABLE post_group (
	post_no	number		NOT NULL,
	group_no	number		NOT NULL,
	subject	varchar2(100)		NOT NULL,
	content	varchar2(1000)		NOT NULL,
	userid	varchar2(100)		NOT NULL,
	writedate	date		NOT NULL
);

drop table post_reply purge
CREATE TABLE post_reply (
	reply_no	number		NOT NULL,
	content	varchar2(1000)		NOT NULL,
	writedate	date		NOT NULL,
	userid	varchar2(100)		NOT NULL,
	post_no	number		NOT NULL
);

drop table notice purge
CREATE TABLE notice (
	notice_no	number		NOT NULL,
	subject	varchar2(100)		NOT NULL,
	content	varchar2(1000)		NOT NULL,
	writedate	date		NOT NULL,
	notice_file_original	varchar2(100)		NULL,
	notice_file	varchar2(100)		NULL,
	userid	varchar2(100)		NOT NULL,
	group_no	number		NOT NULL
);

CREATE TABLE group_join_request (
	group_join_no	number	NOT NULL,
	userid	varchar2(100)	NOT NULL,
	group_no	number	NOT NULL
);

select * from group_join_request

create sequence JOIN_SEQ

insert into group_join_request(group_join_no, userid, group_no) 
values (JOIN_SEQ.nextval, 'test3', 1)

insert into group_join_request(group_join_no, userid, group_no) 
values (JOIN_SEQ.nextval, 'test2', 1)

insert into group_join_request(group_join_no, userid, group_no) 
values (JOIN_SEQ.nextval, 'test1', 1)

insert into group_join_request(group_join_no, userid, group_no) 
values (JOIN_SEQ.nextval, 'test4', 1)
