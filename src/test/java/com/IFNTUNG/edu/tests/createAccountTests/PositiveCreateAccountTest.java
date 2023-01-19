package com.IFNTUNG.edu.tests.createAccountTests;

import com.IFNTUNG.edu.application.pages.AccountSuccessPage;
import com.IFNTUNG.edu.application.pages.HomePage;
import com.IFNTUNG.edu.runners.BaseTest;
import com.IFNTUNG.edu.utils.ConfigReader;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class PositiveCreateAccountTest extends BaseTest {
    private static final String EXPECTED_MESSAGE = "Your Account Has Been Created";
    private static final String EXPECTED_URL = ConfigReader.get().getAccountSuccessPageUrl();

    @Parameters({"firstName", "lastName", "birthDay", "fixLength", "company", "streetAddress", "postCode", "city", "state", "country", "telephoneNumber", "password", "message"})
    @Test
    public void createNewAccountTest(String firstName, String lastName, String birthDay,
                                     int fixLength, String company, String streetAddress, String postCode, String city,
                                     String state, String country, String telephoneNumber, String password, String message) {
        log.info("Starting Create Account Test");
        AccountSuccessPage accountSuccessPage = new HomePage(driver, log)
                .openPage()
                .getHeaderComponent()
                .clickOnMyAccountMenu()
                .clickOnContinueButton()
                .selectAnyRadioButton()
                .enterUserFirstAndLastName(firstName, lastName)
                .enterUserBirthDay(birthDay)
                .enterUserEmail(fixLength)
                .enterCompanyName(company)
                .enterStreetAddressAndPostCode(streetAddress, postCode)
                .enterUserCityAndState(city, state)
                .selectCountry(country)
                .enterTelephoneNumber(telephoneNumber)
                .checkNewsLetterCheckBox()
                .createPassword(password)
                .submitEnteredInformation();
       String actualMessage = accountSuccessPage.getActualMessage(message);
       String actualUrl = accountSuccessPage.getCurrentUrl();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualMessage.contains(EXPECTED_MESSAGE));
        softAssert.assertTrue(actualUrl.contains(EXPECTED_URL));
        softAssert.assertAll();
    }
}
