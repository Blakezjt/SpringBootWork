/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80034
Source Host           : localhost:3306
Source Database       : javaeework

Target Server Type    : MYSQL
Target Server Version : 80034
File Encoding         : 65001

Date: 2024-06-04 16:41:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bookinventory
-- ----------------------------
DROP TABLE IF EXISTS `bookinventory`;
CREATE TABLE `bookinventory` (
  `book_id` int NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `isbn` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`book_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bookinventory
-- ----------------------------

-- ----------------------------
-- Table structure for borrowing
-- ----------------------------
DROP TABLE IF EXISTS `borrowing`;
CREATE TABLE `borrowing` (
  `borrowing_id` int NOT NULL,
  `student_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `book_ud` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `borrow_data` datetime DEFAULT NULL,
  `return_data` datetime DEFAULT NULL,
  PRIMARY KEY (`borrowing_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of borrowing
-- ----------------------------

-- ----------------------------
-- Table structure for clubmanagement
-- ----------------------------
DROP TABLE IF EXISTS `clubmanagement`;
CREATE TABLE `clubmanagement` (
  `club_id` int NOT NULL,
  `club_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `activity_id` int DEFAULT NULL,
  `announcement` text COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`club_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of clubmanagement
-- ----------------------------

-- ----------------------------
-- Table structure for course_schedule
-- ----------------------------
DROP TABLE IF EXISTS `course_schedule`;
CREATE TABLE `course_schedule` (
  `course_id` int NOT NULL,
  `teacher_id` int NOT NULL,
  `classroom_id` int DEFAULT NULL,
  `course_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `time` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `date` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`course_id`,`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of course_schedule
-- ----------------------------

-- ----------------------------
-- Table structure for course_selection
-- ----------------------------
DROP TABLE IF EXISTS `course_selection`;
CREATE TABLE `course_selection` (
  `student_id` int NOT NULL,
  `course_id` int NOT NULL,
  `selection_time` datetime NOT NULL,
  `drop_time` datetime NOT NULL,
  PRIMARY KEY (`student_id`,`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of course_selection
-- ----------------------------

-- ----------------------------
-- Table structure for dormitory
-- ----------------------------
DROP TABLE IF EXISTS `dormitory`;
CREATE TABLE `dormitory` (
  `repair_id` int NOT NULL,
  `dormitory_id` int DEFAULT NULL,
  `student_id` int DEFAULT NULL,
  `repair_date` date DEFAULT NULL,
  PRIMARY KEY (`repair_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of dormitory
-- ----------------------------

-- ----------------------------
-- Table structure for electronicresource
-- ----------------------------
DROP TABLE IF EXISTS `electronicresource`;
CREATE TABLE `electronicresource` (
  `resource_id` int NOT NULL,
  `resource_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  PRIMARY KEY (`resource_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of electronicresource
-- ----------------------------

-- ----------------------------
-- Table structure for emergencycontact
-- ----------------------------
DROP TABLE IF EXISTS `emergencycontact`;
CREATE TABLE `emergencycontact` (
  `student_id` int NOT NULL,
  `contact_name` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `contact_phone` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of emergencycontact
-- ----------------------------

-- ----------------------------
-- Table structure for eventregistration
-- ----------------------------
DROP TABLE IF EXISTS `eventregistration`;
CREATE TABLE `eventregistration` (
  `registration_id` int NOT NULL,
  `student_id` int DEFAULT NULL,
  `event_id` int DEFAULT NULL,
  `registration_time` date DEFAULT NULL,
  PRIMARY KEY (`registration_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of eventregistration
-- ----------------------------

-- ----------------------------
-- Table structure for financialrecord
-- ----------------------------
DROP TABLE IF EXISTS `financialrecord`;
CREATE TABLE `financialrecord` (
  `record_id` int NOT NULL,
  `student_id` int DEFAULT NULL,
  `transaction_type` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of financialrecord
-- ----------------------------
INSERT INTO `financialrecord` VALUES ('1', '1001', '收入', '15000.00', '2024-01-15');
INSERT INTO `financialrecord` VALUES ('2', '1002', '支出', '500.00', '2024-02-10');
INSERT INTO `financialrecord` VALUES ('3', '1003', '收入', '3000.00', '2024-02-15');
INSERT INTO `financialrecord` VALUES ('4', '1004', '收入', '16000.00', '2024-01-20');
INSERT INTO `financialrecord` VALUES ('5', '1005', '支出', '1200.00', '2024-02-25');
INSERT INTO `financialrecord` VALUES ('6', '1006', '收入', '15000.00', '2024-03-01');
INSERT INTO `financialrecord` VALUES ('7', '1007', '支出', '600.00', '2024-03-05');
INSERT INTO `financialrecord` VALUES ('8', '1008', '收入', '3500.00', '2024-03-10');
INSERT INTO `financialrecord` VALUES ('9', '1009', '收入', '14000.00', '2024-03-15');
INSERT INTO `financialrecord` VALUES ('10', '1010', '支出', '1100.00', '2024-03-20');

-- ----------------------------
-- Table structure for forum
-- ----------------------------
DROP TABLE IF EXISTS `forum`;
CREATE TABLE `forum` (
  `post_id` int NOT NULL,
  `student_id` int DEFAULT NULL,
  `topic` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `post_date` date DEFAULT NULL,
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of forum
-- ----------------------------

-- ----------------------------
-- Table structure for grades
-- ----------------------------
DROP TABLE IF EXISTS `grades`;
CREATE TABLE `grades` (
  `student_id` int NOT NULL,
  `course_id` int NOT NULL,
  `grade` int NOT NULL,
  PRIMARY KEY (`student_id`,`course_id`,`grade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of grades
-- ----------------------------

-- ----------------------------
-- Table structure for healthreport
-- ----------------------------
DROP TABLE IF EXISTS `healthreport`;
CREATE TABLE `healthreport` (
  `report_id` int NOT NULL,
  `student_id` int DEFAULT NULL,
  `date` date DEFAULT NULL,
  `health_status` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`report_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of healthreport
-- ----------------------------

-- ----------------------------
-- Table structure for idcard
-- ----------------------------
DROP TABLE IF EXISTS `idcard`;
CREATE TABLE `idcard` (
  `id_card_id` int NOT NULL,
  `student_id` int DEFAULT NULL,
  `issue_date` date DEFAULT NULL,
  `expiration_date` date DEFAULT NULL,
  PRIMARY KEY (`id_card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of idcard
-- ----------------------------

-- ----------------------------
-- Table structure for leaveapplication
-- ----------------------------
DROP TABLE IF EXISTS `leaveapplication`;
CREATE TABLE `leaveapplication` (
  `application_id` int NOT NULL,
  `student_id` int DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `approval_status` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`application_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of leaveapplication
-- ----------------------------

-- ----------------------------
-- Table structure for logistics
-- ----------------------------
DROP TABLE IF EXISTS `logistics`;
CREATE TABLE `logistics` (
  `repair_id` int NOT NULL,
  `equipment_id` int DEFAULT NULL,
  `repair_date` date DEFAULT NULL,
  `status` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`repair_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of logistics
-- ----------------------------
INSERT INTO `logistics` VALUES ('1', '5001', '2024-02-20', '待处理');
INSERT INTO `logistics` VALUES ('2', '5002', '2024-03-01', '已完成');
INSERT INTO `logistics` VALUES ('3', '5003', '2024-03-05', '处理中');
INSERT INTO `logistics` VALUES ('4', '5004', '2024-03-10', '待处理');
INSERT INTO `logistics` VALUES ('5', '5005', '2024-03-15', '已完成');
INSERT INTO `logistics` VALUES ('6', '5006', '2024-03-20', '处理中');
INSERT INTO `logistics` VALUES ('7', '5007', '2024-03-25', '待处理');
INSERT INTO `logistics` VALUES ('8', '5008', '2024-03-30', '已完成');
INSERT INTO `logistics` VALUES ('9', '5009', '2024-04-01', '处理中');
INSERT INTO `logistics` VALUES ('10', '5010', '2024-04-05', '待处理');

-- ----------------------------
-- Table structure for medicalappointment
-- ----------------------------
DROP TABLE IF EXISTS `medicalappointment`;
CREATE TABLE `medicalappointment` (
  `appointment_id` int NOT NULL,
  `student_id` int DEFAULT NULL,
  `appointment_time` datetime DEFAULT NULL,
  `record` text COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`appointment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of medicalappointment
-- ----------------------------

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `payment_id` int NOT NULL,
  `student_id` int DEFAULT NULL,
  `payment_type` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `payment_date` date DEFAULT NULL,
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of payment
-- ----------------------------
INSERT INTO `payment` VALUES ('1', '1001', '学费', '15000.00', '2024-01-15');
INSERT INTO `payment` VALUES ('2', '1002', '书本费', '500.00', '2024-02-10');
INSERT INTO `payment` VALUES ('3', '1003', '住宿费', '3000.00', '2024-02-15');
INSERT INTO `payment` VALUES ('4', '1004', '学费', '16000.00', '2024-01-20');
INSERT INTO `payment` VALUES ('5', '1005', '实验费', '1200.00', '2024-02-25');
INSERT INTO `payment` VALUES ('6', '1006', '学费', '15000.00', '2024-03-01');
INSERT INTO `payment` VALUES ('7', '1007', '书本费', '600.00', '2024-03-05');
INSERT INTO `payment` VALUES ('8', '1008', '住宿费', '3500.00', '2024-03-10');
INSERT INTO `payment` VALUES ('9', '1009', '学费', '14000.00', '2024-03-15');
INSERT INTO `payment` VALUES ('10', '1010', '实验费', '1100.00', '2024-03-20');
