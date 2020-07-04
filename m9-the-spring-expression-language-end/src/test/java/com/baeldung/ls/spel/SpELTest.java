package com.baeldung.ls.spel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SpELTest {

    @Autowired
    private SpELBeanA spELBeanA;

    @Test
    public void whenSpELBeanA_thenAllResolvedCorrectly() {
        assertNotNull(spELBeanA);
    }

}
