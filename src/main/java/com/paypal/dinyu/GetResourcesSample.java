package com.paypal.dinyu;

import java.io.InputStream;
import java.text.MessageFormat;

public class GetResourcesSample {
    private static final String MAIN_FILE = "main-resources-file.txt";
    private static final String MAIN_FILE_WITH_SLASH = "/main-resources-file.txt";
    private static final String TEST_FILE = "test-resources-file.txt";
    private static final String TEST_FILE_WITH_SLASH = "/test-resources-file.txt";
    private static final String ROOT_FILE = "project-root-file.txt";
    private static final String ROOT_FILE_WITH_SLASH = "./project-root-file.txt";

    public static void main(String[] args) {
        validateResult(MAIN_FILE);
        validateResult(MAIN_FILE_WITH_SLASH);

        validateResult(TEST_FILE);
        validateResult(TEST_FILE_WITH_SLASH);

        validateResult(ROOT_FILE);
        validateResult(ROOT_FILE_WITH_SLASH);

    }

    private static void validateResult(String file) {

        InputStream inputStream1 = GetResourcesSample.class.getClass().getResourceAsStream(file);
        if (inputStream1 != null) {
            System.out.println(MessageFormat
                    .format("GetResourcesSample.class.getClass().getResourceAsStream(\"{0}\") is not null!", file));
        }

        InputStream inputStream2 = GetResourcesSample.class.getResourceAsStream(file);
        if (inputStream2 != null) {
            System.out.println(
                    MessageFormat.format("GetResourcesSample.class.getResourceAsStream(\"{0}\") is not null!", file));
        }

        InputStream inputStream3 = GetResourcesSample.class.getClassLoader().getResourceAsStream(file);
        if (inputStream3 != null) {
            System.out.println(
                    MessageFormat.format("GetResourcesSample.class.getClassLoader(\"{0}\") is not null!", file));
        }

    }
}
