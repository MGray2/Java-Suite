import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String expenseName;
    double value;
    Expense(String expenseName, double value) {
        this.expenseName = expenseName;
        this.value = value;
        // constructor method
    }
    @Override
    public String toString() {
        String valueFormatted = String.format("%.2f", value);
        return expenseName + ": $" + valueFormatted;
    }

    void modify(String newName, double newValue) {
        expenseName = newName;
        value = newValue;
    }

    void modify(String newName) {
        expenseName = newName;
    }

    void modify(double newValue) {
        value = newValue;
    }
}

public class ExpenseTracker {
    static ArrayList<Expense> Expenses = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int n = 0;
            for (Expense i : Expenses) { // this for loop prints each expense in list
                System.out.println(n + "# " + i.toString());
                n++;
            }
            System.out.println("[A]dd expense, [R]emove expense, [C]hange expence, [Q]uit.");
            switch (scanner.nextLine().toLowerCase()) {
                case "a":
                    System.out.println("Name of expense:");
                    String newName = scanner.nextLine();
                    System.out.println("Value of expense:");
                    float newValue = scanner.nextFloat();
                    scanner.nextLine();
                    Expense newExpense = new Expense(newName, newValue); // creation of expense
                    Expenses.add(newExpense); // append to list
                    break;
                case "r":
                    n = 0;
                    for (Object i : Expenses) {
                        System.out.println(n + "# " + i.toString());
                        n++;
                    }
                    try {
                        System.out.println("Please use index number to select item for deletion.");

                        int m = scanner.nextInt();
                        if (Expenses.get(m) != null) {
                            Expenses.remove(m);
                            break;
                        }
                    }
                    catch (IndexOutOfBoundsException e) {
                        System.err.println("Index does not exist");
                        break;
                            }


                    scanner.nextLine();
                case "c":
                    n = 0;
                    for (Expense i : Expenses) {
                        System.out.println(n + "# " + i.toString());
                        n++;
                    }
                    try {
                    System.out.println("Please use index number to select item");
                    int p = scanner.nextInt();
                    scanner.nextLine();

                    if (Expenses.get(p) != null) {
                        Expense selected = Expenses.get(p);
                        System.out.println("Provide new name for expense, leave empty to skip:");
                        String rename = scanner.nextLine(); // rename

                        System.out.println("*Optional* provide new value for expense, 0 to skip");
                        double revalue = scanner.nextDouble(); // revalue
                        scanner.nextLine();

                        if (!rename.isEmpty() && revalue == 0.0) {
                            selected.modify(rename);
                        } else if (rename.isEmpty() && revalue != 0.0) {
                            selected.modify(revalue);
                        } else if (!rename.isEmpty()) {
                            selected.modify(rename, revalue);
                        } else {
                            // nothing
                            break;
                        }
                        scanner.nextLine();
                        break;
                    }

                    } catch (IndexOutOfBoundsException e) {
                        System.err.println("Index does not exist");
                    }

                case "q":
                    System.exit(0);
                default:
            }
        }
    }
}
