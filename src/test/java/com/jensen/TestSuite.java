package com.jensen;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({
        CalculatorTest.class,
        Calculator2Test.class,
        BookTest.class,
        QuoteTest.class
})
public class TestSuite {
}
