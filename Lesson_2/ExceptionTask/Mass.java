package Lesson_2.ExceptionTask;

public class Mass {

   private String[][] array;
   public Mass(String[][] array) {
    this.array = array;
    }

    public int sumArray (String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (array.length == 4
                && array[0].length == 4
                && array[1].length == 4
                && array[2].length == 4
                && array[3].length == 4) {

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {

                    try {
                        sum += new Integer(array[i][j]);
                    }
                    catch (Exception e){
                        throw new MyArrayDataException("Неверные данные в ячейке [" + i + "] [" + j + "]");
                    }
                }
            }
        }
        else throw new MyArraySizeException ("Размер переданного массива отличается от 4 х 4");
    return sum;
    }
}
