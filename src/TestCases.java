import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.*;
class TestCases {

	@Test
	void test() {
		Signup si = new Signup(0);
		String p1;
		Scanner s = new Scanner(System.in);
		System.out.println("\n Enter password =");
		p1=s.nextLine();
		
		boolean x = si.passValidation(p1);
		assertEquals(true, x);
	}
	
	@Test
	void emailTest()
	{
		Signup s1 = new Signup(0);
		Scanner s = new Scanner(System.in);
		System.out.println("\n Enter email =");
		String p1=s.nextLine();
		boolean x =s1.emailValidation(p1);
		assertEquals(true, x);
		
		
	}
	
	@Test
	void Accnt_exists()
	{
		Login l = new Login(1);
		Scanner s = new Scanner(System.in);
		System.out.println("\n Enter username =");
		String p1=s.nextLine();
		boolean x =l.does_exist(p1);
		assertEquals(true, x);
		
		
	}

}
