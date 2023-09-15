package com.baeldung.ls;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig(value = LsApp.class)
@TestPropertySource(locations = "classpath:test.properties")
public class TestPropertySourceTest {

    @Value("${testproperty}")
    private String testproperty;

    @Value("${additional.info}")
    private String additional;

    @Test
    public void whenTestPropertySource_thenValuesRetreived() {
        assertEquals("Test Property Value", testproperty);
    }

    @Test
    @Disabled("Added only as an intermediate step for understanding, to make this run - comment additional.info from test.properties")
    public void whenPropertyDefinedInMain_thenValuesRetrieved() {
        assertEquals("Additional Info", additional);
    }

    @Test
    public void givenSameProperty_whenTestPropertySource_thenHigherPriority() {
        assertEquals("Additional Info From Test", additional);
    }

}
