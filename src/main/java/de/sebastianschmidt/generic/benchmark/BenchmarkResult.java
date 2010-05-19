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

import java.io.IOException;
import java.io.StringWriter;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;

public class BenchmarkResult {
	private long endTime;
	private long startTime;
	private Exception exception = null;
	private JsonNode result = null;

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public void setException(Exception exception) {
		this.exception = exception;

	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public void setResult(JsonNode result) {
		this.result = result;
	}

	@Override
	public String toString() {
		JsonFactory jsonFactory = new JsonFactory();
		StringWriter resultWriter = new StringWriter();
		try {
			JsonGenerator g = jsonFactory.createJsonGenerator(resultWriter);
			g.writeStartObject();
			g.writeNumberField("s", startTime);
			g.writeNumberField("e", endTime);

			if (exception != null) {
				g.writeStringField("ex", exception.getMessage());
			}

			if (result != null) {
				g.writeStringField("i", result.toString());
			}

			g.writeEndObject();
			g.close();
			resultWriter.close();
		} catch (IOException e) {
			throw new RuntimeException("error writing to a string?");
		}

		
		return resultWriter.toString();
	}
}