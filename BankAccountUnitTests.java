import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BankAccountUnitTests {

	private static BankAccount acc;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		acc = new BankAccount(100,"ellis");
	}

	@Test
	void test_get_balance() {
		assertEquals(100,acc.getBalance(),0.00001);
	}
	
	
	@Test
	void negative_deposit() {
		assertThrows(IllegalArgumentException.class, () -> {
	        acc.deposit(-20);
	    });
	}
	
	@Test
	void zero_deposit() {
		assertThrows(IllegalArgumentException.class, () -> {
	        acc.deposit(0);
	    });
	}
	
	@Test
	void negative_withdraw() {
		assertThrows(IllegalArgumentException.class, () -> {
	        acc.withdraw(-20);
	    });
	}
	
	@Test
	void zero_withdraw() {
		assertThrows(IllegalArgumentException.class, () -> {
	        acc.withdraw(0);
	    });
	}
	
	
	@Test
	void overdraw_withdraw() {
		assertThrows(InsufficientBalanceException.class, () -> {
	        acc.withdraw(120);
	    });
	}
	
	@Test
	void legal_withdraw() {
		BankAccount a = new BankAccount(100,"ellis");
		a.withdraw(20);
	   assertEquals(80,a.getBalance(),0.0001);
	}
	
	@Test
	void legal_deposit() {
		BankAccount a = new BankAccount(100,"ellis");
		a.deposit(20);
		assertEquals(120,a.getBalance(),0.0001);
	}
	
	

}
