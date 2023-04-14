CREATE DATABASE quan_ly_sinh_vien;
USE quan_ly_sinh_vien;
CREATE TABLE classes(
  class_id INT PRIMARY KEY AUTO_INCREMENT, 
  class_name VARCHAR(50) NOT NULL, 
  start_date DATE NOT NULL , 
  `status` BIT
);
INSERT INTO classes 
VALUES 
  (1, 'A1', '2008-12-20', 1);
INSERT INTO classes 
VALUES 
  (2, 'A2', '2008-12-22', 1);
INSERT INTO classes 
VALUES 
  (3, 'B3', current_date, 0);
CREATE TABLE students(
  student_id INT PRIMARY KEY  AUTO_INCREMENT, 
  student_name VARCHAR(50) NOT NULL, 
  address VARCHAR(50) NOT NULL, 
  phone VARCHAR(50) , 
  `status` INT, 
  classes_id INT NOT NULL, 
  FOREIGN KEY(classes_id) REFERENCES classes(class_id)
);
INSERT INTO students 
VALUES 
  (
    1, 'Hung', 'Ha Noi', '0912113113', 
    1, 1
  );
INSERT INTO students 
VALUES 
  (2, 'Hoa', 'Hai phong', NULL, 1, 1);
INSERT INTO students 
VALUES 
  (
    3, 'Manh', 'HCM', '0123123123', 0, 2
  );
CREATE TABLE subjects(
  sub_id INT PRIMARY KEY AUTO_INCREMENT , 
  sub_name VARCHAR(50) NOT NULL, 
  credit INT NOT NULL CHECK (credit>=1), 
  statuss BIT DEFAULT 1 
);
INSERT INTO subjects 
VALUES 
  (1, 'CF', 5, 1), 
  (2, 'C', 6, 1), 
  (3, 'HDJ', 5, 1), 
  (4, 'RDBMS', 10, 1);
CREATE TABLE mark(
  mark_id INT PRIMARY KEY  AUTO_INCREMENT, 
  
  sub_id INT NOT NULL , 
  FOREIGN KEY(sub_id) REFERENCES subjects(sub_id), 
  student_id INT, 
  FOREIGN KEY(student_id) REFERENCES students(student_id), 
  mark FLOAT DEFAULT 0 CHECK(mark BETWEEN 0 AND 100), 
  exam_times TINYINT 
);
INSERT INTO mark 
VALUES 
  (1, 1, 1, 8, 1), 
  (2, 1, 2, 10, 2), 
  (3, 2, 1, 12, 3);
-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
SELECT 
 *
FROM
    students 
WHERE
    student_name LIKE 'h%';
-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
  SELECT * FROM classes WHERE month(start_date) = 12;

-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
SELECT 
    *
FROM
    subjects
WHERE
    credit BETWEEN 3 AND 5;
-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
 SET SQL_SAFE_UPDATES =0;
 UPDATE students SET classes_id=2
 WHERE students.student_name='Hung';
SET SQL_SAFE_UPDATES =1;
SELECT 
    *
FROM
    students;
-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp

  
  SELECT  s.student_name AS 'TÊN HỌC SINH'  , sb.sub_name AS'TÊN MÔN HỌC',m.mark AS'ĐIỂM' FROM mark m 
  INNER JOIN students s ON s.student_id = m.student_id 
    INNER JOIN subjects  sb ON sb.sub_id = m.sub_id ORDER  BY m.mark DESC , s.student_name 

 -- drop DATABASE quan_ly_sinh_vien