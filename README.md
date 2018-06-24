This is a console application which gives You to follow your expenses.

Application was written in IntelliJ IDEA. It uses spring boot and if you want to launch it on your local pc You must be sure that your IDEA supports the spring boot projects.

Also app uses mysql you may install mysql version 5+ or download full installation https://dev.mysql.com/downloads/mysql/ and install developer default.
For connect to data base app uses default password encoding. If You want to run app, You need ot create database in mysql with name — test_problem and change username and password in application.properties to yours.
Application builds with Maven. 
If You will be using Eclipse to run this app, Your need to install free plugin "ANSI Escape in Console" from eclipse marketplace to see colors in console.
If You don't want to install the plugin, you will see extra symbols like "[31m" in Your console.
For converting currency app uses https://fixer.io api, for correct api working you need api key. You can use my or get your own from https://fixer.io and replace it in Constants class.

Author Mykhailo Kovalevuch.
