USE kucher;

DROP PROCEDURE IF EXISTS add_zone;
DROP PROCEDURE IF EXISTS add_base_object;
DROP PROCEDURE IF EXISTS add_10_zones;
DROP PROCEDURE IF EXISTS dymanic_procedure;
DELIMITER //
CREATE PROCEDURE add_zone(

    IN zone_lvl integer
)
BEGIN
INSERT INTO zone(lvl) VALUES (zone_lvl);
END //


DROP PROCEDURE IF EXISTS add_base_object;
DELIMITER //
CREATE PROCEDURE add_base_object(
    IN object_id integer,
    IN user_id integer
)
BEGIN
INSERT INTO object_has_user VALUES (object_id, user_id);
END //


DROP PROCEDURE IF EXISTS add_10_zones;
DELIMITER //
CREATE PROCEDURE add_10_zones(
    IN zone_lvl integer
)
BEGIN
    DECLARE x int;
    SET x = 1;
    label1: LOOP
        IF x > 10 THEN LEAVE label1;
        END IF;
        INSERT INTO zone(lvl) VALUES(CONCAT(zone_lvl,x));
        SET x = x+1;
    END LOOP;
END //
DELIMITER ;

DELIMITER //


CREATE PROCEDURE dymanic_procedure()
BEGIN
    DECLARE done int DEFAULT false;
    DECLARE name_T char(25);

    DECLARE user_cursor CURSOR
        FOR SELECT name FROM user;
    DECLARE CONTINUE HANDLER
        FOR NOT FOUND SET done = TRUE;

    OPEN user_cursor;
    label:
    LOOP
        FETCH user_cursor INTO name_T;
        IF done = TRUE THEN
            LEAVE label;
        END IF;

        SET @temp_query = CONCAT('CREATE DATABASE ', name_T);
        SET @temp_drop = CONCAT('DROP DATABASE IF EXISTS ', name_T);

        PREPARE my_query FROM @temp_drop;
        EXECUTE my_query;
        DEALLOCATE PREPARE my_query;

        PREPARE my_query FROM @temp_query;
        EXECUTE my_query;
        DEALLOCATE PREPARE my_query;

        SET @iterator = 1;
        SET @LIMIT = FLOOR(1 + RAND() * (10 - 1));
        WHILE @iterator <= @LIMIT
            DO
                SET @temp_query = CONCAT('CREATE TABLE ', name_T, @iterator, ' (name VARCHAR(30) NOT NULL PRIMARY KEY);');
                SET @iterator = @iterator + 1;
                PREPARE my_query FROM @temp_query;
                EXECUTE my_query;
                DEALLOCATE PREPARE my_query;
            END WHILE;
    END LOOP;
    CLOSE user_cursor;
END //
DELIMITER ;