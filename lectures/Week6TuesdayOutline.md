# Tuesday, December 6 - Java Week 6

## Discussion topics:
- https://login.codingdojo.com/d/325/158/1243 - "Name an instance where we would want to use JSTL to build our forms on the front end, and another where we would want to use vanilla HTML."
- https://login.codingdojo.com/d/325/158/1244 - "State what MVC is and what each part does in a full stack Java Spring application."

Discussion topics are due Sunday night by 10:59 PM Pacific!

## Core assignments:
No more core assignments - so use this as an opportunity to catch up!

## Exam notes
Codes will be sent by 10 AM Pacific this Friday if you have at least 9 out of 10 core assignments handed in!

## Git session 1 this Thursday
Lecture room 2 in Dojo Hall with Melissa at 1 PM Pacific this Thursday, December 8!

## Lecture outline:
- Wrap up login/registration demo (WILL be pushed to GitHub):
    - Ensuring someone cannot access pages that require being logged in
    - Logging in
        - Add login form
        - Create a second model that won't be saved in the Database
        - Add validations for logging in
        - Careful about model attributes!!
- Adding login/registration to our universities/halls project (WILL NOT be pushed to GitHub):
    - Start off with code from last week
    - Add new dependency to our pom.xml file - jbcrypt
    - Drop our tables to start over from scratch!
    - Adding the following files:
        - User and LoginUser Models
        - User repository
        - User service
        - User controller
        - Login/registration .jsp file
    - Add to our .jsp files (didn't get to entirely Tuesday):
        - Name of who added each hall/university
        - Only showing the edit/delete links when the logged in user is the one who added the hall/university
    - Ensuring only logged in users can access most pages (didn't get to Tuesday)
