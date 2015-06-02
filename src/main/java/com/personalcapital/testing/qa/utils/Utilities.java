package com.personalcapital.testing.qa.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;

public class Utilities
{
	public static final String NULL = "null";
	public static final String COMMA_SEPARATOR_FORMAT = "###,###,###,###.00";
	public static String toCamelCase(String input)
	{
		if (isNullOrNull(input))
		{
			return null;
		}

		return WordUtils.capitalizeFully(input);
	}

	public static boolean isNull(String value)
	{
		if (value == null || value.length() == 0 || value.trim().length() == 0)
		{
			return true;
		}
		return false;
	}
	
	public static boolean validDouble(Double value)
	{
		if (value != null && (value.isInfinite() || value.isNaN()))
		{
			return false;
		}
		return true;
	}

	public static List<Object> getUniqueValues(Collection<?> collection)
	{
		return new ArrayList<Object>(new HashSet<Object>(collection));
	}
	
	/**
	 * This method is used to format -0.00075 to two decimal place not to return -0.00, this just
	 * retuns 0.00
	 * 
	 * @param amount
	 * @return
	 */
	public static double formatAmountDouble(double amount)
	{
		return formatAmountDouble(amount, BigDecimal.ROUND_HALF_EVEN);
	}

	public static double formatAmountDouble(double amount, int ROUNDING_MODE)
	{
		final int DECIMALS = 2;

		DecimalFormat twoDForm = new DecimalFormat("0.00");
		String format = "";

		BigDecimal amountValue = new BigDecimal(amount);
		amountValue = amountValue.setScale(DECIMALS, ROUNDING_MODE);

		format = twoDForm.format(amountValue.doubleValue());

		if (format == null)
		{
			format = "";
		}

		if (format.equals("-0.0") || format.equals("-0.00"))
		{
			format = "0.00";
		}

		double formattedDouble = Double.valueOf(format);

		return formattedDouble;
	}

	/**
	 * function to format percentage
	 * 
	 * @param amount
	 * @return
	 */
	public static double formatPercentage(double amount)
	{
		return formatPercentage(amount, RoundingMode.HALF_UP);

	}

	/**
	 * function to format percentage
	 * 
	 * @param amount
	 * @return
	 */
	public static double formatPercentage(double amount, RoundingMode roundingMode)
	{
		return formatAmountDouble(amount, roundingMode);
	}

	/**
	 * function to format amount
	 * 
	 * @param amount
	 * @return
	 */
	public static double formatAmountDouble(double amount, RoundingMode roundingMode)
	{
		String format = formatNumberToTwoDecimals(amount, roundingMode);
		double formattedDouble = Double.valueOf(format);

		return formattedDouble;

	}

	/**
	 * function to convert to percentage
	 * 
	 * @param amount
	 * @return
	 */
	public static double convertToPercentage(double amount)
	{

		return amount * 100.0;

	}

	/**
	 * function to percentage to rate
	 * 
	 * @param value
	 * @return
	 */
	public static double convertPercentageToRate(double value)
	{

		return value / 100.0;

	}

	public static final String FOUR_DECIMALS_FORMAT = "#0.0000";
	public static final String TWO_DECIMALS_FORMAT = "#0.00";

	public static String formatNumberToFourDecimals(double number)
	{
		String format = new DecimalFormat(FOUR_DECIMALS_FORMAT).format(number);
		if (format.equals("-0.0000"))
		{
			format = "0.0000";
		}

		return format;
	}
	/**
	 * @param balance
	 * @param type
	 *            for financial accounts, type is currency, for non-financial can be anything, like
	 *            miles.
	 * @return
	 */
	public static String formatAmount(Double balance, String type)
	{
		if (balance == null || isNull(type))
		{
			return null;
		}

		DecimalFormatSymbols formatSymbol = new DecimalFormatSymbols(Locale.US);
		formatSymbol.setGroupingSeparator(',');
		if (type.equals("USD"))
		{
			if (balance == 0)
			{
				return "$0";
			}

			boolean isNegative = balance.doubleValue() < 0;
			if (isNegative)
			{
				balance = Double.valueOf(balance.doubleValue() * -1);
			}

			DecimalFormat formatter = new DecimalFormat("###,###,###,###.00", formatSymbol);
			if (isNegative)
			{
				return "-$" + formatter.format(balance);
			}
			else
			{
				return "$" + formatter.format(balance);
			}
		}
		else
		{
			DecimalFormat formatter = new DecimalFormat("###,###,###,###", formatSymbol);
			return formatter.format(balance) + " " + type;
		}
	}
	/**
	 * This is to format the display of the percentage whether it is positive or negative and append
	 * with % for example: 0.02 will be +0.02% etc
	 * 
	 * @param percentageChange
	 */
	public static String formatDisplayFormatForPercentageChange(Double percentageChange)
	{
		Double localPercentageChange = percentageChange;
		if (localPercentageChange == null || validDouble(localPercentageChange) == false)
		{
			return null;
		}
		String percentInvestmentChangeString = formatNumberToTwoDecimals(localPercentageChange);
		if (localPercentageChange > 0)
		{
			if (localPercentageChange < 0.01)
			{
				percentInvestmentChangeString = "< + 0.01%";
			}
			else
			{
				percentInvestmentChangeString = "+" + percentInvestmentChangeString + "%";
			}
		}
		else if (localPercentageChange < 0)
		{

			if (localPercentageChange > -0.01)
			{
				percentInvestmentChangeString = "> - 0.01%";
			}
			else
			{
				percentInvestmentChangeString = percentInvestmentChangeString + "%";
			}
		}
		return percentInvestmentChangeString;
	}

