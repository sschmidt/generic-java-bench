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

import java.io.IOException;
import java.io.InputStream;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

import de.sebastianschmidt.generic.benchmark.BenchmarkResult;

public class LogParser {

	public GnuplotData parseLog(InputStream logInputStream) {
		JsonFactory f = new JsonFactory();
		GnuplotData data = new GnuplotData();

		try {
			JsonParser jp = f.createJsonParser(logInputStream);
			jp.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);

			BenchmarkResult result;
			while ((result = readEntry(jp)) != null) {
				// XXX: todo
			}
		} catch (JsonParseException e) {
			throw new RuntimeException("illegal log format", e);
		} catch (IOException e) {
			throw new RuntimeException("error reading log file", e);
		}

		return data;
	}

	private BenchmarkResult readEntry(JsonParser jp) throws IOException,
			JsonParseException {
		BenchmarkResult entry = new BenchmarkResult();

		if (jp.nextToken() == null) {
			return null;
		}

		while (jp.nextToken() != JsonToken.END_OBJECT) {
			String fieldname = jp.getCurrentName();
			jp.nextToken();

			if ("a".equals(fieldname)) {
				entry.setStartTime(jp.getLongValue());
			} else if ("e".equals(fieldname)) {
				entry.setEndTime(jp.getLongValue());
			} else if ("ex".equals(fieldname)) {
				entry.setException(jp.getText());
			}
		}

		return entry;
	}
}
