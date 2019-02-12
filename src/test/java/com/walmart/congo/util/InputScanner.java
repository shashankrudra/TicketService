package com.walmart.congo.util;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.walmart.congo.AppConstants;

/**
 * 
 * @author vn0d8d4
 *
 */
public class InputScanner {

	private static final Logger LOG = LoggerFactory.getLogger("ResponseLogger");
	private static final Scanner scanner = new Scanner(System.in);

	/**
	 * 
	 * @param argName
	 * @param defaultValue
	 * @param skipValidation
	 * @return
	 */
	public static String scanArgument(String argName, String defaultValue, boolean... skipValidation) {
		String arg = scanString(getPromptString(argName, defaultValue));
		// if arg is spaces only
		Validate.isTrue(!(StringUtils.isBlank(arg) && (arg != null && arg.length() > 0)), AppConstants.VALIDATE_EMPTY);
		if ((StringUtils.isBlank(arg) && StringUtils.isNotBlank(defaultValue))) {
			arg = defaultValue;
		}
		if (skipValidation.length > 0 && !skipValidation[0]) {
			Validate.notBlank(arg, AppConstants.VALIDATE_EMPTY);
		}
		return arg;
	}

	/**
	 * 
	 * @param argName
	 * @param defaultValue
	 * @return
	 */
	public static int scanInteger(String argName, Integer defaultValue) {
		Integer arg = defaultValue;
		arg = scanInt(argName, getPromptString(argName, defaultValue));
		if (null == arg && null != defaultValue) {
			arg = defaultValue;
		}
		Validate.notNull(arg, AppConstants.VALIDATE_EMPTY);
		return arg;
	}

	private static Integer scanInt(String argName, String ask) {
		String arg = scanString(ask);
		if (StringUtils.isBlank(arg) && arg.length() == 0)
			return null;
		Validate.matchesPattern(arg, "\\d+", AppConstants.INVALID_INT_ARG);
		return Integer.parseInt(arg);
	}

	private static String scanString(String ask) {
		LOG.info(ask);
		String choice = scanner.nextLine();
		return choice;
	}

	private static String getPromptString(String argName, Object defaultValue) {
		StringBuilder prompt = new StringBuilder("Enter ");
		prompt.append(argName);

		if (defaultValue instanceof String && StringUtils.isBlank(String.valueOf(defaultValue)))
			return prompt.append(": ").toString();

		if (defaultValue instanceof Integer && (defaultValue == null || (Integer) defaultValue < 0))
			return prompt.append(": ").toString();

		if (defaultValue != null) {
			prompt.append(" [press 'enter' to use current value '").append(defaultValue).append("']");
		}
		return prompt.append(": ").toString();
	}

}