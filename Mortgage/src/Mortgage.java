import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Mortgage {
	
	public static void main(String[] args) {
		
		ImageIcon icon = new ImageIcon("image.png");
		
		double loan = 0;
		double interestRate = 0;
		double monthlyPayment = 0;
		double outstandingBalance = 0;
		int term = 0;
		
		String tempLoan = JOptionPane.showInputDialog("Enter total amount of loan : ");
		loan = Double.parseDouble(tempLoan);
		
		String tempRate = JOptionPane.showInputDialog("Enter annual interest rate : ");
		interestRate = Double.parseDouble(tempRate);
		
		String tempTerm = JOptionPane.showInputDialog("Enter mortgage term in months : ");
		term = Integer.parseInt(tempTerm);
		
		monthlyPayment = getMonthlyPayment(loan, interestRate, term);
		outstandingBalance = (monthlyPayment * (term * 12));
		JOptionPane.showMessageDialog(null, "<html>Amount owed to bank is $"+ Math.round(outstandingBalance) +" <br>"
				+ "Minimum monthly payment is $"+ Math.round(monthlyPayment) +"</html>", "Result", JOptionPane.PLAIN_MESSAGE, icon);
	}
		
		public static double getMonthlyPayment(double loan, double interestRate, double term) {
			double rate = (interestRate / 100) / 12;
			double base = (rate + 1);
			double months = term * 12;
			double result = 0;
			result = loan * (rate * (Math.pow(base,  months)) / ((Math.pow(base,  months)) - 1));
			return result;
		}
	}

