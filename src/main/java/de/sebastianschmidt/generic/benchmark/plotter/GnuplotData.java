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

import java.util.HashMap;
import java.util.Map;

public class GnuplotData {
	private Map<String, Integer> successfulBenchmarks = new HashMap<String, Integer>();
	private Map<String, Integer> failedBenchmarks = new HashMap<String, Integer>();
	private Map<String, Integer> averageDuration = new HashMap<String, Integer>();
	private Map<String, Integer> minDuration = new HashMap<String, Integer>();
	private Map<String, Integer> maxDuration = new HashMap<String, Integer>();

	public Map<String, Integer> getSuccessfulBenchmarks() {
		return successfulBenchmarks;
	}

	public Map<String, Integer> getFailedBenchmarks() {
		return failedBenchmarks;
	}

	public Map<String, Integer> getAverageDuration() {
		return averageDuration;
	}

	public Map<String, Integer> getMinDuration() {
		return minDuration;
	}

	public Map<String, Integer> getMaxDuration() {
		return maxDuration;
	}
}
