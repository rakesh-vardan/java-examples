package io.learning.try_with_resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Example1 {

    public static void main(String[] args) {
        Example1 sample = new Example1();
        sample.methodWithTryCatchFinally();
        sample.methodWithTryWithResources();
    }

    public void methodWithTryCatchFinally() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    public void methodWithTryWithResources() {
        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
