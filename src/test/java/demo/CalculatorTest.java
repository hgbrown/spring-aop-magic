package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class CalculatorTest {

    @Autowired
    Calculator calculator;

    @Test
    public void shouldShow2and2is5() throws Exception {
        final int a = 2;
        final int b = 2;

        final int result = calculator.add(a, b);

        assertThat(result, is(5));

        System.out.printf("%s + %s = %s%n", a, b, result);
    }

    @Test
    public void shouldShow2and1is3() throws Exception {
        final int a = 2;
        final int b = 1;

        final int result = calculator.add(a, b);

        assertThat(result, is(3));
        System.out.printf("%s + %s = %s%n", a, b, result);
    }

    @Test
    public void shouldShow2and3is5() throws Exception {
        final int a = 2;
        final int b = 3;

        final int result = calculator.add(a, b);

        assertThat(result, is(5));
        System.out.printf("%s + %s = %s%n", a, b, result);
    }

}