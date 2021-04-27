/* Cursos*/
INSERT INTO `courses`(id,name_of_course,total_quota,remaining_quota) values (0,'Analisis I',50,50);
INSERT INTO `courses`(id,name_of_course,total_quota,remaining_quota) values (1,'Analisis II',40,40);
INSERT INTO `courses`(id,name_of_course,total_quota,remaining_quota) values (2,'Algebra I',30,20);
INSERT INTO `courses`(id,name_of_course,total_quota,remaining_quota) values (3,'Quimica I',30,20);

/* Horarios*/
INSERT INTO `schedules`(id,course_id,day_of_week,start_time,end_time) values (0,0,0,'08:00:00','10:00:00');
INSERT INTO `schedules`(id,course_id,day_of_week,start_time,end_time) values (3,0,1,'08:00:00','10:00:00');

INSERT INTO `schedules`(id,course_id,day_of_week,start_time,end_time) values (1,1,0,'10:00:00','12:00:00');
INSERT INTO `schedules`(id,course_id,day_of_week,start_time,end_time) values (4,1,1,'10:00:00','12:00:00');

INSERT INTO `schedules`(id,course_id,day_of_week,start_time,end_time) values (2,2,0,'12:00:00','14:00:00');
INSERT INTO `schedules`(id,course_id,day_of_week,start_time,end_time) values (5,2,1,'12:00:00','14:00:00');

INSERT INTO `schedules`(id,course_id,day_of_week,start_time,end_time) values (6,3,0,'12:00:00','14:00:00');
INSERT INTO `schedules`(id,course_id,day_of_week,start_time,end_time) values (7,3,1,'08:00:00','10:00:00');

/* Estudiantes */
INSERT INTO `students`(id,dni,first_name,last_name,padron) values (0,'12345678','Pepe','Perez','1234');
INSERT INTO `students`(id,dni,first_name,last_name,padron) values (1,'87654321','Lola','Mora','8765');

/* student_course*/
/*estudiante 0, a curso 0,1,2*/
INSERT INTO `student_course`(student_id,course_id) values (0,0);
INSERT INTO `student_course`(student_id,course_id) values (0,1);
INSERT INTO `student_course`(student_id,course_id) values (0,2);
/*estudiante 1, a curso 1,2,3*/
INSERT INTO `student_course`(student_id,course_id) values (1,1);
INSERT INTO `student_course`(student_id,course_id) values (1,2);
INSERT INTO `student_course`(student_id,course_id) values (1,3);