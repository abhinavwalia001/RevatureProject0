package com.aw.bank.test;
import static org.junit.Assert.*;

import org.junit.Test;

import com.aw.bank.bean.Coustmer;
//import com.ak.bank.operation.CoustmerOperation;
public class NegativeTestCaseForCoustmerLogin{

	Coustmer co = new Coustmer();

	@Test
    public void testtransfer()
    {
		assertNotEquals(1,co.checkCoustmerCrediential(3040,"Sanket@123"));;
	}
}


