package me.salmonmoses;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class OrderModelVerifier {
	public static enum Error {
		INVALID_NAME,
		INVALID_EMAIL,
		INVALID_PHONE,
		NOT_ACCEPTED_MAILING
	}

	private static final Pattern nameRegex = Pattern.compile("^(\\p{InCyrillic}|-)+ (\\p{InCyrillic}|-)+$");
	private static final Pattern numberRegex = Pattern.compile("^([+]38)?0[0-9]{9}$");
	private static final Pattern emailRegex = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");

	public Set<Error> verify(OrderModel model) {
		Set<Error> errors = new HashSet<>();
		if (!model.wantsMailing.getValue()) {
			errors.add(Error.NOT_ACCEPTED_MAILING);
		}
		if (!nameRegex.matcher(model.getName()).find()) {
			errors.add(Error.INVALID_NAME);
		}
		if (!numberRegex.matcher(model.getNumber()).find()) {
			errors.add(Error.INVALID_PHONE);
		}
		if (!emailRegex.matcher(model.getEmail()).find()) {
			errors.add(Error.INVALID_EMAIL);
		}
		return errors;
	}
}
