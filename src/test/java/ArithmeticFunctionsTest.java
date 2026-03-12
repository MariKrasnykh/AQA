import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class ArithmeticFunctionsTest {

    @Test
    public void factorialPositiveTest() {
        Assertions.assertEquals(120, ArithmeticFunctions.factorial(5));
    }
    @Test
    public void factorialNegativeTest() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(outputStream));
            ArithmeticFunctions.factorial(-5);
            Assertions.assertEquals("Невозможно посчитать факториал отрицательного числа" + System.lineSeparator(), outputStream.toString());
        } finally {
            System.setOut(originalOut);
        }
    }
    @Test
    public void areaTrianglePositiveTest() {
        Assertions.assertEquals((float) 6, ArithmeticFunctions.areaTriangle(3,4,5));
    }
    @DisplayName("Сторона треугольник не может быть <= 0")
    @ParameterizedTest
    @CsvSource({"-3, 4, 5","0, 3, 4"})
    public void areaTriangleNegativeTest(int a, int b, int c) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(outputStream));
            ArithmeticFunctions.areaTriangle(a,b,c);
            Assertions.assertEquals("Сторона треугольника не может быть отрицательной или равна 0"
                    + System.lineSeparator(), outputStream.toString());
        } finally {
            System.setOut(originalOut);
        }
    }
    @DisplayName("Проверка существования треугольника с заданными сторонами")
    @Test
    public void areaTriangleTestIsTriangle(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(outputStream));
            ArithmeticFunctions.areaTriangle(2,6,9);
            Assertions.assertEquals("Треугольника с такими сторонами не существует"
                    + System.lineSeparator(), outputStream.toString());
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void additionTest(){
        Assertions.assertEquals(5,ArithmeticFunctions.addition(-2, 7));
    }
    @Test
    public void subtractionTest(){
        Assertions.assertEquals(-5, ArithmeticFunctions.subtraction(2, 7));
    }
    @Test
    public void multiplicationTest(){
        Assertions.assertEquals(20, ArithmeticFunctions.multiplication(4, 5));
    }
    @Test
    public void divisionTest(){
       Assertions.assertEquals((float) 0.8, ArithmeticFunctions.division(4, 5));
    }
    @Test
    public void comparingTest(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(outputStream));
            ArithmeticFunctions.comparing(6,9);
            ArithmeticFunctions.comparing(9,6);
            ArithmeticFunctions.comparing(9,9);
            Assertions.assertEquals("6 < 9" + System.lineSeparator()
                    + "9 > 6" + System.lineSeparator() + "9 = 9"
                    + System.lineSeparator(), outputStream.toString());
        } finally {
            System.setOut(originalOut);
        }
    }
}
