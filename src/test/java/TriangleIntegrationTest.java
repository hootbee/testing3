import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class TriangleIntegrationTest
{
    @Test
    void mainFlowEquilateral() {
        String output = runMain("3", "3", "3");
        assertTrue(output.contains("Type: equilateral"));
        assertTrue(output.contains("Type flags: equilateral"));
    }

    @Test
    void mainFlowIsosceles() {
        String output = runMain("3", "3", "4");
        assertTrue(output.contains("Type: isosceles"));
        assertTrue(output.contains("Type flags: isosceles"));
    }

    @Test
    void mainFlowRightAngledScalene() {
        String output = runMain("3", "4", "5");
        assertTrue(output.contains("Type: right-angled"));
        assertTrue(output.contains("Type flags: right-angled, scalene"));
    }

    @Test
    void mainFlowScalene() {
        String output = runMain("4", "5", "6");
        assertTrue(output.contains("Type: scalene"));
        assertTrue(output.contains("Type flags: scalene"));
    }

    @Test
    void mainFlowImpossible() {
        String output = runMain("1", "2", "3");
        assertTrue(output.contains("Type: impossible"));
        assertTrue(output.contains("Type flags: impossible"));
    }

    @Test
    void insufficientArgsShowsUsage() {
        String output = runMain("3", "4");
        assertTrue(output.contains("Usage: java Quadrangle"));
    }

    @Test
    void nonNumericShowsUsage() {
        String output = runMain("a", "4", "5");
        assertTrue(output.contains("Usage: java Quadrangle"));
    }

    @Test
    void rightAngledOrderIndependenceInMainFlow() {
        String output = runMain("5", "3", "4");
        assertTrue(output.contains("Type flags: right-angled, scalene"));
    }

    private String runMain(String... args) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream captured = new PrintStream(outputStream);

        try {
            System.setOut(captured);
            Triangle.main(args);
            captured.flush();
            return outputStream.toString();
        } finally {
            System.setOut(originalOut);
            captured.close();
        }
    }
}
