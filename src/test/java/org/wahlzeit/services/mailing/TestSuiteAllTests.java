package org.wahlzeit.services.mailing;
import java.lang.ClassLoader;
import java.nio.ByteBuffer;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.Test;
import java.util.*;
import java.io.*;
import java.lang.ClassLoader;

/**
 * Created on 06.11.16.
 */

public class TestSuiteAllTests {

    static String folder = "/Users/varj/Desktop/Master/1/ADAP/Wahlzeit/wahlzeit/build";

    public static ArrayList<String> findTests(String folder){
        String startFolder = folder;
        File files = new File(folder);
        File[] allFiles = files.listFiles();
        ArrayList allTestFiles = new ArrayList<String>();

        for (int i = 0; i < allFiles.length; i++) {
            if (allFiles[i].isFile()) {
                if(allFiles[i].getName().contains("Test")){
                    if(allFiles[i].getName().endsWith(".class")){
                        allTestFiles.add(allFiles[i].getAbsolutePath());
                    }
                }
            } else if (allFiles[i].isDirectory()) {
                allTestFiles.addAll(findTests(folder + "/" + allFiles[i].getName()));
            }
        }

        return allTestFiles;
    }

    public static TestSuite testSuite() {
        TestSuite testSuite = new TestSuite();
        ArrayList<String> arr = findTests(folder);
        Class cl = null;
        ClassLoader loader = Test.class.getClassLoader();

        // add all TestClasses to TestSuite
        //TODO: find out how to load class from class path
        for(String c : arr){
//            cl = loader.getResource(c).getClass();
//            testSuite.addTestSuite(cl);
        }


        testSuite.addTestSuite(EmailServiceTest.class);
        return testSuite;
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(testSuite());
    }
}
