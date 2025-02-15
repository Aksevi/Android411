package Lesson15.exception.Dog2;

// 29 55 min свой класс исключений
public class DogIsNotReadyException extends Exception {

    public DogIsNotReadyException(String message) {
        super(message);

    }
}
