package com.roman.trello.tests;

import com.roman.trello.manager.ApplicationManager;
import com.roman.trello.utils.Listener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;

@Listeners(Listener.class)

public class TestBase {

    public static ApplicationManager app = new ApplicationManager();

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startTestLog(Method m, Object[] parameter) {
        logger.info("Start test" + m.getName() + "with parameters" + Arrays.asList(parameter));
    }

    @AfterMethod
    public void stoptestLog(Method m) {
        logger.info("Stop test" + m.getName());

    }

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}