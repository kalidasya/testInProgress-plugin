package org.jenkinsci.plugins.testinprogress.events.run;

import org.jenkinsci.plugins.testinprogress.messages.MessageIds;

/**
 * Notification that a test run has started.
 * 
 * @author Cedric Chabanois (cchabanois at gmail.com)
 * 
 */
public class RunStartEvent extends AbstractRunTestEvent {
	private final int testCount;

	public RunStartEvent(long timestamp, int testCount) {
		super(timestamp);
		this.testCount = testCount;
	}

	public int getTestCount() {
		return testCount;
	}

	public String getType() {
		return "TESTC";
	}

	public String toString(boolean includeTimeStamp) {
		return (includeTimeStamp ? Long.toString(getTimestamp())+" " : "")
				+ MessageIds.TEST_RUN_START + Integer.toString(testCount) + " "
				+ "v2";
	}

	@Override
	public String toString() {
		return toString(true);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + testCount;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RunStartEvent other = (RunStartEvent) obj;
		if (testCount != other.testCount)
			return false;
		return true;
	}


}
