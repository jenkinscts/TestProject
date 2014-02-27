fdsfsjfsldkf
TestProject
===========

TestProject having gradle scripts, jersey, spring , angularjs

The project contains two service customService , billingService.
One jersey rest service integrated using spring.

For using the war:
Make sure you have installed all below:

jdk1.7
tomcat
gradle
git


Build Command: From root project
gradle clean build

Once success, copy the war from 
TestProject/application/testWebApplication/build/libs/testWebApplication-1.0.war to tomcat/webapp testWebApplication.war

Restart the tomcat:
Open the url: This is angular app, which will call rest service and get the data from server.

http://localhost:8080/testWebApplication/
