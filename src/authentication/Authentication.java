package authentication;

import javax.swing.JTextField;
import java.util.Random;
import components.Home;

public class Authentication {
	private Home home;
	
	public Authentication(Home home) {
		this.home = home;
	}
	
	public String capitalizeFirstLetter(String input) {
	    if (input == null || input.isEmpty()) {
	        return input;
	    }

	    StringBuilder result = new StringBuilder(input.length());
	    boolean capitalizeNext = true;

	    for (char ch : input.toCharArray()) {
	        if (Character.isWhitespace(ch)) {
	            capitalizeNext = true;
	        } else if (capitalizeNext) {
	            ch = Character.toUpperCase(ch);
	            capitalizeNext = false;
	        }

	        result.append(ch);
	    }

	    return result.toString();
	}

	public String containDigits(String input) {
		 if (input == null || input.isEmpty()) {
		        System.out.println("Please enter a 3 to 4 digit value!");
		        return "";
		    }

		    if (!input.matches("\\d{3,4}")) {
		        System.out.println("Please enter only numeric values that ranging from 3 digits to 4 digits");
		        return "";
		    }

		    return "Cvv: " + input;
	}
	
	public String cardNumbers(String input) {
		 if (input == null || input.isEmpty()) {
		        System.out.println("Please enter a 15 to 16 digit value!");
		        return "";
		    }

		    if (!input.matches("\\d{15,16}")) {
		        System.out.println("Please enter only numeric values that ranging from 15 digits to 16 digits");
		        return "";
		    }

		    return "Cvv: " + input;
	}
	
	public String days(String input, String month) {
	    if (input == null || input.isEmpty()) {
	        System.out.println("Please enter the day!");
	        return "";
	    }

	    int day = Integer.parseInt(input);
	    int maxDays = getMaxDaysOfMonth(month);

	    if (day < 1 || day > maxDays) {
	        System.out.println("Invalid number of days for the month " + month);
	        return "";
	    }

	    if (month.equals("2") && day > 28) {
	        System.out.println("Invalid number of days for February");
	        return "";
	    }
	    

	    return "Days: " + input;
	}


	public String months(String input) {
	    if (input == null || input.isEmpty()) {
	        System.out.println("Please enter the month!");
	        return "";
	    }

	    if (!input.matches("\\d+") || Integer.parseInt(input) < 1 || Integer.parseInt(input) > 12) {
	        System.out.println("Please enter a month from 1 to 12");
	        return "";
	    }

	    String monthName = getMonthName(input);
	    System.out.println(monthName);

	    return "Month: " + input;
	}

	public int getMaxDaysOfMonth(String month) {
	    int monthValue = Integer.parseInt(month);

	    switch (monthValue) {
	        case 1: // January
	        case 3: // March
	        case 5: // May
	        case 7: // July
	        case 8: // August
	        case 10: // October
	        case 12: // December
	            return 31;

	        case 4: // April
	        case 6: // June
	        case 9: // September
	        case 11: // November
	            return 30;

	        case 2: // February
	            return 28; // or 29 in a leap year

	        default:
	            return 0; // Invalid month
	    }
	}

	private String getMonthName(String input) {
	    int monthValue = Integer.parseInt(input);

	    switch (monthValue) {
	        case 1:
	            return "January";
	        case 2:
	            return "February";
	        case 3:
	            return "March";
	        case 4:
	            return "April";
	        case 5:
	            return "May";
	        case 6:
	            return "June";
	        case 7:
	            return "July";
	        case 8:
	            return "August";
	        case 9:
	            return "September";
	        case 10:
	            return "October";
	        case 11:
	            return "November";
	        case 12:
	            return "December";
	        default:
	            return "Invalid month";
	    }
	}


	public String years(String input) {
	    if (input == null || input.isEmpty()) {
	        System.out.println("Please enter the year!");
	        return "";
	    }

	    if (!input.matches("\\d+") || input.length() != 4) {
	        System.out.println("Please enter a valid 4-digit year");
	        return "";
	    }

	    int year = Integer.parseInt(input);
	    if (year < 1 || year > 9999) {
	        System.out.println("Please enter a year between 0001 and 9999");
	        return "";
	    }

	    return "Year: " + input;
	}

	public void limitInput(JTextField components, int limit) {
        String input = components.getText();
        int characterLimit = limit; // Set the character limit to 16

        if (input.length() > characterLimit) {
        	components.setText(input.substring(0, characterLimit));
        }
    }
	
	public void daysLimit(JTextField dayInput, JTextField monthInput) {
		if(dayInput.getText() == "30" && monthInput.getText() == "2") {
			System.out.println("Invalid month days!");
		}
	}
	
	public long orderNumberGenerator() {
	    int digits = 16;
	    Random random = new Random();
	    long orderNumber = generateRandomOrderNumber(random, digits);
	    return orderNumber;
	}

	private static long generateRandomOrderNumber(Random random, int digits) {
	    long min = (long) Math.pow(10, digits - 1);
	    long max = (long) Math.pow(10, digits) - 1;
	    long randomNumber = random.nextLong() % (max - min + 1) + min;
	    return Math.abs(randomNumber);
	}


}
