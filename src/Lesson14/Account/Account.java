package Lesson14.Account;
// 26 23 min
public interface Account {

    void deposit(double amount); // внесение денег
    void withdraw(double amount); // снятие денег
    double getBalance(); // просмотр баланса поэтому в скобках никаких принимаемых значений нет
}
