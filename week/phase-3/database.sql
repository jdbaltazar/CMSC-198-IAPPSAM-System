SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `IAPPSAM` ;
CREATE SCHEMA IF NOT EXISTS `IAPPSAM` ;
USE `IAPPSAM` ;

-- -----------------------------------------------------
-- Table `IAPPSAM`.`Person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Person` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Person` (
  `Person_ID` INT NOT NULL AUTO_INCREMENT ,
  `Title` VARCHAR(10) NULL ,
  `Name` VARCHAR(80) NOT NULL ,
  PRIMARY KEY (`Person_ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`Contact_Type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Contact_Type` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Contact_Type` (
  `Contact_Type` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`Contact_Type`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`Contact`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Contact` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Contact` (
  `Contact_ID` INT NOT NULL AUTO_INCREMENT ,
  `Data` VARCHAR(45) NOT NULL ,
  `Contact_Type` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`Contact_ID`) ,
  INDEX `fk_Contact_Contact_Type1` (`Contact_Type` ASC) ,
  CONSTRAINT `fk_Contact_Contact_Type1`
    FOREIGN KEY (`Contact_Type` )
    REFERENCES `IAPPSAM`.`Contact_Type` (`Contact_Type` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`Employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Employee` ;

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


-- -----------------------------------------------------
-- Table `IAPPSAM`.`Supplier`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Supplier` ;

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


