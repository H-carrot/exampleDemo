package com.hcarrot.example.common;

import com.hcarrot.example.common.util.StringUtils;
import org.testng.annotations.Test;

public class StringUtilsTest {

	@Test
	public void getString() {
		System.out.println(StringUtils.getString("hello,", "world!"));
	}
}
