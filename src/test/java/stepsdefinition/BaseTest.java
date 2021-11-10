package stepsdefinition;

import com.eleks.framework.base.DriverContext;
import com.eleks.framework.base.FrameworkInitialize;
import com.eleks.framework.config.ConfigReader;
import com.eleks.framework.config.Settings;
import com.eleks.framework.utils.ExcelUtil;
import com.eleks.framework.utils.LogUtil;
import io.cucumber.java.Before;

import java.io.IOException;

public class BaseTest extends FrameworkInitialize {

    @Before
    public void Initialize() throws IOException {
        //Initialize config
        ConfigReader.populateSettings();

        //Logging
        Settings.log = new LogUtil();
        Settings.log.createLogFile();
        Settings.log.write("Initialization of framework");

        //TODO
        //Create Test cycle for reporting(DB)
        //Settings.autConnection = DbUtil.openConnection(Settings.autConnectionString);
        //DbUtil.executeQuery("SELECT * FROM Employees", Settings.autConnection);
        //logUtil.write("Test cycle created");

        initializeBrowser(Settings.browserType);
        Settings.log.write("Browser initialized");
        DriverContext.goToUrl(Settings.aut);
        Settings.log.write("Navigated to URL");
        ExcelUtil.initializeExcelFile(Settings.excelSheetPath, "Sheet1");
    }
}
