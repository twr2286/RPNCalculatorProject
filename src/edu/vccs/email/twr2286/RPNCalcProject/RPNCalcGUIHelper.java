package edu.vccs.email.twr2286.RPNCalcProject;

/**
 * Helper to integrate the calculator GUI with the calculations
 * 2022-04-08
 * @author Tim Root
 */
public class RPNCalcGUIHelper {
    private StringBuilder display;      // for the GUI to display
    private RPNCalcMath calc;           // to access the RPN calculator logic
    private boolean isEditable;         // displayed number can be adjusted
    private boolean displayIsInStack;   // number displayed is in the stack

    /**
     * no arg constructor
     */
    public RPNCalcGUIHelper() {
        display = new StringBuilder();
        calc = new RPNCalcMath();
        setDisplay("");
    }

    /**
     * handles all the possible keystrokes from the calculator GUI
     * @param key the key pressed by the user
     * @return String current number
     */
    public String addKey(String key) {
        double num;
        switch (key) {
            case "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" -> {
                if (isEditable) {
                    display.append(key);
                } else {
                    if (!displayIsInStack) {
                        calc.enterNumber(getNum());
                    }
                    setDisplay(key);
                }
                displayIsInStack = false;
                isEditable = true;
                break;
            }
            case "." -> {
                if (displayIsInStack) {
                    setDisplay("0.");
                    displayIsInStack = false;
                    isEditable = true;
                    break;
                } else if (isEditable && !display.toString().contains(".")) {
                    display.append(key);
                }
                break;
            }
            case "+/-" -> {
                num = getNum();
                if (num != 0.0) {
                    if (display.charAt(0) == '-') {
                        display.deleteCharAt(0);
                    }
                    else {
                        display.insert(0, '-');
                    }
                    displayIsInStack = false;
                }
                break;
            }
            case "π" -> {
                finishCurrentNum();
                num = Math.PI;
                calc.enterNumber(num);
                setDisplay("" + num);
                break;
            }
            case "/" -> {
                finishCurrentNum();
                setDisplay("" + calc.divide());
                break;
            }
            case "τ" -> {
                finishCurrentNum();
                num = Math.PI * 2;
                calc.enterNumber(num);
                setDisplay("" + num);
                break;
            }
            case "*" -> {
                finishCurrentNum();
                setDisplay("" + calc.multiply());
                break;
            }
            case "<" -> {     // backspace
                if (isEditable && display.length() > 0) {
                    display.deleteCharAt(display.length() - 1);
                    if (display.length() == 0) {
                        setDisplay("0");
                    }
                }
                break;
            }
            case "-" -> {
                finishCurrentNum();
                setDisplay("" + calc.subtract());
                break;
            }
            case "^" -> {         // "Enter" key
                num = getNum();
                calc.enterNumber(num);
                setDisplay("" + num);
                displayIsInStack = true;
                isEditable = false;
                break;
            }
            case "+" -> {
                finishCurrentNum();
                setDisplay("" + calc.add());
                break;
            }
            default -> {
                return "Ya broke it.";
            }
        }

        return display.toString();
    }
    /**
     * set/reset the string to be displayed
     * @param toDisplay the string to be displayed
     */
    private void setDisplay(String toDisplay) {
        toDisplay = (toDisplay == null) ? "" : toDisplay;
        display.replace(0, display.length(), toDisplay);
    }

    /**
     * get the number in the display string, or zero (0.0) if it's not a number
     * @return number from the display string
     */
    private double getNum() {
        double num = 0.0;             // number to get from display

        try {
            num = Double.parseDouble(display.toString());
        } catch (NumberFormatException e) {
            // if it's not a number, just return the default (0.0)
        }

        return num;
    }
    /**
     *  for commands that indicate the displayed number is complete
     */
    private void finishCurrentNum() {
        if (isEditable) {
            calc.enterNumber(getNum());
        }
        displayIsInStack = true;
        isEditable = false;
    }
}

