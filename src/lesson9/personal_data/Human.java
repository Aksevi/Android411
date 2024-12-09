package lesson9.personal_data;
// ур 20 1-55
public class Human {

   private String name;
   private String birthday;
   private String phone;
   private String country;
   private String city;
   private String address;

Human(){

}
// конструктор
   public Human(String name, String birthday, String phone, String country, String city, String address) {
      this.name = name;
      this.birthday = birthday;
      this.phone = phone;
      this.country = country;
      this.city = city;
      this.address = address;
   }
 // сеттеры и геттеры
   public String getName() { //  геттер получаем значение
      return this.name;
   }

   public void setName(String name) { // сеттер установили значение
      this.name = name;
   }

   public String getBirthday() {
      return birthday;
   }

   public void setBirthday(String birthday) {
      this.birthday = birthday;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   // метод printInfo
   public void printInfo(){
       System.out.println("********* персональные данные **********");
       System.out.println("Имя:           " + this.name);
       System.out.println("Дата рождения: " + this.birthday);
       System.out.println("Телефон:       " + this.phone);
       System.out.println("Страна:        " + this.country);
       System.out.println("Город:         " + this.city);
       System.out.println("Адрес:         " + this.address);
       System.out.println("========================================");
    }
}
