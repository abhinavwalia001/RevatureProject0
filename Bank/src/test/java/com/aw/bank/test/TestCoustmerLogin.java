package com.aw.bank.test;
import static org.junit.Assert.*;

import org.junit.Test;

import com.aw.bank.bean.Coustmer;
//import com.ak.bank.operation.CoustmerOperation;
public class TestCoustmerLogin {

	Coustmer co = new Coustmer();

	@Test
    public void testtransfer()
    {
		assertEquals(1,co.checkCoustmerCrediential(3008,"Sanket@123"));;
	}
}

