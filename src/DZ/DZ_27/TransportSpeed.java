package DZ.DZ_27;

public class TransportSpeed {

    public enum Transport{
        CAR(65),
        TRUCK(55),
        AIRPLANE(600),
        TRAIN(70),
        BOAT(22);

        private  int speed;
// конструктор
        Transport(int speed) {
            this.speed = speed;
        }
// метод вывода скорости
       public int getSpeed(){
            return speed;
       }
    }
    public static void main (String[] args){
        System.out.println("Скорость самолета составляет 600 миль в час.");
        System.out.println();
        for (Transport transport : Transport.values()){ // проходимся по массиву enum
//            System.out.println(transport.name() + " типичная скорость составляет " + transport.getSpeed() + " миль в час.");
            System.out.println(transport.name() + " типичная скорость составляет " + transport.getSpeed() + " миль в час.");
        }
    }

}
