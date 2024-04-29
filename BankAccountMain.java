import java.util.Scanner;

public class BankAccountMain
{

	public static void main(String[] args) 
	{
		BankAccount ba = new BankAccount(5000,"Ishaan");
		Scanner sc = new Scanner(System.in);
		
		boolean end = false;
		
		while(!end)
		{
			System.out.println("Would you like to withdraw (press w), deposit (press d), get balance (press g), or exit (press e)?");
			String wouldLike = sc.nextLine();
			
			switch(wouldLike)
			{
			case "w":
			
				System.out.println("How much would you like to withdraw?: ");
				double amtWithdraw = sc.nextDouble();
				sc.nextLine();
				try
				{
					
					ba.withdraw(amtWithdraw);
					System.out.println("Successfull Withdrawal");
				}
				catch(IllegalArgumentException e)
				{
					System.out.println("Amount is invalid as appropriate for the exception that was caught");
				}
				catch(InsufficientBalanceException e)
				{
					System.out.println("Balance Insufficient, cannot withdraw");
				}
			break;
			
			case "d":
			
				System.out.println("How much would you like to deposit?: ");
				double amtDeposit = sc.nextDouble();
				sc.nextLine();
				try
				{
					
					ba.deposit(amtDeposit);
					System.out.println("Amount Successfully Deposited");
				}
				catch(IllegalArgumentException e)
				{
					System.out.println("Amount was invalid as appropriate for the exception that was caught");
				}
			break;
			
			case "g":
			
				System.out.println("Your account balance is " + ba.getBalance());
				break;
			case "e":
				end = true;
				break;
			default:
				System.out.println("Invalid selection, press w for withdraw, d for deposit, e for exit, and g for get Balance. Try Again");
				break;
		}
		}
		
		

	}

}
