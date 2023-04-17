USE quan_ly_sinh_vien;
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất. 
SELECT  *
 FROM  subjects  s 
WHERE credit = ( SELECT  MAX(credit) FROM subjects );
 -- Hiển thị các thông tin môn học có điểm thi lớn nhất.
 SELECT  s.*
 FROM mark m 
 INNER JOIN subjects s ON s.sub_id=m.sub_id WHERE mark =  (SELECT MAX(m.mark) FROM  mark m ) ; 
 
 -- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên,
 -- xếp hạng theo thứ tự điểm giảm dần  
 SELECT s.* , AVG(m.mark) AS diem_trung_binh
 FROM students s 
 INNER JOIN mark m ON m.student_id=s.student_id GROUP BY s.student_id
 ORDER BY diem_trung_binh DESC;
 