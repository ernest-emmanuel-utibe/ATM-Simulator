import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static final Atm atm = new Atm();
    public static void main(String[] args) {



        System.out.println("Welcome to the ATM of the People's Bank");
        System.out.print("Please enter your name: ");
        atm.setName(input.nextLine());
        enterPin();
    }

    private static void enterPin(){
        System.out.print("Input your pin: ");
        atm.setPin(1234);
        int pinNumber = input.nextInt();
        if (pinNumber == atm.getPin()) {
            displayOptions();
        }
        else {
            System.out.println("Enter a valid pin");
            enterPin();
        }

    }

    private static void displayOptions() {
        System.out.println("++++++++++++++++++++++++++++++++++++++");
        System.out.println("|                                        |");
        System.out.printf("|        WELCOME %S                       |", atm.getName());
        System.out.println("|                                         |");
        System.out.println("+++++++++++++++++++++++++++++++++++++++");

        System.out.println("""
                Press 1 for Current Account
                Press 2 for Saving Account
                Press 3 to Exit Transaction
                """);

        int numOptions = input.nextInt();
        switch (numOptions) {
            case 1: current();
            case 2: savings();
            case 3: atm.savings();
            case 4: exit();
            case 5: exitApp();
        }
    }

    public static void current() {
        System.out.println("""
                Press 1 to deposit
                Press 2 to withdraw
                Press 3 to transfer
                Press 4 to check balance
                Press 5 to go back to the main menu
                Press 6 to exit
                """);
        int numberPattern = input.nextInt();

        switch (numberPattern) {
            case 1 -> makeDepositOnCurrentAccount();
            case 2 -> makeWithdrawOnCurrentAccount();
            case 3 -> makeTransferOnCurrentAccount();
            case 4 -> checkBalanceOnCurrentAccount();
            case 5 -> displayOptions();
            case 6 -> exit();
        }
    }

    public static void makeDepositOnCurrentAccount() {
        System.out.print("Enter deposit amount: ");
        double amount = input.nextDouble();
        atm.deposit(BigDecimal.valueOf(amount));
        System.out.println("Deposit successful\n");
        System.out.printf("Your new balance is %.2f%n\n", atm.getBalance());
        current();
    }

   public static void makeWithdrawOnCurrentAccount() {
       System.out.print("Enter withdrawal amount: ");
       double amount = input.nextDouble();
       atm.withdraw(BigDecimal.valueOf(amount));
       System.out.println("Withdrawal Successful\n");
       System.out.printf("Your new balance is %.2f%n", atm.getBalance());
       current();
   }

   public static void makeTransferOnCurrentAccount() {
       System.out.print("Enter the amount you want to transfer: ");
       double transferAmount = input.nextDouble();
       System.out.print("Enter account number: ");
       int number = input.nextInt();
       atm.transfer(BigDecimal.valueOf(transferAmount));

       System.out.print("Transfer successfully\n");
       System.out.printf("Your new balance is %.2f%n",
               atm.getBalance());
       current();
   }

   public static void checkBalanceOnCurrentAccount() {
        System.out.printf("Your current balance is %.2f%n", atm.getBalance());
        current();
   }

   private static void exit(){
        System.out.println("Thank you for using ATM");
        System.exit(0);
   }

   public static void savings() {
       System.out.println("""
                Press 1 to deposit
                Press 2 to withdraw
                Press 3 to transfer
                Press 4 to check balance
                Press 5 to go back to the main menu
                Press 6 to exit
                """);
       int pickNumber = input.nextInt();
       switch (pickNumber) {
           case 1 -> makeDepositOnSavingAccount();
           case 2 -> makeWithdrawOnSavingAccount();
           case 3 -> makeTransferOnSavingAccount();
           case 4 -> checkBalanceOnSavingAccount();
           case 5 -> displayOptions();
           case 6 -> exitApp();
       }
   }

   public static void makeDepositOnSavingAccount() {
        System.out.print("Enter deposit amount: ");
        double amount = input.nextDouble();
        atm.deposit(BigDecimal.valueOf(amount));
        System.out.println("Deposit successful");
       System.out.printf("Your new balance is %.2f%n\n",
               atm.getBalance().add(BigDecimal.valueOf(amount)));
       savings();
   }

    private static void makeWithdrawOnSavingAccount() {
        System.out.print("Enter withdrawal amount: ");
        double amount = input.nextDouble();
        atm.withdraw(BigDecimal.valueOf(amount));
        System.out.println("Withdrawal successful");
        System.out.printf("Your new balance is %.2f%n\n", atm.getBalance());
        savings();
    }

    private static void makeTransferOnSavingAccount() {
        System.out.print("Enter transfer amount: ");
        double transferMoney = input.nextDouble();
        System.out.print("Enter account number: ");
        int number = input.nextInt();
        atm.transfer(BigDecimal.valueOf(transferMoney));

        System.out.println("Transfer successful");
        System.out.printf("Your new balance is %.2f%n\n", atm.getBalance());
        savings();
    }

    private static void checkBalanceOnSavingAccount() {
        System.out.printf("Your balance is %.2f%n", atm.getBalance());
        savings();
    }
    private static void exitApp() {
        System.out.println("Thank you for using our ATM");
        System.exit(0);
    }
}
