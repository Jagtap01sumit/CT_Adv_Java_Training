package com.citiustech.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.citiustech.db.StockDAO;
import com.citiustech.stock.Authentication;
import com.citiustech.stock.BaseEntity;
import com.citiustech.stock.Portfolio;
import com.citiustech.stock.Stock;
import com.citiustech.stock.TradeManagement;
import com.citiustech.stock.UserOperations;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BaseEntity user = null;
		boolean check = true;

		do {
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Exit");

			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.print("Enter your email: ");
				String email = scanner.nextLine();
				System.out.print("Enter your name: ");
				String name = scanner.nextLine();
				try {
					if ((user = Authentication.loginUser(email, name)) != null) {
						System.out.println("User logged in successfully!");

						System.out.println(user);
						check = false;
					} else {
						System.out.println("Invalid email or name. Please try again.");
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				System.out.print("Enter your email: ");
				String registerEmail = scanner.nextLine();
				System.out.print("Enter your name: ");
				String registerName = scanner.nextLine();
				try {
					user = Authentication.createNewUser(registerEmail, registerName);
					System.out.println("User created successfully!");

					check = false;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (check);
		boolean check2 = true;

		System.out.println(user);
		if (user != null) {
			StockDAO stockDAO = new StockDAO();
			do {
				System.out.println("1. View Stocks");
				System.out.println("2. Buy Stock");
				System.out.println("3. Sell Stock");
				System.out.println("4. View Portfolio");
				System.out.println("5. View Trade History");
				System.out.println("6. Exit");

				System.out.print("Enter your choice: ");
				int choice2 = scanner.nextInt();
				scanner.nextLine();
				switch (choice2) {
				case 1:
					List<Stock> dbStocks = stockDAO.getStocks();

					for (Stock stock : dbStocks) {
						System.out.printf("%d, \t%s, \t%.2f, \t,%s, \t%d\n", stock.id(), stock.symbol(),
								stock.pricePerShare(), stock.companyName(), stock.quantity());
					}
					break;
				case 2:
					System.out.print("Enter the symbol of the stock you want to buy: ");
					String buySymbol = scanner.nextLine();
					Stock buyStock = getStockBySymbol(stockDAO, buySymbol);

					if (buyStock != null) {
						System.out.print("Enter the quantity you want to buy: ");
						int buyQuantity = scanner.nextInt();
						scanner.nextLine();

						TradeManagement.trade(user, buyStock, buyQuantity, "BUY");
					} else {
						System.out.println("Stock not found.");
					}
					break;
				case 3:
					System.out.print("Enter the symbol of the stock you want to sell: ");
					String sellSymbol = scanner.nextLine();
					Stock sellStock = getStockBySymbol(stockDAO, sellSymbol);

					if (sellStock != null) {
						System.out.print("Enter the quantity you want to sell: ");
						int sellQuantity = scanner.nextInt();
						scanner.nextLine();

						TradeManagement.trade(user, sellStock, sellQuantity, "SELL");
					} else {
						System.out.println("Stock not found.");
					}
					break;
				case 4:

					Map<String, Integer> map = TradeManagement.fetchPortfolio(user);
					for (String str : map.keySet()) {
						System.out.println(str + "      " + map.get(str));
					}
					;
					break;
				case 5:
					try {
						TradeManagement.viewHistory(user);
					} catch (Exception e) {
						System.out.println(e);
					}
					break;
				case 6:
					System.out.println("Exiting...");
					check2 = false;
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
				}
			} while (check2);
		}
	}

	private static Stock getStockBySymbol(StockDAO stockDAO, String symbol) {
		List<Stock> dbStocks = stockDAO.getStocks();

		for (Stock stock : dbStocks) {
			if (stock.symbol().equals(symbol)) {
				return stock;
			}
		}

		return null;
	}
}