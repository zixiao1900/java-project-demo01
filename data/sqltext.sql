-- 创建video表
create table video (
    bv varchar(16) primary key,
    type varchar(2),
    category varchar(16),
    title varchar(32),
    cover varchar(64),
    introduction varchar(255),
    publish_time datetime,
    tags varchar(32)
) default charset=utf8;

-- 将磁盘中的数据导入video
load data local infile
"D:\\JavaCodes\\java-project-demo01\\data\\p.csv"
into table video
fields terminated by ','
lines terminated by '\r\n';

-- 创建play表
create table play (
    id varchar(16),
    title varchar(32),
    url varchar(64),
    duration time,
    bv varchar(16)
) default charset=utf8;

-- 磁盘中的数据追加导入play表
load data local infile
"D:\\JavaCodes\\java-project-demo01\\data\\v_1_mysql.csv"
into table play
fields terminated by ','
lines terminated by '\n';

load data local infile
"D:\\JavaCodes\\java-project-demo01\\data\\v_2_mysql.csv"
into table play
fields terminated by ','
lines terminated by '\n';


