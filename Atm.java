import java.math.BigDecimal;

public class Atm {
    private BigDecimal balance;
    private int pinNumber;
    private String name;

    public Atm(){
        this.balance = new BigDecimal("0.0");
    }

    public Atm(BigDecimal balance, int pinNumber, String name) {
        this.balance = balance;
        this.pinNumber = pinNumber;
        this.name = name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setPin(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public int getPin() {
        return pinNumber;
    }



    public void autoMatedTellerMachine() {
        getPin();
    }
    public void savings() {}
    public void deposit(BigDecimal depositAmount) {
        if (depositAmount.compareTo(balance) > 0 && depositAmount.compareTo(BigDecimal.ZERO) > 0) {
           balance = balance.add(depositAmount);
        }
    }

    public void withdraw(BigDecimal withdrawAmount) {
        if (withdrawAmount.compareTo(balance) < 0 && withdrawAmount.compareTo(BigDecimal.ZERO) > 0) {
            balance = balance.subtract(withdrawAmount);
        }
    }

    public void transfer(BigDecimal transferAmount) {
        if (transferAmount.compareTo(balance) < 0 && transferAmount.compareTo(BigDecimal.ZERO) > 0) {
            balance = balance.subtract(transferAmount);
        }
    }

}
