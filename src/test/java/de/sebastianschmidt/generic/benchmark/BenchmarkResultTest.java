package de.sebastianschmidt.generic.benchmark;

import org.junit.Test;

public class BenchmarkResultTest {

	@Test
	public void toStringTest() {
		BenchmarkResult result = new BenchmarkResult();
		System.out.println(result.toString());
	}
}
