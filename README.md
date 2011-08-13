IAPPSAM System
===============
Developers
----------
Baltazar, John David
Basal, Warren Anthony
de Veyra, Jafet Kim
Delmo, Duken
Ybañez, Neil Patrick

Requirements
-------------
Java Development Kit 6.x
MySQL 5.x.x 

Deployment
----------
Remove any Java and MySQL installations before installing the system
1. Install Java Development Kit.
	a. Don't install Public JRE. If install accidentally, uninstall it.
	
	b. To make sure that Windows can find the Java compiler and interpreter:
		Select Environment Variables -> System variables -> PATH.
		Prepend C:\Program Files\Java\jdk1.6.0_23\bin; to the beginning of the PATH variable.
		Click OK three times.
2. Install MySQL.
	a. Do not specify password for the root account.
3. Run iappsam-windows-1_0.exe.
4. Run Start > Programs > IAPPSAM > Server.
5. Browse to localhost. The default account is.
	Username: Admin
	Password: Admin

Backup
-------
To backup database, Login into the webapp as Administrator then click Backup 

Recovery
--------	
To recover database , run Start > Programs > IAPPSAM > Recover.


