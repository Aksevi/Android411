package Lesson14.Account;

public class Main {
    public static void main(String[] args) {
// экз класса
        Bank bank = new Bank();

// экз класса
        SavingAccount savingAccount = new SavingAccount(1000, 1.25);

        System.out.println("===== Сберегательный счет =====\nПервоначальный депозит: $" + savingAccount.getBalance() + "\nПроцентная ставка: " + savingAccount.getInterestRate() + "%\n");
// экз класса
        CurrentAccount currentAccount = new CurrentAccount(5000, 1000);

        System.out.println("======== Текущий  счет ========\nПервоначальный депозит: $" + currentAccount.getBalance() + "\nЛимит овердрафта: $" + currentAccount.getOverdraftLimit() + "\n");

        bank.addAccount(savingAccount);
        bank.addAccount(currentAccount);

        System.out.println("Вносим 100$ на сберегательный счет.");
        bank.deposit(savingAccount, 100); // на какой счет и сколько

        System.out.println("Вносим 500$ на текущий счет.");
        bank.deposit(currentAccount, 500); // на какой счет и сколько

        System.out.println("Снимаем 150$ со сберегательного счета");
        bank.withDraw(savingAccount, 150);



        System.out.println("\n=== Сберегательный и текущий счет ===");
        bank.printAccountBalances(); // вызов метода вывода баланса из класса Bank

        savingAccount.applyInterest();
        System.out.println("\n     После начисления процентов");

        System.out.println("=== Сберегательный и текущий счет ===");
        bank.printAccountBalances(); // вызов метода вывода баланса из класса Bank
    }
}
