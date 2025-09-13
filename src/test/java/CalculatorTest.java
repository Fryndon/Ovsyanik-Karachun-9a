import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class CalculatorTest {

  private final Calculator calculator = new Calculator();
  private static final double DELTA = 0.0001;

  @Test
  public void testAddition() {
    assertEquals(5.0, calculator.add(2, 3), DELTA);
    assertEquals(1.0, calculator.add(-2, 3), DELTA);
    assertEquals(0.0, calculator.add(0, 0), DELTA);
  }

  @Test
  public void testSubtraction() {
    assertEquals(2.0, calculator.subtract(5, 3), DELTA);
    assertEquals(-2.0, calculator.subtract(3, 5), DELTA);
    assertEquals(0.0, calculator.subtract(0, 0), DELTA);
  }

  @Test
  public void testMultiplication() {
    assertEquals(6.0, calculator.multiply(2, 3), DELTA);
    assertEquals(-6.0, calculator.multiply(-2, 3), DELTA);
    assertEquals(0.0, calculator.multiply(0, 5), DELTA);
  }

  @Test
  public void testDivision() {
    assertEquals(2.0, calculator.divide(6, 3), DELTA);
    assertEquals(2.5, calculator.divide(5, 2), DELTA);
    assertEquals(-2.0, calculator.divide(-6, 3), DELTA);
  }

  @Test(expected = ArithmeticException.class)
  public void testDivisionByZero() {
    calculator.divide(5, 0);
  }

  @Test
  public void testDivisionByZeroMessage() {
    try {
      calculator.divide(5, 0);
      fail("Expected ArithmeticException was not thrown");
    } catch (ArithmeticException e) {
      assertEquals("Nan", e.getMessage());
    }
  }

  @Test
  public void testFloatingPointOperations() {
    assertEquals(0.3, calculator.add(0.1, 0.2), DELTA);
    assertEquals(3.0, calculator.multiply(1.5, 2), DELTA);
  }
}