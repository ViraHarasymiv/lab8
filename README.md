# Lab 8: Page Object Model & TestNG
  The project is made by using Page Object Model and TestNG framework. Log4j is used for logging events. All logs are saved in the directory named logs (target/logs/appTest.log).

The target website is [BPB PUBLICATIONS](http://practice.bpbonline.com/index.php).

- The "DataProvider" annotation is used in order to pass multiple parameters to the Creating New Account test with invalid data. Using DataProviders, we can easily pass multiple values to a test in just one execution cycle.
- The "Parameter" annotation is used in order to pass multiple parameters to the Creating New Account test with valid data

Automated tests (for chrome and opera browsers):
1. Positive test for the creating new account
2. Negative test for the creating new account
3. Test for checking the radio buttons' functionality

## Executing the Tests

- Clone the repository:
```shell
git clone https://github.com/ViraHarasymiv/laboratorna_8.git
```
- Run all tests:
```shell
mvn clean test
```
- run the positive test for the creating new account:
```shell
mvn -Dtest=PositiveCreateAccountTest#createNewAccountTest test
```
- run the negative test for the creating new account:
```shell
mvn -Dtest=NegativeCreateAccountTest#negativeCreateAccountTest test
```
- run test for checking the radio buttons' functionality:
```shell
mvn -Dtest=RadioButtonTest#checkRadioButtons test
```

