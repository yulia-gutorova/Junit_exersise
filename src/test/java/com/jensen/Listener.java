package com.jensen;


import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class Listener extends RunListener {

    static final String RESET = "\u001b[0m";
    static final String RED = "\u001b[31m";
    static final String GREEN = "\u001b[32m";
    static final String YELLOW = "\u001b[33m";
    static final String BLUE = "\u001b[34m";
    static final String PURPLE = "\u001b[35m";
    static final String CYAN = "\u001b[36m";

    public static void main(String[] args) {

        System.out.println(RED +  "\n-----TestListener-----\n" + RESET);
        JUnitCore core = new JUnitCore();
        core.addListener(new Listener());
        core.run(TestSuite.class);
        System.out.println(RED + "\n-----End of testListener-----\n" + RESET);

    }
    //-----------------------------------------------------------------
    //Called before all tests.
    @Override
    public void testRunStarted(Description description) throws Exception {
        System.out.println(YELLOW + "\nTest runs" + RESET);
    }

    //-----------------------------------------------------------------
    //Called when an atomic test to be started.
    @Override
    public void testStarted (Description description) throws Exception
    {
        System.out.println(GREEN + "\nTestListener - test started: " +
                description.getDisplayName()
                + "  class: " + description.getClassName()+ RESET );
    }

    //-----------------------------------------------------------------
    // Called when an atomic test has finished, whether the test succeeds or fails.
    @Override
    public void testFinished(Description description) throws Exception {
        System.out.println(BLUE + "Test listener - tests finished: " +  description.getDisplayName()
                + "  class: " + description.getClassName() + RESET);
        System.out.println("--------------------------------------");
    }

    //-----------------------------------------------------------------
    //Called when an atomic test fails.
    @Override
    public void testFailure (Failure failure) throws Exception
    {
        System.out.println(RED +  "\nTestListener tests failure "  +  failure + RESET);
    }

    //-----------------------------------------------------------------
    //Called when a test will not be run, generally because a test method is annotated with Ignore.
    @Override
    public void testIgnored(Description description) throws Exception {
        System.out.println(CYAN + "Tests ignored: " + description + RESET);
        System.out.println("--------------------------------------");
    }

    @Override
    public void testRunFinished(Result result) throws Exception {

        System.out.println(RED + "Report:" + RESET);
        System.out.println("\nResult of the test run: " +  result.wasSuccessful());
        System.out.println("Run time: " + result.getRunTime() + " ms");
        System.out.println("Number of tests executed: " + result.getRunCount());
        System.out.println("Failure count: " +  result.getFailureCount());
        System.out.println("Ignored count: " +  result.getIgnoreCount());
    }
}
