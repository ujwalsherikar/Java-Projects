package BankingSystemProgram;

import java.util.Scanner;
public class BankSystemCode {
    static Scanner sc = new Scanner(System.in);
    static String name, designation, department, accountNumber, accountType;
    static int age, pin;
    static double salary, balance;
    static boolean created = false;
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- BANKING SYSTEM ---");
            System.out.println("1. Create Account");
            System.out.println("2. Display Account");
            System.out.println("3. Raise Salary");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
            case 1:
                createAccount();
                break;
            case 2:
                displayAccount();
                break;
            case 3:
                raiseSalary();
                break;
            case 4:
                System.out.print("Are you sure? (yes/no): ");
                if (sc.next().equalsIgnoreCase("yes"))
                    System.out.println("Thank you!");
                else
                    choice = 0;
                break;
            default:
                System.out.println("Invalid choice!");
            }
        } while (choice != 4);
        sc.close();
    }
    static void createAccount() {
        if (created) {
            System.out.println("Account already exists!");
            return;
        }
        System.out.println("\n--- CREATE ACCOUNT ---");
        System.out.print("Enter name: ");
        name = sc.next();
        System.out.print("Enter age: ");
        age = sc.nextInt();
if (age < 18) { System.out.println("Age must be 18 or above."); return; }
        System.out.println("\nSelect Designation:");
        System.out.println("1. Programmer");
        System.out.println("2. Tester");
        System.out.println("3. Software Engineer");
        System.out.println("4. Data Analyst");
        System.out.println("5. Manager");
        System.out.print("Enter choice: ");
        int d = sc.nextInt();
        switch (d) {
        case 1: designation = "Programmer"; break;
        case 2: designation = "Tester"; break;
        case 3: designation = "Software Engineer"; break;
        case 4: designation = "Data Analyst"; break;
        case 5: designation = "Manager"; break;
        default:
            System.out.println("Invalid designation!");
            return;
        }
        System.out.println("\nSelect Department:");
        System.out.println("1. IT");
        System.out.println("2. HR");
        System.out.println("3. Finance");
        System.out.println("4. Marketing");
        System.out.println("5. Management");
        System.out.print("Enter choice: ");
        int dpt = sc.nextInt();
        switch (dpt) {
        case 1: department = "IT"; break;
        case 2: department = "HR"; break;
        case 3: department = "Finance"; break;
        case 4: department = "Marketing"; break;
        case 5: department = "Management"; break;
        default:
            System.out.println("Invalid department!");
            return;
        }
        System.out.print("Enter salary: ");
        salary = sc.nextDouble();
if (salary <= 0) { System.out.println("Invalid salary!"); return; }
        System.out.println("\nSelect Account Type:");
        System.out.println("1. Savings");
        System.out.println("2. Salary");
        System.out.println("3. Current");
        System.out.print("Enter choice: ");
        int type = sc.nextInt();
        switch (type) {
        case 1: accountType = "Savings"; break;
        case 2: accountType = "Salary"; break;
        case 3: accountType = "Current"; break;
        default:
            System.out.println("Invalid account type!");
            return;
        }
        System.out.print("Enter opening balance: ");
        balance = sc.nextDouble();
if (balance < 0) { System.out.println("Invalid balance!"); return; }
        System.out.print("Create 4-digit PIN: ");
        pin = sc.nextInt();
if (pin < 1000 || pin > 9999) { System.out.println("PIN must contain 4 digits."); return; }
        accountNumber = "BANK" + (10000 + (int)(Math.random() * 90000));
        System.out.println("Account Number: " + accountNumber);
        System.out.println("\n--- ACCOUNT SUMMARY ---");
        System.out.println("Name: " + name);
        System.out.println("Designation: " + designation);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
        System.out.println("Account Type: " + accountType);
        System.out.print("Confirm account creation? (yes/no): ");
        if (sc.next().equalsIgnoreCase("yes")) {
            created = true;
            System.out.println("Account created successfully!");
        } else {
            System.out.println("Account creation cancelled.");
        }
    }
    static boolean verifyAccount() {
        System.out.print("Enter account number: ");
        String acc = sc.next();
        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();
        return acc.equals(accountNumber) && enteredPin == pin;
    }
    static void displayAccount() {
if (!created) { System.out.println("Create an account first."); return; }
        System.out.println("\n--- ACCOUNT VERIFICATION ---");
        if (!verifyAccount()) {
            System.out.println("Invalid account number or PIN!");
            return;
        }
        System.out.println("\n--- ACCOUNT DETAILS ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Designation: " + designation);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: " + balance);
    }
    static void raiseSalary() {
if (!created) { System.out.println("Create an account first."); return; }
        System.out.println("\n--- RAISE SALARY ---");
        if (!verifyAccount()) {
            System.out.println("Invalid account number or PIN!");
            return;
        }
        System.out.println("Current Salary: " + salary);
        System.out.print("Enter increase amount: ");
        double increase = sc.nextDouble();
        if (increase <= 0) {
            System.out.println("Invalid amount!");
            return;
        }
        System.out.println("New Salary: " + (salary + increase));
        System.out.print("Confirm increase? (yes/no): ");
        if (sc.next().equalsIgnoreCase("yes")) {
            salary += increase;
            System.out.println("Salary updated successfully!");
        } else {
            System.out.println("Salary update cancelled.");
        }
    }
}
