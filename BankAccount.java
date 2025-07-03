public class BankAccount implements CentralBank {
    String name, accNo, type;
    long balance;
    String bankName;

    BankAccount(String bankName, String name, String accNo, String type, long balance) {
        this.bankName = bankName;
        this.name = name;
        this.accNo = accNo;
        this.type = type;
        this.balance = balance;
    }

    public void deposit(long amount) {
        balance += amount;
    }

    public void withdraw(long amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn. Balance: " + balance);
        } else {
            System.out.println("Not enough balance.");
        }
    }

    public void showAccount() {
        System.out.println("\nBank: " + bankName);
        System.out.println("Name: " + name);
        System.out.println("Acc No: " + accNo);
        System.out.println("Type: " + type);
        System.out.println("Balance: " + balance);
    }

    public boolean search(String accNo) {
        return this.accNo.equals(accNo);
    }
}
