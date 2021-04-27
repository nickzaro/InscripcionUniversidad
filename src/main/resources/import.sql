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