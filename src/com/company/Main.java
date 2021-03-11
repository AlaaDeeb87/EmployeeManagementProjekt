package com.company;
import java.util.*;
import java.io.*;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.Arrays;

public class Main {



    public static void main(String[] args) {
        // write your code here

        System.out.println("Employee Management type 1");
        System.out.println("Accountant type 2");
        Scanner sc=new Scanner(System.in);
        int UserInput = sc.nextInt();
        switch (UserInput)
        {
            case 1:
            {
                adminLogin.adminJohann();
                break;
            }
            case 2:
            {
                Accountant.Menu();
                break;
            }
        }
    }
}
class adminLogin
{
    public static void adminJohann()
    {
        int attempt = 0;
        String username = "johann";
        String password = "Johann123";
        String AdminUsername;
        String adminPassword;
        AdminUsername = (JOptionPane.showInputDialog("Please enter your username"));
        adminPassword = (JOptionPane.showInputDialog("Please enter your password"));
        if (AdminUsername.equals(username) && adminPassword.equals(password) )
        {
            JOptionPane.showMessageDialog(null,"Welcome Johann");
            Admin.Menu();
        }
        else if (AdminUsername.equals(username))
        {
            JOptionPane.showMessageDialog(null,"Password incorrect");
            attempt++;
            adminPassword = (JOptionPane.showInputDialog("Please enter the password again"));
            Admin.Menu();
        }
        else if (adminPassword.equals(password))
        {
            JOptionPane.showMessageDialog(null, "Username incorrect");
            attempt++;
            AdminUsername = (JOptionPane.showInputDialog("Please enter username again"));
            Admin.Menu();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Username and password are incorrect");
            attempt++;
            AdminUsername = (JOptionPane.showInputDialog("Please enter username again"));
            adminPassword = (JOptionPane.showInputDialog("Please enter password again"));
            Admin.Menu();
        }
        if (attempt == 5)
        {
            JOptionPane.showMessageDialog(null,"You've reached maximum attempts");
            System.exit(0);
        }
    }
}
class Admin
{
    public static String name;
    public static String EmployeeID;
    public static String EmployeeAddress;
    public static String EmployeeContact;
    public static String EmployeePosition;
    public static void Menu()
    {

        Scanner sc= new Scanner(System.in);
        System.out.println("");
        System.out.println("Press 1 : Add an Employee");
        System.out.println("Press 2 : View Employee details");
        System.out.println("Press 3 : Modify Employee details");
        System.out.println("Press 4 : Remove Employee details");
        System.out.println("Press 5 : Exit");
        System.out.println("");
        int UserInput=sc.nextInt();

        switch (UserInput)
        {
            case 1:
            {
                Admin.AddEmployee();
                break;
            }
            case 2:
            {

                Admin.ViewEmployeeDetails();
                break;
            }
            case 3:
            {
                Admin.ModifyEmployee();
                break;
            }
            case 4:
            {
                Admin.RemoveEmployee();
                break;
            }
            case 5:
            {
                Admin.Exit();
                break;
            }
        }

    }
    public static void AddEmployee()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Employee Name ");
        name=sc.nextLine();
        System.out.println("Enter Employee ID");
        EmployeeID=sc.nextLine();
        System.out.println("Enter Employee Address");
        EmployeeAddress=sc.nextLine();
        System.out.println("Enter Employee Contact");
        EmployeeContact=sc.nextLine();
        System.out.println("Enter Employee Position");
        EmployeePosition=sc.nextLine();

        try {
            FileWriter myWriter = new FileWriter("file "+EmployeeID+".txt");
            myWriter.write("Employee ID       :  " + EmployeeID+"\n");
            myWriter.write("Employee name     :  " + name+"\n");
            myWriter.write("Employee address  :  " + EmployeeAddress+"\n");
            myWriter.write("Employee contact  :  " + EmployeeContact+"\n");
            myWriter.write("Employee position :  " + EmployeePosition+"\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            Admin.Menu();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
    public static void ViewEmployeeDetails()
    {
        try {
            Scanner sc=new Scanner(System.in);
            System.out.print("\nPlease Enter Employee's ID you want to view :");
            String inputID=sc.nextLine();
            File myWriter = new File("file "+inputID+".txt");
            Scanner myReader = new Scanner(myWriter);
            try (BufferedReader br = new BufferedReader(new FileReader(myWriter))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                Admin.Menu();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Admin.Menu();
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Incorrect employee ID.");
            Admin.Menu();
        }


    }
    public static void ModifyEmployee()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Employee ID you want to modify");
        EmployeeID=sc.nextLine();
        System.out.println("Enter new Employee Name ");
        name=sc.nextLine();
        System.out.println("Enter new Employee Address");
        EmployeeAddress=sc.nextLine();
        System.out.println("Enter new Employee Contact");
        EmployeeContact=sc.nextLine();
        System.out.println("Enter new Employee Position");
        EmployeePosition=sc.nextLine();
        try {
            FileWriter myWriter = new FileWriter("file "+EmployeeID+".txt");
            myWriter.write("Employee ID       :  " + EmployeeID+"\n");
            myWriter.write("Employee name     :  " + name+"\n");
            myWriter.write("Employee address  :  " + EmployeeAddress+"\n");
            myWriter.write("Employee contact  :  " + EmployeeContact+"\n");
            myWriter.write("Employee position :  " + EmployeePosition+"\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            Admin.Menu();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    public static void RemoveEmployee()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("\nPlease Enter Employee's ID you want to remove :");
        String inputID=sc.nextLine();
        File myWriter = new File("file "+inputID+".txt");
        if (myWriter.delete()) {
            System.out.println("Deleted the file: " + myWriter.getName());
            Admin.Menu();
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
    public static void Exit()
    {
        System.out.println("       ****** Good bye ******     ");

        System.exit(0);


    }


}
class Accountant
{
    public static void Menu()
    {
        System.out.println("Press 1 : Calculator");
        System.out.println("Press 2 : Exit");
        Scanner sc=new Scanner(System.in);
        int UserInput = sc.nextInt();
        switch (UserInput)
        {
            case 1:
            {
                Accountant.calculator();
                break;
            }
            case 2:
            {
                Accountant.exit();
                break;
            }
        }



    }
    public static void calculator()
    {
        float [] num=new float[2];
        String operation;
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the first number");
        num[0] = sc.nextInt();
        Scanner op = new Scanner(System.in);
        System.out.println("Please enter operation");
        operation = op.next();
        System.out.println("Please enter the second number");
        num[1] = sc.nextInt();
        switch (operation)
        {
            case "+":
            {
                System.out.println("Your answer is : " + (num[0] + num[1]));
                Accountant.Menu();
                break;

            }
            case "-":
            {
                System.out.println("Your answer is : " + (num[0] - num[1]));
                Accountant.Menu();
                break;
            }
            case "/":
            {
                System.out.println("Your answer is : " + (num[0] / num[1]));
                Accountant.Menu();
                break;
            }
            case "*":
            {
                System.out.println("Your answer is : " + (num[0] * num[1]));
                Accountant.Menu();
                break;
            }
        }
    }
    public static void exit()
    {
        System.out.println("       ****** Good bye ******     ");
        System.exit(0);
    }
}