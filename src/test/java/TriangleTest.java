import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class TriangleTest
{
    @Test
    void equilateralTriangle()
    {
        Triangle triangle = new Triangle(3, 3, 3);
        assertEquals(List.of("equilateral"), triangle.getTypeFlags());
    }

    @Test
    void isoscelesTriangle()
    {
        Triangle triangle = new Triangle(3, 3, 4);
        assertEquals(List.of("isosceles"), triangle.getTypeFlags());
    }

    @Test
    void rightAngledScaleneTriangle()
    {
        Triangle triangle = new Triangle(3, 4, 5);
        assertEquals(List.of("right-angled", "scalene"), triangle.getTypeFlags());
    }

    @Test
    void scaleneTriangle()
    {
        Triangle triangle = new Triangle(4, 5, 6);
        assertEquals(List.of("scalene"), triangle.getTypeFlags());
    }

    @Test
    void boundaryImpossibleTriangle()
    {
        Triangle triangle = new Triangle(1, 2, 3);
        assertEquals(List.of("impossible"), triangle.getTypeFlags());
    }

    @Test
    void boundaryEqualSumImpossibleTriangle()
    {
        Triangle triangle = new Triangle(1, 1, 2);
        assertEquals(List.of("impossible"), triangle.getTypeFlags());
    }

    @Test
    void zeroSideImpossibleTriangle()
    {
        Triangle triangle = new Triangle(0, 1, 1);
        assertEquals(List.of("impossible"), triangle.getTypeFlags());
    }

    @Test
    void negativeSideImpossibleTriangle()
    {
        Triangle triangle = new Triangle(-1, 2, 2);
        assertEquals(List.of("impossible"), triangle.getTypeFlags());
    }

    @Test
    void rightAngledOrderIndependenceFirst()
    {
        Triangle triangle = new Triangle(5, 3, 4);
        assertEquals(List.of("right-angled", "scalene"), triangle.getTypeFlags());
    }

    @Test
    void rightAngledOrderIndependenceSecond()
    {
        Triangle triangle = new Triangle(4, 5, 3);
        assertEquals(List.of("right-angled", "scalene"), triangle.getTypeFlags());
    }
}
