package Lesson14.Account;

public class CurrentAccount implements Account {
    private double balance; // баланс видимый только тут
    private double overdraftLimit;

// конструктор
    public CurrentAccount(double balance, double overdraftLimit) {
        this.balance = balance;
        this.overdraftLimit = overdraftLimit;
    }
// геттер только офердрафта так как баланс уже передан через интерфейс
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    // переопределяем методы интерфейса
    @Override
    public void deposit(double amount) {
        balance += amount; // пополнение

    }

    @Override
    public void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) // проверка количества денег на счете
            balance -= amount;// снятие на величину amount

    }

    @Override
    public double getBalance() {
        return balance; // возвращаем текущий баланс
    }
}
