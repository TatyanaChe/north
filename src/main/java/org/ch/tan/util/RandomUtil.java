package org.ch.tan.util;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtil {

	private RandomUtil() {
	}

	public static String generate(String prefix) {
		return prefix + RandomStringUtils.randomNumeric(12);
	}

}
