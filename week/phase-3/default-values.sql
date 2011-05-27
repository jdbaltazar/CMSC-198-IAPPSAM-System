USE IAPPSAM;

INSERT INTO ACCOUNT_TYPE VALUES
("System Administrator"),
("SPSO Personnel"),
("Non-SPSO Personnel (Head)"),
("Non-SPSO Personnel (Employee)");


INSERT INTO DISPOSAL (name) VALUES 
("Destroyed"),
("Sold at private sale"),
("Sold at public auction"),
("Transferred Without Cost");

INSERT INTO MODE_OF_PROCUREMENT VALUES
("Shopping");

INSERT INTO UNIT(name) VALUES 
('PCS');

INSERT INTO ITEM_STATUS(name) VALUES
('Not Available'),
('Available');

INSERT INTO ITEM_CONDITION(name) VALUES
('Good Condition');

INSERT INTO ITEM_CATEGORY(name) VALUES
('Common Office Supplies'),
('Other Office Supplies'),
('Common Office Devices'),
('Common Office Supplies (Exclusive Distributorship)'),
('Common Computer Supplies'),
('Common Janitorial Supplies'),
('Common Electrical/Planing Supplies'),
('Office Forms (for Purchasing)'),
('Others');

