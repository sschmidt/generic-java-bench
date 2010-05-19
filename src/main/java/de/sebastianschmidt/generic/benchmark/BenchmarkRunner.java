/*
   Copyright 2010 Sebastian Schmidt

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */
package de.sebastianschmidt.generic.benchmark;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.codehaus.jackson.JsonNode;

public class BenchmarkRunner implements Runnable {
	private Benchmark benchmark;
	private ConcurrentLinkedQueue<BenchmarkResult> benchmarkResults = new ConcurrentLinkedQueue<BenchmarkResult>();
	private int threads;
	private BenchmarkLog logger;

	public BenchmarkRunner(Benchmark benchmark, int threads, String logFilePath) {
		this.benchmark = benchmark;
		this.threads = threads;
		this.logger = new BenchmarkLog(logFilePath);
	}

	public void init() {
		for (int i = 0; i < threads; i++) {
			new Thread(this).start();
		}

	}

	@Override
	public void run() {
		while (true) {
			BenchmarkResult result = new BenchmarkResult();
			result.setStartTime(System.currentTimeMillis());

			try {
				JsonNode resultInfo = benchmark.run();
				result.setResult(resultInfo);
			} catch (Exception e) {
				result.setException(e.getMessage());
			}

			result.setEndTime(System.currentTimeMillis());
			logger.log(result);
		}
	}

	public ConcurrentLinkedQueue<BenchmarkResult> getBenchmarkResults() {
		return benchmarkResults;
	}
}
