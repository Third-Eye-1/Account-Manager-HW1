public class Amount {    // Создаем класс с именем Amount
    // Приватные поля класса для хранения суммы и типа транзакции
    private double amount; // Сумма транзакции
    private String transactionType; // Тип транзакции (Покупка, вложение и так далее)

    // Конструктор класса, который принимает сумму и тип транзакции в качестве параметров
    public Amount(double amount, String transactionType) {
        // Устанавливаем значения переданных параметров в соответствующие поля класса
        this.amount = amount;
        this.transactionType = transactionType;
    }

    // Метод для получения суммы транзакции
    public double getAmount() {
        return amount;
    }

    // Метод для получения типа транзакции
    public String getTransactionType() {
        return transactionType;
    }
}
