CREATE TABLE `vispro`.`department` (
  `deptId` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `chairId` NVARCHAR(11) NULL,
  `facultyId` INT NULL,
  PRIMARY KEY (`deptId`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC));
  
CREATE TABLE `vispro`.`student` (
  `studentId` NVARCHAR(11) NOT NULL,
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `birthDate` DATE NULL,
  `address` VARCHAR(100) NULL,
  `deptId` INT NULL,
  PRIMARY KEY (`studentId`),
  FOREIGN KEY (`deptId`) REFERENCES `vispro`.`department`(`deptId`));

  CREATE TABLE `vispro`.`course` (
  `courseId` INT NOT NULL,
  `code` VARCHAR(10) NULL,
  `title` VARCHAR(50) NOT NULL,
  `numOfCredits` INT NOT NULL,
  PRIMARY KEY (`courseId`));

  CREATE TABLE `vispro`.`enrollment` (
  `studentId` NVARCHAR(11) NOT NULL,
  `courseId` INT NOT NULL,
  `dateRegistered` DATE NULL,
  `grade` VARCHAR(2) NULL,
  PRIMARY KEY (`studentId`, `courseId`));
  
  CREATE TABLE `vispro`.`instructor` (
  `instructorId` NVARCHAR(11) NOT NULL,
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `office` VARCHAR(45) NULL,
  `deptId` INT NULL,
  PRIMARY KEY (`instructorId`));
  
  CREATE TABLE `vispro`.`faculty` (
  `facultyId` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`facultyId`));
  
  CREATE TABLE `vispro`.`taughtby` (
  `courseId` INT NOT NULL,
  `instructorId` NVARCHAR(11) NOT NULL,
  `term` VARCHAR(10) NULL,
  `year` YEAR(4) NULL);
  
insert into department (name, chairId, facultyId) values ( 'Computer Engineering', '1001', '1');
insert into department (name, chairId, facultyId) values ( 'Electrical Engineering', '1002', '1');

INSERT INTO `vispro`.`instructor` (`instructorId`, `firstName`, `lastName`, `office`, `deptId`) VALUES ('1001', 'Ali', 'Kaya', 'A2 201', '1');
INSERT INTO `vispro`.`instructor` (`instructorId`, `firstName`, `lastName`, `office`, `deptId`) VALUES ('1002', 'Metin', 'Kurt', 'A1 102', '2');
INSERT INTO `vispro`.`instructor` (`instructorId`, `firstName`, `lastName`, `office`, `deptId`) VALUES ('1003', 'Mehmet', 'Demir', 'A1 103', '2');
INSERT INTO `vispro`.`instructor` (`instructorId`, `firstName`, `lastName`, `office`, `deptId`) VALUES ('1004', 'Bilge', 'Budun', 'A2 202', '1');

INSERT INTO `vispro`.`student` (`studentId`, `firstName`, `lastName`, `birthDate`, `address`, `deptId`) VALUES ('1030510001', 'Ayse', 'Sebe', '1998-10-10', 'Kayseri', '1');
INSERT INTO `vispro`.`student` (`studentId`, `firstName`, `lastName`, `birthDate`, `address`, `deptId`) VALUES ('1030510002', 'Yunus', 'Eren', '1997-10-10', 'Kayseri', '1');
INSERT INTO `vispro`.`student` (`studentId`, `firstName`, `lastName`, `birthDate`, `address`, `deptId`) VALUES ('1030510003', 'Elif', 'Kara', '1998-12-12', 'Antalya', '1');
INSERT INTO `vispro`.`student` (`studentId`, `firstName`, `lastName`, `birthDate`, `address`, `deptId`) VALUES ('1030510004', 'Emir', 'Turan', '1999-10-10', 'Erzurum', '1');


INSERT INTO `vispro`.`course` (`courseId`, `code`, `title`, `numOfCredits`) VALUES ('1','BZ 214', 'Visual Programming', '6');
INSERT INTO `vispro`.`course` (`courseId`,`code`, `title`, `numOfCredits`) VALUES ('2','BZ 209', 'Object Oriented Programming', '7');
INSERT INTO `vispro`.`course` (`courseId`,`code`, `title`, `numOfCredits`) VALUES ('3','BZ 205', 'Data Structures and Algorithms', '7');
INSERT INTO `vispro`.`course` (`courseId`,`code`, `title`, `numOfCredits`) VALUES ('4','BZ 101', 'Calculus I', '6');
INSERT INTO `vispro`.`course` (`courseId`,`code`, `title`, `numOfCredits`) VALUES ('5','BZ 108', 'Calculus II', '6');
INSERT INTO `vispro`.`course` (`courseId`,`code`, `title`, `numOfCredits`) VALUES ('6','BZ 310', 'Database Management Systems', '5');

INSERT INTO `vispro`.`faculty` (`facultyId`, `name`) VALUES ('1', 'Engineering Faculty');


insert into enrollment values ('1030510001', '1', CURDATE(), 'AA');
insert into enrollment values ('1030510001', '2', CURDATE(), 'BA');
insert into enrollment values ('1030510001', '3', CURDATE(), 'CC');
insert into enrollment values ('1030510001', '4', CURDATE(), 'CC');

insert into enrollment values ('1030510002', '1', CURDATE(), 'FF');
insert into enrollment values ('1030510002', '2', CURDATE(), 'BA');
insert into enrollment values ('1030510002', '3', CURDATE(), 'CC');
insert into enrollment values ('1030510002', '4', CURDATE(), 'CC');

insert into enrollment values ('1030510003', '1', CURDATE(), 'AA');
insert into enrollment values ('1030510003', '2', CURDATE(), 'AA');
insert into enrollment values ('1030510003', '3', CURDATE(), 'AA');
insert into enrollment values ('1030510003', '4', CURDATE(), 'AA');

insert into enrollment values ('1030510004', '1', CURDATE(), 'CC');
insert into enrollment values ('1030510004', '2', CURDATE(), 'FF');
insert into enrollment values ('1030510004', '3', CURDATE(), 'FF');
insert into enrollment values ('1030510004', '4', CURDATE(), 'FD');

insert into taughtby values ('1', '1001', 'spring', '2018');
insert into taughtby values ('2', '1002', 'spring', '2018');
insert into taughtby values ('3', '1003', 'spring', '2018');
insert into taughtby values ('4', '1004', 'spring', '2018');

CREATE PROCEDURE `find_grade` (IN id NVARCHAR(11), IN course_id INT)
BEGIN
	SELECT firstName, lastName, title, grade FROM student 
    INNER JOIN enrollment ON student.studentId = enrollment.studentId 
    INNER JOIN course ON enrollment.courseId = course.courseId 
    WHERE student.studentId = id and  enrollment.courseId = course_id ;
END

