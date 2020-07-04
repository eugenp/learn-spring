package com.baeldung.ls.spel;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpELTest {

    @Autowired
    private SpELBeanA spELBeanA;

    @Test
    public void whenSpELBeanAIsInjected_thenExpressionsResolvedCorrectly() {
        assertNotNull(spELBeanA);
    }

}
