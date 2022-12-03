USE kucher;


DROP FUNCTION IF EXISTS max_user_age;


DELIMITER //
CREATE FUNCTION max_user_age()
    RETURNS INTEGER DETERMINISTIC
BEGIN
   DECLARE max_user_age INTEGER;
   SELECT MAX(age)
   INTO max_user_age
   FROM user;
   RETURN max_user_age;
END; //
DELIMITER //