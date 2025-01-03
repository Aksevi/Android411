package Lesson14.Account;

import java.util.ArrayList;

public class Bank {
  // 25 1-02
// создаем список аккаунтов
    private ArrayList <Account> accounts; // список аккаунтов accounts просто название

// конструктор. чуть изменили 1-02 см
    public Bank() {
        this.accounts = new ArrayList<>();
    }
// метод добавления списков аккаунтов
        public void addAccount(Account account){
        accounts.add(account);
        }

        public void deposit(Account account, double amount){ // на какой аккаунт какая сумма денег придет

        account.deposit(amount); // добавление суммы на опред счет

        }

        public void withDraw(Account account, double amount){ // с какого счета какую сумму снимаем
        account.withdraw(amount); // снятие суммы с опред счета

        }
 // вывод баланса ввсех счетов
        public void printAccountBalances(){
        for(Account account : accounts){ // проходимся по списку и выводим
            System.out.println("Баланс счета: " + account.getBalance());
        }
    }

}
