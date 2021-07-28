package com.aw.bank.test;
import static org.junit.Assert.*;

import org.junit.Test;

import com.aw.bank.operation.CoustmerOperation;
public class TestDeposite {

	CoustmerOperation co = new CoustmerOperation();

	@Test
    public void testdeposite()
    {
		assertEquals(1,co.deposit(3008,500));
	}
}

