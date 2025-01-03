package Lesson14.Account;

public class SavingAccount implements Account {
    private double balance; // баланс видимый только тут
    private double interestRate; // процентная ставка

// конструктор
    public SavingAccount(double balance, double interestRate) {
        this.balance = balance;
        this.interestRate = interestRate;
    }
// геттер только ставка потому что баланс берется из интерфейса
    public double getInterestRate() {
        return interestRate;
    }

    // переопределяем методы из интерфейса
    @Override
    public void deposit(double amount) {
    balance += amount; // пополнение счета на определенную сумму
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount; // снятие со счета на определенную сумму

    }

    @Override
    public double getBalance() {
        return balance;
    }
// метод начисления процентов
    public void applyInterest(){
        balance += balance * interestRate / 100;
    }
}
