package com.jensen;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({TestCupSettersAndGetters.class,
        TestCupConstructor.class,
        CalculatorTest.class,
        Calculator2Test.class,
        BookTest.class})
public class TestSuite {
}
