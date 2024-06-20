import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class CheckOutApp{
public static void main(String[] args){

Scanner input = new Scanner(System.in);

String name;
String item;
int qty;
int price;
int subTotal = 0;
double vat;
double discount;
double billTotal;
String customerNames;

List<String> customerData = new ArrayList<>(); 
List<String> customerName = new ArrayList<>();

while(true){
System.out.print("What is the customers name? ");
 name = input.nextLine();
//input.nextLine();
System.out.print("What did the customer buy? ");
 item = input.nextLine();

System.out.print("How many pieces? ");
 qty = input.nextInt();

System.out.print("How much per unit? ");
 price = input.nextInt();

input.nextLine();

System.out.print("Add more items? \n");
String choice = input.nextLine();
//input.nextLine();

customerData.add(String.format("%18s%18s%18s%18s", item, qty, price, qty * price));
customerName.add(name);


//input.nextLine();

int total = qty * price;

subTotal += total;

vat = subTotal * (17.50 / 100);

if(choice.equalsIgnoreCase("no")) {
break;
	}
}
System.out.print("How much discount did he give you? ");
double customerDiscount = input.nextInt();

discount = subTotal * (customerDiscount / 100);
billTotal = (subTotal + vat) - discount;

System.out.print("SEMICOLON STORES\n");
System.out.print("MAIN BRANCH\n");
System.out.print("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.\n");
System.out.print("03293828343\n");
System.out.print("DATE: 18-DEC-22 8:48:11 PM\n");
System.out.print("CASHIER: SISTER NELSON\n");
	for (String names : customerName){
	System.out.println(names);
	}
System.out.print("=========================================================================\n");


System.out.printf("%18s%18s%18s%18s", "ITEM", "QTY","PRICE","TOTAL(NGN)\n");
System.out.print("-------------------------------------------------------------------------\n");
	for (String customer : customerData){
	System.out.print(customer + "\n"); 
	}
System.out.print("-------------------------------------------------------------------------\n");
System.out.printf("%18s%10s%18s", "SUB TOTAL: ", subTotal,  "\n" );
System.out.printf("%18s%10s%18s","DISCOUNT: ", discount,  "\n" );
System.out.printf("%18s\t%.2f%18s", "  VAT @ 17.5%:", vat, "\n" );

System.out.print("=========================================================================\n");
System.out.print("        BILL TOTAL: " + billTotal +  "\n" );
System.out.print("=========================================================================\n");
System.out.print("THIS IS NOT A RECIEPT KINDLY PAY " + billTotal + "\n");
System.out.print("=========================================================================\n");

System.out.print("How much did the customer give to you? ");
int amountPaid = input.nextInt();
double balance = amountPaid - billTotal;


	System.out.print("SEMICOLON STORES\n");
	System.out.print("MAIN BRANCH\n");
	System.out.print("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.\n");
	System.out.print("03293828343\n");
	System.out.print("DATE: 18-DEC-22 8:48:11 PM\n");
	System.out.print("CASHIER: SISTER NELSON\n");
	for (String names : customerName){
	System.out.println(names);
	}
System.out.print("=========================================================================\n");


	System.out.printf("%18s%18s%18s%18s", "ITEM", "QTY","PRICE","TOTAL(NGN)\n");
System.out.print("-------------------------------------------------------------------------\n");
	for (String customer : customerData){
	System.out.print(customer + "\n"); 
	}
System.out.print("-------------------------------------------------------------------------\n");
	System.out.printf("%18s%10s%18s", "SUB TOTAL: ", subTotal,  "\n" );
	System.out.printf("%18s%10s%18s", "DISCOUNT: ", discount,  "\n" );
	System.out.printf("%18s\t%.2f%18s", "VAT @ 17.5%:", vat, "\n" );

System.out.print("=========================================================================\n");
	System.out.print("        BILL TOTAL: " + billTotal +  "\n" );
	System.out.print("        AMOUNT PAID: " + amountPaid +  "\n" );
	System.out.print("        BALANCE: " +  + balance + "\n" );
	
System.out.print("=========================================================================\n");
	System.out.print("THANK YOU FOR YOUR PATRONAGE\n");
System.out.print("=========================================================================\n");












}
}
