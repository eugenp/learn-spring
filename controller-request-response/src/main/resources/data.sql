INSERT INTO Project(id, name, date_created) VALUES (default, 'Project 1', '2019-06-13');
INSERT INTO Project(id, name, date_created) VALUES (default, 'Project 2', '2019-06-14');
INSERT INTO Project(id, name, date_created) VALUES (default, 'Project 3', '2019-06-15');

INSERT INTO Task(id, name, date_created, due_date, description, project_id) VALUES (default, 'Task 1', '2019-06-13', '2019-07-13', 'Task 1 Description', 1);
INSERT INTO Task(id, name, date_created, due_date, description, project_id) VALUES (default, 'Task 2', '2019-06-13', '2019-06-15', 'Task 2 Description', 1);
INSERT INTO Task(id, name, date_created, due_date, description, project_id) VALUES (default, 'Task 3', '2019-06-13', '2019-07-13', 'Task 3 Description', 1);
INSERT INTO Task(id, name, date_created, due_date, description, project_id) VALUES (default, 'Task 4', '2019-06-13', '2019-06-25', 'Task 4 Description', 2); 