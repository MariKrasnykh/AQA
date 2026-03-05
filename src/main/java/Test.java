import java.util.Arrays;

public class Test {

    static int sum;
    public static int[][] convertToInt(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int[][] convertArray = new int[4][4];
        if (array.length != 4 || array[0].length != 4 || array[1].length != 4 || array[2].length != 4 || array[3].length != 4){
            throw new MyArraySizeException();
        } else {
            sum = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    try {
                    convertArray[i][j] = Integer.parseInt(array[i][j]);
                    }
                    catch (NumberFormatException e){
                        throw new MyArrayDataException(i,j);
                    }
                    sum += Integer.parseInt(array[i][j]);
                }
            }
        }
        return convertArray;
    }


    public static void main(String[] args) {
        String[][] array = new String[][]{
            {"2","3","4","5"},
            {"1","1","2","2"},
            {"0","1","2","3"},
            {"6","0","0","8"}
        };

        String[][] arraySizeException = new String[][]{
                {"2","3","4","5"},
                {"1","1","2","2"}
        };

        String[][] arrayDataException = new String[][]{
                {"2","3","4","5"},
                {"1","1","2","2"},
                {"0","1","a","3"},
                {"6","0","0","8"}
        };

        try {
            int[][] arrayToInt = convertToInt(array);
            for (int i = 0; i < 4; i++) {
                System.out.println(Arrays.toString(arrayToInt[i]));
            }
            int[][] arrayToIntSizeException = convertToInt(arraySizeException);
        }
        catch (MyArraySizeException e){
            //System.out.println("Метод может обработать только массив размером 4х4");
            e.printStackTrace();
        }
        catch (MyArrayDataException e){
            e.printStackTrace();
        }
        finally {
            System.out.println("Сумма элементов массива = " + sum);
        }


        try {
            int[][] arrayToIntDataException = convertToInt(arrayDataException);
        }
        catch (MyArraySizeException e){
            e.printStackTrace();
        }
        catch (MyArrayDataException e){
            e.printStackTrace();
        }


        try {
            System.out.println(array[4][4]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }


    }
}
