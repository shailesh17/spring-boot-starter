package com.ssp.web;

import org.junit.BeforeClass;

/**
 * @author shailesh.patel
 */
public abstract class AppTestSupport {

    /**
     * This is needed to be done once to enhance all the entity objects for Ebean ORM.
     */
    @BeforeClass
    public static void runOnce() {
    }
}
