package Utils;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class Restutils {
	private final static String EMAIL_NAME_PATTERN = "testsudipto";
	private final static String EMAIL_DOMAIN_PATTERN = "@gmail.com";

	public static String empName() {
		String generatedstring = RandomStringUtils.randomAlphabetic(4);
		return ("S" + generatedstring);
	}

	public static String empJob() {
		String generatedstring = RandomStringUtils.randomAlphabetic(4);
		return (generatedstring);
	}

	public static String email() {
		// return generateValidEmailAddress();
		return "eve.holt@reqres.in";
	}

	public static String password() {
		// String generatedstring=RandomStringUtils.randomAlphabetic(4);
		// return(generatedstring);
		return "pistol";
	}

	private static String generateValidEmailAddress() {
		Random rnd = new Random();
		int random = rnd.nextInt(90) + 10;
		@SuppressWarnings("deprecation")
		Integer rndNum = new Integer(random);

		String valid_email_id = EMAIL_NAME_PATTERN + rndNum.toString() + EMAIL_DOMAIN_PATTERN;
		return valid_email_id;
	}
}