	/**
	 * Converting double to two digit strings.
	 * 
	 * @param inDouble
	 * @return
	 */
	public static BigDecimal formatToTwoDecimalNumbers(Double inDouble)
	{
		if (inDouble == null || Double.isNaN(inDouble))
		{
			return null;
		}
		try
		{
			String formattedNumber = formatNumberToTwoDecimals(inDouble);
			BigDecimal returnFormattedNumber = BigDecimal.valueOf(Double.valueOf(formattedNumber))
					.setScale(2);

			return returnFormattedNumber;
		}
		catch (RuntimeException ex)
		{
			// logger.error("Error", ex);
		}

		return null;
	}
	public static String formatNumberToTwoDecimals(double number)
	{
		String format = new DecimalFormat(TWO_DECIMALS_FORMAT).format(number);
		if (format.equals("-0.00"))
		{
			format = "0.00";
		}
		return format;
	}
	

	/**
	 * Strips the input string of leading and trailing white space. Strips the input string of
	 * leading and trailing control characters.
	 */
	public static String stripAndTrim(String input)
	{
		if (input == null)
		{
			return null;
		}

		input = StringUtils.strip(input);
		input = StringUtils.trim(input);
		return input;
	}
	/**
	 * This method is used to format Phone Number with Area Code passed and length of the phone
	 * number is 10 otherwise it returns the passed in phone number itself
	 */
	public static String formatPhoneNumberWithAreaCode(String phoneNumber)
	{
		phoneNumber = stripAndTrim(phoneNumber);
		if (isNullOrNull(phoneNumber))
		{
			return "";
		}
		if (phoneNumber.length() == 10)
		{
			String formattedPhoneNumber = "(" + phoneNumber.substring(0, 3) + ") "
					+ phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6, 10);
			return formattedPhoneNumber;
		}
		else
		{
			return phoneNumber;
		}
	}

	public static boolean isNullOrNull(String value)
	{
		if (isNull(value) || NULL.equalsIgnoreCase(value))
		{
			return true;
		}
		return false;
	}
	/**
	 * This method is used to format Phone Number with Area Code passed and length of the phone
	 * number is 10 otherwise it returns the passed in phone number itself
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public static String formatPhoneNumberWithAreaCodeEncoded(String phoneNumber)
	{
		phoneNumber = stripAndTrim(phoneNumber);
		if (isNullOrNull(phoneNumber))
		{
			return "";
		}
		if (phoneNumber.length() == 10)
		{
			String formattedPhoneNumber = "(" + phoneNumber.substring(0, 3) + ")+"
					+ phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6, 10);
			return formattedPhoneNumber;
		}
		else
		{
			return phoneNumber;
		}
	}


	/**
	 * Note: DecimalFormat is not thread safe. Formats given input as per decimal formatter
	 * experession.
	 */
	public static String formatNumberToTwoDecimals(double number, RoundingMode roundingMode)
	{
		DecimalFormat df = new DecimalFormat(TWO_DECIMALS_FORMAT);
		df.setRoundingMode(roundingMode);
		String format = df.format(number);

		if (format.equals("-0.00"))
		{
			format = "0.00";
		}

		return format;
	}

	/**
	 * PFA-4567- fulfillment. Note: DecimalFormat is not thread safe. Formats given input as per
	 * decimal formatter experession.
	 */
	public static String formatNumberToFourDecimals(double number, RoundingMode roundingMode)
	{
		DecimalFormat df = new DecimalFormat(FOUR_DECIMALS_FORMAT);
		df.setRoundingMode(roundingMode);
		String format = df.format(number);

		if (format.equals("-0.0000"))
		{
			format = "0.0000";
		}

		return format;
	}

	/**
	 * This method is to format a given amount to 1,000 and there on
	 * 
	 * @param amount
	 * @return
	 */
	public static String formatAmountToDecimalsWithSeparator(double amount)
	{
		if (Double.isNaN(amount))
		{
			amount = 0.00;
		}
		DecimalFormatSymbols formatSymbol = new DecimalFormatSymbols(Locale.US);
		formatSymbol.setGroupingSeparator(',');
		DecimalFormat commaFormatter = new DecimalFormat(COMMA_SEPARATOR_FORMAT, formatSymbol);
		return commaFormatter.format(amount);
	}
}
