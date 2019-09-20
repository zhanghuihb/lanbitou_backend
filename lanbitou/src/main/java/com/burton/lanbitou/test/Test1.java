package com.burton.lanbitou.test;

/**
 * @author Tainy
 * @date 2019-09-19 11:39
 */
public class Test1 {
    public static void main(String[] args) {
        final TestDomain testDomain = new TestDomain();

        testDomain.setParam1("1");
        System.out.println(System.identityHashCode(testDomain));
        testDomain.setParam2("2");
        System.out.println(System.identityHashCode(testDomain));

    }
}
