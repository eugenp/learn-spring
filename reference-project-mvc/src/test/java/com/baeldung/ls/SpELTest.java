package com.baeldung.ls;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SpELTest {

    @Value("#{2+3}")
    private Integer add;

    @Value("#{'Learn ' + 'Spring'}")
    private String addString;

    @Value("#{2 == 2}")
    private boolean equal;

    @Value("#{3 > 2 ? 'a' : 'b'}")
    private String ternary;

    @Test
    public void whenSpELTestInitialized_addExpressionResolvedCorrectly() {
        assertEquals(this.add, 5);
    }

    @Test
    public void whenSpELTestInitialized_addStringExpressionResolvedCorrectly() {
        assertEquals(this.addString, "Learn Spring");
    }

    @Test
    public void whenSpELTestInitialized_booleanExpressionResolvedCorrectly() {
        assertTrue(this.equal);
    }

    @Test
    public void whenSpELTestInitialized_ternaryExpressionResolvedCorrectly() {
        assertEquals(this.ternary, "a");
    }

}
