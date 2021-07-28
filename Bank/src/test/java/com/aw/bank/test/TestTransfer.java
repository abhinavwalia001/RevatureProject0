package com.aw.bank.test;
import static org.junit.Assert.*;

import org.junit.Test;

import com.aw.bank.operation.CoustmerOperation;
public class TestTransfer {

	CoustmerOperation co = new CoustmerOperation();

	@Test
    public void testtransfer()
    {
		assertEquals(1,co.transfer(3008, 3009, 500));
	}
}
