package io.learning.try_with_resources;

import java.io.*;

public class Example2 {

    public static void main(String[] args) {
        Example2 sample = new Example2();
        sample.methodWithTryCatchFinally();
        sample.methodWithTryWithResources();
    }

    public void methodWithTryCatchFinally() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("input.txt");
            fos = new FileOutputStream("output.txt");
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void methodWithTryWithResources() {
        try (FileInputStream fis = new FileInputStream("input.txt");
             FileOutputStream fos = new FileOutputStream("output.txt")) {
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
