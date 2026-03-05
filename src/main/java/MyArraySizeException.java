public class MyArraySizeException extends ArrayIndexOutOfBoundsException{
    public MyArraySizeException(){
        super("Метод может обработать только массив размером 4х4");
    }

}
