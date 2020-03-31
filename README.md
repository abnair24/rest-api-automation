# rest-api-automation

## Introduction

  Sample REST API AUTOMATION framework for http://dummy.restapiexample.com/ using Rest-Assured, 
  
  Java, TestNG, Gradle and ReportNG for reporting.
  
## How to use

1. Clone the repository
2. Enable `lombok` plugin in Intellij
3. Enable `Annotation Processing` in Intellij preferences

Run the tests in parallel

      use runTestsParallel task

Run tests sequentially

      use runTests task

To enable slackNotification,

      use -DslackNotif=automation

Run only SMOKE test in parallel

      gradle clean runTestsParallel -Dtag=SMOKE -DslackNotif=automation

Run only regression test in parallel

      gradle clean runTestsParallel -Dtag=REGRESSION -DslackNotif=automation
  
Run all tests in suite in parallel
  
      gradle clean runTestsParallel -Dtag=EMPLOYEE
   
Reports can be found at

      restApiAutomation/build/{tag}/tests/html/index.html


