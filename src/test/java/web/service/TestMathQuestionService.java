package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

	@Test
    public void testQ1Addition() {
        Assert.assertEquals(MathQuestionService.q1Addition("1", "2"), Double.valueOf(3.0), 0);
    }

    @Test
    public void testQ1AdditionInvalidInput() {
        Assert.assertNull(MathQuestionService.q1Addition("", "2"));
        Assert.assertNull(MathQuestionService.q1Addition("a", "2"));
        Assert.assertNull(MathQuestionService.q1Addition("1", "b"));
    }

    @Test
    public void testQ2Subtraction() {
        Assert.assertEquals(MathQuestionService.q2Subtraction("5", "3"), Double.valueOf(2.0), 0);
    }

    @Test
    public void testQ2SubtractionInvalidInput() {
        Assert.assertNull(MathQuestionService.q2Subtraction("", "3"));
        Assert.assertNull(MathQuestionService.q2Subtraction("a", "3"));
        Assert.assertNull(MathQuestionService.q2Subtraction("5", "b"));
    }
    
    @Test
    public void testQ3Multiplication() {
        Assert.assertEquals(MathQuestionService.q3Multiplication("3", "4"), Double.valueOf(12.0), 0);
    }

    @Test
    public void testQ3MultiplicationInvalidInput() {
        Assert.assertNull(MathQuestionService.q3Multiplication("", "4"));
        Assert.assertNull(MathQuestionService.q3Multiplication("a", "4"));
        Assert.assertNull(MathQuestionService.q3Multiplication("3", "b"));
    }
}
