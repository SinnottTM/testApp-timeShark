drop table IF EXISTS STAFF;
drop table IF EXISTS SHIFTS;

create TABLE STAFF (
    id INT PRIMARY KEY,
    management BIT NOT NULL,
    name VARCHAR(50) NOT NULL,
    contract VARCHAR(50) NOT NULL,
    hours INT NOT NULL
);

insert into STAFF values(1, 1, 'Glenn', 'Manager', 35);
insert into STAFF values(2, 0, 'Tim', 'Challenging Behaviour Specalist', 35);
insert into STAFF values(3, 0, 'Ray', 'Challenging Behaviour Specalist', 35);
insert into STAFF values(4, 0, 'Gordon', 'Nurse', 35);
insert into STAFF values(5, 0, 'Leila', 'Assistant Manager', 35);
insert into STAFF values(6, 0, 'Mo', 'Floor Staff', 30);
insert into STAFF values(7, 0, 'Brenda', 'Floor Staff', 30);

------------------------------------------------------------------------------------------------------------------------

create TABLE SHIFTS (
    id INT PRIMARY KEY,
    shifts VARCHAR(50) NOT NULL,
    shift_date TIMESTAMP NOT NULL,
    staff_id INT NOT NULL,
    FOREIGN KEY (staff_id) REFERENCES STAFF(id)
);

/*
Shift breakdown

'EARLY',  '2020-10-01 06:00:00',
'LATE',  '2020-10-01 14:00:00',
'NIGHT',  '2020-10-01 22:00:00',
'OFF',   '2020-10-01 00:00:00',
*/

/* Glenn */

insert into SHIFTS values(1, 'EARLY', '2020-09-11 06:00:00', 1);
insert into SHIFTS values(2, 'LATE', '2020-09-12 14:00:00', 1);
insert into SHIFTS values(3, 'NIGHT', '2020-09-13 22:00:00', 1);
insert into SHIFTS values(4, 'OFF', '2020-09-14 00:00:00', 1);
insert into SHIFTS values(5, 'EARLY', '2020-09-15 06:00:00', 1);
insert into SHIFTS values(6, 'LATE', '2020-09-16 14:00:00', 1);
insert into SHIFTS values(7, 'NIGHT', '2020-09-17 22:00:00', 1);
insert into SHIFTS values(8, 'OFF', '2020-09-18 00:00:00', 1);

/*
Tim
INSERT INTO SHIFTS VALUES(9, 'EARLY',  '2020-10-01 00:06:00', 2);
INSERT INTO SHIFTS VALUES(10, 'LATE',  '2020-10-01 14:00:00', 2);
INSERT INTO SHIFTS VALUES(11, 'NIGHT',  '2020-10-01 22:00:00', 2);
INSERT INTO SHIFTS VALUES(12, 'OFF',   '2020-10-01 00:00:00', 2);
Ray
INSERT INTO SHIFTS VALUES(13, 'EARLY',  '2020-08-30 00:00:00', 3);
INSERT INTO SHIFTS VALUES(14, 'LATE',  '2020-10-01 14:00:00', 3);
INSERT INTO SHIFTS VALUES(15, 'NIGHT',  '2020-10-01 22:00:00', 3);
INSERT INTO SHIFTS VALUES(16, 'OFF',   '2020-10-01 00:00:00', 3);
Gordon
INSERT INTO SHIFTS VALUES(17, 'EARLY',  '2020-08-29 00:00:00', 4);
INSERT INTO SHIFTS VALUES(18, 'LATE',  '2020-10-01 14:00:00', 4);
INSERT INTO SHIFTS VALuES(19, 'NIGHT',  '2020-08-28 00:00:00', 4);
INSERT INTO SHIFTS VALUES(20, 'OFF',  '2020-08-28 00:00:00', 4);
Leila
INSERT INTO SHIFTS VALUES(21, 'EARLY',  '2020-10-01 06:00:00', 5);
INSERT INTO SHIFTS VALUES(22, 'LATE',  '2020-10-01 14:00:00', 5);
INSERT INTO SHIFTS VALUES(23, 'NIGHT',  '2020-10-01 22:00:00', 5);
INSERT INTO SHIFTS VALUES(24, 'OFF',  '2020-08-28 00:00:00', 5);
Mo
INSERT INTO SHIFTS VALUES(25, 'EARLY',  '2020-08-28 00:00:00', 6);
INSERT INTO SHIFTS VALUES(26, 'LATE',  '2020-08-28 00:00:00', 6);
INSERT INTO SHIFTS VALUES(27, 'NIGHT',  '2020-10-01 22:00:00', 6);
INSERT INTO SHIFTS VALUES(28, 'OFF',  '2020-08-28 00:00:00', 6);
Brenda
INSERT INTO SHIFTS VALUES(29, 'EARLY',  '2020-10-01 06:00:00', 7);
INSERT INTO SHIFTS VALUES(30, 'LATE',  '2020-10-01 14:00:00', 7);
INSERT INTO SHIFTS VALUES(31, 'NIGHT',  '2020-10-01 22:00:00', 7);
INSERT INTO SHIFTS VALUES(32, 'OFF',  '2020-08-28 00:00:00', 7);
Random
INSERT INTO SHIFTS VALUES(33, 'EARLY',  '2020-08-30 00:00:00', 1);
INSERT INTO SHIFTS VALUES(34, 'LATE',  '2020-10-01 14:00:00', 2);
INSERT INTO SHIFTS VALUES(35, 'NIGHT',  '2020-10-01 22:00:00', 3);

*/
------------------------------------------------------------------------------------------------------------------------




