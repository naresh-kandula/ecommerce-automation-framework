package data;

import org.testng.annotations.DataProvider;

public class LoginTestData {

    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() {

        return new Object[][] {

                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"},
                {"invalid_user", "wrong_password"}

        };
    }
}
