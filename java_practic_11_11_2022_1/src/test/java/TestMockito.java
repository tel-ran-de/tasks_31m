import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestMockito {

    @Mock
    ICalculator mCalc;

    @InjectMocks
    Calculator calc = new Calculator(mCalc);

    @Test
    public void test1() {
        // определяем поведение калькулятора для операции сложения
        when(calc.add(10.0, 20.0)).thenReturn(30.0);
        // проверяем действие сложения
        Assertions.assertEquals(30.0, calc.add(10.0, 20.0));
        // проверяем выполнение действия
        verify(mCalc).add(10.0, 20.0);

        doReturn(15.0).when(mCalc).add(10.0, 5.0);
        Assertions.assertEquals(15.0, calc.add(10.0, 5.0));
        verify(mCalc).add(10.0, 5.0);

        verify(mCalc, atLeast(1)).add(10.0, 20.0);
    }



}
