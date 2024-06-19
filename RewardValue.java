import java.util.Scanner;

public class RewardValue {
    private double cashValue;
    private double milesValue;


    public static final double CONVERSION_RATE=0.0035;



    //constructor that accepts  a cash value
    public RewardValue(double cashValue) {
        this.cashValue = cashValue;
        this.milesValue = convertToMiles(cashValue);

    }

    public RewardValue(double milesValue, boolean isMiles) {

        if (isMiles) {
            this.milesValue = milesValue;
            this.cashValue = convertToCash(milesValue);

        } else {
            throw new IllegalArgumentException("Invalid constructor usage. Use the constructor with cash value.");
        }
    }


    // Method to get the cash value of the RewardValue
    public double getCashValue() {
        return cashValue;
    }

    // Method to get how many miles the RewardValue is worth
    public double getMilesValue() {
        return milesValue;
    }


    //Private method to convert cash value to miles
    private double convertToMiles(double cashValue) {

        return cashValue / CONVERSION_RATE;


    }

    //Private method to convert miles value to cash
    private double convertToCash(double milesValue) {

        return milesValue * CONVERSION_RATE;


    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Welcome to the Credit Card Rewards Converter!");
        System.out.println("Please enter a cash value to convert to airline miles: ");
        var input_value = scanner.nextLine();
        double cashValue;
        try {
            cashValue = Double.parseDouble(input_value);
            System.out.println("converting $" + input_value + " to miles");
            var rewardsValue = new RewardValue(cashValue);
            System.out.println("$" + input_value + " is worth " + rewardsValue.getMilesValue() + " miles");
            scanner.close();
        } catch (NumberFormatException exception) {
            System.out.println("Could not parse input value as a double, exiting");
        }
       
    }

}
