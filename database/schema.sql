-- operate of system table
create table if not exists tb_os (
	id bigint not null auto_increment,
	-- code of os
	os_code varchar(255) default null,
	-- os of name
	os_name varchar(255) default null,
	-- os of version
	os_version varchar(100) default null,
	-- device type of os
	device_type varchar(255) default NULL,
	-- device code of os
	device_code varchar(255) default null,
	-- body of os
	body  varchar(1000) default null,
	-- Time the operate
	create_date timestamp default 0,
	-- status.
	status int default 0,
	primary key (id)
);

-- logs of system table
create table if not exists tb_os_log (
	id bigint not null auto_increment,
	-- account of os
	account varchar(100) default null,
	-- id of unit
	unit_id bigint(10) default 0,
	-- id of shop
	shop_id bigint(10) default 0,
	-- code of os
	os_code varchar(255) default null,
	-- type of os
	os_type varchar(100) default null,
	-- type of operate
	op_type varchar(100) default null,
	-- operate of flg
	flg varchar(100) default null,
	-- content of operate
	content varchar(2000),
	-- Time the operate
	create_date timestamp default 0,
	-- status.
	status int default 0,
	primary key (id)
);