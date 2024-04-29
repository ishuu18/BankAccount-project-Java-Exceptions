
public class BankAccount 
{
	
	private double balance;
	private String name;
	public BankAccount(double balance, String name)
	{
		this.balance = balance;
		this.name = name;
	}
	
	public void deposit(double amount)
	{
		if (amount <= 0)
		{
			throw new IllegalArgumentException("Amount has to be greater than 0");
		}
		balance += amount;
	}
	
	public void withdraw(double amount)
	{
		if (amount <= 0)
		{
			throw new IllegalArgumentException("Amount has to be greater than 0");
		}
		if (amount > balance)
		{
			throw new InsufficientBalanceException(amount + " is more than the balance, "+ balance);
		}
		balance -= amount;
	}
	
	public double getBalance()
	{
		return balance;
	}
}
