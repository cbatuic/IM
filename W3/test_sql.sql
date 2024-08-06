ALTER TABLE person MODIFY person_id SMALLINT UNSIGNED AUTO_INCREMENT;

desc person;

INSERT INTO person
(person_id, fname, lname, gender, birth_date)
VALUES (null, 'William','Turner', 'M', '1972-05-27');

SELECT person_id, fname, lname, birth_date
FROM person;

SELECT person_id, fname, lname, birth_date
 FROM person
 WHERE person_id = 1;
 
INSERT INTO favorite_food (person_id, food)
VALUES (1, 'pizza');

INSERT INTO favorite_food (person_id, food)
VALUES (1, 'cookies');

INSERT INTO favorite_food (person_id, food)
VALUES (1, 'nachos');

SELECT food
FROM favorite_food
WHERE person_id = 1
ORDER BY food;

INSERT INTO person
(person_id, fname, lname, gender, birth_date,
 street, city, state, country, postal_code)
VALUES (null, 'Susan','Smith', 'F', '1975-11-02',
'23 Maple St.', 'Arlington', 'VA', 'USA', '20220');

SELECT person_id, fname, lname, birth_date
FROM person;

UPDATE person
SET street = '1225 Tremont St.',
 city = 'Boston',
 state = 'MA',
 country = 'USA',
 postal_code = '02138'
 WHERE person_id = 1;
 
UPDATE person
SET birth_date = str_to_date('DEC-21-1980' , '%b-%d-%Y')
 WHERE person_id = 1;
