drop schema public cascade;

create schema public;

create table public.city
(
	ct_id serial,
	ct_name character varying(100),
	ct_active boolean default true,
	ct_creation_date timestamp default now(),
	ct_creation_user character varying(20),
	ct_update_date timestamp default now(),
	ct_update_user character varying(20),
	constraint pk_ct_id primary key (ct_id)
);

insert into public.city(ct_name) values('Darkulaib');
insert into public.city(ct_name) values('Aali');

create table public.address
(
	addr_id serial,
	addr_building integer,
	addr_road integer,
	addr_block integer,
	addr_city_id integer,
	addr_active boolean default true,
	addr_creation_date timestamp default now(),
	addr_creation_user character varying(20),
	addr_update_date timestamp default now(),
	addr_update_user character varying(20),
	constraint pk_addr_id primary key (addr_id),
	constraint fk_city_id foreign key (addr_city_id)
	references public.city (ct_id)
);

insert into public.address(addr_building, addr_road, addr_block, addr_city_id) values(22, 33, 44, 1);
insert into public.address(addr_building, addr_road, addr_block, addr_city_id) values(55, 66, 77, 2);
insert into public.address(addr_building, addr_road, addr_block, addr_city_id) values(22, 33, 44, 1);
insert into public.address(addr_building, addr_road, addr_block, addr_city_id) values(55, 66, 77, 2);
insert into public.address(addr_building, addr_road, addr_block, addr_city_id) values(22, 33, 44, 1);
insert into public.address(addr_building, addr_road, addr_block, addr_city_id) values(55, 66, 77, 2);
insert into public.address(addr_building, addr_road, addr_block, addr_city_id) values(22, 33, 44, 1);
insert into public.address(addr_building, addr_road, addr_block, addr_city_id) values(55, 66, 77, 2);
insert into public.address(addr_building, addr_road, addr_block, addr_city_id) values(22, 33, 44, 1);
insert into public.address(addr_building, addr_road, addr_block, addr_city_id) values(55, 66, 77, 2);


create table public.employee
(
	emp_id serial,
    emp_cpr integer,
	emp_name character varying(255),
	emp_age smallint,
    emp_email character varying(255),
    emp_gender character(1),
    emp_mobile integer,
    emp_salary double precision,
	emp_address_id integer,
	emp_active boolean default true,
	emp_creation_date timestamp default now(),
	emp_creation_user character varying(20),
	emp_update_date timestamp default now(),
	emp_update_user character varying(20),
	constraint pk_emp_id primary key (emp_id),
	constraint fk_home_address_id foreign key (emp_address_id)
	references public.address (addr_id)
);

insert into public.employee(emp_cpr, emp_name, emp_age, emp_email, emp_gender, emp_mobile, emp_salary, emp_address_id) values (123456789, 'Hasan', 12, 'hasan.lmra@gmail.com', 'M', 12345678, 400, 1);
insert into public.employee(emp_cpr, emp_name, emp_age, emp_email, emp_gender, emp_mobile, emp_salary, emp_address_id) values (987654321, 'Fatima', 33, 'test@gmail.com', 'F', 987654321, 500, 2);
insert into public.employee(emp_cpr, emp_name, emp_age, emp_email, emp_gender, emp_mobile, emp_salary, emp_address_id) values (123456789, 'Hasan', 12, 'hasan.lmra@gmail.com', 'M', 12345678, 400, 3);
insert into public.employee(emp_cpr, emp_name, emp_age, emp_email, emp_gender, emp_mobile, emp_salary, emp_address_id) values (987654321, 'Fatima', 33, 'test@gmail.com', 'F', 987654321, 500, 4);
insert into public.employee(emp_cpr, emp_name, emp_age, emp_email, emp_gender, emp_mobile, emp_salary, emp_address_id) values (123456789, 'Hasan', 12, 'hasan.lmra@gmail.com', 'M', 12345678, 400, 5);
insert into public.employee(emp_cpr, emp_name, emp_age, emp_email, emp_gender, emp_mobile, emp_salary, emp_address_id) values (987654321, 'Fatima', 33, 'test@gmail.com', 'F', 987654321, 500, 6);
insert into public.employee(emp_cpr, emp_name, emp_age, emp_email, emp_gender, emp_mobile, emp_salary, emp_address_id) values (123456789, 'Hasan', 12, 'hasan.lmra@gmail.com', 'M', 12345678, 400, 7);
insert into public.employee(emp_cpr, emp_name, emp_age, emp_email, emp_gender, emp_mobile, emp_salary, emp_address_id) values (987654321, 'Fatima', 33, 'test@gmail.com', 'F', 987654321, 500, 8);
insert into public.employee(emp_cpr, emp_name, emp_age, emp_email, emp_gender, emp_mobile, emp_salary, emp_address_id) values (123456789, 'Hasan', 12, 'hasan.lmra@gmail.com', 'M', 12345678, 400, 9);
insert into public.employee(emp_cpr, emp_name, emp_age, emp_email, emp_gender, emp_mobile, emp_salary, emp_address_id) values (987654321, 'Fatima', 33, 'test@gmail.com', 'F', 987654321, 500, 10);

