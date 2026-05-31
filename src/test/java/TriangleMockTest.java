import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import org.junit.jupiter.api.Test;

class TriangleMockTest
{
    @Test
    void returnsImpossibleAndStopsFurtherChecks()
    {
        Triangle triangle = spy(new Triangle(1, 2, 3));

        doReturn(true).when(triangle).isImpossible();

        List<String> flags = triangle.getTypeFlags();

        assertEquals(List.of("impossible"), flags);
        verify(triangle, times(1)).isImpossible();
        verify(triangle, never()).isEquilateral();
        verify(triangle, never()).isIsosceles();
        verify(triangle, never()).isRightAngled();
        verify(triangle, never()).isScalene();
    }

    @Test
    void returnsRightAngledAndScaleneTogether()
    {
        Triangle triangle = spy(new Triangle(3, 4, 5));

        doReturn(false).when(triangle).isImpossible();
        doReturn(false).when(triangle).isEquilateral();
        doReturn(false).when(triangle).isIsosceles();
        doReturn(true).when(triangle).isRightAngled();
        doReturn(true).when(triangle).isScalene();

        List<String> flags = triangle.getTypeFlags();

        assertEquals(List.of("right-angled", "scalene"), flags);
        verify(triangle, times(1)).isImpossible();
        verify(triangle, times(1)).isEquilateral();
        verify(triangle, times(1)).isIsosceles();
        verify(triangle, times(1)).isRightAngled();
        verify(triangle, times(1)).isScalene();
    }
}
