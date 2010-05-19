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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class BenchmarkLog {

	private final BufferedWriter writer;
	private final AtomicInteger flushCount = new AtomicInteger();

	public BenchmarkLog(String logFilePath) {
		File logFile = new File(logFilePath);
		try {
			logFile.createNewFile();
			this.writer = new BufferedWriter(new FileWriter(logFile));
		} catch (IOException e) {
			throw new RuntimeException("error creating logfile", e);
		}
	}

	public void log(BenchmarkResult result) {
		try {
			writer.write(result.toString());
			if (flushCount.incrementAndGet() > 1000) {
				writer.flush();
				flushCount.set(0);
			}
		} catch (IOException e) {
			throw new RuntimeException("error writing logfile", e);
		}
	}
}
