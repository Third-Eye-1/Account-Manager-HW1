import java.util.ArrayList; //Импортируем ArrayList так как по умолчанию его в обычном Джава библиотеке нету

public class PersonalAccount {  // Создаем класс PersonalAccount

    // Приватные поля класса
    private int accountNumber; // Номер счета
    private String accountHolder; // имя хозяина Кошелька
    private double balance; // Баланс на счете
    private ArrayList<Amount> transactions; // Список с историей транзакций

    // Конструктор класса PersonalAccount
    public PersonalAccount(int accountNumber, String accountHolder) {
        this.accountNumber = accountNumber; // Устанавливаем номер счета который мы сами пишем
        this.accountHolder = accountHolder; // Устанавливаем владельца счета который также мы сами пишем
        this.balance = 0.0; // Изначально баланс равен 0
        this.transactions = new ArrayList<>(); // Инициализируем список транзакций
    }

    // Метод для внесения денег на счет (депозит)
    public void deposit(double amount) {
        if (amount > 0) { // Проверяем, что Депозит не отрицательное число
            balance += amount; // Увеличиваем баланс на сумму депозита
            transactions.add(new Amount(amount, "Депозит")); // Добавляем запись о депозите в список транзакций
        }
    }

    // Метод для снятия денег со счета 
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) { // Проверяем, что сумма больше нуля и на счете достаточно Денег
            balance -= amount; // отнимаем столько денег из баланса сколько мы взяли
            transactions.add(new Amount(amount, "Выдача")); // Добавляем запись о снятии в список транзакций
        }
    }

    // Метод для вывода истории транзакций
    public void printTransactionHistory() {
        System.out.println("История Тразакций для счета #" + accountNumber + " (" + accountHolder + "):");
        for (Amount transaction : transactions) {
            System.out.println(transaction.getTransactionType() + ", Количевство: $" + transaction.getAmount());
        }
    }

    // Метод для получения текущего баланса (На всякий случай)
    public double getBalance() {
        return balance;
    }

    // Метод для получения номера счета (На всякий случай)
    public int getAccountNumber() {
        return accountNumber;
    }

    // Метод для получения владельца счета (На всякий случай)
    public String getAccountHolder() {
        return accountHolder;
    }

    // Метод main для тестирования класса PersonalAccount
    public static void main(String[] args) {
        PersonalAccount account = new PersonalAccount(777, "Ahmet Myrzakulov"); // Создаем пример счета с именем

        // Выполняем несколько операций с счетом (депозиты и снятия)
        account.deposit(1000.0);
        account.withdraw(500.0);
        account.deposit(200.0);
        account.deposit(1050.0);
        account.withdraw(50.0);
        account.deposit(200.0);
        account.deposit(100.0);
        account.withdraw(500.0);
        account.deposit(200.0);

        // Выводим информацию о счете и историю транзакций
        System.out.println(account.getAccountNumber());
        System.out.println(account.getAccountHolder());
        account.printTransactionHistory();
        System.out.println("Текущий баланс: $" + account.getBalance());
    }
}
