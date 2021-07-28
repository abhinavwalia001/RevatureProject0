package com.aw.bank.test;
import static org.junit.Assert.*;

import org.junit.Test;

import com.aw.bank.operation.CoustmerOperation;
public class NegativeTestForWithdrawal {

	CoustmerOperation co = new CoustmerOperation();

	@Test
    public void testdeposite()
    {
		assertNotEquals(1,co.withdrawal(3050,5000));
	}
}

