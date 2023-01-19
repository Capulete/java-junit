package org.example;

import java.util.Scanner;

public class Main {
		public static String[] products = initialProducts();
		public static int[] prices = initialPrices();

		public static void main(String[] args) {
				Scanner scanner = new Scanner(System.in);

				drawProductList();

				int[] order = new int[products.length];

				while (true) {
						System.out.println("Выберите номер товара и его количество, или введите 'end'");
						String input = scanner.nextLine();
						if ("end".equals(input)) {
										drawOrder(order, calculateOrder(order));
								break;
						}
						order = addToOrder(input, order);
				}
		}
		public static String[] initialProducts() {
				return new String[]{
												"Пиво",
												"Сигареты",
												"Пицца"
				};
		}
		public static int[] initialPrices() {
				return new int[]{
												100,
												200,
												300
				};
		}
		public static void drawProductList() {
				System.out.println("Список возможных товаров для покупки:");
				for (int i = 0; i < products.length; i++) {
						System.out.println(i + 1 + ".\t" + products[i] + "\t" + prices[i] + "\tруб/шт");
				}
		}
		public static int[] addToOrder(String input, int[] order) {
				String[] parts = input.split(" ");
				int productId = Integer.parseInt(parts[0]) - 1;
				int countProducts = Integer.parseInt(parts[1]);
				order[productId] += countProducts;
				return order;
		}
		public static int calculateOrder (int[] order) {
				int sumOrder = 0;
				for (int i = 0; i < order.length; i++) {
								sumOrder += prices[i] * order[i];
				}
				return sumOrder;
		}
		public static void drawOrder (int[] order, int sumOrder) {
				System.out.println("Ваша корзина:\n" +
												"Наименование товара   " +
												"Количество  " +
												"Цена/за.ед  " +
												"Общая стоимость");
				for (int i = 0; i < order.length; i++) {
						if (order[i] == 0)
								continue;
						System.out.println(products[i] +
														"\t" + order[i] +
														"\t" + prices[i] +
														"\t" + order[i] * prices[i]);
				}
				System.out.println("\tИтого: " + sumOrder);
		}
}