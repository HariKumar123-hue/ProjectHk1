package Hooks;

import base.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        BasePage.initDriver();
    }

    @After
    public void tearDown() {
        BasePage.quitDriver();
    }
}
