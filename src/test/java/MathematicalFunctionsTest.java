import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MathematicalFunctionsTest {

    @Test
    public void factorialPositiveTest() {
        Assert.assertEquals(MathematicalFunctions.factorial(5),120);
    }
    @Test
    public void factorialNegativeTest() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(outputStream));
            MathematicalFunctions.factorial(-5);
            Assert.assertEquals(outputStream.toString(), "Невозможно посчитать факториал отрицательного числа" + System.lineSeparator());
        } finally {
            System.setOut(originalOut);
        }
    }
    @Test
    public void areaTrianglePositiveTest() {
        Assert.assertEquals(MathematicalFunctions.areaTriangle(3,4,5), (float) 6);
    }

    @DataProvider
    public Object[][] valueSidesTriangle(){
        return new Object[][]{
                {-3, 4, 5},
                {0, 3, 4}
        };
    }
    @Description("Сторона треугольник не может быть <= 0")
    @Test(dataProvider = "valueSidesTriangle")
    public void areaTriangleNegativeTest(int a, int b, int c) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(outputStream));
            MathematicalFunctions.areaTriangle(a,b,c);
            Assert.assertEquals(outputStream.toString(), "Сторона треугольника не может быть отрицательной или равна 0" + System.lineSeparator());
        } finally {
            System.setOut(originalOut);
        }
    }
    @Description("Проверка существования треугольника с заданными сторонами")
    @Test
    public void areaTriangleTestIsTriangle(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(outputStream));
            MathematicalFunctions.areaTriangle(2,6,9);
            Assert.assertEquals(outputStream.toString(), "Треугольника с такими сторонами не существует" + System.lineSeparator());
        } finally {
            System.setOut(originalOut);
        }
    }
    @Test
    public void additionTest(){
        Assert.assertEquals(MathematicalFunctions.addition(-2, 7),5);
    }
    @Test
    public void subtractionTest(){
        Assert.assertEquals(MathematicalFunctions.subtraction(2, 7), -5);
    }
    @Test
    public void multiplicationTest(){
        Assert.assertEquals(MathematicalFunctions.multiplication(4, 5), 20);
    }
    @Test
    public void divisionTest(){
        Assert.assertEquals(MathematicalFunctions.division(4, 5), (float) 0.8);
    }
    @Test
    public void comparingTest(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(outputStream));
            MathematicalFunctions.comparing(6,9);
            MathematicalFunctions.comparing(9,6);
            MathematicalFunctions.comparing(9,9);
            Assert.assertEquals(outputStream.toString(), "6 < 9" + System.lineSeparator()
                    + "9 > 6" + System.lineSeparator() + "9 = 9"
                    + System.lineSeparator());
        } finally {
            System.setOut(originalOut);
        }
    }



}
