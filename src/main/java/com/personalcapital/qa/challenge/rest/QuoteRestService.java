package com.personalcapital.qa.challenge.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.personalcapital.testing.qa.rest.model.Quote;
import com.personalcapital.testing.qa.rest.model.QuoteJson;
import com.personalcapital.testing.qa.rest.model.QuoteXml;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class QuoteRestService {

	private static Logger logger = LoggerFactory
			.getLogger(QuoteRestService.class);

	protected String SERVICE_JSON_URL = "http://superquotes.xignite.com/xSuperQuotes.json";
	protected String SERVICE_XML_URL = "http://superquotes.xignite.com/xSuperQuotes.xml";

	protected String GET_RESOURCE = "GetQuotes";
	protected String TICKER_TYPE = "Symbol";
	protected String token = "xignite@personalcapital.com";
	protected Integer timeout = 5000;

	protected Client jerseyClient;
	protected MediaType mediaType = MediaType.APPLICATION_JSON_TYPE;

	public void init(MediaType mediaType) {
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getClasses().add(JacksonJsonProvider.class);
		this.jerseyClient = Client.create(clientConfig);
		this.jerseyClient.setReadTimeout(timeout);
		this.jerseyClient.setConnectTimeout(timeout);
		this.mediaType = mediaType;
	}

	public List<Quote> getQuotes(List<String> tickers) {
		if (tickers == null || tickers.isEmpty()) {
			return null;
		}

		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("_token", this.token);
		params.putSingle("IdentifierType", TICKER_TYPE);
		params.putSingle("Identifiers", StringUtils.join(tickers, ','));
		try {
			List<Quote> results = this.mediaType
					.equals(MediaType.APPLICATION_JSON_TYPE) ? getAsJson(
					tickers, params) : getAsXml(tickers, params);
			return results;
		} catch (Exception e) {
			logger.error("Failed in getQuotes");
			logger.error(e.getMessage());
		}
		return null;
	}

	private List<Quote> getAsJson(List<String> tickers,
			MultivaluedMap<String, String> params) throws IOException,
			JsonParseException, JsonMappingException {

		WebResource webResource = jerseyClient.resource(SERVICE_JSON_URL + "/"
				+ GET_RESOURCE);
		ClientResponse response = webResource.queryParams(params)
				.type(MediaType.APPLICATION_JSON_TYPE)
				.get(ClientResponse.class);
		if (!verifyResponse(response)) {
			return null;
		}

		String responseBody = response.getEntity(String.class);
		ObjectMapper mapper = new ObjectMapper();
		QuoteJson quotes[] = mapper.readValue(responseBody,
				QuoteJson[].class);

		if (quotes == null) {
			logger.warn("Quote service : cant convert to json");
			return null;
		} else if (quotes.length != tickers.size()) {
			logger.warn("Quote service : didn't return expected # of quotes");
			return null;
		}

		List<Quote> results = new ArrayList<>();
		for (QuoteJson quote : quotes) {
			if (quote == null) {
				continue;
			}
			results.add(quote);
			//
		}
		return results;
	}

	private List<Quote> getAsXml(List<String> tickers,
			MultivaluedMap<String, String> params) throws IOException,
			JsonParseException, JsonMappingException {

		WebResource webResource = jerseyClient.resource(SERVICE_XML_URL + "/"
				+ GET_RESOURCE);
		ClientResponse response = webResource.queryParams(params)
				.type(MediaType.APPLICATION_XML_TYPE).get(ClientResponse.class);
		if (!verifyResponse(response)) {
			return null;
		}

		String responseBody = response.getEntity(String.class);
		ObjectMapper mapper = new XmlMapper();
		QuoteXml quotes[] = mapper.readValue(responseBody,
				QuoteXml[].class);

		if (quotes == null) {
			logger.warn("Quote service : cant convert to json");
			return null;
		} else if (quotes.length != tickers.size()) {
			logger.warn("Quote service : didn't return expected # of quotes");
			return null;
		}

		List<Quote> results = new ArrayList<>();
		for (QuoteXml quote : quotes) {
			if (quote == null) {
				continue;
			}
			results.add(quote);
			//
		}
		return results;
	}

	private boolean verifyResponse(ClientResponse response) {
		if (response == null) {
			logger.warn("Quote service : not good - response is null");
			return false;
		} else if (response.getStatus() != 200) {
			logger.warn("Quote service : not good - http code {}, "
					+ "response {}", response.getStatus(), response.toString());
			return false;
		}
		logger.warn("Quote service : response {}", response.toString());
		return true;
	}
}
