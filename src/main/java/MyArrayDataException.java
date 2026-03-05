public class MyArrayDataException extends NumberFormatException{
    public MyArrayDataException(int row, int column) {
        super("В ячейке [" + row + "][" + column + "] неверные данные - невозможно преобразовать");
    }
}
