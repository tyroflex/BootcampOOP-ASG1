package javaClasses;

public class userInput {
    private final int firstNumber;
    private final int secondNumber;
    private final String plus;
    private final char firstChar;
    private final char secondChar;
    private final int multiplication;
    private final float division;
    private final boolean same;
    private final int addition;
    private final int subtraction;
    private final int remainder;
    private final int integerDivision;


    public userInput( int firstNumber, int secondNumber ) {

        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.plus = toString(this.firstNumber) + " + " + toString(this.secondNumber);
        this.firstChar = ((char) this.firstNumber);
        this.secondChar = ((char) this.secondNumber);
        this.multiplication = this.firstNumber * this.secondNumber;
        this.division = (float) this.firstNumber / (float) this.secondNumber;
        this.same = this.firstNumber == this.secondNumber;
        this.addition = this.firstNumber + this.secondNumber;
        this.subtraction = this.firstNumber - this.secondNumber;
        this.integerDivision = this.firstNumber / this.secondNumber;
        this.remainder = this.firstNumber % this.secondNumber;
    }

    private String toString( int number ) {
        String converted = "";
        int denominator = (int) Math.pow( 10, Math.floor(Math.log10(number)));
        while ( denominator > 0 ) {
            int digit = number / denominator;
            converted += (char) (digit + '0');
            number %= denominator;
            denominator /= 10;
        }
        return converted;
    }

    public int getFirstNumber() {
        return this.firstNumber;
    }

    public int getSecondNumber() {
        return this.secondNumber;
    }

    public String getPlus() {
        return this.plus;
    }

    public char getFirstChar() {
        return this.firstChar;
    }

    public char getSecondChar() {
        return this.secondChar;
    }

    public int getMultiplication() {
        return this.multiplication;
    }

    public float getDivision() {
        return this.division;
    }

    public boolean same() {
        return this.same;
    }

    public int getAddition() {
        return this.addition;
    }

    public boolean isSame() {
        return same;
    }

    public int getSubtraction() {
        return subtraction;
    }

    public int getRemainder() {
        return remainder;
    }

    public int getIntegerDivision() {
        return integerDivision;
    }
}
