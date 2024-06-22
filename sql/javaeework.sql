/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80034
Source Host           : localhost:3306
Source Database       : javaeework

Target Server Type    : MYSQL
Target Server Version : 80034
File Encoding         : 65001

Date: 2024-06-22 16:23:20
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
  `id` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `course_id` int NOT NULL,
  `teacher_id` int NOT NULL,
  `classroom_id` int DEFAULT NULL,
  `course_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `time` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `date` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of course_schedule
-- ----------------------------
INSERT INTO `course_schedule` VALUES ('a0f7c70b-0cc1-4ca9-a532-d41390e80229', '10003', '210007001', '10001', 'C++', '8.00-9.40', '1', '2024-06-16 10:41:25', '2024-06-16 10:41:25');
INSERT INTO `course_schedule` VALUES ('e1946677-d2f1-4759-ae82-6f6568127df6', '10002', '210007002', '10003', 'python', '8.00-9.40', '2', '2024-06-16 10:39:53', '2024-06-16 10:39:53');

-- ----------------------------
-- Table structure for course_selection
-- ----------------------------
DROP TABLE IF EXISTS `course_selection`;
CREATE TABLE `course_selection` (
  `id` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `student_id` int NOT NULL,
  `course_id` int NOT NULL,
  `selection_time` datetime NOT NULL,
  `drop_time` datetime DEFAULT NULL,
  `is_select` int DEFAULT '0' COMMENT '0=>不选，1反之',
  `begin_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of course_selection
-- ----------------------------
INSERT INTO `course_selection` VALUES ('ad874bc0-f192-4ac9-9d7d-d0348f496b09', '212100001', '10003', '2024-06-16 11:31:48', null, '1', '2024-06-16 14:30:00', '2024-06-20 14:30:00');

-- ----------------------------
-- Table structure for dormitory
-- ----------------------------
DROP TABLE IF EXISTS `dormitory`;
CREATE TABLE `dormitory` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `buildingid` int DEFAULT NULL,
  `dormname` varchar(255) NOT NULL,
  `type` int DEFAULT NULL,
  `available` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
