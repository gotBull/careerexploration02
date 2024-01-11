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
  `accountnum` varchar(30) NOT NULL DEFAULT '',
  `passwd` varchar(30) NOT NULL DEFAULT '',
  `username` varchar(50) DEFAULT '',
  `email` varchar(50) DEFAULT '',
  `mobile` varchar(20) DEFAULT '',
  `regdate` date NOT NULL DEFAULT current_timestamp() COMMENT '註冊時間',
  PRIMARY KEY (`memberid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='紀錄登錄會員的基本資料';

-- 正在傾印表格  membertest.userdata 的資料：~2 rows (近似值)
INSERT IGNORE INTO `userdata` (`memberid`, `accountnum`, `passwd`, `username`, `email`, `mobile`, `regdate`) VALUES
	(1, 'abc123', '12345', 'Dave', 'aaa321@gmail.com', '0939321456', '2024-01-02'),
	(2, 'luffy121020', '12345', 'Tony Steak', 'luffy121020@gmail.com', '0927123654', '2024-01-04');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
userdata