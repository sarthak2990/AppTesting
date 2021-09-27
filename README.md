# AppTest

Software Requirement: Java , Maven , Appium and Testng

Instruction to Install : mvn clean install

Instruction to run: "mvn test" or in case when app supports ios then "mvn test -Ddevice=ios/andriod" by default it picks andriod

Locators are stored in homeScreen.properties and for storing locatores for xpath I have added XP_ as prefix and ClassName CS_, AS_ for accesibility

I have log4f for logger and Extent report for reporting and report can be found at test-output folder

Appium and Android sdk needs to be configured before running test

```Also I like to highlight great work by Dev team to be putting ID almost on each elements which makes test engineer job very easy```

#Test Cases covered:
```
   Verify User is able to add expenses
   Verify User is able to add income
   Verify User is able to change currency and right correct should be displayed in overall application
   Verify User should be able to transfer between two accounts
   Verify list in the left menu screen
   Verify list in the right menu screen
   Verify all income and expenses are correctly displayed in the balance screen
   Verify search functionality is working fine or not
   Verify user is able to set the budget
   Verify Color of all the expenses```

#As Currently I don't have macbook and ios so I have setup automation for Android only 
This test will currenlty work on any default real andriod device connected to your laptop or any emulator and incase of multiple connect currently it will pick the first devices shown on adb devices command

I have used factory pattern to intiate Appium session and use of listeners , dataproviders are made to test with multiple test data 

Please reach out to me at sarthak2990@gmail.com incase of any questions