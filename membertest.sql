-- --------------------------------------------------------
-- 主機:                           127.0.0.1
-- 伺服器版本:                        11.2.2-MariaDB - mariadb.org binary distribution
-- 伺服器作業系統:                      Win64
-- HeidiSQL 版本:                  12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- 傾印 membertest 的資料庫結構
CREATE DATABASE IF NOT EXISTS `membertest` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `membertest`;

-- 傾印  資料表 membertest.userdata 結構
CREATE TABLE IF NOT EXISTS `userdata` (
  `memberid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自動編排會員ID',
  `accountnum` varchar(30) NOT NULL DEFAULT '' COMMENT '帳號',
  `passwd` varchar(30) NOT NULL DEFAULT '' COMMENT '密碼',
  `username` varchar(50) DEFAULT '' COMMENT '姓名',
  `email` varchar(50) DEFAULT '' COMMENT '電子郵件',
  `mobile` varchar(20) DEFAULT '' COMMENT '手機',
  `regdate` date NOT NULL DEFAULT current_timestamp() COMMENT '註冊時間',
  `address` varchar(50) DEFAULT NULL COMMENT '地址',
  `landline` varchar(20) DEFAULT NULL COMMENT '室內電話',
  `paymentStatus` varchar(10) DEFAULT NULL COMMENT '會員付費等級',
  `paymentDate` date DEFAULT current_timestamp() COMMENT '會員付費時間',
  `randomCode` char(6) DEFAULT NULL COMMENT '忘記密碼之隨機碼',
  PRIMARY KEY (`memberid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='紀錄登錄會員的基本資料';

-- 正在傾印表格  membertest.userdata 的資料：~11 rows (近似值)
INSERT IGNORE INTO `userdata` (`memberid`, `accountnum`, `passwd`, `username`, `email`, `mobile`, `regdate`, `address`, `landline`, `paymentStatus`, `paymentDate`, `randomCode`) VALUES
	(1, 'abc123', '12345', 'Dave', 'aaa321@gmail.com', '0939321456', '2024-01-02', 'Taipei', '0424821234', 'normal', '2024-01-15', NULL),
	(2, 'select123', '4564', 'Tony Steak', 'luffy121020@gmail.com', '0927123789', '2024-01-08', NULL, NULL, NULL, '2024-01-15', NULL),
	(3, 'qwerty321', '12345', 'sd123', 'aa0980988701@gmail.com', '0927123789', '2024-01-08', NULL, NULL, NULL, '2024-01-15', NULL),
	(4, 'pp789987', '12345', 'sd123', 'aa0980988701@gmail.com', '0927123789', '2024-01-08', NULL, NULL, NULL, '2024-01-15', NULL),
	(5, 'pp787897777', '12345', 'Wick', 'aa0980988701@gmail.com', '0927123789', '2024-01-08', NULL, NULL, NULL, '2024-01-15', NULL),
	(6, 'pp78pp', '12345', 'John Wick', 'aa0980988701@gmail.com', '0927123789', '2024-01-08', NULL, NULL, NULL, '2024-01-15', NULL),
	(7, 'pp78pp123', '12345', 'John Wick', 'aa0980988701@gmail.com', '0927123789', '2024-01-08', NULL, NULL, NULL, '2024-01-15', NULL),
	(8, 'pp78pp987', '12345', 'John Wick', 'aa0980988701@gmail.com', '0927123789', '2024-01-08', NULL, NULL, NULL, '2024-01-15', NULL),
	(9, 'abc12345', '12345', 'John Wick', 'luffy121020@gmail.com', '0927123789', '2024-01-08', NULL, NULL, NULL, '2024-01-15', NULL),
	(10, 'abc321', '12345', 'Amen', 'aaa123@gmail.com', '0912987654', '2024-01-08', NULL, NULL, NULL, '2024-01-15', NULL),
	(11, 'abc20240109', '12345', 'LLLLL', 'luffy121020@gmail.com', '0927123456', '2024-01-09', NULL, NULL, NULL, '2024-01-15', NULL);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
membertestuserdata