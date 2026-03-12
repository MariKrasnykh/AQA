public class ArithmeticFunctions {

    public static int factorial(int number){
        int factorial = 1;
        if (number < 0) System.out.println("Невозможно посчитать факториал отрицательного числа");
        else {
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
        }
        return factorial;
    }


    public static float areaTriangle(float a, float b, float c) {
        float area = 0;
        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("Сторона треугольника не может быть отрицательной или равна 0");
        } else if (a >= b + c || b >= c + a || c >= a + b) {
            System.out.println("Треугольника с такими сторонами не существует");
        } else {
            float p = (a + b + c) / 2;
            area = (float) Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return area;
    }

    public static int addition(int number1, int number2){
        return number1 + number2;
    }

    public static int subtraction(int number1, int number2){
        return number1 - number2;
    }

    public static int multiplication(int number1, int number2){
        return number1 * number2;
    }

    public static float division(int number1, int number2){
        return (float) number1 / number2;
    }

    public static void comparing(int number1, int number2){
        if (number1 == number2) System.out.println(number1 + " = " + number2);
        else if (number1 > number2) System.out.println(number1 + " > " + number2);
        else System.out.println(number1 + " < " + number2);
    }

    
}
