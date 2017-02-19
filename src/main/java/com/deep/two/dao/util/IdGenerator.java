package com.deep.two.dao.util;

import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.UUIDHexGenerator;

public final class IdGenerator {
	private static IdentifierGenerator gen = new UUIDHexGenerator();
	
	public static synchronized String getUuid() {
		return (String)gen.generate(null, null);
	}
	
	public static synchronized String getSequenceNum(String s) {
	    return s+System.currentTimeMillis();
    }
}
