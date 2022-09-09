package com.nduckett.api.resources;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RootResourceTest {
    private RootResource rootResource;

    @BeforeEach
    public void setup() {
        rootResource = new RootResource();
    }

    @Test
    public void testWelcome() {
        assertEquals("Welcome", rootResource.get());
    }
}
