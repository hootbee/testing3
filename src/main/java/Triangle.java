import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Triangle. The main function takes 3 positive whole-number lengths
 * to be typed in as command line arguments. The program responds
 * with a description of the triangle, as follows:
 *
 * <ul>
 *  <li><b>equilateral</b> - if all three sides have equal length
 *  <li><b>isosceles</b> - if two sides have equal length
 *  <li><b>right-angled</b> - if one angle is a right angle
 *  <li><b>scalene</b> - all sides different lengths, no right angles
 *  <li><b>impossible</b> - if the given side lengths do not form a triangle
 * </ul>
 * Area and perimeter of the triangle are calculated, too.
 *
 * @author Mikko Rusama, SoberIT
 * @version 26.8.2004
 */
public class Triangle
{
    private int side1, side2, side3;
    private static final String P_EQUILATERAL = "equilateral";
    private static final String P_ISOSCELES   = "isosceles";
    private static final String P_RIGHTANGLED = "right-angled";
    private static final String P_SCALENE     = "scalene";
    private static final String P_IMPOSSIBLE  = "impossible";

    public Triangle(int s1, int s2, int s3)
    {
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }

    public Triangle setSideLengths(int s1, int s2, int s3)
    {
        side1 = s1;
        side2 = s2;
        side3 = s3;
        return this;
    }

    public String getSideLengths()
    {
        return side1 + "," + side2 + "," + side3;
    }

    public int getPerimeter()
    {
        return side1 + side2 + side3;
    }

    public double getArea()
    {
        if (!isImpossible())
        {
            return Math.sqrt(getPerimeter()
                / 2
                * (getPerimeter() / 2 - side1)
                * (getPerimeter() / 2 - side2)
                * (getPerimeter() / 2 - side3));
        }
        return -1;
    }

    public String classify()
    {
        if (isImpossible())
        {
            return P_IMPOSSIBLE;
        }
        if (isEquilateral())
        {
            return P_EQUILATERAL;
        }
        if (isIsosceles())
        {
            return P_ISOSCELES;
        }
        if (isRightAngled())
        {
            return P_RIGHTANGLED;
        }
        return P_SCALENE;
    }

    public List<String> getTypeFlags()
    {
        List<String> flags = new ArrayList<>();

        if (isImpossible())
        {
            flags.add(P_IMPOSSIBLE);
            return flags;
        }

        if (isEquilateral())
        {
            flags.add(P_EQUILATERAL);
            return flags;
        }

        if (isIsosceles())
        {
            flags.add(P_ISOSCELES);
        }
        if (isRightAngled())
        {
            flags.add(P_RIGHTANGLED);
        }
        if (isScalene())
        {
            flags.add(P_SCALENE);
        }

        return flags;
    }

    public boolean isEquilateral()
    {
        return side1 == side2 && side2 == side3;
    }

    public boolean isIsosceles()
    {
        return side1 == side2 || side1 == side3 || side2 == side3;
    }

    public boolean isScalene()
    {
        return side1 != side2 && side1 != side3 && side2 != side3;
    }

    public boolean isRightAngled()
    {
        int[] sides = new int[] { side1, side2, side3 };
        Arrays.sort(sides);

        long a = sides[0];
        long b = sides[1];
        long c = sides[2];

        return a * a + b * b == c * c;
    }

    public boolean isImpossible()
    {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0)
        {
            return true;
        }

        return side1 + side2 <= side3
            || side1 + side3 <= side2
            || side2 + side3 <= side1;
    }

    public static void main(String[] args)
    {
        Triangle triangle;
        try
        {
            triangle = new Triangle(
                Integer.parseInt(args[0]),
                Integer.parseInt(args[1]),
                Integer.parseInt(args[2]));
        }
        catch (Exception e)
        {
            System.out.println(
                "Usage: java Quadrangle <side1:int> <side2:int> <side3:int>");
            return;
        }
        System.out.println("Type: " + triangle.classify());
        System.out.println("Type flags: " + String.join(", ", triangle.getTypeFlags()));
        System.out.println("Triangle sides: " + triangle.getSideLengths());
        System.out.println("Area: " + triangle.getArea());
        System.out.println("Perimeter: " + triangle.getPerimeter());
    }
}
