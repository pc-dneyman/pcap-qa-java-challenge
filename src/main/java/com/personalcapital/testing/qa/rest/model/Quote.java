package com.personalcapital.testing.qa.rest.model;

public interface Quote {

	public abstract double getLast();

	public abstract void setLast(double last);

	public abstract double getOpen();

	public abstract void setOpen(double open);

	public abstract double getHigh();

	public abstract void setHigh(double high);

	public abstract double getLow();

	public abstract void setLow(double low);

	public abstract long getVolume();

	public abstract void setVolume(long volume);

	public abstract String getCurrency();

	public abstract void setCurrency(String currency);

	public abstract String getOutcome();

	public abstract void setOutcome(String outcome);

	public abstract String getMessage();

	public abstract void setMessage(String message);

	public abstract String getIdentity();

	public abstract void setIdentity(String identity);

	public abstract double getDelay();

	public abstract void setDelay(double delay);

	public abstract String getSourceAPI();

	public abstract void setSourceAPI(String sourceAPI);

	public abstract String getInstrumentType();

	public abstract void setInstrumentType(String instrumentType);

	public abstract String getName();

	public abstract void setName(String name);

	public abstract String getIdentifier();

	public abstract void setIdentifier(String identifier);

	public abstract String getDateTime();

	public abstract void setDateTime(String dateTime);

	public abstract int getUtcOffset();

	public abstract void setUtcOffset(int utcOffset);

	public abstract int getLastSize();

	public abstract void setLastSize(int lastSize);

	public abstract String getVolumeDate();

	public abstract void setVolumeDate(String volumeDate);

	public abstract double getPreviousClose();

	public abstract void setPreviousClose(double previousClose);

	public abstract String getPreviousCloseDate();

	public abstract void setPreviousCloseDate(String previousCloseDate);

	public abstract double getChange();

	public abstract void setChange(double change);

	public abstract double getPercentChange();

	public abstract void setPercentChange(double percentChange);

	public abstract String getExtendedHoursType();

	public abstract void setExtendedHoursType(String extendedHoursType);

	public abstract String getExtendedHoursDateTime();

	public abstract void setExtendedHoursDateTime(String extendedHoursDateTime);

	public abstract String getExtendedHoursPrice();

	public abstract void setExtendedHoursPrice(String extendedHoursPrice);

	public abstract double getExtendedHoursChange();

	public abstract void setExtendedHoursChange(double extendedHoursChange);

	public abstract double getExtendedHoursPercentChange();

	public abstract void setExtendedHoursPercentChange(
			double extendedHoursPercentChange);

	public abstract double getBid();

	public abstract void setBid(double bid);

	public abstract int getBidSize();

	public abstract void setBidSize(int bidSize);

	public abstract String getBidDateTime();

	public abstract void setBidDateTime(String bidDateTime);

	public abstract double getAsk();

	public abstract void setAsk(double ask);

	public abstract int getAskSize();

	public abstract void setAskSize(int askSize);

	public abstract String getAskDateTime();

	public abstract void setAskDateTime(String askDateTime);

	public abstract boolean isTradingHalted();

	public abstract void setTradingHalted(boolean tradingHalted);

	public abstract String getIdentifierType();

	public abstract void setIdentifierType(String identifierType);
}