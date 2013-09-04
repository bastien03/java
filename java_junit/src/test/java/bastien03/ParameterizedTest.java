package bastien03;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedTest {

  private final Integer difference;
  private final Integer sum;
  private final Integer firstValue;
  private final Integer secondValue;
  private CalculationHelper helper;

  @Parameters(name = "{0} - {1}")
  public static Collection<Object[]> data() {
    Object[][] toBeTested = new Object[][] {
        {
            2, 3, 5, -1
        }, {
            30, 6, 36, 24
        }
    };

    return Arrays.asList(toBeTested);
  }

  public ParameterizedTest(Integer firstValue, Integer secondValue, Integer sum, Integer difference) {
    this.firstValue = firstValue;
    this.secondValue = secondValue;
    this.sum = sum;
    this.difference = difference;
  }

  @Before
  public void setUp() {
    helper = new CalculationHelper();
  }

  @Test
  public void testSum() {
    assertEquals(sum, helper.addition(firstValue, secondValue));
  }

  @Test
  public void testDifference() {
    assertEquals(difference, helper.difference(firstValue, secondValue));
  }
}
