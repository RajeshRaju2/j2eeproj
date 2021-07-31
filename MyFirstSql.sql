select round(sysdate,'year') from dual;
select round(sysdate,'month') from dual;
select trunc(sysdate,'year') from dual;
select trunc(sysdate,'month') from dual;
select sysdate from dual;
select to_char(hiredate,'ddth"of" mon yyyy') from emp;
select to_char(sal,'$99,999.00')from emp;
select 10000||20 from dual;


NVL(exp1,exp2)-- if e1==null then e2 else e1
NVL2(exp1,exp2,exp3)--if e1 = null then e3 else e2
NULLIF(exp1,exp2) -- if e1=e2 then null else e1
select ename,comm,nvl(comm,100)from emp;
select ename ,comm,nvl2(comm,comm+100,200)from emp;
select ename,job, sal,
case job when 'MANAGER' then SAL*5
         when  'ANALYST'then SAL*10
              ELSE SAL
              END "REVISED SALARY"
              FROM emp;
              
select ename,job,sal,
DECODE(job,'MANAGER',sal*2,
        'ANALYST',sal*5,sal)"REVISED SALARY"
        from emp;
select sum(sal),count(*),min(sal),max(sal),avg(sal) from emp;
select count(nvl(comm,0))from emp;

select job,deptno from emp group by deptno,job,comm order by deptno;
select min(sal),deptno dn from emp where sal>900 group by deptno having min(sal)>900
order by dn;


--1) Write a query to find the employee names who is earning sal in 4 digits
select* from emp where sal>999 and sal<10000;
--2) Write a query to find out emps whose sal is an odd number.
select * from emp where ;
--3) List the names of the employee whose name contains letter 'O'
select ename from emp where ename like '%O%';
--4) Produce the following output
--        SMITH(CLERK)
--        ALLEN(SALESMAN)
select ename||'('||job||')'from emp;
--5) List the employee names with hire date in the format April, 4,1999
select ename,to_char(hiredate,'month, dd, yyyy')from emp;
--6) Write a query to display the day of the week (like WEDNESDAY,FRIDAY...) for any date which is 
--entered i  the format DD-MM-YY. Use emp table
select datename(weekday,[hiredate]) from emp;
--7) List all employees in the emp table who joined in the month of FEB
select month(hiredate) from emp;
--8) Print the name of the employee who is earning highest salary
select ename, sal from emp where sal==max(sal);

-- natural join
select ename,job,sal,dname from emp natural join dept;
-- equi join
select ename,job,sal,deptno,dname from emp join dept using(deptno);

select e.ename,e.job,e.sal,e.deptno,d.dname from emp e join dept d  on e.deptno=d.deptno where job='MANAGER'

-- non equi join
select e.ename,e.job,e.sal,e.deptno,d.dname from emp e join dept d  on e.deptno>10;


--left,right,full outer join

select e.ename,e.job,e.sal,e.deptno,d.dname from emp e left outer join dept d on e.deptno=d.deptno;
select e.ename,e.job,e.sal,e.deptno,d.dname from emp e right outer join dept d on e.deptno=d.deptno;
select e.ename,e.job,e.sal,e.deptno,d.dname from emp e full outer join dept d on e.deptno=d.deptno;

-- self join

select m.ename || ' is manager of '|| e.ename "Manager Details" from emp e join emp m
on e.mgr=m.empno;

--cross join

select e.ename ,e.deptno,d.dname from emp e cross join dept d;



--single row subquery
select ename from emp where sal=(select max(sal) from emp);

--multiple row subquery
--1) Write a query to find the employees whose salary is equal to the salary of atleast one employee in depart 30?
select e.ename , d.dname , e.sal , e.deptno
from emp e join dept d 
on sal in(select sal from emp where deptno=30) and e.deptno=d.deptno;
2) Write a query to find the employees whose salary is greater than the salary of atleast one employee in depart 30?
select e.ename,d.dname,e.sal,d.deptno
 from emp e join dept d
 on sal > any(select sal from emp where deptno=30) and e.deptno=d.deptno;
 3) Write a query to find the employees whose salary is less  than the salary of atleast one employee in depart 30?
 select e.ename,e.job,e.sal,e.deptno
 from emp e
 where sal < any(select sal from emp where deptno=30) ;
 4) Write a query to find the employees whose salary is less  than the salary of all of the employee in depart 30?
 select e.ename,e.job,e.sal,e.deptno
 from emp e 
 where sal < all(select sal from emp where deptno=30) ;
 --1.Write a query to list the department names which have at least one employee.
 select dname from dept d where exists(select * from emp where emp.deptno=d.deptno) ;

Select * from mphemp;





create table mphsemp (eid number constraint mphsemp_eid_pk primary key,ename varchar2(20),dept varchar2(20));

insert into mphsemp values(13,'Rajesh','IT');

select * from mphsemp;

delete from mphsemp ;

commit;

create table valid (eid number constraint valid_eid_pk primary key,pass varchar2(20));

insert into valid values(10,'Raju');

select * from valid ;
select * from valid where eid=13;

create table valid (eid number constraint valid_eid_pk primary key,ename varchar2(40),pass varchar2(20),phone-no number);

drop table valid;

