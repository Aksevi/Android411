package Lessons15.exception;
// 29 2-18
public class Test5 {
    public static void main(String[] args) {
        try{
        compute(1);
        compute(20);

      } catch (NewException e) {
            System.out.println("перехваченное исключение " + e);
            }
        }

      public static void compute(int a) throws NewException{

          System.out.println("Вызван метод compute (" + a + ")");
          if (a > 10){
              throw new NewException(a, "Некорректное значение");
          }
          System.out.println("Корректное значение");
      }
}

class NewException extends Exception{

    private int detail;

// конструктор
    public NewException(int detail, String message) {
        super(message);
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "NewException{" +
                "detail=" + detail +
                ", message=" + getMessage() + "}";
    }
}