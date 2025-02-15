package Lesson15.exception.Dog2;

public class Main {
    public static void main(String[] args) {
        Dog dog2 = new Dog("Бэрри");
// вызываем эти методы. если все вызваны то идем гулять. если  что закоментируешь (т.е. не вызовешь )то и будет false
        dog2.putCollar();
        dog2.putLeash();
//        dog2.putMuzzle();

        try {
            dog2.walk();
        } catch (DogIsNotReadyException e) {
            System.out.println(e.getMessage());
            System.out.println("\nПроверяем экипировку!\nОшейник надет: " + dog2.isCoolarOutOn + "\nПоводок надет: " + dog2.isLeashPutOn + "\nНамордник надет: " + dog2.isMuzzlePutOn);
        }

    }
}
