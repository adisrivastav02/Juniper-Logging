package com.juniper.logging;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@ComponentScan("com.iig.*")
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	
	@Test
	public void contextLoads() {
	}

}

