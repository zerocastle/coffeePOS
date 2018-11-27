/*
 * //DBMS : mariaDB   디비이름 : coffee   비밀번호 : 123456
 * 
 */


//직원 테이블 생성
create table coffee.employee(
	eNum varchar(12) primary key,
	ePhone varchar(12) ,
	eName varchar(12),
	ePqy int(7),
	ePart varchar(4)
	);