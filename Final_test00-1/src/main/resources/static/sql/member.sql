drop table k_member purge

create table k_member (
	userid varchar2(100) not null,
	password varchar2(50)not null,
	gender varchar2(5)	 not null,
	email  varchar2(100) not null,
	area_name varchar2(100) not null,
	joindate date not null
)

select * from k_member

insert into k_member
values ('admin',123, '남', 'admin@naver.com', '서울','2022-09-09')