-- -----------------------------------------------------
-- Table `IAPPSAM`.`Building`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Building` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Building` (
  `Building_ID` INT NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(80) NOT NULL ,
  `Address` VARCHAR(200) NULL ,
  PRIMARY KEY (`Building_ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`DivisionOffice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`DivisionOffice` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`DivisionOffice` (
  `DivisionOffice_ID` INT NOT NULL AUTO_INCREMENT ,
  `Division` VARCHAR(80) NOT NULL ,
  `Office` VARCHAR(80) NULL ,
  `Building_ID` INT NOT NULL ,
  PRIMARY KEY (`DivisionOffice_ID`) ,
  INDEX `fk_DivisionOffice_Building1` (`Building_ID` ASC) ,
  CONSTRAINT `fk_DivisionOffice_Building1`
    FOREIGN KEY (`Building_ID` )
    REFERENCES `IAPPSAM`.`Building` (`Building_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`Signatory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Signatory` ;

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


-- -----------------------------------------------------
-- Table `IAPPSAM`.`Purchase_Request`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Purchase_Request` ;

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
  `Signatory_ID` INT NOT NULL ,
  `Signatory_ID1` INT NOT NULL ,
  PRIMARY KEY (`Purchase_Request_ID`) ,
  INDEX `fk_Purchase_Request_DivisionOffice1` (`DivisionOffice_ID` ASC) ,
  INDEX `fk_Purchase_Request_Signatory1` (`Signatory_ID` ASC) ,
  INDEX `fk_Purchase_Request_Signatory2` (`Signatory_ID1` ASC) ,
  CONSTRAINT `fk_Purchase_Request_DivisionOffice1`
    FOREIGN KEY (`DivisionOffice_ID` )
    REFERENCES `IAPPSAM`.`DivisionOffice` (`DivisionOffice_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Purchase_Request_Signatory1`
    FOREIGN KEY (`Signatory_ID` )
    REFERENCES `IAPPSAM`.`Signatory` (`Signatory_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Purchase_Request_Signatory2`
    FOREIGN KEY (`Signatory_ID1` )
    REFERENCES `IAPPSAM`.`Signatory` (`Signatory_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`PR_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`PR_Line` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`PR_Line` (
  `Quantity` INT NOT NULL ,
  `Item_Description` VARCHAR(500) NOT NULL ,
  `Estimated_Unit_Cost` DECIMAL(50,2) NULL ,
  `Purchase_Request_ID` INT NOT NULL ,
  PRIMARY KEY (`Purchase_Request_ID`, `Item_Description`) ,
  INDEX `fk_PR_Line_Purchase_Request1` (`Purchase_Request_ID` ASC) ,
  CONSTRAINT `fk_PR_Line_Purchase_Request1`
    FOREIGN KEY (`Purchase_Request_ID` )
    REFERENCES `IAPPSAM`.`Purchase_Request` (`Purchase_Request_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`Unit`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Unit` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Unit` (
  `Unit` VARCHAR(20) NOT NULL ,
  PRIMARY KEY (`Unit`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`Item_Status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Item_Status` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Item_Status` (
  `Item_Status` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`Item_Status`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`Item_Condition`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Item_Condition` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Item_Condition` (
  `Item_Condition` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`Item_Condition`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`Item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Item` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Item` (
  `Description` VARCHAR(500) NOT NULL ,
  `Stock_Number` VARCHAR(45) NULL ,
  `Unit` VARCHAR(20) NOT NULL ,
  `Price` DECIMAL(50,2) NULL ,
  `Date_Acquired` DATE NULL ,
  `Inventory_Item_Number` VARCHAR(60) NULL ,
  `Property_Number` VARCHAR(45) NULL ,
  `Item_Status` VARCHAR(50) NOT NULL ,
  `Item_Condition` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`Description`) ,
  INDEX `fk_Item_Unit1` (`Unit` ASC) ,
  INDEX `fk_Item_Item_Status1` (`Item_Status` ASC) ,
  INDEX `fk_Item_Item_Condition1` (`Item_Condition` ASC) ,
  CONSTRAINT `fk_Item_Unit1`
    FOREIGN KEY (`Unit` )
    REFERENCES `IAPPSAM`.`Unit` (`Unit` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Item_Item_Status1`
    FOREIGN KEY (`Item_Status` )
    REFERENCES `IAPPSAM`.`Item_Status` (`Item_Status` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Item_Item_Condition1`
    FOREIGN KEY (`Item_Condition` )
    REFERENCES `IAPPSAM`.`Item_Condition` (`Item_Condition` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`Mode_Of_Procurement`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Mode_Of_Procurement` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Mode_Of_Procurement` (
  `Mode_Of_Procurement` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`Mode_Of_Procurement`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`Purchase_Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Purchase_Order` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Purchase_Order` (
  `Supplier_ID` INT NOT NULL AUTO_INCREMENT ,
  `PO_Number` VARCHAR(45) NOT NULL ,
  `Date` DATE NOT NULL ,
  `Mode_Of_Procurement` VARCHAR(50) NOT NULL ,
  `DivisionOffice_ID` INT NOT NULL ,
  `Date_Of_Delivery` VARCHAR(100) NOT NULL ,
  `Payment_Term` VARCHAR(80) NULL ,
  `Delivery_Term` VARCHAR(80) NULL ,
  `Total_Amount_In_Words` VARCHAR(100) NOT NULL ,
  `OR_Number` VARCHAR(60) NULL ,
  `Amount` DECIMAL(50,2) NULL ,
  `Signatory_ID` INT NOT NULL ,
  `Signatory_ID1` INT NOT NULL ,
  `Signatory_ID2` INT NOT NULL ,
  PRIMARY KEY (`PO_Number`) ,
  INDEX `fk_Purchase_Order_Supplier1` (`Supplier_ID` ASC) ,
  INDEX `fk_Purchase_Order_Mode_Of_Procurement1` (`Mode_Of_Procurement` ASC) ,
  INDEX `fk_Purchase_Order_DivisionOffice1` (`DivisionOffice_ID` ASC) ,
  INDEX `fk_Purchase_Order_Signatory1` (`Signatory_ID` ASC) ,
  INDEX `fk_Purchase_Order_Signatory2` (`Signatory_ID1` ASC) ,
  INDEX `fk_Purchase_Order_Signatory3` (`Signatory_ID2` ASC) ,
  CONSTRAINT `fk_Purchase_Order_Supplier1`
    FOREIGN KEY (`Supplier_ID` )
    REFERENCES `IAPPSAM`.`Supplier` (`Supplier_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Purchase_Order_Mode_Of_Procurement1`
    FOREIGN KEY (`Mode_Of_Procurement` )
    REFERENCES `IAPPSAM`.`Mode_Of_Procurement` (`Mode_Of_Procurement` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Purchase_Order_DivisionOffice1`
    FOREIGN KEY (`DivisionOffice_ID` )
    REFERENCES `IAPPSAM`.`DivisionOffice` (`DivisionOffice_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Purchase_Order_Signatory1`
    FOREIGN KEY (`Signatory_ID` )
    REFERENCES `IAPPSAM`.`Signatory` (`Signatory_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Purchase_Order_Signatory2`
    FOREIGN KEY (`Signatory_ID1` )
    REFERENCES `IAPPSAM`.`Signatory` (`Signatory_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Purchase_Order_Signatory3`
    FOREIGN KEY (`Signatory_ID2` )
    REFERENCES `IAPPSAM`.`Signatory` (`Signatory_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`PO_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`PO_Line` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`PO_Line` (
  `Item_Description` VARCHAR(500) NOT NULL ,
  `PO_Number` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`PO_Number`, `Item_Description`) ,
  INDEX `fk_PO_Line_Item1` (`Item_Description` ASC) ,
  INDEX `fk_PO_Line_Purchase_Order1` (`PO_Number` ASC) ,
  CONSTRAINT `fk_PO_Line_Item1`
    FOREIGN KEY (`Item_Description` )
    REFERENCES `IAPPSAM`.`Item` (`Description` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_PO_Line_Purchase_Order1`
    FOREIGN KEY (`PO_Number` )
    REFERENCES `IAPPSAM`.`Purchase_Order` (`PO_Number` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`PAR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`PAR` ;

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


-- -----------------------------------------------------
-- Table `IAPPSAM`.`PAR_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`PAR_Line` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`PAR_Line` (
  `Item_Description` VARCHAR(500) NOT NULL ,
  `Property_Number` VARCHAR(45) NULL ,
  `PAR_ID` INT NOT NULL ,
  PRIMARY KEY (`PAR_ID`, `Item_Description`) ,
  INDEX `fk_PAR_Line_Item1` (`Item_Description` ASC) ,
  INDEX `fk_PAR_Line_PAR1` (`PAR_ID` ASC) ,
  CONSTRAINT `fk_PAR_Line_Item1`
    FOREIGN KEY (`Item_Description` )
    REFERENCES `IAPPSAM`.`Item` (`Description` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_PAR_Line_PAR1`
    FOREIGN KEY (`PAR_ID` )
    REFERENCES `IAPPSAM`.`PAR` (`PAR_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`ICS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`ICS` ;

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


-- -----------------------------------------------------
-- Table `IAPPSAM`.`ICS_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`ICS_Line` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`ICS_Line` (
  `Quantity` INT NOT NULL ,
  `Item_Description` VARCHAR(500) NOT NULL ,
  `Estimated_Useful_Life` INT NOT NULL ,
  `ICS_ID` INT NOT NULL ,
  PRIMARY KEY (`ICS_ID`, `Item_Description`) ,
  INDEX `fk_ICS_Line_ICS1` (`ICS_ID` ASC) ,
  INDEX `fk_ICS_Line_Item1` (`Item_Description` ASC) ,
  CONSTRAINT `fk_ICS_Line_ICS1`
    FOREIGN KEY (`ICS_ID` )
    REFERENCES `IAPPSAM`.`ICS` (`ICS_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_ICS_Line_Item1`
    FOREIGN KEY (`Item_Description` )
    REFERENCES `IAPPSAM`.`Item` (`Description` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`PTRPA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`PTRPA` ;

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
    REFERENCES `IAPPSAM`.`DivisionOffice` (`DivisionOffice_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_PTRPA_DivisionOffice2`
    FOREIGN KEY (`DivisionOffice_ID1` )
    REFERENCES `IAPPSAM`.`DivisionOffice` (`DivisionOffice_ID` )
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


-- -----------------------------------------------------
-- Table `IAPPSAM`.`PTRPA_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`PTRPA_Line` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`PTRPA_Line` (
  `Item_Description` VARCHAR(500) NOT NULL ,
  `ARE_MR_Number` VARCHAR(45) NULL ,
  `Quantity` INT NOT NULL ,
  `Remarks` VARCHAR(100) NULL ,
  `PTRPA_ID` INT NOT NULL ,
  PRIMARY KEY (`PTRPA_ID`, `Item_Description`) ,
  INDEX `fk_PTRPA_Line_Item1` (`Item_Description` ASC) ,
  INDEX `fk_PTRPA_Line_PTRPA1` (`PTRPA_ID` ASC) ,
  CONSTRAINT `fk_PTRPA_Line_Item1`
    FOREIGN KEY (`Item_Description` )
    REFERENCES `IAPPSAM`.`Item` (`Description` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_PTRPA_Line_PTRPA1`
    FOREIGN KEY (`PTRPA_ID` )
    REFERENCES `IAPPSAM`.`PTRPA` (`PTRPA_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`Waste_Materials_Report`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Waste_Materials_Report` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Waste_Materials_Report` (
  `Waste_Materials_Report_ID` INT NOT NULL AUTO_INCREMENT ,
  `Place_Of_Storage` VARCHAR(80) NULL ,
  `DivisionOffice_ID` INT NOT NULL ,
  `Date` DATE NOT NULL ,
  `Signatory_ID` INT NOT NULL ,
  `Signatory_ID1` INT NOT NULL ,
  `Signatory_ID2` INT NOT NULL ,
  `Signatory_ID3` INT NOT NULL ,
  PRIMARY KEY (`Waste_Materials_Report_ID`) ,
  INDEX `fk_Waste_Materials_Report_DivisionOffice1` (`DivisionOffice_ID` ASC) ,
  INDEX `fk_Waste_Materials_Report_Signatory1` (`Signatory_ID` ASC) ,
  INDEX `fk_Waste_Materials_Report_Signatory2` (`Signatory_ID1` ASC) ,
  INDEX `fk_Waste_Materials_Report_Signatory3` (`Signatory_ID2` ASC) ,
  INDEX `fk_Waste_Materials_Report_Signatory4` (`Signatory_ID3` ASC) ,
  CONSTRAINT `fk_Waste_Materials_Report_DivisionOffice1`
    FOREIGN KEY (`DivisionOffice_ID` )
    REFERENCES `IAPPSAM`.`DivisionOffice` (`DivisionOffice_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
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


-- -----------------------------------------------------
-- Table `IAPPSAM`.`Disposal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Disposal` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Disposal` (
  `Disposal` VARCHAR(80) NOT NULL ,
  PRIMARY KEY (`Disposal`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`WMR_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`WMR_Line` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`WMR_Line` (
  `Item_Description` VARCHAR(500) NOT NULL ,
  `Quantity` INT NOT NULL ,
  `OR_Number` VARCHAR(60) NOT NULL ,
  `Disposal` VARCHAR(80) NOT NULL ,
  `Disposed_To` VARCHAR(80) NULL ,
  `Waste_Materials_Report_ID` INT NOT NULL ,
  PRIMARY KEY (`Waste_Materials_Report_ID`, `Item_Description`) ,
  INDEX `fk_WMR_Line_Dispoasal_Type1` (`Disposal` ASC) ,
  INDEX `fk_WMR_Line_Waste_Materials_Report1` (`Waste_Materials_Report_ID` ASC) ,
  INDEX `fk_WMR_Line_Item1` (`Item_Description` ASC) ,
  CONSTRAINT `fk_WMR_Line_Dispoasal_Type1`
    FOREIGN KEY (`Disposal` )
    REFERENCES `IAPPSAM`.`Disposal` (`Disposal` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_WMR_Line_Waste_Materials_Report1`
    FOREIGN KEY (`Waste_Materials_Report_ID` )
    REFERENCES `IAPPSAM`.`Waste_Materials_Report` (`Waste_Materials_Report_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_WMR_Line_Item1`
    FOREIGN KEY (`Item_Description` )
    REFERENCES `IAPPSAM`.`Item` (`Description` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`IIRUP`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`IIRUP` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`IIRUP` (
  `IIRUP_ID` INT NOT NULL AUTO_INCREMENT ,
  `As_Of` DATE NOT NULL ,
  `Employee_ID` INT NOT NULL ,
  `Station` VARCHAR(80) NULL ,
  `Signatory_ID` INT NOT NULL ,
  `Signatory_ID1` INT NOT NULL ,
  `Signatory_ID2` INT NOT NULL ,
  `Signatory_ID3` INT NOT NULL ,
  PRIMARY KEY (`IIRUP_ID`) ,
  INDEX `fk_IIRUP_Signatory1` (`Signatory_ID` ASC) ,
  INDEX `fk_IIRUP_Signatory2` (`Signatory_ID1` ASC) ,
  INDEX `fk_IIRUP_Signatory3` (`Signatory_ID2` ASC) ,
  INDEX `fk_IIRUP_Signatory4` (`Signatory_ID3` ASC) ,
  INDEX `fk_IIRUP_Employee1` (`Employee_ID` ASC) ,
  CONSTRAINT `fk_IIRUP_Signatory1`
    FOREIGN KEY (`Signatory_ID` )
    REFERENCES `IAPPSAM`.`Signatory` (`Signatory_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_IIRUP_Signatory2`
    FOREIGN KEY (`Signatory_ID1` )
    REFERENCES `IAPPSAM`.`Signatory` (`Signatory_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_IIRUP_Signatory3`
    FOREIGN KEY (`Signatory_ID2` )
    REFERENCES `IAPPSAM`.`Signatory` (`Signatory_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_IIRUP_Signatory4`
    FOREIGN KEY (`Signatory_ID3` )
    REFERENCES `IAPPSAM`.`Signatory` (`Signatory_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_IIRUP_Employee1`
    FOREIGN KEY (`Employee_ID` )
    REFERENCES `IAPPSAM`.`Employee` (`Employee_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`IIRUP_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`IIRUP_Line` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`IIRUP_Line` (
  `Item_Description` VARCHAR(500) NOT NULL ,
  `Quantity` INT NOT NULL ,
  `Years_In_Service` INT NOT NULL ,
  `Accumulated_Depreciation` DECIMAL(50,2) NOT NULL ,
  `Disposal_Type` VARCHAR(80) NOT NULL ,
  `Appraisal` VARCHAR(50) NULL ,
  `OR_Number` VARCHAR(45) NOT NULL ,
  `IIRUP_ID` INT NOT NULL ,
  PRIMARY KEY (`IIRUP_ID`, `Item_Description`) ,
  INDEX `fk_IIRUP_Line_Dispoasal_Type1` (`Disposal_Type` ASC) ,
  INDEX `fk_IIRUP_Line_IIRUP1` (`IIRUP_ID` ASC) ,
  INDEX `fk_IIRUP_Line_Item1` (`Item_Description` ASC) ,
  CONSTRAINT `fk_IIRUP_Line_Dispoasal_Type1`
    FOREIGN KEY (`Disposal_Type` )
    REFERENCES `IAPPSAM`.`Disposal` (`Disposal` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_IIRUP_Line_IIRUP1`
    FOREIGN KEY (`IIRUP_ID` )
    REFERENCES `IAPPSAM`.`IIRUP` (`IIRUP_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_IIRUP_Line_Item1`
    FOREIGN KEY (`Item_Description` )
    REFERENCES `IAPPSAM`.`Item` (`Description` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`APP`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`APP` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`APP` (
  `Year` INT NOT NULL ,
  `DivisionOffice_ID` INT NOT NULL ,
  `Plan_Control_Number` VARCHAR(45) NULL ,
  `Date_Scheduled` DATE NULL ,
  `Signatory_ID` INT NOT NULL ,
  `Signatory_ID1` INT NOT NULL ,
  PRIMARY KEY (`Year`, `DivisionOffice_ID`) ,
  INDEX `fk_APP_Signatory1` (`Signatory_ID` ASC) ,
  INDEX `fk_APP_Signatory2` (`Signatory_ID1` ASC) ,
  INDEX `fk_APP_DivisionOffice1` (`DivisionOffice_ID` ASC) ,
  CONSTRAINT `fk_APP_Signatory1`
    FOREIGN KEY (`Signatory_ID` )
    REFERENCES `IAPPSAM`.`Signatory` (`Signatory_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_APP_Signatory2`
    FOREIGN KEY (`Signatory_ID1` )
    REFERENCES `IAPPSAM`.`Signatory` (`Signatory_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_APP_DivisionOffice1`
    FOREIGN KEY (`DivisionOffice_ID` )
    REFERENCES `IAPPSAM`.`DivisionOffice` (`DivisionOffice_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`APP_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`APP_Line` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`APP_Line` (
  `Item_Description` VARCHAR(500) NOT NULL ,
  `Quantity_Quarter_1` INT NOT NULL ,
  `Quantity_Quarter_2` INT NOT NULL ,
  `Quantity_Quarter_3` INT NOT NULL ,
  `Quantity_Quarter_4` INT NOT NULL ,
  `Year` INT NOT NULL ,
  `DivisionOffice_ID` INT NOT NULL ,
  PRIMARY KEY (`Item_Description`, `Year`, `DivisionOffice_ID`) ,
  INDEX `fk_APP_Line_Item1` (`Item_Description` ASC) ,
  INDEX `fk_APP_Line_APP1` (`Year` ASC, `DivisionOffice_ID` ASC) ,
  CONSTRAINT `fk_APP_Line_Item1`
    FOREIGN KEY (`Item_Description` )
    REFERENCES `IAPPSAM`.`Item` (`Description` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_APP_Line_APP1`
    FOREIGN KEY (`Year` , `DivisionOffice_ID` )
    REFERENCES `IAPPSAM`.`APP` (`Year` , `DivisionOffice_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`Inventory_Of_Equipment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Inventory_Of_Equipment` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Inventory_Of_Equipment` (
  `Inventory_Of_Equipment_ID` INT NOT NULL AUTO_INCREMENT ,
  `DivisionOffice_ID` INT NOT NULL ,
  PRIMARY KEY (`Inventory_Of_Equipment_ID`) ,
  INDEX `fk_Inventory_Of_Equipment_DivisionOffice1` (`DivisionOffice_ID` ASC) ,
  CONSTRAINT `fk_Inventory_Of_Equipment_DivisionOffice1`
    FOREIGN KEY (`DivisionOffice_ID` )
    REFERENCES `IAPPSAM`.`DivisionOffice` (`DivisionOffice_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`IE_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`IE_Line` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`IE_Line` (
  `Item_Description` VARCHAR(500) NOT NULL ,
  `Quantity` INT NOT NULL ,
  `Employee_ID` INT NOT NULL ,
  `How_Acquired` VARCHAR(100) NOT NULL ,
  `Remarks` VARCHAR(100) NULL ,
  `Inventory_Of_Equipment_ID` INT NOT NULL ,
  PRIMARY KEY (`Inventory_Of_Equipment_ID`, `Item_Description`) ,
  INDEX `fk_IE_Line_Inventory_Of_Equipment1` (`Inventory_Of_Equipment_ID` ASC) ,
  INDEX `fk_IE_Line_Employee1` (`Employee_ID` ASC) ,
  INDEX `fk_IE_Line_Item1` (`Item_Description` ASC) ,
  CONSTRAINT `fk_IE_Line_Inventory_Of_Equipment1`
    FOREIGN KEY (`Inventory_Of_Equipment_ID` )
    REFERENCES `IAPPSAM`.`Inventory_Of_Equipment` (`Inventory_Of_Equipment_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_IE_Line_Employee1`
    FOREIGN KEY (`Employee_ID` )
    REFERENCES `IAPPSAM`.`Employee` (`Employee_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_IE_Line_Item1`
    FOREIGN KEY (`Item_Description` )
    REFERENCES `IAPPSAM`.`Item` (`Description` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`Requisition_And_Issue_Slip`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Requisition_And_Issue_Slip` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Requisition_And_Issue_Slip` (
  `DivisionOffice_ID` INT NOT NULL AUTO_INCREMENT ,
  `RC_Code` VARCHAR(80) NULL ,
  `RIS_Number` INT NOT NULL ,
  `RIS_Date` DATE NOT NULL ,
  `SAI_Number` VARCHAR(80) NULL ,
  `SAI_Date` DATE NULL ,
  `Purpose` VARCHAR(200) NOT NULL ,
  `Signatory_ID` INT NOT NULL ,
  `Signatory_ID1` INT NOT NULL ,
  `Signatory_ID2` INT NOT NULL ,
  `Signatory_ID3` INT NOT NULL ,
  PRIMARY KEY (`RIS_Number`) ,
  INDEX `fk_Requisition_And_Issue_Slip_DivisionOffice1` (`DivisionOffice_ID` ASC) ,
  INDEX `fk_Requisition_And_Issue_Slip_Signatory1` (`Signatory_ID` ASC) ,
  INDEX `fk_Requisition_And_Issue_Slip_Signatory2` (`Signatory_ID1` ASC) ,
  INDEX `fk_Requisition_And_Issue_Slip_Signatory3` (`Signatory_ID2` ASC) ,
  INDEX `fk_Requisition_And_Issue_Slip_Signatory4` (`Signatory_ID3` ASC) ,
  CONSTRAINT `fk_Requisition_And_Issue_Slip_DivisionOffice1`
    FOREIGN KEY (`DivisionOffice_ID` )
    REFERENCES `IAPPSAM`.`DivisionOffice` (`DivisionOffice_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Requisition_And_Issue_Slip_Signatory1`
    FOREIGN KEY (`Signatory_ID` )
    REFERENCES `IAPPSAM`.`Signatory` (`Signatory_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Requisition_And_Issue_Slip_Signatory2`
    FOREIGN KEY (`Signatory_ID1` )
    REFERENCES `IAPPSAM`.`Signatory` (`Signatory_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Requisition_And_Issue_Slip_Signatory3`
    FOREIGN KEY (`Signatory_ID2` )
    REFERENCES `IAPPSAM`.`Signatory` (`Signatory_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Requisition_And_Issue_Slip_Signatory4`
    FOREIGN KEY (`Signatory_ID3` )
    REFERENCES `IAPPSAM`.`Signatory` (`Signatory_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`RIS_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`RIS_Line` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`RIS_Line` (
  `Item_Description` VARCHAR(500) NOT NULL ,
  `Quantity_Requested` INT NOT NULL ,
  `Quantity_Issued` INT NOT NULL ,
  `Remarks` VARCHAR(200) NULL ,
  `RIS_Number` INT NOT NULL ,
  PRIMARY KEY (`RIS_Number`, `Item_Description`) ,
  INDEX `fk_RIS_Line_Item1` (`Item_Description` ASC) ,
  INDEX `fk_RIS_Line_Requisition_And_Issue_Slip1` (`RIS_Number` ASC) ,
  CONSTRAINT `fk_RIS_Line_Item1`
    FOREIGN KEY (`Item_Description` )
    REFERENCES `IAPPSAM`.`Item` (`Description` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_RIS_Line_Requisition_And_Issue_Slip1`
    FOREIGN KEY (`RIS_Number` )
    REFERENCES `IAPPSAM`.`Requisition_And_Issue_Slip` (`RIS_Number` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`RSMI`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`RSMI` ;

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


-- -----------------------------------------------------
-- Table `IAPPSAM`.`RSMI_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`RSMI_Line` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`RSMI_Line` (
  `RIS_Number` VARCHAR(45) NOT NULL ,
  `Item_Description` VARCHAR(200) NOT NULL ,
  `Responsibility_Center` VARCHAR(80) NULL ,
  `RSMI_ID` INT NOT NULL ,
  PRIMARY KEY (`RIS_Number`, `RSMI_ID`) ,
  INDEX `fk_RSMI_Line_RSMI1` (`RSMI_ID` ASC) ,
  INDEX `fk_RSMI_Line_Item1` (`Item_Description` ASC) ,
  CONSTRAINT `fk_RSMI_Line_RSMI1`
    FOREIGN KEY (`RSMI_ID` )
    REFERENCES `IAPPSAM`.`RSMI` (`RSMI_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_RSMI_Line_Item1`
    FOREIGN KEY (`Item_Description` )
    REFERENCES `IAPPSAM`.`Item` (`Description` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`Recapitulation_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Recapitulation_Line` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Recapitulation_Line` (
  `Item_Description` VARCHAR(500) NOT NULL ,
  `Quantity` INT NOT NULL ,
  `Account_Code` VARCHAR(45) NOT NULL ,
  `RSMI_ID` INT NOT NULL ,
  PRIMARY KEY (`RSMI_ID`, `Item_Description`) ,
  INDEX `fk_Recapitulation_Line_RSMI1` (`RSMI_ID` ASC) ,
  INDEX `fk_Recapitulation_Line_Item1` (`Item_Description` ASC) ,
  CONSTRAINT `fk_Recapitulation_Line_RSMI1`
    FOREIGN KEY (`RSMI_ID` )
    REFERENCES `IAPPSAM`.`RSMI` (`RSMI_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Recapitulation_Line_Item1`
    FOREIGN KEY (`Item_Description` )
    REFERENCES `IAPPSAM`.`Item` (`Description` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`Account_Type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Account_Type` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Account_Type` (
  `Account_Type` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`Account_Type`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`Account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Account` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`Account` (
  `Username` VARCHAR(60) NOT NULL ,
  `Password` VARCHAR(80) NOT NULL ,
  `Acquainted` TINYINT(1)  NOT NULL ,
  `Account_Type` VARCHAR(50) NOT NULL ,
  `Person_ID` INT NOT NULL ,
  PRIMARY KEY (`Username`) ,
  INDEX `fk_Account_Person1` (`Person_ID` ASC) ,
  INDEX `fk_Account_Account_Type1` (`Account_Type` ASC) ,
  CONSTRAINT `fk_Account_Person1`
    FOREIGN KEY (`Person_ID` )
    REFERENCES `IAPPSAM`.`Person` (`Person_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Account_Account_Type1`
    FOREIGN KEY (`Account_Type` )
    REFERENCES `IAPPSAM`.`Account_Type` (`Account_Type` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`Person_Contact`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Person_Contact` ;

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


-- -----------------------------------------------------
-- Table `IAPPSAM`.`DivisionOffice_Contact`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`DivisionOffice_Contact` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`DivisionOffice_Contact` (
  `DivisionOffice_ID` INT NOT NULL ,
  `Contact_ID` INT NOT NULL ,
  PRIMARY KEY (`Contact_ID`, `DivisionOffice_ID`) ,
  INDEX `fk_DivisionOfficeContact_DivisionOffice1` (`DivisionOffice_ID` ASC) ,
  INDEX `fk_DivisionOfficeContact_Contact1` (`Contact_ID` ASC) ,
  CONSTRAINT `fk_DivisionOfficeContact_DivisionOffice1`
    FOREIGN KEY (`DivisionOffice_ID` )
    REFERENCES `IAPPSAM`.`DivisionOffice` (`DivisionOffice_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_DivisionOfficeContact_Contact1`
    FOREIGN KEY (`Contact_ID` )
    REFERENCES `IAPPSAM`.`Contact` (`Contact_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`Supplier_Contact`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Supplier_Contact` ;

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


-- -----------------------------------------------------
-- Table `IAPPSAM`.`Employee_DivisionOffice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`Employee_DivisionOffice` ;

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
    REFERENCES `IAPPSAM`.`DivisionOffice` (`DivisionOffice_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IAPPSAM`.`IE_Signatory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IAPPSAM`.`IE_Signatory` ;

CREATE  TABLE IF NOT EXISTS `IAPPSAM`.`IE_Signatory` (
  `Inventory_Of_Equipment_ID` INT NOT NULL ,
  `Signatory_ID` INT NOT NULL ,
  PRIMARY KEY (`Inventory_Of_Equipment_ID`, `Signatory_ID`) ,
  INDEX `fk_IE_Signatory_Inventory_Of_Equipment1` (`Inventory_Of_Equipment_ID` ASC) ,
  INDEX `fk_IE_Signatory_Signatory1` (`Signatory_ID` ASC) ,
  CONSTRAINT `fk_IE_Signatory_Inventory_Of_Equipment1`
    FOREIGN KEY (`Inventory_Of_Equipment_ID` )
    REFERENCES `IAPPSAM`.`Inventory_Of_Equipment` (`Inventory_Of_Equipment_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_IE_Signatory_Signatory1`
    FOREIGN KEY (`Signatory_ID` )
    REFERENCES `IAPPSAM`.`Signatory` (`Signatory_ID` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
