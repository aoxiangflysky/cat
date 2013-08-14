package com.dianping.cat.statistic;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ServerStatistic {
	private Map<Long, Statistic> m_statistics = new LinkedHashMap<Long, Statistic>();

	public Statistic findOrCreate(Long time) {
		Statistic state = m_statistics.get(time);

		if (state == null) {
			state = new Statistic();
			m_statistics.put(time, state);
		}
		return state;
	}

	public void remove(long time) {
		m_statistics.remove(time);
	}

	public static class Statistic {

		private Map<String, Long> m_messageTotals = new HashMap<String, Long>();

		private long m_messageDump;

		private Map<String, Long> m_messageTotalLosses = new HashMap<String, Long>();

		private long m_messageDumpLoss;

		private Map<String, Double> m_messageSizes = new HashMap<String, Double>();

		private double m_processDelaySum;

		private int m_processDelayCount;

		private double m_avgTps;

		private double m_maxTps;

		private long m_blockTotal;

		private long m_blockLoss;

		private long m_blockTime;

		private long m_pigeonTimeError;

		private long m_networkTimeError;

		public static String TOTAL = "Total";

		public void addBlockTotal(long block) {
			m_blockTotal += block;
		}

		public void addBlockLoss(long blockLoss) {
			m_blockLoss += blockLoss;
		}

		public void addPigeonTimeError(long pigeonTimeError) {
			m_pigeonTimeError += pigeonTimeError;
		}

		public void addNetworkTimeError(long networkTimeError) {
			m_networkTimeError += networkTimeError;
		}

		public void addMessageDump(long messageDump) {
			m_messageDump += messageDump;
		}

		public void addMessageDumpLoss(long messageDumpLoss) {
			m_messageDumpLoss += messageDumpLoss;
		}

		public void addMessageSize(String domain, double messageSize) {
			Double value = m_messageSizes.get(domain);
			if (value != null) {
				m_messageSizes.put(domain, value + messageSize);
			} else {
				m_messageSizes.put(domain, messageSize);
			}
			if(!domain.equals(TOTAL)){
				addMessageSize(TOTAL,messageSize);
			}
		}

		public void addMessageTotal(String domain, long messageTotal) {
			Long value = m_messageTotals.get(domain);
			if (value != null) {
				m_messageTotals.put(domain, value + messageTotal);
			} else {
				m_messageTotals.put(domain, messageTotal);
			}
			if(!domain.equals(TOTAL)){
				addMessageTotal(TOTAL,messageTotal);
			}
		}

		public void addMessageTotalLoss(String domain, long messageTotalLoss) {
			Long value = m_messageTotalLosses.get(domain);
			if (value != null) {
				m_messageTotalLosses.put(domain, value + messageTotalLoss);
			} else {
				m_messageTotalLosses.put(domain, messageTotalLoss);
			}
			if(!domain.equals(TOTAL)){
				addMessageTotalLoss(TOTAL,messageTotalLoss);
			}
		}

		public void addBlockTime(long blockTime) {
			m_blockTime += blockTime;
		}

		public void addProcessDelay(double processDelay) {
			m_processDelaySum += processDelay;
			m_processDelayCount++;
		}

		public double getAvgProcessDelay() {
			if (m_processDelayCount > 0) {
				return m_processDelaySum / m_processDelayCount;
			}
			return 0;
		}

		public double getAvgTps() {
			return m_avgTps;
		}

		public void setAvgTps(double avgTps) {
			m_avgTps = avgTps;
		}

		public double getMaxTps() {
			return m_maxTps;
		}

		public void setMaxTps(double maxTps) {
			m_maxTps = maxTps;
		}

		public long getMessageDump() {
			return m_messageDump;
		}

		public long getMessageDumpLoss() {
			return m_messageDumpLoss;
		}

		public Map<String,Double> getMessageSizes() {
			return m_messageSizes;
		}

		public Map<String, Long> getMessageTotal() {
			return m_messageTotals;
		}

		public Map<String, Long> getMessageTotalLoss() {
			return m_messageTotalLosses;
		}

		public int getProcessDelayCount() {
			return m_processDelayCount;
		}

		public double getProcessDelaySum() {
			return m_processDelaySum;
		}

		public void setProcessDelaySum(double processDelaySum) {
			m_processDelaySum = processDelaySum;
		}

		public void setProcessDelayCount(int processDelayCount) {
			m_processDelayCount = processDelayCount;
		}

		public long getBlockTotal() {
			return m_blockTotal;
		}

		public long getBlockLoss() {
			return m_blockLoss;
		}

		public long getPigeonTimeError() {
			return m_pigeonTimeError;
		}

		public long getNetworkTimeError() {
			return m_networkTimeError;
		}

		public long getBlockTime() {
			return m_blockTime;
		}

	}

}