-- Table structure for exams
-- ----------------------------
DROP TABLE IF EXISTS `exams`;
CREATE TABLE `exams` (
  `id` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `exam_id` int NOT NULL,
  `course_id` int DEFAULT NULL,
  `exam_time` datetime DEFAULT NULL,
  `exam_location` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `exam_hour` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of exams
-- ----------------------------
INSERT INTO `exams` VALUES ('69071ab6-2e30-4d01-ac2d-dad83d917f64', '100001', '10002', '2024-06-16 14:30:00', '东教101', '2');
INSERT INTO `exams` VALUES ('d52c5451-68d0-4af3-bb1f-916a6883529b', '100002', '10003', '2024-06-16 16:30:00', '东教101', '2');

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
  `id` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `student_id` int NOT NULL,
  `course_id` int NOT NULL,
  `grade` int NOT NULL,
  `gpa` double DEFAULT NULL,
  `record_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of grades
-- ----------------------------
INSERT INTO `grades` VALUES ('527c37df-8815-4629-9c28-868836058d8b', '212100004', '10002', '90', '4', '2024-06-16 23:39:06');

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
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `admin_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `user_name` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `role` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `phone` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_delete` int DEFAULT '0' COMMENT '0不删，1反之',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `delect_time` datetime DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of manager
-- ----------------------------

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

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` varchar(255) NOT NULL,
  `student_id` int NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `student_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `student_sex` int NOT NULL,
  `student_xb` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `student_dept` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `student_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `is_delete` int DEFAULT '0' COMMENT '软删除，0是没删，1是删了',
  `dormitory_id` int DEFAULT NULL,
  `entry_time` date DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `delete_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('0c515232-fdff-403b-aad7-5bbef7f33d4b', '212100001', '97796cd1cf912f72141beadc3fb0776b', 'zjt', '1', '计算机工程系', '计算机与科学', '18828384567', '1', '14', '2021-09-01', '2024-06-15 23:17:56', '2024-06-20 22:40:29', '2024-06-20 22:43:30');
INSERT INTO `student` VALUES ('1443e47a-7869-4f74-bd9d-9aa057b13c8f', '212100009', 'e10adc3949ba59abbe56e057f20f883e', '张三', '1', '计算机工程系', '软件工程', '18828384567', '0', '10', '2021-09-01', '2024-06-20 11:14:34', '2024-06-20 11:19:22', null);
INSERT INTO `student` VALUES ('194a60eb-3a32-4f88-8c77-4aa80b8cc354', '212100003', 'e10adc3949ba59abbe56e057f20f883e', 'cjc', '1', '计算机工程系', '软件工程', '18828384567', '0', '10', '2021-09-01', '2024-06-15 23:21:52', '2024-06-22 12:06:44', null);
INSERT INTO `student` VALUES ('2986dd8b-cf91-4e31-98be-35918998c9cd', '212100019', 'e10adc3949ba59abbe56e057f20f883e', '张三', '1', '计算机工程系', '软件工程', '18828384567', '0', '1', '2021-09-01', '2024-06-20 11:14:43', '2024-06-20 11:14:43', null);
INSERT INTO `student` VALUES ('2f6c07eb-e5dd-4d6e-b880-c551607337cd', '212100026', 'e10adc3949ba59abbe56e057f20f883e', '张三', '1', '计算机工程系', '软件工程', '18828384567', '0', '1', '2021-09-01', '2024-06-20 11:14:49', '2024-06-20 11:14:49', null);
INSERT INTO `student` VALUES ('3555730a-dd54-4342-be0e-587aa1db9e53', '212100029', 'e10adc3949ba59abbe56e057f20f883e', '张三', '1', '计算机工程系', '软件工程', '18828384567', '0', '1', '2021-09-01', '2024-06-20 11:14:51', '2024-06-20 11:14:51', null);
INSERT INTO `student` VALUES ('3baa259b-07b2-42c9-b457-ac6a5f4fae5c', '212100002', 'e10adc3949ba59abbe56e057f20f883e', 'cjc', '1', '计算机工程系', '数字媒体与技术', '18828384567', '1', '7', '2021-09-01', '2024-06-15 23:21:45', '2024-06-20 16:34:41', '2024-06-20 22:48:05');
INSERT INTO `student` VALUES ('423fbf9d-32e7-4815-a045-3c7653e8e503', '212100023', 'e10adc3949ba59abbe56e057f20f883e', '张三', '1', '计算机工程系', '软件工程', '18828384567', '0', '1', '2021-09-01', '2024-06-20 11:14:46', '2024-06-20 11:14:46', null);
INSERT INTO `student` VALUES ('4cbd426b-113a-4a33-a0df-3cfa565d7b6a', '212100012', 'e10adc3949ba59abbe56e057f20f883e', '张三', '1', '计算机工程系', '软件工程', '18828384567', '0', '1', '2021-09-01', '2024-06-20 11:14:36', '2024-06-20 11:14:36', null);
INSERT INTO `student` VALUES ('6e12e3d4-cb25-4bbf-83b4-17a657965738', '212100021', 'e10adc3949ba59abbe56e057f20f883e', '张三', '1', '计算机工程系', '软件工程', '18828384567', '0', '1', '2021-09-01', '2024-06-20 11:14:44', '2024-06-20 11:14:44', null);
INSERT INTO `student` VALUES ('8c2fda5f-f693-41be-bc6a-aebdad230de5', '212100027', 'e10adc3949ba59abbe56e057f20f883e', '张三', '1', '计算机工程系', '软件工程', '18828384567', '0', '1', '2021-09-01', '2024-06-20 11:14:50', '2024-06-20 11:14:50', null);
INSERT INTO `student` VALUES ('8ea6a369-e86b-4e74-ab44-d9f14ad45798', '212100005', 'e10adc3949ba59abbe56e057f20f883e', '张三', '1', '计算机工程系', '软件工程', '18828384567', '0', '6', '2021-09-01', '2024-06-20 11:14:28', '2024-06-20 16:21:59', null);
INSERT INTO `student` VALUES ('9581e20f-115d-43ea-b779-7ffc7f0f8b84', '212100020', 'e10adc3949ba59abbe56e057f20f883e', '张三', '1', '计算机工程系', '软件工程', '18828384567', '0', '1', '2021-09-01', '2024-06-20 11:14:43', '2024-06-20 11:14:43', null);
INSERT INTO `student` VALUES ('a502ebbe-86fc-49de-a974-4f6ebf13936a', '212100006', 'e10adc3949ba59abbe56e057f20f883e', '张三', '1', '人文艺术系', '汉语言文学', '18828384567', '0', '15', '2021-09-01', '2024-06-20 11:14:31', '2024-06-22 12:07:30', null);
INSERT INTO `student` VALUES ('a6a35ce8-6c22-4d6a-b649-593aa0f10693', '212100030', 'e10adc3949ba59abbe56e057f20f883e', '飒飒', '0', '计算机工程', '软件工程', '19987654567', '0', '2001', '2024-09-02', '2024-06-20 21:15:55', '2024-06-20 21:15:55', null);
INSERT INTO `student` VALUES ('a7126749-2cc7-4b0d-a1a6-1fa76b59ece2', '212100007', 'e10adc3949ba59abbe56e057f20f883e', '张三', '1', '计算机工程系', '软件工程', '18828384567', '0', '3', '2021-09-01', '2024-06-20 11:14:32', '2024-06-20 11:17:04', null);
INSERT INTO `student` VALUES ('a807976f-7e75-4487-b3b6-f418a777a83c', '212100032', 'e10adc3949ba59abbe56e057f20f883e', '李四', '1', '计算机工程', '计算机与科学', '17786543456', '0', '1002', '2021-09-01', '2024-06-20 23:33:36', '2024-06-20 23:33:36', null);
INSERT INTO `student` VALUES ('ac5bf56b-22d9-4d48-9070-d9d6994d6882', '212100014', 'e10adc3949ba59abbe56e057f20f883e', '张三', '1', '计算机工程系', '软件工程', '18828384567', '0', '1', '2021-09-01', '2024-06-20 11:14:38', '2024-06-20 11:14:38', null);
INSERT INTO `student` VALUES ('ba0441e6-ca1c-46f1-8cf0-8dbb154c3b7e', '212100013', 'e10adc3949ba59abbe56e057f20f883e', '张三', '1', '计算机工程系', '软件工程', '18828384567', '0', '1', '2021-09-01', '2024-06-20 11:14:37', '2024-06-20 11:14:37', null);
INSERT INTO `student` VALUES ('c263b052-944c-4abc-954a-4771250e3af3', '212100017', 'e10adc3949ba59abbe56e057f20f883e', '张三', '1', '计算机工程系', '软件工程', '18828384567', '0', '1', '2021-09-01', '2024-06-20 11:14:41', '2024-06-20 11:14:41', null);
INSERT INTO `student` VALUES ('c561c4d3-0ce0-4793-9201-91b2eb3c56ec', '212100024', 'e10adc3949ba59abbe56e057f20f883e', '张三', '1', '计算机工程系', '软件工程', '18828384567', '0', '1', '2021-09-01', '2024-06-20 11:14:47', '2024-06-20 11:14:47', null);
INSERT INTO `student` VALUES ('c698add1-7a3e-4233-b741-979942401a1b', '212100018', 'e10adc3949ba59abbe56e057f20f883e', '张三', '1', '计算机工程系', '软件工程', '18828384567', '0', '1', '2021-09-01', '2024-06-20 11:14:42', '2024-06-20 11:14:42', null);
INSERT INTO `student` VALUES ('c90da371-5cd6-4dcf-9fff-e68e1acd4ab5', '212100010', 'e10adc3949ba59abbe56e057f20f883e', '张三', '1', '计算机工程系', '软件工程', '18828384567', '1', '1', '2021-09-01', '2024-06-20 11:14:35', '2024-06-20 11:14:35', '2024-06-20 23:31:49');
INSERT INTO `student` VALUES ('d7f05545-8e2e-486c-8708-308ee22f31b5', '212100031', 'e10adc3949ba59abbe56e057f20f883e', 'wdx', '0', '人文艺术系', '汉语言文学', '19987653678', '0', '2002', '2024-09-01', '2024-06-20 23:25:45', '2024-06-20 23:25:45', null);
INSERT INTO `student` VALUES ('e061966c-62d3-4ce1-aca7-5f4797e89b14', '212100028', 'e10adc3949ba59abbe56e057f20f883e', '张三', '1', '计算机工程系', '软件工程', '18828384567', '0', '1', '2021-09-01', '2024-06-20 11:14:50', '2024-06-20 11:14:50', null);
INSERT INTO `student` VALUES ('e561f3df-de83-4d20-81dd-74ae735dc500', '212100008', 'e10adc3949ba59abbe56e057f20f883e', '张三', '1', '计算机工程系', '软件工程', '18828384567', '0', '2', '2021-09-01', '2024-06-20 11:14:33', '2024-06-20 16:22:11', null);
INSERT INTO `student` VALUES ('e5634f89-403c-4d6e-b4ca-c244655ad5c6', '212100004', 'e10adc3949ba59abbe56e057f20f883e', 'pj', '1', '计算机工程系', '软件工程', '18828384567', '0', '12', '2021-09-01', '2024-06-16 10:37:53', '2024-06-20 10:52:16', null);
INSERT INTO `student` VALUES ('ea2f5bc9-235a-49aa-8ece-026c6744c431', '212100015', 'e10adc3949ba59abbe56e057f20f883e', '张三', '1', '计算机工程系', '软件工程', '18828384567', '0', '1', '2021-09-01', '2024-06-20 11:14:39', '2024-06-20 11:14:39', null);
INSERT INTO `student` VALUES ('f376f98e-0083-407e-9442-618016544c91', '212100022', 'e10adc3949ba59abbe56e057f20f883e', '张三', '1', '计算机工程系', '软件工程', '18828384567', '0', '1', '2021-09-01', '2024-06-20 11:14:45', '2024-06-20 11:14:45', null);
INSERT INTO `student` VALUES ('f8901385-2e08-473c-96ad-951865c78946', '212100016', 'e10adc3949ba59abbe56e057f20f883e', '张三', '1', '计算机工程系', '软件工程', '18828384567', '0', '1', '2021-09-01', '2024-06-20 11:14:40', '2024-06-20 11:14:40', null);
INSERT INTO `student` VALUES ('fed256c9-742f-4b12-9c31-70ace18600a6', '212100025', 'e10adc3949ba59abbe56e057f20f883e', '张三', '1', '计算机工程系', '软件工程', '18828384567', '0', '1', '2021-09-01', '2024-06-20 11:14:48', '2024-06-20 11:14:48', null);
INSERT INTO `student` VALUES ('ff48bf64-b7ae-49df-a6d1-3f57f7b27118', '212100011', 'e10adc3949ba59abbe56e057f20f883e', '张三', '1', '计算机工程系', '软件工程', '18828384567', '0', '1', '2021-09-01', '2024-06-20 11:14:35', '2024-06-20 11:14:35', null);

-- ----------------------------
-- Table structure for teachers
-- ----------------------------
DROP TABLE IF EXISTS `teachers`;
CREATE TABLE `teachers` (
  `id` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `teacher_id` int NOT NULL,
  `name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `sex` int NOT NULL,
  `birth_date` date NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `address` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_delete` int DEFAULT '0' COMMENT '软删除，0是没删，1是删了',
  `hire_date` date NOT NULL,
  `salary` int DEFAULT NULL,
  `degree` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `major` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `delete_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of teachers
-- ----------------------------
INSERT INTO `teachers` VALUES ('11fa36f8-5304-4a37-b524-bb244fe5d841', '210007003', '王五', 'e10adc3949ba59abbe56e057f20f883e', '1', '1975-09-01', '1853834123@qq.com', '18897652330', '福州市鼓楼区', '0', '2003-07-01', '10000', '博士', '操作系统、软件工程、C++、java', '2024-06-15 23:08:12', '2024-06-15 23:08:12', null);
INSERT INTO `teachers` VALUES ('25d6ac59-9b31-4112-a591-79dd259a75bc', '210007004', '李四', 'e10adc3949ba59abbe56e057f20f883e', '1', '1975-09-01', '1853834123@qq.com', '18897652330', '福州市鼓楼区', '0', '2003-07-01', '10000', '博士', '操作系统、软件工程、C++、java', '2024-06-16 10:38:25', '2024-06-16 10:38:25', null);
INSERT INTO `teachers` VALUES ('e4531f24-d565-4709-b3de-523ee2d181fc', '210007001', '王五', 'e10adc3949ba59abbe56e057f20f883e', '1', '1975-09-01', '1853834123@qq.com', '18897652330', '福州市鼓楼区', '0', '2003-07-01', '10000', '博士', '操作系统、软件工程、C++、java', '2024-06-15 23:03:41', '2024-06-15 23:03:41', null);
INSERT INTO `teachers` VALUES ('fe42b78a-2321-40bb-8303-34935fd0c72a', '210007002', '王五', 'e10adc3949ba59abbe56e057f20f883e', '1', '1975-09-01', '1853834123@qq.com', '18897652330', '福州市鼓楼区', '0', '2003-07-01', '10000', '博士', '操作系统、软件工程、C++、java', '2024-06-15 23:08:00', '2024-06-15 23:08:00', null);
