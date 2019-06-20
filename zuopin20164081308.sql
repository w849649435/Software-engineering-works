CREATE DATABASE IF NOT EXISTS zuopin20164081308;
USE zuopin20164081308;


 drop table if exists Contacts;
 create table Contacts(
     contactsNo varchar(13) not null primary key comment '会员编号',
     contactsName varchar(20) comment '会员姓名'
     )default charset=utf8 comment = '会员表';

 INSERT INTO Contacts (contactsNo,contactsName) VALUES 
 ('01','会员一号'),
 ('02','会员二号'),
 ('03','吴先生'),
 ('04','张先生'),
 ('05','李女士'),
 ('06','营业员');



drop table if exists Member;
 create table Member(
     memberid int not null primary key comment '会员编号',
     username varchar(40) comment '用户名',
     title varchar(40) comment '标题',
     email varchar(50) comment '邮件',
	 context varchar(400) comment '内容',
	 magdate varchar(10) comment '日期',
	 contactsNo varchar(13) )default charset=utf8 comment = '会员表';


 insert into Member values(1001,"吴先生","好好学习","天天向上","认真专注","1997-04-06",'01');
 insert into Member values(1002,"李先生","好好学习","天天向上","认真专注","1997-04-06",'02');
 insert into Member values(1003,"王先生","好好学习","天天向上","认真专注","1997-04-06",'03');
 insert into Member values(1004,"等先生","好好学习","天天向上","认真专注","1997-04-06",'04');
 insert into Member values(1005,"王先生","好好学习","天天向上","认真专注","1997-04-06",'05');
 insert into Member values(1006,"邹女士","好好学习","天天向上","认真专注","1997-04-06",'06');
 insert into Member values(1007,"吴先生","好好学习","天天向上","认真专注","1997-04-06",'07');
 insert into Member values(1008,"邹先生","好好学习","天天向上","认真专注","1997-04-06",'08');








DROP TABLE IF EXISTS `loginfo`;
CREATE TABLE `loginfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(20) DEFAULT NULL,
  `logintime` datetime DEFAULT NULL,
   shebei  varchar(10) DEFAULT NULL,
   operation  varchar(1000) DEFAULT NULL,
   ip  varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;



INSERT INTO `loginfo` (`id`,`userid`,`logintime`,shebei,operation,ip) VALUES 
 (1,'admin','2015-11-18 18:11:06','PC端登录','进行登陆','127.0.0.1'),
 (2,'admin','2015-11-18 18:11:32','PC端登录','进行登陆','127.0.0.1'),
 (3,'admin','2015-11-18 20:43:34','PC端登录','进行登陆','127.0.0.1'),
 (4,'admin','2015-11-18 20:52:48','PC端登录','进行登陆','127.0.0.1'),
 (5,'admin','2019-05-04 10:25:24','PC端登录','进行登陆','127.0.0.1'),
 (6,'admin','2019-05-04 10:34:32','PC端登录','进行登陆','127.0.0.1');


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userID` varchar(20) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `userType` char(2) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `contactsNo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;



INSERT INTO `user` (`userID`,`userName`,`password`,`email`,`userType`,`photo`,`contactsNo`) VALUES 
 ('admin','张三','c4ca4238a0b923820dcc509a6f75849b','3@126.com','01',NULL,NULL),
 ('1','cde','c4ca4238a0b923820dcc509a6f75849b','1@163.com','02','20121015194055.JPG','01'),
 ('20074071003','ert','c4ca4238a0b923820dcc509a6f75849b','1@163.com','02',NULL,'02'),
 ('4','ghi','c4ca4238a0b923820dcc509a6f75849b','2@tom.com','02',NULL,'02'),
 ('5','ijk','c4ca4238a0b923820dcc509a6f75849b','3@126.com','02',NULL,'02'),
 ('6','abc','c4ca4238a0b923820dcc509a6f75849b','1@163.com','02',NULL,'02'),
 ('g001','abc','c4ca4238a0b923820dcc509a6f75849b','1@163.com','02',NULL,'02');




