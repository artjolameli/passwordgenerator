import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Simple Password generator
 * set length = 4 in his code and run it  
 * several times.
 *
 */
public class PasswordGenerator {

	private static final String CHARS = "abcdefghijklmnopqrstuvwxyz";
	private static final String CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String NUMBERS = "0123456789";
	private static final String SYMBOLS = "!@#$%^&*_=+-/";

	private int charsCount;
	private int capsCount;
	private int numbersCount;
	private int symbolsCount;

	private Random random;

	// Default constructor
	public PasswordGenerator() {
		this(4, 1, 1, 1);
	}

	// Constructor with params
	public PasswordGenerator(int charsCount,
							 int capsCount,
							 int numbersCount,
							 int symbolsCount) {
		this.charsCount = charsCount;
		this.capsCount = capsCount;
		this.numbersCount = numbersCount;
		this.symbolsCount = symbolsCount;
		random = new Random();
	}

	// Demonstration
	public static void main(String[] args) {
		PasswordGenerator pwdGenerator = new PasswordGenerator(4, 2, 2, 1);
		System.out.println("Password with 4 chars, 2 caps, 2 numbers, 1 symbol:");
		System.out.println(pwdGenerator.generatePassword());
		System.out.println("Another password with the same set:");
		System.out.println(pwdGenerator.generatePassword());
		System.out.println("Password with 1 chars, 1 caps, 1 numbers, 1 symbol:");
		System.out.println(pwdGenerator.generatePassword(1, 1, 1, 1));
		// Password with 5 numbers only
		System.out.println("Password with 5 numbers only:");
		System.out.println(pwdGenerator.generatePassword(0, 0, 5, 0));
	}

	// General method to use
	public String generatePassword() {
		return generatePassword(charsCount, capsCount, numbersCount, symbolsCount);
	}

	// Alternative method to use
	public String generatePassword(int charsCount,
								   int capsCount,
								   int numbersCount,
								   int symbolsCount) {
		String password = "";
		password += getRandomString(CHARS, charsCount);
		password += getRandomString(CAPS, capsCount);
		password += getRandomString(NUMBERS, numbersCount);
		password += getRandomString(SYMBOLS, symbolsCount);
		return shuffle(password);
	}

	private String getRandomString(String baseString, int count) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < count; i++) {
			result.append(baseString.charAt(random.nextInt(baseString.length())));
		}
		return result.toString();
	}

	private String shuffle(String source) {
		List<Character> characters = new ArrayList<Character>();
		for (char c : source.toCharArray()) {
			characters.add(c);
		}
		StringBuilder result = new StringBuilder(source.length());
		while (characters.size() > 0) {
			int randPicker = random.nextInt(characters.size());
			result.append(characters.remove(randPicker));
		}
		return result.toString();
	}
}
