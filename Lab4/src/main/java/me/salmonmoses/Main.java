package me.salmonmoses;

public class Main {
	public static void main(String[] args) {
		OrderModel model = new OrderModel();
		OrderView view = new OrderView();
		OrderController controller = new OrderController(model, view);

		controller.start();}
	}
