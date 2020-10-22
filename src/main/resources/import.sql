CREATE TABLE Department (
  departmentId INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  departmentName CHAR NULL,
  PRIMARY KEY(departmentId)
);

CREATE TABLE Employee (
  employeeId INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Department_departmentId INTEGER UNSIGNED NOT NULL,
  e_Password CHAR NULL,
  name CHAR NULL,
  role CHAR NULL,
  PRIMARY KEY(employeeId),
  INDEX Employee_FKIndex1(Department_departmentId)
);

CREATE TABLE Event (
  eventId INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Employee_employeeId INTEGER UNSIGNED NOT NULL,
  title CHAR NULL,
  description CHAR NULL,
  remember CHAR NULL,
  initial_Date DATE NULL,
  end_Date DATE NULL,
  repeat CHAR NULL,
  reason CHAR NULL,
  manager_Notification BOOL NULL,
  PRIMARY KEY(eventId),
  INDEX Event_FKIndex1(Employee_employeeId)
);

CREATE TABLE Notification (
  notification_Id INTEGER UNSIGNED NOT NULL,
  Event_eventId INTEGER UNSIGNED NOT NULL,
  manager_Comment CHAR NULL,
  notification_Status CHAR NULL,
  PRIMARY KEY(notification_Id),
  INDEX Notification_FKIndex1(Event_eventId)
);