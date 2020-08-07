DROP TABLE IF EXISTS STAFF;

CREATE TABLE STAFF (
    id INT PRIMARY KEY,
    management BIT NOT NULL,
    name VARCHAR(50) NOT NULL,
    contract VARCHAR(50) NOT NULL,
    hours INT NOT NULL
);

INSERT INTO STAFF VALUES(1, 1, 'Glenn', 'Manager', 35);
INSERT INTO STAFF VALUES(2, 0, 'Tim', 'Challenging Behaviour Specalist', 35);
INSERT INTO STAFF VALUES(3, 0, 'Ray', 'Challenging Behaviour Specalist', 35);
INSERT INTO STAFF VALUES(4, 0, 'Gordon', 'Nurse', 35);
INSERT INTO STAFF VALUES(5, 0, 'Leila', 'Assistant Manager', 35);
INSERT INTO STAFF VALUES(6, 0, 'Mo', 'Floor Staff', 30);
INSERT INTO STAFF VALUES(7, 0, 'Brenda', 'Floor Staff', 30);
