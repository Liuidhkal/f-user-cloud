/*
SQLyog Enterprise v12.5.0 (64 bit)
MySQL - 5.7.28 : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `tab_dept` */

DROP TABLE IF EXISTS `tab_dept`;

CREATE TABLE `tab_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `tab_dept` */

insert  into `tab_dept`(`id`,`name`) values 
(1,'软件部'),
(2,'测试部'),
(3,'财务部'),
(4,'人事部');

/*Table structure for table `tab_user` */

DROP TABLE IF EXISTS `tab_user`;

CREATE TABLE `tab_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(32) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `telephone` varchar(11) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `isadmin` tinyint(1) DEFAULT '0',
  `dept_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;

/*Data for the table `tab_user` */

insert  into `tab_user`(`uid`,`username`,`password`,`name`,`birthday`,`sex`,`telephone`,`email`,`status`,`code`,`isadmin`,`dept_id`) values 
(1,'malong','2','mal','2019-06-19','女','010-1234567','malong@163.com','Y','57fdfb86837c4888b12411b89eba00e1',NULL,3),
(2,'lgl','1','刘国梁','1977-10-26','男','13234342434','liuguoliang@qq.com','Y','1e9d9337a40e423eaeb4987aad0c2bfe',NULL,NULL),
(3,'zjk','1','张继科','2019-08-16','男','12345678909','zjk@qq.com','Y',NULL,NULL,NULL),
(5,'fzd','1','樊振东','2019-08-07','男','13234342434','fzd@qq.com','Y',NULL,NULL,NULL),
(38,'zsf','1','张三丰','2019-08-20','男','13234342434','zsf@163.com','Y','78d67a65e3804cd89a4b2ee62dbc6f2e',NULL,3),
(39,'zwj','1','张无忌','2019-07-31','男','13234342434','zwj@163.com','Y',NULL,NULL,NULL),
(40,'lhc','1','令狐冲','2019-08-15','男','13234342434','lhc@qq.com','Y',NULL,NULL,NULL),
(41,'lb','1','刘备','2019-08-24','男','13234342434','lb@qq.com','Y',NULL,NULL,3),
(53,'234','234','asdf',NULL,NULL,NULL,NULL,NULL,'a',0,NULL),
(54,'asd','asdf','asd',NULL,NULL,NULL,NULL,NULL,'a',0,3),
(55,'23','234','f',NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),
(56,'asdf','234','asd',NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),
(58,'aaa','aaa','fasd',NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),
(59,'aaa','bbb','f',NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),
(60,'ccc','ccc','asdf',NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),
(61,'ddd','eee','asd',NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),
(62,'fff','fff','asd',NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),
(71,'admin234','123456','雪松234','2020-07-07','男','123456','lxsong77@163.com',NULL,NULL,0,NULL),
(77,'33','','3333','2023-01-17','','','33',NULL,NULL,0,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
