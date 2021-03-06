package com.personalcapital.testing.qa.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.personalcapital.qa.challenge.rest.QuoteRestService;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteXml implements Quote {

	private static Logger logger = LoggerFactory
			.getLogger(QuoteRestService.class);

	private String outcome; // Success;
	private String message; // null;
	private String identity; // Request;
	private double delay; // 0.103006
	private String sourceAPI; // XigniteGlobalQuotes_V3
	private String instrumentType; // Stock
	private String name; // Apple Inc
	private String identifier; // AAPL
	private String identifierType; // Symbol
	private String dateTime; // yyyy-MM-dd HH:mm:ss
	private int utcOffset; // -4 for EDT, -5 for EST
	private String currency; // USD;
	private double open; // 10.98;
	private double high; // 10.98;
	private double low; // 10.98;
	private double last; // 10.98;
	private int lastSize; // 100
	private long volume; // 0;
	private String volumeDate; // yyyy-MM-dd
	private double previousClose; // 10.98
	private String previousCloseDate; // yyyy-MM-dd
	private double change; // 0.64
	private double percentChange; // 6.30
	private String extendedHoursType; // PostMarket
	private String extendedHoursDateTime; // yyyy-MM-dd HH:mm:ss
	private String extendedHoursPrice; // 10.90
	private double extendedHoursChange; // 0.56
	private double extendedHoursPercentChange; // 5.5
	private double bid; // 10.97
	private int bidSize; // 100
	private String bidDateTime; // yyyy-MM-dd HH:mm:ss
	private double ask; // 10.99
	private int askSize; // 200
	private String askDateTime; // yyyy-MM-dd HH:mm:ss
	private boolean tradingHalted; // TRUE or FALSE

	public QuoteXml() {
	}

	@Override
	public double getLast() {
		return last;
	}

	@Override
	// @XmlElement(name="Last")
	public void setLast(double last) {
		this.last = last;
	}

	@Override
	public double getOpen() {
		return open;
	}

	@Override
	// @XmlElement(name="Open")
	public void setOpen(double open) {
		this.open = open;
	}

	@Override
	public double getHigh() {
		return high;
	}

	@Override
	// @XmlElement(name="High")
	public void setHigh(double high) {
		this.high = high;
	}

	@Override
	public double getLow() {
		return low;
	}

	@Override
	// @XmlElement(name="Low")
	public void setLow(double low) {
		this.low = low;
	}

	@Override
	public long getVolume() {
		return volume;
	}

	@Override
	// @XmlElement(name="Volume")
	public void setVolume(long volume) {
		this.volume = volume;
	}

	@Override
	public String getCurrency() {
		return currency;
	}

	@Override
	// @XmlElement(name="Currency")
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String getOutcome() {
		return outcome;
	}

	@Override
	// @XmlElement(name="Outcome")
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	// @XmlElement(name="Message")
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String getIdentity() {
		return identity;
	}

	@Override
	// @XmlElement(name="Identity")
	public void setIdentity(String identity) {
		this.identity = identity;
	}

	@Override
	public double getDelay() {
		return delay;
	}

	@Override
	// @XmlElement(name="Delay")
	public void setDelay(double delay) {
		this.delay = delay;
	}

	@Override
	public String getSourceAPI() {
		return sourceAPI;
	}

	@Override
	// @XmlElement(name="SourceAPI")
	public void setSourceAPI(String sourceAPI) {
		this.sourceAPI = sourceAPI;
	}

	@Override
	public String getInstrumentType() {
		return instrumentType;
	}

	@Override
	// @XmlElement(name="InstrumentType")
	public void setInstrumentType(String instrumentType) {
		this.instrumentType = instrumentType;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	// @XmlElement(name="Name")
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getIdentifier() {
		return identifier;
	}

	@Override
	// @XmlElement(name="Identifier")
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	@Override
	public String getDateTime() {
		return dateTime;
	}

	@Override
	// @XmlElement(name="DateTime")
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public int getUtcOffset() {
		return utcOffset;
	}

	@Override
	// @XmlElement(name="UTCOffset")
	public void setUtcOffset(int utcOffset) {
		this.utcOffset = utcOffset;
	}

	@Override
	public int getLastSize() {
		return lastSize;
	}

	@Override
	// @XmlElement(name="LastSize")
	public void setLastSize(int lastSize) {
		this.lastSize = lastSize;
	}

	@Override
	public String getVolumeDate() {
		return volumeDate;
	}

	@Override
	// @XmlElement(name="VolumeDate")
	public void setVolumeDate(String volumeDate) {
		this.volumeDate = volumeDate;
	}

	@Override
	public double getPreviousClose() {
		return previousClose;
	}

	@Override
	// @XmlElement(name="PreviousClose")
	public void setPreviousClose(double previousClose) {
		this.previousClose = previousClose;
	}

	@Override
	public String getPreviousCloseDate() {
		return previousCloseDate;
	}

	@Override
	// @XmlElement(name="PreviousCloseDate")
	public void setPreviousCloseDate(String previousCloseDate) {
		this.previousCloseDate = previousCloseDate;
	}

	@Override
	public double getChange() {
		return change;
	}

	@Override
	// @XmlElement(name="Change")
	public void setChange(double change) {
		this.change = change;
	}

	@Override
	public double getPercentChange() {
		return percentChange;
	}

	@Override
	// @XmlElement(name="PercentChange")
	public void setPercentChange(double percentChange) {
		this.percentChange = percentChange;
	}

	@Override
	public String getExtendedHoursType() {
		return extendedHoursType;
	}

	@Override
	// @XmlElement(name="ExtendedHoursType")
	public void setExtendedHoursType(String extendedHoursType) {
		this.extendedHoursType = extendedHoursType;
	}

	@Override
	public String getExtendedHoursDateTime() {
		return extendedHoursDateTime;
	}

	@Override
	// @XmlElement(name="ExtendedHoursDateTime")
	public void setExtendedHoursDateTime(String extendedHoursDateTime) {
		this.extendedHoursDateTime = extendedHoursDateTime;
	}

	@Override
	public String getExtendedHoursPrice() {
		return extendedHoursPrice;
	}

	@Override
	// @XmlElement(name="ExtendedHoursPrice")
	public void setExtendedHoursPrice(String extendedHoursPrice) {
		this.extendedHoursPrice = extendedHoursPrice;
	}

	@Override
	public double getExtendedHoursChange() {
		return extendedHoursChange;
	}

	@Override
	// @XmlElement(name="ExtendedHoursChange")
	public void setExtendedHoursChange(double extendedHoursChange) {
		this.extendedHoursChange = extendedHoursChange;
	}

	@Override
	public double getExtendedHoursPercentChange() {
		return extendedHoursPercentChange;
	}

	@Override
	// @XmlElement(name="ExtendedHoursPercentChange")
	public void setExtendedHoursPercentChange(double extendedHoursPercentChange) {
		this.extendedHoursPercentChange = extendedHoursPercentChange;
	}

	@Override
	public double getBid() {
		return bid;
	}

	@Override
	// @XmlElement(name="Bid")
	public void setBid(double bid) {
		this.bid = bid;
	}

	@Override
	public int getBidSize() {
		return bidSize;
	}

	@Override
	// @XmlElement(name="BidSize")
	public void setBidSize(int bidSize) {
		this.bidSize = bidSize;
	}

	@Override
	public String getBidDateTime() {
		return bidDateTime;
	}

	@Override
	// @XmlElement(name="BidDateTime")
	public void setBidDateTime(String bidDateTime) {
		this.bidDateTime = bidDateTime;
	}

	@Override
	public double getAsk() {
		return ask;
	}

	@Override
	// @XmlElement(name="Ask")
	public void setAsk(double ask) {
		this.ask = ask;
	}

	@Override
	public int getAskSize() {
		return askSize;
	}

	@Override
	// @XmlElement(name="AskSize")
	public void setAskSize(int askSize) {
		this.askSize = askSize;
	}

	@Override
	public String getAskDateTime() {
		return askDateTime;
	}

	@Override
	// @XmlElement(name="AskDateTime")
	public void setAskDateTime(String askDateTime) {
		this.askDateTime = askDateTime;
	}

	@Override
	public boolean isTradingHalted() {
		return tradingHalted;
	}

	@Override
	// @XmlElement(name="TradingHalted")
	public void setTradingHalted(boolean tradingHalted) {
		this.tradingHalted = tradingHalted;
	}

	@Override
	public String getIdentifierType() {
		return identifierType;
	}

	@Override
	// @XmlElement(name="IdentifierType")
	public void setIdentifierType(String identifierType) {
		this.identifierType = identifierType;
	}

	@Override
	public String toString() {
		XmlMapper mapper = new XmlMapper();
		try {
			String xml = mapper.writeValueAsString(this);
			return xml;
		} catch (JsonProcessingException e) {
			logger.error("Cant convert to xml", e);
		}
		return null;
	}

}
