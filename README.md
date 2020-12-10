# slems
#Project code for simplylearn EMS.

#Code structure is divided as follows
#Controller are divided in admin and employee. Admin section handles admin pages functionality.
#Employee section handles employees pages functionality.
#From controller classes calls goes to the service classes inside service package.
#Service classes interact with repositories interfaces inside repositories package.
#Repositories interfaces interact with database and receives data in model classes defined inside models package.
#utils package contains classes inside which there are common method and variables used in the classes in the app
#Views are created in jsp. which are inside webapp/WEB-INF/jsp folder.

#Admin can add,delete,edit an employee. Can also add and view department.
#Admin can create a regulation. View the regulation details and the comments from the users.
#Admin can change the status of the regulation from open to close.

#User can see all the assigned regulations as well as can add/update comments on compliance.
#User can check compliance status of department as well as can check the status of previous compliance with their comments.

#As soon as all the employees submitted their comments on a compliance it will automatically gets closed. 
