package utils;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static void setTest(ExtentTest test) {
        extentTest.set(test); //Called at the start of each test
    }

    public static ExtentTest getTest() {
        return extentTest.get(); //Used to fetch the ExtentTest object of current thread, We use this while logging
    }

    public static void unload() { //Removes the ExtentTest instance from ThreadLocal
        extentTest.remove();     //Helps in memory cleanup after test execution
    }
}

//Thread safe reporting
//Parallel execution reporting
//Clean and accurate Extent report
//NO log overlapping

/*1)Every running test thread gets its own separate ExtentTest object
  2)Logs are stored independently

  3)No conflict between parallel tests*/