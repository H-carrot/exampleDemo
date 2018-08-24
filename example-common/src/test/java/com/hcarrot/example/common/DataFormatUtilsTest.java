package com.hcarrot.example.common;

import com.hcarrot.example.common.util.DateFormatUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataFormatUtilsTest {
	@Test
	public void getDateLong() {
		long time = DateFormatUtils.getDateLong("2014-10-12 01:10:00", "yyyy-MM-dd HH:mm:ss");
		System.out.println("Test  123");
		Assert.assertEquals(time, 1413047400000L);
	}
}
