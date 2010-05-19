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
package de.sebastianschmidt.generic.benchmark.plotter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Application {
	public static void main(String[] args) throws FileNotFoundException {
		if (args.length != 2) {
			System.out.println("please provide: [output dir] [log file]");
			System.exit(0);
		}

		String outputDir = args[0];
		String logFile = args[1];

		InputStream logInputStream = new FileInputStream(logFile);

		LogParser parser = new LogParser();
		GnuplotData data = parser.parseLog(logInputStream);

		GnuplotDataWriter writer = new GnuplotDataWriter(outputDir);
		writer.writeGnuplotFiles(data);
	}
}
