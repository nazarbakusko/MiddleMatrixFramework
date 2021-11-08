package seleniumtest;

import com.eleks.framework.utils.ExcelUtil;
import page.HomePage;
import page.LoginPage;
import stepsdefinition.BaseTest;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void TC_VerifyLogin() throws InterruptedException {
        CurrentPage = getInstance(HomePage.class);
        CurrentPage = CurrentPage.as(HomePage.class).clickLogin();
        Thread.sleep(2000);
        //DDT from excel
        CurrentPage.as(LoginPage.class).login(ExcelUtil.readCell("UserName", 1),
                ExcelUtil.readCell("Password", 1));
    }

}
