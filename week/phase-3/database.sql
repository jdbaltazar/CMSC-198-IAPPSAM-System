SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `IAPPSAM` ;
CREATE SCHEMA IF NOT EXISTS `IAPPSAM` ;
SHOW WARNINGS;
USE `IAPPSAM` ;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`Person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Person` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Person` (
  `Person_ID` INT NOT NULL AUTO_INCREMENT ,
  `Title` VARCHAR(20) NULL ,
  `Name` VARCHAR(80) NOT NULL ,
  PRIMARY KEY (`Person_ID`) ,
  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`Contact`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Contact` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Contact` (
  `Contact_ID` INT NOT NULL AUTO_INCREMENT ,
  `Data` VARCHAR(45) NOT NULL ,
  `Contact_Type` INT NOT NULL ,
  PRIMARY KEY (`Contact_ID`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`Employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Employee` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Employee` (
  `Employee_ID` INT NOT NULL AUTO_INCREMENT ,
  `Designation` VARCHAR(45) NOT NULL ,
  `Employee_Number` VARCHAR(45) NULL ,
  `Person_ID` INT NOT NULL ,
  PRIMARY KEY (`Employee_ID`) ,
  INDEX `fk_Employee_Person1` (`Person_ID` ASC) ,
  CONSTRAINT `fk_Employee_Person1`
    FOREIGN KEY (`Person_ID` )
    REFERENCES `IAPPSAM`.`Person` (`Person_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`Supplier`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Supplier` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Supplier` (
  `Supplier_ID` INT NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(80) NOT NULL ,
  `Address` VARCHAR(100) NOT NULL ,
  `TIN` VARCHAR(45) NULL ,
  `Contact_Person_ID` INT NOT NULL ,
  PRIMARY KEY (`Supplier_ID`) ,
  INDEX `fk_Supplier_Employee1` (`Contact_Person_ID` ASC) ,
  CONSTRAINT `fk_Supplier_Employee1`
    FOREIGN KEY (`Contact_Person_ID` )
    REFERENCES `IAPPSAM`.`Employee` (`Employee_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`DivisionOffice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`DivisionOffice` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`DivisionOffice` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `Division` VARCHAR(80) NOT NULL ,
  `Office` VARCHAR(80) NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`Building`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Building` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Building` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(80) NOT NULL ,
  `Address` VARCHAR(200) NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`Signatory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Signatory` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Signatory` (
  `Signatory_ID` INT NOT NULL AUTO_INCREMENT ,
  `Description` VARCHAR(45) NOT NULL ,
  `Date` DATE NULL ,
  `Employee_ID` INT NOT NULL ,
  PRIMARY KEY (`Signatory_ID`) ,
  INDEX `fk_Signatory_Employee2` (`Employee_ID` ASC) ,
  CONSTRAINT `fk_Signatory_Employee2`
    FOREIGN KEY (`Employee_ID` )
    REFERENCES `IAPPSAM`.`Employee` (`Employee_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`Purchase_Request`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Purchase_Request` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Purchase_Request` (
  `Purchase_Request_ID` INT NOT NULL AUTO_INCREMENT ,
  `DivisionOffice_ID` INT NOT NULL ,
  `PR_Number` VARCHAR(45) NULL ,
  `PR_Date` DATE NULL ,
  `SAI_Number` VARCHAR(45) NULL ,
  `SAI_Date` DATE NULL ,
  `ALOBS_Number` VARCHAR(45) NULL ,
  `ALOBS_Date` DATE NULL ,
  `Purpose` VARCHAR(200) NOT NULL ,
  `Requested_by` INT NOT NULL ,
  `Approved_by` INT NOT NULL ,
  PRIMARY KEY (`Purchase_Request_ID`) ,
  INDEX `fk_Purchase_Request_DivisionOffice1` (`DivisionOffice_ID` ASC) ,
  INDEX `fk_Purchase_Request_Employee1` (`Requested_by` ASC) ,
  INDEX `fk_Purchase_Request_Employee2` (`Approved_by` ASC) ,
  CONSTRAINT `fk_Purchase_Request_DivisionOffice1`
    FOREIGN KEY (`DivisionOffice_ID` )
    REFERENCES `IAPPSAM`.`DivisionOffice` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Purchase_Request_Employee1`
    FOREIGN KEY (`Requested_by` )
    REFERENCES `IAPPSAM`.`Employee` (`Employee_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Purchase_Request_Employee2`
    FOREIGN KEY (`Approved_by` )
    REFERENCES `IAPPSAM`.`Employee` (`Employee_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`Item_Condition`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Item_Condition` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Item_Condition` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`Item_Status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Item_Status` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Item_Status` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(50) NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`Unit`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Unit` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Unit` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(20) NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`Item_Category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Item_Category` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Item_Category` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(200) NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`Item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Item` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Item` (
  `Item_ID` INT NOT NULL AUTO_INCREMENT ,
  `Description` VARCHAR(500) NOT NULL ,
  `Stock_Number` VARCHAR(45) NULL ,
  `Price` DECIMAL(50,2) NULL ,
  `Date_Acquired` DATE NULL ,
  `Inventory_Item_Number` VARCHAR(60) NULL ,
  `Property_Number` VARCHAR(45) NULL ,
  `Item_Condition_ID` INT NOT NULL ,
  `Item_Status_ID` INT NOT NULL ,
  `Unit_ID` INT NOT NULL ,
  `Item_Category_ID` INT NOT NULL ,
  PRIMARY KEY (`Item_ID`) ,
  INDEX `fk_Item_Item_Condition1` (`Item_Condition_ID` ASC) ,
  INDEX `fk_Item_Item_Status1` (`Item_Status_ID` ASC) ,
  INDEX `fk_Item_Unit1` (`Unit_ID` ASC) ,
  INDEX `fk_Item_Item_Category1` (`Item_Category_ID` ASC) ,
  UNIQUE INDEX `Description_UNIQUE` (`Description` ASC) ,
  CONSTRAINT `fk_Item_Item_Condition1`
    FOREIGN KEY (`Item_Condition_ID` )
    REFERENCES `IAPPSAM`.`Item_Condition` (`id` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Item_Item_Status1`
    FOREIGN KEY (`Item_Status_ID` )
    REFERENCES `IAPPSAM`.`Item_Status` (`id` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Item_Unit1`
    FOREIGN KEY (`Unit_ID` )
    REFERENCES `IAPPSAM`.`Unit` (`id` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Item_Item_Category1`
    FOREIGN KEY (`Item_Category_ID` )
    REFERENCES `IAPPSAM`.`Item_Category` (`id` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`PR_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`PR_Line` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`PR_Line` (
  `PR_Line_ID` INT NULL AUTO_INCREMENT ,
  `Quantity` INT NOT NULL ,
  `Estimated_Unit_Cost` DECIMAL(50,2) NULL ,
  `Purchase_Request_ID` INT NOT NULL ,
  `Item_ID` INT NOT NULL ,
  PRIMARY KEY (`PR_Line_ID`) ,
  INDEX `fk_PR_Line_Purchase_Request1` (`Purchase_Request_ID` ASC) ,
  INDEX `fk_PR_Line_Item1` (`Item_ID` ASC) ,
  CONSTRAINT `fk_PR_Line_Purchase_Request1`
    FOREIGN KEY (`Purchase_Request_ID` )
    REFERENCES `IAPPSAM`.`Purchase_Request` (`Purchase_Request_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_PR_Line_Item1`
    FOREIGN KEY (`Item_ID` )
    REFERENCES `IAPPSAM`.`Item` (`Item_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`Mode_Of_Procurement`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Mode_Of_Procurement` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Mode_Of_Procurement` (
  `Id` INT NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(80) NOT NULL ,
  PRIMARY KEY (`Id`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`Purchase_Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Purchase_Order` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Purchase_Order` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Supplier_ID` INT NOT NULL ,
  `PO_Number` VARCHAR(45) NOT NULL ,
  `Date` DATE NOT NULL ,
  `Mode_Of_Procurement_ID` INT NOT NULL ,
  `DivisionOffice_ID` INT NOT NULL ,
  `Date_Of_Delivery` VARCHAR(100) NOT NULL ,
  `Payment_Term` VARCHAR(80) NULL ,
  `Delivery_Term` VARCHAR(80) NULL ,
  `Total_Amount_In_Words` VARCHAR(100) NULL ,
  `OR_Number` VARCHAR(60) NULL ,
  `Amount` DECIMAL(50,2) NULL ,
  `Supplier_Name_ID` INT NOT NULL ,
  `Supplier_Date` DATE NOT NULL ,
  `Accountant_ID` INT NOT NULL ,
  `Accountant_Date` DATE NOT NULL ,
  `Dean_ID` INT NOT NULL ,
  `Dean_Date` DATE NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Purchase_Order_Supplier1` (`Supplier_ID` ASC) ,
  INDEX `fk_Purchase_Order_DivisionOffice1` (`DivisionOffice_ID` ASC) ,
  INDEX `fk_Purchase_Order_Mode_Of_Procurement1` (`Mode_Of_Procurement_ID` ASC) ,
  INDEX `fk_Purchase_Order_Employee1` (`Supplier_Name_ID` ASC) ,
  INDEX `fk_Purchase_Order_Employee2` (`Accountant_ID` ASC) ,
  INDEX `fk_Purchase_Order_Employee3` (`Dean_ID` ASC) ,
  CONSTRAINT `fk_Purchase_Order_Supplier1`
    FOREIGN KEY (`Supplier_ID` )
    REFERENCES `IAPPSAM`.`Supplier` (`Supplier_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Purchase_Order_DivisionOffice1`
    FOREIGN KEY (`DivisionOffice_ID` )
    REFERENCES `IAPPSAM`.`DivisionOffice` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Purchase_Order_Mode_Of_Procurement1`
    FOREIGN KEY (`Mode_Of_Procurement_ID` )
    REFERENCES `IAPPSAM`.`Mode_Of_Procurement` (`Id` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Purchase_Order_Employee1`
    FOREIGN KEY (`Supplier_Name_ID` )
    REFERENCES `IAPPSAM`.`Employee` (`Employee_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Purchase_Order_Employee2`
    FOREIGN KEY (`Accountant_ID` )
    REFERENCES `IAPPSAM`.`Employee` (`Employee_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Purchase_Order_Employee3`
    FOREIGN KEY (`Dean_ID` )
    REFERENCES `IAPPSAM`.`Employee` (`Employee_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`PO_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`PO_Line` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`PO_Line` (
  `Id` INT NOT NULL AUTO_INCREMENT ,
  `Item_ID` INT NOT NULL ,
  `PO_Id` INT NOT NULL ,
  `Quantity` INT NOT NULL ,
  INDEX `fk_PO_Line_Item1` (`Item_ID` ASC) ,
  PRIMARY KEY (`Id`) ,
  INDEX `fk_PO_Line_Purchase_Order1` (`PO_Id` ASC) ,
  CONSTRAINT `fk_PO_Line_Item1`
    FOREIGN KEY (`Item_ID` )
    REFERENCES `IAPPSAM`.`Item` (`Item_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_PO_Line_Purchase_Order1`
    FOREIGN KEY (`PO_Id` )
    REFERENCES `IAPPSAM`.`Purchase_Order` (`id` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`PAR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`PAR` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`PAR` (
  `PAR_ID` INT NOT NULL AUTO_INCREMENT ,
  `Supplier_ID` INT NOT NULL ,
  `Signatory_ID` INT NOT NULL ,
  `Signatory_ID1` INT NOT NULL ,
  PRIMARY KEY (`PAR_ID`) ,
  INDEX `fk_PAR_Supplier1` (`Supplier_ID` ASC) ,
  INDEX `fk_PAR_Signatory1` (`Signatory_ID` ASC) ,
  INDEX `fk_PAR_Signatory2` (`Signatory_ID1` ASC) ,
  CONSTRAINT `fk_PAR_Supplier1`
    FOREIGN KEY (`Supplier_ID` )
    REFERENCES `IAPPSAM`.`Supplier` (`Supplier_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_PAR_Signatory1`
    FOREIGN KEY (`Signatory_ID` )
    REFERENCES `IAPPSAM`.`Signatory` (`Signatory_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_PAR_Signatory2`
    FOREIGN KEY (`Signatory_ID1` )
    REFERENCES `IAPPSAM`.`Signatory` (`Signatory_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`PAR_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`PAR_Line` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`PAR_Line` (
  `Item_ID` INT NOT NULL ,
  `Property_Number` VARCHAR(45) NULL ,
  `PAR_ID` INT NOT NULL ,
  PRIMARY KEY (`PAR_ID`, `Item_ID`) ,
  INDEX `fk_PAR_Line_Item1` (`Item_ID` ASC) ,
  INDEX `fk_PAR_Line_PAR1` (`PAR_ID` ASC) ,
  CONSTRAINT `fk_PAR_Line_Item1`
    FOREIGN KEY (`Item_ID` )
    REFERENCES `IAPPSAM`.`Item` (`Item_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_PAR_Line_PAR1`
    FOREIGN KEY (`PAR_ID` )
    REFERENCES `IAPPSAM`.`PAR` (`PAR_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`ICS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`ICS` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`ICS` (
  `ICS_ID` INT NOT NULL AUTO_INCREMENT ,
  `ICS_Number` VARCHAR(45) NULL ,
  `Purpose` VARCHAR(200) NULL ,
  `Supplier_ID` INT NOT NULL ,
  `Signatory_ID` INT NOT NULL ,
  `Signatory_ID1` INT NOT NULL ,
  PRIMARY KEY (`ICS_ID`) ,
  INDEX `fk_ICS_Number_Supplier1` (`Supplier_ID` ASC) ,
  INDEX `fk_ICS_Signatory1` (`Signatory_ID` ASC) ,
  INDEX `fk_ICS_Signatory2` (`Signatory_ID1` ASC) ,
  CONSTRAINT `fk_ICS_Number_Supplier1`
    FOREIGN KEY (`Supplier_ID` )
    REFERENCES `IAPPSAM`.`Supplier` (`Supplier_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_ICS_Signatory1`
    FOREIGN KEY (`Signatory_ID` )
    REFERENCES `IAPPSAM`.`Signatory` (`Signatory_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_ICS_Signatory2`
    FOREIGN KEY (`Signatory_ID1` )
    REFERENCES `IAPPSAM`.`Signatory` (`Signatory_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`ICS_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`ICS_Line` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`ICS_Line` (
  `Quantity` INT NOT NULL ,
  `Item_ID` INT NOT NULL ,
  `Estimated_Useful_Life` INT NOT NULL ,
  `ICS_ID` INT NOT NULL ,
  PRIMARY KEY (`ICS_ID`, `Item_ID`) ,
  INDEX `fk_ICS_Line_ICS1` (`ICS_ID` ASC) ,
  INDEX `fk_ICS_Line_Item1` (`Item_ID` ASC) ,
  CONSTRAINT `fk_ICS_Line_ICS1`
    FOREIGN KEY (`ICS_ID` )
    REFERENCES `IAPPSAM`.`ICS` (`ICS_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_ICS_Line_Item1`
    FOREIGN KEY (`Item_ID` )
    REFERENCES `IAPPSAM`.`Item` (`Item_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`PTRPA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`PTRPA` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`PTRPA` (
  `PTRPA_ID` INT NOT NULL AUTO_INCREMENT ,
  `UP_Control_Number` VARCHAR(45) NULL ,
  `DivisionOffice_ID` INT NOT NULL ,
  `DivisionOffice_ID1` INT NOT NULL ,
  `Signatory_ID` INT NOT NULL ,
  `Signatory_ID1` INT NOT NULL ,
  `Signatory_ID2` INT NOT NULL ,
  PRIMARY KEY (`PTRPA_ID`) ,
  INDEX `fk_PTRPA_DivisionOffice1` (`DivisionOffice_ID` ASC) ,
  INDEX `fk_PTRPA_DivisionOffice2` (`DivisionOffice_ID1` ASC) ,
  INDEX `fk_PTRPA_Signatory1` (`Signatory_ID` ASC) ,
  INDEX `fk_PTRPA_Signatory2` (`Signatory_ID1` ASC) ,
  INDEX `fk_PTRPA_Signatory3` (`Signatory_ID2` ASC) ,
  CONSTRAINT `fk_PTRPA_DivisionOffice1`
    FOREIGN KEY (`DivisionOffice_ID` )
    REFERENCES `IAPPSAM`.`DivisionOffice` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_PTRPA_DivisionOffice2`
    FOREIGN KEY (`DivisionOffice_ID1` )
    REFERENCES `IAPPSAM`.`DivisionOffice` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_PTRPA_Signatory1`
    FOREIGN KEY (`Signatory_ID` )
    REFERENCES `IAPPSAM`.`Signatory` (`Signatory_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_PTRPA_Signatory2`
    FOREIGN KEY (`Signatory_ID1` )
    REFERENCES `IAPPSAM`.`Signatory` (`Signatory_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_PTRPA_Signatory3`
    FOREIGN KEY (`Signatory_ID2` )
    REFERENCES `IAPPSAM`.`Signatory` (`Signatory_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`PTRPA_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`PTRPA_Line` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`PTRPA_Line` (
  `Item_ID` INT NOT NULL ,
  `ARE_MR_Number` VARCHAR(45) NULL ,
  `Quantity` INT NOT NULL ,
  `Remarks` VARCHAR(100) NULL ,
  `PTRPA_ID` INT NOT NULL ,
  PRIMARY KEY (`PTRPA_ID`, `Item_ID`) ,
  INDEX `fk_PTRPA_Line_Item1` (`Item_ID` ASC) ,
  INDEX `fk_PTRPA_Line_PTRPA1` (`PTRPA_ID` ASC) ,
  CONSTRAINT `fk_PTRPA_Line_Item1`
    FOREIGN KEY (`Item_ID` )
    REFERENCES `IAPPSAM`.`Item` (`Item_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_PTRPA_Line_PTRPA1`
    FOREIGN KEY (`PTRPA_ID` )
    REFERENCES `IAPPSAM`.`PTRPA` (`PTRPA_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`Waste_Materials_Report`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Waste_Materials_Report` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Waste_Materials_Report` (
  `Waste_Materials_Report_ID` INT NOT NULL AUTO_INCREMENT ,
  `Place_Of_Storage` VARCHAR(80) NULL ,
  `Date` DATE NOT NULL ,
  `Signatory_ID` INT NOT NULL ,
  `Signatory_ID1` INT NOT NULL ,
  `Signatory_ID2` INT NOT NULL ,
  `Signatory_ID3` INT NOT NULL ,
  PRIMARY KEY (`Waste_Materials_Report_ID`) ,
  INDEX `fk_Waste_Materials_Report_Signatory1` (`Signatory_ID` ASC) ,
  INDEX `fk_Waste_Materials_Report_Signatory2` (`Signatory_ID1` ASC) ,
  INDEX `fk_Waste_Materials_Report_Signatory3` (`Signatory_ID2` ASC) ,
  INDEX `fk_Waste_Materials_Report_Signatory4` (`Signatory_ID3` ASC) ,
  CONSTRAINT `fk_Waste_Materials_Report_Signatory1`
    FOREIGN KEY (`Signatory_ID` )
    REFERENCES `IAPPSAM`.`Signatory` (`Signatory_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Waste_Materials_Report_Signatory2`
    FOREIGN KEY (`Signatory_ID1` )
    REFERENCES `IAPPSAM`.`Signatory` (`Signatory_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Waste_Materials_Report_Signatory3`
    FOREIGN KEY (`Signatory_ID2` )
    REFERENCES `IAPPSAM`.`Signatory` (`Signatory_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Waste_Materials_Report_Signatory4`
    FOREIGN KEY (`Signatory_ID3` )
    REFERENCES `IAPPSAM`.`Signatory` (`Signatory_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`Disposal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Disposal` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Disposal` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(80) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`WMR_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`WMR_Line` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`WMR_Line` (
  `Item_ID` INT NOT NULL ,
  `Quantity` INT NOT NULL ,
  `OR_Number` VARCHAR(60) NOT NULL ,
  `Disposed_To` VARCHAR(80) NULL ,
  `Waste_Materials_Report_ID` INT NOT NULL ,
  `id` INT NOT NULL ,
  PRIMARY KEY (`Waste_Materials_Report_ID`, `Item_ID`) ,
  INDEX `fk_WMR_Line_Waste_Materials_Report1` (`Waste_Materials_Report_ID` ASC) ,
  INDEX `fk_WMR_Line_Item1` (`Item_ID` ASC) ,
  INDEX `fk_WMR_Line_Disposal1` (`id` ASC) ,
  CONSTRAINT `fk_WMR_Line_Waste_Materials_Report1`
    FOREIGN KEY (`Waste_Materials_Report_ID` )
    REFERENCES `IAPPSAM`.`Waste_Materials_Report` (`Waste_Materials_Report_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_WMR_Line_Item1`
    FOREIGN KEY (`Item_ID` )
    REFERENCES `IAPPSAM`.`Item` (`Item_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_WMR_Line_Disposal1`
    FOREIGN KEY (`id` )
    REFERENCES `IAPPSAM`.`Disposal` (`id` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`IIRUP`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`IIRUP` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`IIRUP` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `As_Of` DATE NOT NULL ,
  `Station` VARCHAR(80) NULL ,
  `Accountable_Officer_ID` INT NOT NULL ,
  `Requested_by_ID` INT NOT NULL ,
  `Approved_by_ID` INT NOT NULL ,
  `Inspector_ID` INT NOT NULL ,
  `Witness_ID` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `fk_IIRUP_Employee2` (`Accountable_Officer_ID` ASC) ,
  INDEX `fk_IIRUP_Employee1` (`Requested_by_ID` ASC) ,
  INDEX `fk_IIRUP_Employee3` (`Approved_by_ID` ASC) ,
  INDEX `fk_IIRUP_Employee4` (`Inspector_ID` ASC) ,
  INDEX `fk_IIRUP_Employee5` (`Witness_ID` ASC) ,
  CONSTRAINT `fk_IIRUP_Employee2`
    FOREIGN KEY (`Accountable_Officer_ID` )
    REFERENCES `IAPPSAM`.`Employee` (`Employee_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_IIRUP_Employee1`
    FOREIGN KEY (`Requested_by_ID` )
    REFERENCES `IAPPSAM`.`Employee` (`Employee_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_IIRUP_Employee3`
    FOREIGN KEY (`Approved_by_ID` )
    REFERENCES `IAPPSAM`.`Employee` (`Employee_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_IIRUP_Employee4`
    FOREIGN KEY (`Inspector_ID` )
    REFERENCES `IAPPSAM`.`Employee` (`Employee_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_IIRUP_Employee5`
    FOREIGN KEY (`Witness_ID` )
    REFERENCES `IAPPSAM`.`Employee` (`Employee_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`IIRUP_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`IIRUP_Line` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`IIRUP_Line` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `Disposal_ID` INT NOT NULL ,
  `Item_ID` INT NOT NULL ,
  `Quantity` INT NOT NULL ,
  `Years_In_Service` INT NOT NULL ,
  `Accumulated_Depreciation` DECIMAL(50,2) NOT NULL ,
  `Appraisal` VARCHAR(50) NULL ,
  `OR_Number` VARCHAR(45) NOT NULL ,
  `IIRUP_ID` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `fk_IIRUP_Line_Item1` (`Item_ID` ASC) ,
  INDEX `fk_IIRUP_Line_Disposal1` (`Disposal_ID` ASC) ,
  INDEX `fk_IIRUP_Line_IIRUP1` (`IIRUP_ID` ASC) ,
  CONSTRAINT `fk_IIRUP_Line_Item1`
    FOREIGN KEY (`Item_ID` )
    REFERENCES `IAPPSAM`.`Item` (`Item_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_IIRUP_Line_Disposal1`
    FOREIGN KEY (`Disposal_ID` )
    REFERENCES `IAPPSAM`.`Disposal` (`id` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_IIRUP_Line_IIRUP1`
    FOREIGN KEY (`IIRUP_ID` )
    REFERENCES `IAPPSAM`.`IIRUP` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`APP`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`APP` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`APP` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `Year` INT NOT NULL ,
  `DivisionOffice_ID` INT NOT NULL ,
  `Plan_Control_Number` VARCHAR(45) NULL ,
  `Date_Scheduled` DATE NULL ,
  `Prepared_by` INT NOT NULL ,
  `Recommended_by` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `fk_APP_DivisionOffice1` (`DivisionOffice_ID` ASC) ,
  INDEX `fk_APP_Employee1` (`Prepared_by` ASC) ,
  INDEX `fk_APP_Employee2` (`Recommended_by` ASC) ,
  CONSTRAINT `fk_APP_DivisionOffice1`
    FOREIGN KEY (`DivisionOffice_ID` )
    REFERENCES `IAPPSAM`.`DivisionOffice` (`ID` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_APP_Employee1`
    FOREIGN KEY (`Prepared_by` )
    REFERENCES `IAPPSAM`.`Employee` (`Employee_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_APP_Employee2`
    FOREIGN KEY (`Recommended_by` )
    REFERENCES `IAPPSAM`.`Employee` (`Employee_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`APP_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`APP_Line` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`APP_Line` (
  `APP_Line_ID` INT NOT NULL AUTO_INCREMENT ,
  `Item_ID` INT NOT NULL ,
  `APP_ID` INT NOT NULL ,
  `Quantity_Quarter_1` INT NOT NULL ,
  `Quantity_Quarter_2` INT NOT NULL ,
  `Quantity_Quarter_3` INT NOT NULL ,
  `Quantity_Quarter_4` INT NOT NULL ,
  PRIMARY KEY (`APP_Line_ID`) ,
  INDEX `fk_APP_Line_Item1` (`Item_ID` ASC) ,
  INDEX `fk_APP_Line_APP1` (`APP_ID` ASC) ,
  CONSTRAINT `fk_APP_Line_Item1`
    FOREIGN KEY (`Item_ID` )
    REFERENCES `IAPPSAM`.`Item` (`Item_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_APP_Line_APP1`
    FOREIGN KEY (`APP_ID` )
    REFERENCES `IAPPSAM`.`APP` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`Inventory_Of_Equipment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Inventory_Of_Equipment` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Inventory_Of_Equipment` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `DivisionOffice_ID` INT NOT NULL ,
  `Building_ID` INT NOT NULL ,
  `PreparedBy` INT NOT NULL ,
  `CommitteeMember1` INT NOT NULL ,
  `CommitteeMember2` INT NOT NULL ,
  `CounterCheckedBy` INT NOT NULL ,
  `NotedBy` INT NOT NULL ,
  `COARepresentative` INT NOT NULL ,
  `DatePrepared` DATE NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `fk_Inventory_Of_Equipment_DivisionOffice1` (`DivisionOffice_ID` ASC) ,
  INDEX `fk_Inventory_Of_Equipment_Building1` (`Building_ID` ASC) ,
  INDEX `fk_Inventory_Of_Equipment_Employee1` (`PreparedBy` ASC) ,
  INDEX `fk_Inventory_Of_Equipment_Employee2` (`CommitteeMember1` ASC) ,
  INDEX `fk_Inventory_Of_Equipment_Employee3` (`CommitteeMember2` ASC) ,
  INDEX `fk_Inventory_Of_Equipment_Employee4` (`CounterCheckedBy` ASC) ,
  INDEX `fk_Inventory_Of_Equipment_Employee5` (`NotedBy` ASC) ,
  INDEX `fk_Inventory_Of_Equipment_Employee6` (`COARepresentative` ASC) ,
  CONSTRAINT `fk_Inventory_Of_Equipment_DivisionOffice1`
    FOREIGN KEY (`DivisionOffice_ID` )
    REFERENCES `IAPPSAM`.`DivisionOffice` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Inventory_Of_Equipment_Building1`
    FOREIGN KEY (`Building_ID` )
    REFERENCES `IAPPSAM`.`Building` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Inventory_Of_Equipment_Employee1`
    FOREIGN KEY (`PreparedBy` )
    REFERENCES `IAPPSAM`.`Employee` (`Employee_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Inventory_Of_Equipment_Employee2`
    FOREIGN KEY (`CommitteeMember1` )
    REFERENCES `IAPPSAM`.`Employee` (`Employee_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Inventory_Of_Equipment_Employee3`
    FOREIGN KEY (`CommitteeMember2` )
    REFERENCES `IAPPSAM`.`Employee` (`Employee_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Inventory_Of_Equipment_Employee4`
    FOREIGN KEY (`CounterCheckedBy` )
    REFERENCES `IAPPSAM`.`Employee` (`Employee_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Inventory_Of_Equipment_Employee5`
    FOREIGN KEY (`NotedBy` )
    REFERENCES `IAPPSAM`.`Employee` (`Employee_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Inventory_Of_Equipment_Employee6`
    FOREIGN KEY (`COARepresentative` )
    REFERENCES `IAPPSAM`.`Employee` (`Employee_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`IE_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`IE_Line` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`IE_Line` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `Item_ID` INT NOT NULL ,
  `IE_ID` INT NOT NULL ,
  `Employee_ID` INT NOT NULL ,
  `Quantity` INT NOT NULL ,
  `Remarks` VARCHAR(100) NULL ,
  `How_Acquired` INT NOT NULL ,
  INDEX `fk_IE_Line_Inventory_Of_Equipment1` (`IE_ID` ASC) ,
  INDEX `fk_IE_Line_Employee1` (`Employee_ID` ASC) ,
  INDEX `fk_IE_Line_Item1` (`Item_ID` ASC) ,
  PRIMARY KEY (`ID`) ,
  INDEX `fk_IE_Line_Mode_Of_Procurement1` (`How_Acquired` ASC) ,
  CONSTRAINT `fk_IE_Line_Inventory_Of_Equipment1`
    FOREIGN KEY (`IE_ID` )
    REFERENCES `IAPPSAM`.`Inventory_Of_Equipment` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_IE_Line_Employee1`
    FOREIGN KEY (`Employee_ID` )
    REFERENCES `IAPPSAM`.`Employee` (`Employee_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_IE_Line_Item1`
    FOREIGN KEY (`Item_ID` )
    REFERENCES `IAPPSAM`.`Item` (`Item_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_IE_Line_Mode_Of_Procurement1`
    FOREIGN KEY (`How_Acquired` )
    REFERENCES `IAPPSAM`.`Mode_Of_Procurement` (`Id` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`Requisition_And_Issue_Slip`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Requisition_And_Issue_Slip` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Requisition_And_Issue_Slip` (
  `Id` INT NOT NULL AUTO_INCREMENT ,
  `DivisionOffice_ID` INT NOT NULL ,
  `RC_Code` VARCHAR(80) NULL ,
  `RIS_Number` VARCHAR(45) NOT NULL ,
  `RIS_Date` DATE NOT NULL ,
  `SAI_Number` VARCHAR(80) NULL ,
  `SAI_Date` DATE NULL ,
  `Purpose` VARCHAR(200) NOT NULL ,
  `Requested_by` INT NOT NULL ,
  `Requested_by_Date` DATE NOT NULL ,
  `Approved_by` INT NOT NULL ,
  `Approved_by_Date` DATE NOT NULL ,
  `Issued_by` INT NOT NULL ,
  `Issued_by_Date` DATE NOT NULL ,
  `Received_by` INT NOT NULL ,
  `Received_by_Date` DATE NOT NULL ,
  PRIMARY KEY (`Id`) ,
  INDEX `fk_Requisition_And_Issue_Slip_DivisionOffice1` (`DivisionOffice_ID` ASC) ,
  INDEX `fk_Requisition_And_Issue_Slip_Employee1` (`Requested_by` ASC) ,
  INDEX `fk_Requisition_And_Issue_Slip_Employee2` (`Approved_by` ASC) ,
  INDEX `fk_Requisition_And_Issue_Slip_Employee3` (`Issued_by` ASC) ,
  INDEX `fk_Requisition_And_Issue_Slip_Employee4` (`Received_by` ASC) ,
  CONSTRAINT `fk_Requisition_And_Issue_Slip_DivisionOffice1`
    FOREIGN KEY (`DivisionOffice_ID` )
    REFERENCES `IAPPSAM`.`DivisionOffice` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Requisition_And_Issue_Slip_Employee1`
    FOREIGN KEY (`Requested_by` )
    REFERENCES `IAPPSAM`.`Employee` (`Employee_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Requisition_And_Issue_Slip_Employee2`
    FOREIGN KEY (`Approved_by` )
    REFERENCES `IAPPSAM`.`Employee` (`Employee_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Requisition_And_Issue_Slip_Employee3`
    FOREIGN KEY (`Issued_by` )
    REFERENCES `IAPPSAM`.`Employee` (`Employee_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Requisition_And_Issue_Slip_Employee4`
    FOREIGN KEY (`Received_by` )
    REFERENCES `IAPPSAM`.`Employee` (`Employee_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`RIS_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`RIS_Line` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`RIS_Line` (
  `Id` INT NOT NULL AUTO_INCREMENT ,
  `Item_ID` INT NOT NULL ,
  `RIS_ID` INT NOT NULL ,
  `Quantity_Requested` INT NOT NULL ,
  `Quantity_Issued` INT NOT NULL ,
  `Remarks` VARCHAR(200) NULL ,
  INDEX `fk_RIS_Line_Item1` (`Item_ID` ASC) ,
  INDEX `fk_RIS_Line_Requisition_And_Issue_Slip1` (`RIS_ID` ASC) ,
  PRIMARY KEY (`Id`) ,
  CONSTRAINT `fk_RIS_Line_Item1`
    FOREIGN KEY (`Item_ID` )
    REFERENCES `IAPPSAM`.`Item` (`Item_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_RIS_Line_Requisition_And_Issue_Slip1`
    FOREIGN KEY (`RIS_ID` )
    REFERENCES `IAPPSAM`.`Requisition_And_Issue_Slip` (`Id` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`RSMI`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`RSMI` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`RSMI` (
  `RSMI_ID` INT NOT NULL AUTO_INCREMENT ,
  `Date` DATE NOT NULL ,
  `RSMI_Number` VARCHAR(45) NOT NULL ,
  `Signatory_ID` INT NOT NULL ,
  `Signatory_ID1` INT NOT NULL ,
  PRIMARY KEY (`RSMI_ID`) ,
  INDEX `fk_RSMI_Signatory1` (`Signatory_ID` ASC) ,
  INDEX `fk_RSMI_Signatory2` (`Signatory_ID1` ASC) ,
  CONSTRAINT `fk_RSMI_Signatory1`
    FOREIGN KEY (`Signatory_ID` )
    REFERENCES `IAPPSAM`.`Signatory` (`Signatory_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_RSMI_Signatory2`
    FOREIGN KEY (`Signatory_ID1` )
    REFERENCES `IAPPSAM`.`Signatory` (`Signatory_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`RSMI_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`RSMI_Line` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`RSMI_Line` (
  `RIS_Number` VARCHAR(45) NOT NULL ,
  `Item_ID` INT NOT NULL ,
  `Responsibility_Center` VARCHAR(80) NULL ,
  `RSMI_ID` INT NOT NULL ,
  PRIMARY KEY (`RIS_Number`, `RSMI_ID`) ,
  INDEX `fk_RSMI_Line_RSMI1` (`RSMI_ID` ASC) ,
  INDEX `fk_RSMI_Line_Item1` (`Item_ID` ASC) ,
  CONSTRAINT `fk_RSMI_Line_RSMI1`
    FOREIGN KEY (`RSMI_ID` )
    REFERENCES `IAPPSAM`.`RSMI` (`RSMI_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_RSMI_Line_Item1`
    FOREIGN KEY (`Item_ID` )
    REFERENCES `IAPPSAM`.`Item` (`Item_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`Recapitulation_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Recapitulation_Line` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Recapitulation_Line` (
  `Item_ID` INT NOT NULL ,
  `Quantity` INT NOT NULL ,
  `Account_Code` VARCHAR(45) NOT NULL ,
  `RSMI_ID` INT NOT NULL ,
  PRIMARY KEY (`RSMI_ID`, `Item_ID`) ,
  INDEX `fk_Recapitulation_Line_RSMI1` (`RSMI_ID` ASC) ,
  INDEX `fk_Recapitulation_Line_Item1` (`Item_ID` ASC) ,
  CONSTRAINT `fk_Recapitulation_Line_RSMI1`
    FOREIGN KEY (`RSMI_ID` )
    REFERENCES `IAPPSAM`.`RSMI` (`RSMI_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Recapitulation_Line_Item1`
    FOREIGN KEY (`Item_ID` )
    REFERENCES `IAPPSAM`.`Item` (`Item_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`Account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Account` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Account` (
  `Username` VARCHAR(60) NOT NULL ,
  `Password` VARCHAR(80) NOT NULL ,
  `Acquainted` TINYINT(1)  NOT NULL ,
  `Account_Type` INT NOT NULL ,
  `Person_ID` INT NOT NULL ,
  PRIMARY KEY (`Username`) ,
  INDEX `fk_Account_Person1` (`Person_ID` ASC) ,
  CONSTRAINT `fk_Account_Person1`
    FOREIGN KEY (`Person_ID` )
    REFERENCES `IAPPSAM`.`Person` (`Person_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`Person_Contact`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Person_Contact` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Person_Contact` (
  `Person_ID` INT NOT NULL ,
  `Contact_ID` INT NOT NULL ,
  PRIMARY KEY (`Contact_ID`, `Person_ID`) ,
  INDEX `fk_PersonContact_Person1` (`Person_ID` ASC) ,
  INDEX `fk_PersonContact_Contact1` (`Contact_ID` ASC) ,
  CONSTRAINT `fk_PersonContact_Person1`
    FOREIGN KEY (`Person_ID` )
    REFERENCES `IAPPSAM`.`Person` (`Person_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_PersonContact_Contact1`
    FOREIGN KEY (`Contact_ID` )
    REFERENCES `IAPPSAM`.`Contact` (`Contact_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`DivisionOffice_Contact`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`DivisionOffice_Contact` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`DivisionOffice_Contact` (
  `DivisionOffice_ID` INT NOT NULL ,
  `Contact_ID` INT NOT NULL ,
  PRIMARY KEY (`Contact_ID`, `DivisionOffice_ID`) ,
  INDEX `fk_DivisionOfficeContact_DivisionOffice1` (`DivisionOffice_ID` ASC) ,
  INDEX `fk_DivisionOfficeContact_Contact1` (`Contact_ID` ASC) ,
  CONSTRAINT `fk_DivisionOfficeContact_DivisionOffice1`
    FOREIGN KEY (`DivisionOffice_ID` )
    REFERENCES `IAPPSAM`.`DivisionOffice` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_DivisionOfficeContact_Contact1`
    FOREIGN KEY (`Contact_ID` )
    REFERENCES `IAPPSAM`.`Contact` (`Contact_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`Supplier_Contact`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Supplier_Contact` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Supplier_Contact` (
  `Supplier_ID` INT NOT NULL ,
  `Contact_ID` INT NOT NULL ,
  INDEX `fk_SupplierContact_Supplier1` (`Supplier_ID` ASC) ,
  INDEX `fk_SupplierContact_Contact1` (`Contact_ID` ASC) ,
  PRIMARY KEY (`Supplier_ID`, `Contact_ID`) ,
  CONSTRAINT `fk_SupplierContact_Supplier1`
    FOREIGN KEY (`Supplier_ID` )
    REFERENCES `IAPPSAM`.`Supplier` (`Supplier_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_SupplierContact_Contact1`
    FOREIGN KEY (`Contact_ID` )
    REFERENCES `IAPPSAM`.`Contact` (`Contact_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`Employee_DivisionOffice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Employee_DivisionOffice` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Employee_DivisionOffice` (
  `Employee_ID` INT NOT NULL ,
  `DivisionOffice_ID` INT NOT NULL ,
  PRIMARY KEY (`Employee_ID`, `DivisionOffice_ID`) ,
  INDEX `fk_Employee_DivisionOffice_Employee1` (`Employee_ID` ASC) ,
  INDEX `fk_Employee_DivisionOffice_DivisionOffice1` (`DivisionOffice_ID` ASC) ,
  CONSTRAINT `fk_Employee_DivisionOffice_Employee1`
    FOREIGN KEY (`Employee_ID` )
    REFERENCES `IAPPSAM`.`Employee` (`Employee_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Employee_DivisionOffice_DivisionOffice1`
    FOREIGN KEY (`DivisionOffice_ID` )
    REFERENCES `IAPPSAM`.`DivisionOffice` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`Log`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Log` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Log` (
  `Log_ID` INT NOT NULL AUTO_INCREMENT ,
  `Date` TIMESTAMP NOT NULL ,
  `Description` VARCHAR(500) NOT NULL ,
  PRIMARY KEY (`Log_ID`) )
ENGINE = InnoDB;

SHOW WARNINGS;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `IAPPSAM`.`Person`
-- -----------------------------------------------------
START TRANSACTION;
USE `IAPPSAM`;
INSERT INTO `IAPPSAM`.`Person` (`Person_ID`, `Title`, `Name`) VALUES (1, NULL, 'admin');

COMMIT;

-- -----------------------------------------------------
-- Data for table `IAPPSAM`.`Item_Condition`
-- -----------------------------------------------------
START TRANSACTION;
USE `IAPPSAM`;
INSERT INTO `IAPPSAM`.`Item_Condition` (`id`, `name`) VALUES (1, 'Good Condition');

COMMIT;

-- -----------------------------------------------------
-- Data for table `IAPPSAM`.`Item_Status`
-- -----------------------------------------------------
START TRANSACTION;
USE `IAPPSAM`;
INSERT INTO `IAPPSAM`.`Item_Status` (`id`, `name`) VALUES (1, 'Not Available');
INSERT INTO `IAPPSAM`.`Item_Status` (`id`, `name`) VALUES (2, 'Available');

COMMIT;

-- -----------------------------------------------------
-- Data for table `IAPPSAM`.`Unit`
-- -----------------------------------------------------
START TRANSACTION;
USE `IAPPSAM`;
INSERT INTO `IAPPSAM`.`Unit` (`id`, `name`) VALUES (1, 'Pcs.');

COMMIT;

-- -----------------------------------------------------
-- Data for table `IAPPSAM`.`Item_Category`
-- -----------------------------------------------------
START TRANSACTION;
USE `IAPPSAM`;
INSERT INTO `IAPPSAM`.`Item_Category` (`id`, `name`) VALUES (1, 'Common Office Supplies');
INSERT INTO `IAPPSAM`.`Item_Category` (`id`, `name`) VALUES (2, 'Other Office Supplies');
INSERT INTO `IAPPSAM`.`Item_Category` (`id`, `name`) VALUES (3, 'Common Office Supplies (Exclusive Distributorship)');
INSERT INTO `IAPPSAM`.`Item_Category` (`id`, `name`) VALUES (4, 'Common Computer Supplies');
INSERT INTO `IAPPSAM`.`Item_Category` (`id`, `name`) VALUES (5, 'Common Janitorial Supplies');
INSERT INTO `IAPPSAM`.`Item_Category` (`id`, `name`) VALUES (6, 'Common Electrical/Planing Supplies');
INSERT INTO `IAPPSAM`.`Item_Category` (`id`, `name`) VALUES (7, 'Office Forms (for Purchasing)');
INSERT INTO `IAPPSAM`.`Item_Category` (`id`, `name`) VALUES (8, 'Others');

COMMIT;

-- -----------------------------------------------------
-- Data for table `IAPPSAM`.`Disposal`
-- -----------------------------------------------------
START TRANSACTION;
USE `IAPPSAM`;
INSERT INTO `IAPPSAM`.`Disposal` (`id`, `name`) VALUES (1, 'Destroyed');
INSERT INTO `IAPPSAM`.`Disposal` (`id`, `name`) VALUES (2, 'Sold at private sale');
INSERT INTO `IAPPSAM`.`Disposal` (`id`, `name`) VALUES (3, 'Sold at public auction');
INSERT INTO `IAPPSAM`.`Disposal` (`id`, `name`) VALUES (4, 'Transferred Without Cost');

COMMIT;

-- -----------------------------------------------------
-- Data for table `IAPPSAM`.`Account`
-- -----------------------------------------------------
START TRANSACTION;
USE `IAPPSAM`;
INSERT INTO `IAPPSAM`.`Account` (`Username`, `Password`, `Acquainted`, `Account_Type`, `Person_ID`) VALUES ('admin', 'admin', 0, 0, 1);

COMMIT;
