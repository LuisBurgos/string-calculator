
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luisburgos on 30/09/15.
 */
public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @Before
    public void initialize(){
        stringCalculator = new StringCalculator();
    }


    @Test
    public void input_EmptyString_Returns_0() throws NegativesNotAllowed {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void input_1_Returns_0() throws NegativesNotAllowed {
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    public void input_1_2_Returns_3() throws NegativesNotAllowed {
        assertEquals(3, stringCalculator.add("1, 2"));
    }

    @Test
    public void input_1_2_3_40_Returns_46() throws NegativesNotAllowed {
        assertEquals(46, stringCalculator.add("1, 2, 3, 40"));
    }

    @Test
    public void input_1_n_2_3_Returns_6() throws NegativesNotAllowed {
        assertEquals(6, stringCalculator.add("1 \n2, 3"));
    }

    @Test
    public void input_1_n_Returns_1() throws NegativesNotAllowed {
        assertEquals(1, stringCalculator.add("1,\n"));
    }

    @Test
    public void input_token_delimiter_n_1_delimiter_2_Return_3() throws NegativesNotAllowed {
        assertEquals(3, stringCalculator.add("//; \n 1; 2"));
    }

    @Test
    public void input_negatives_Return_NegativeNotAllowed(){
        try{
            stringCalculator.add("-1, -2, -3");
            fail("No pasó la prueba");
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

}