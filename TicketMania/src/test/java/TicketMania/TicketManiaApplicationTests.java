package TicketMania;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class TicketManiaApplicationTests {

	@Test
	void quickMaths() {
		assertEquals(1, 1);
	}

	@Test
	void quickMaths2() {
		assertEquals(2, 1 + 1);
	}

}
