package de.sebastianschmidt.generic.benchmark;

import org.codehaus.jackson.JsonNode;
import org.junit.Test;

public class BenchmarkTest {

	@Test
	public void benchmarkRunTest() {
		Benchmark benchmark = new Benchmark() {

			@Override
			public JsonNode run() {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return null;
			}
		};
		
		BenchmarkRunner runner = new BenchmarkRunner(benchmark, 100, "/tmp/test.txt");
		runner.init();
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
