package storonnee._Alex;

import java.util.Scanner;

    public class Daya_Car {
        Scanner input = new Scanner(System.in);
        private String nameCar;
        private String ageCreate;
        private String manufacturer;
        private String powerEngine;
        private String colorCar;
        private String priceCar;

        public Daya_Car(String nameCar, String ageCreate, String manufacturer, String powerEngine, String colorCar, String priceCar) {
            this.nameCar = nameCar;
            this.ageCreate = ageCreate;
            this.manufacturer = manufacturer;
            this.powerEngine = powerEngine;
            this.colorCar = colorCar;
            this.priceCar = priceCar;
        }

        public String getNameCar() {
            return nameCar;
        }

        public void setNameCar(String nameCar) {
            this.nameCar = nameCar;
        }

        public String getAgeCreate() {
            return ageCreate;
        }

        public void setAgeCreate(String ageCreate) {
            this.ageCreate = ageCreate;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public String getPowerEngine() {
            return powerEngine;
        }

        public void setPowerEngine(String powerEngine) {
            this.powerEngine = powerEngine;
        }

        public String getColorCar() {
            return colorCar;
        }

        public void setColorCar(String colorCar) {
            this.colorCar = colorCar;
        }

        public String getPriceCar() {
            return priceCar;
        }

        public void setPriceCar(String priceCar) {
            this.priceCar = priceCar;
        }

        public void getPrintInfoCar() {
            System.out.println("\n****** Данные автомобиля ******");
            System.out.println("1. Модели: " + this.nameCar);
            System.out.println("2. Год выпуска: " + this.ageCreate);
            System.out.println("3. Производитель: " + this.manufacturer);
            System.out.println("4. Мощность двигателя: " + this.powerEngine + " л.с.");
            System.out.println("5. Цвет машины: " + this.colorCar);
            System.out.println("6. Цена: " + this.priceCar + " р.");
            System.out.println("===============================");
        }

        public void getTextPrint(int n) {
            switch (n) {
                case 1 -> System.out.println("\n Для выполнения одной из команд укажите её цифру: \n  1. Отобразть таблицу с данными о машине  \n  2. Изменить данные в таблице \n  3. Выход");
                case 2 -> System.out.print("\nВведите цифру команды -> ");
                case 3 -> System.out.print("  Выберите цифру строки из таблицы данных на машину, которую хотите изменить или введите цифру 7 чтоб выйти предыдущее меню. -> ");
                case 4 -> System.out.println("\n<Ошибка при вводе пункта, попробуйте еще раз>\n");
                case 5 -> System.out.print("Введите новые данные -> ");
                case 6 -> System.out.println("\n<Программа завершена>");
            }
        }

    }

