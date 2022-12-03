USE kucher;

DROP TRIGGER IF EXISTS prevent_delete_user;
DROP TRIGGER IF EXISTS ZoneCardinality;
DROP TRIGGER IF EXISTS object_addres_not_zero;


DELIMITER //
CREATE TRIGGER prevent_delete_user
    BEFORE DELETE
    ON user
    FOR EACH ROW
BEGIN
    SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Delete error for table country';
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER object_addres_not_zero
    BEFORE INSERT
    ON object
    FOR EACH ROW
BEGIN
    IF (NEW.adress REGEXP('00$')) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Operators can not have phone numbers with two 0 in the end';
    END IF;
END //
DELIMITER ;


DELIMITER //
CREATE TRIGGER ZoneCardinality
    AFTER  INSERT
    ON zone
    FOR EACH ROW
BEGIN
    -- DECLARE amount_rows int;
    SET @amount_rows := (SELECT COUNT(*) FROM kucher.zone);
    IF  @amount_rows>12
    THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'You can  insert row because of range cardinality';
    END IF;
END //;
DELIMITER ;


