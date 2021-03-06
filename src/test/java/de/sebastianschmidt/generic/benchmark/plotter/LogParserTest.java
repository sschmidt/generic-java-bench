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

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

public class LogParserTest {
	
	private static final String LOG_FILE_1 = "{\"a\":1274307989478,\"e\":1274307994181}{\"a\":1274307989478,\"e\":1274307994181,\"ex\":\"boese\"}";

	@Test
	public void testLogParser() {
		// XXX: todo
		InputStream is = new ByteArrayInputStream(LOG_FILE_1.getBytes());
		LogParser parser = new LogParser();
		GnuplotData data = parser.parseLog(is);
	}
}
