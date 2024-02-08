package org.kirzhoy.lesson3Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.kirzhoy.lesson3.Resolver;

public class ResolverTest {

    private static Resolver resolver;

    @BeforeAll
    static void beforeAll() {
        resolver = new Resolver();
    }

    @Test
    void baseTest() {
    int min = Resolver.getMin(new int[]{4,2,1,5});
        Assertions.assertEquals(1, min);


    }


}