create table public.certificate
(
	cert_id serial,
	cert_employee_id integer,
	cert_title character varying(200),
	cert_year integer,
	cert_active boolean default true,
	cert_creation_date timestamp default now(),
	cert_creation_user character varying(20),
	cert_update_date timestamp default now(),
	cert_update_user character varying(20),
	constraint pk_cert_id primary key (cert_id),
	constraint fk_employee_id foreign key (cert_employee_id)
	references public.employee (emp_id)
);

insert into public.certificate(cert_employee_id, cert_title, cert_year) values (1, 'Java', 2005);
insert into public.certificate(cert_employee_id, cert_title, cert_year) values (1, 'Postgres', 2010);
insert into public.certificate(cert_employee_id, cert_title, cert_year) values (2, 'Java EE', 2015);
insert into public.certificate(cert_employee_id, cert_title, cert_year) values (2, 'Struts', 2020);
insert into public.certificate(cert_employee_id, cert_title, cert_year) values (3, 'Java', 2005);
insert into public.certificate(cert_employee_id, cert_title, cert_year) values (3, 'Postgres', 2010);
insert into public.certificate(cert_employee_id, cert_title, cert_year) values (4, 'Java EE', 2015);
insert into public.certificate(cert_employee_id, cert_title, cert_year) values (4, 'Struts', 2020);
insert into public.certificate(cert_employee_id, cert_title, cert_year) values (5, 'Java', 2005);
insert into public.certificate(cert_employee_id, cert_title, cert_year) values (5, 'Postgres', 2010);
insert into public.certificate(cert_employee_id, cert_title, cert_year) values (6, 'Java EE', 2015);
insert into public.certificate(cert_employee_id, cert_title, cert_year) values (6, 'Struts', 2020);
insert into public.certificate(cert_employee_id, cert_title, cert_year) values (7, 'Java', 2005);
insert into public.certificate(cert_employee_id, cert_title, cert_year) values (7, 'Postgres', 2010);
insert into public.certificate(cert_employee_id, cert_title, cert_year) values (8, 'Java EE', 2015);
insert into public.certificate(cert_employee_id, cert_title, cert_year) values (8, 'Struts', 2020);
insert into public.certificate(cert_employee_id, cert_title, cert_year) values (9, 'Java', 2005);
insert into public.certificate(cert_employee_id, cert_title, cert_year) values (9, 'Postgres', 2010);
insert into public.certificate(cert_employee_id, cert_title, cert_year) values (10, 'Java EE', 2015);
insert into public.certificate(cert_employee_id, cert_title, cert_year) values (10, 'Struts', 2020);

create table public.manager
(
	mngr_id integer,
	mngr_degree integer,
	mngr_allowance double precision,
	mngr_creation_date timestamp default now(),
	mngr_creation_user character varying(20),
	mngr_update_date timestamp default now(),
	mngr_update_user character varying(20),
	constraint pk_mngr_id primary key (mngr_id),
	constraint fk_mngr_id foreign key (mngr_id)
	references public.employee (emp_id)
);

insert into public.manager(mngr_id, mngr_degree, mngr_allowance) values(1, 2, 300);
insert into public.manager(mngr_id, mngr_degree, mngr_allowance) values(2, 3, 600);
insert into public.manager(mngr_id, mngr_degree, mngr_allowance) values(3, 2, 300);
insert into public.manager(mngr_id, mngr_degree, mngr_allowance) values(4, 3, 600);
insert into public.manager(mngr_id, mngr_degree, mngr_allowance) values(5, 2, 300);
insert into public.manager(mngr_id, mngr_degree, mngr_allowance) values(6, 3, 600);
insert into public.manager(mngr_id, mngr_degree, mngr_allowance) values(7, 2, 300);
insert into public.manager(mngr_id, mngr_degree, mngr_allowance) values(8, 3, 600);
insert into public.manager(mngr_id, mngr_degree, mngr_allowance) values(9, 2, 300);
insert into public.manager(mngr_id, mngr_degree, mngr_allowance) values(10, 3, 600);

create table public.chief_executive_officer
(
	ceo_id int,
	ceo_sector character varying(200),
	constraint pk_ceo_id primary key (ceo_id),
	constraint fk_ceo_id foreign key (ceo_id)
	references public.manager (mngr_id)
);