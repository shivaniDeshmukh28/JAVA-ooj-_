import java.util.*;

public class BankDriver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();
        int ch;

        do {
            System.out.println("\n1.Create\n2.Show All\n3.Search\n4.Deposit\n5.Withdraw\n6.Delete\n7.Exit");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter Bank Name (UNB/NBD/FGB): ");
                    String bank = sc.next();
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Acc No: ");
                    String accNo = sc.next();
                    System.out.print("Type: ");
                    String type = sc.next();
                    System.out.print("Balance: ");
                    long bal = sc.nextLong();

                    boolean exists = false;
                    for (BankAccount acc : accounts)
                        if (acc.search(accNo)) exists = true;

                    if (exists) {
                        System.out.println("Account already exists.");
                    } else {
                        long minBal = bank.equals("UNB") ? 1000 : bank.equals("NBD") ? 2000 : 3000;
                        if (bal >= minBal) {
                            accounts.add(new BankAccount(bank, name, accNo, type, bal));
                            System.out.println("Account created.");
                        } else {
                            System.out.println("Minimum balance for " + bank + " is " + minBal);
                        }
                    }
                    break;

                case 2:
                    if (accounts.isEmpty()) System.out.println("No accounts.");
                    for (BankAccount acc : accounts) acc.showAccount();
                    break;

                case 3:
                    System.out.print("Enter Acc No: ");
                    accNo = sc.next();
                    boolean found = false;
                    for (BankAccount acc : accounts) {
                        if (acc.search(accNo)) {
                            acc.showAccount();
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Account not found.");
                    break;

                case 4:
                    System.out.print("Enter Acc No: ");
                    accNo = sc.next();
                    System.out.print("Amount: ");
                    long amt = sc.nextLong();
                    for (BankAccount acc : accounts)
                        if (acc.search(accNo)) acc.deposit(amt);
                    break;

                case 5:
                    System.out.print("Enter Acc No: ");
                    accNo = sc.next();
                    System.out.print("Amount: ");
                    amt = sc.nextLong();
                    for (BankAccount acc : accounts)
                        if (acc.search(accNo)) acc.withdraw(amt);
                    break;

                case 6:
                    System.out.print("Enter Acc No to delete: ");
                    accNo = sc.next();
                    accounts.removeIf(acc -> acc.search(accNo));
                    System.out.println("Deleted if found.");
                    break;

                case 7:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (ch != 7);
    }
}
