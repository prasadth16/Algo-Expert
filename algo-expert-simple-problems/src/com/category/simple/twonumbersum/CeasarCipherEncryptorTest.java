package com.category.simple.twonumbersum;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CeasarCipherEncryptorTest {

	@Test
	void test() {
		assertTrue("zab".equals(CeasarCipherEncryptor.CeasarCipher("xyz", 2)));
		assertTrue("zab".equals(CeasarCipherEncryptor.CeasarCipher("xyz", 54)));
	}

}
