  INSERT INTO account (id, email, name , password, receive_email) VALUES
  (1, 'testUser1@hotmail.com','testUser1', 'testUser1',1),
  (2, 'testUser2@hotmail.com','testUser2', 'testUser2',0),
  (3, 'testUser3@hotmail.com','testUser3', 'testUser3',1),
  (4, 'testUser4@hotmail.com','testUser4', 'testUser4',0);

  INSERT INTO kapper (id, name, age) VALUES
  (1, 'kapper1',14),
  (2, 'kapper2',12),
  (3, 'kapper3',15),
  (4, 'kapper4',16);

  INSERT INTO appointment(id,date, time, fk_account, fk_kapper) VALUES
  (1,'12-07-2021','12:07:00',1,1),
  (2,'12-07-2021','12:07:00',2,1),
  (3,'12-07-2021','12:07:00',3,4),
  (4,'12-07-2021','12:07:00',4,3)