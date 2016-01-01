package example;

public class Main {

	public static void main(String[] args) {

		Model model = new Model();
		View view = new View();
		@SuppressWarnings("unused")
		Controller controller = new Controller(model, view);
		view.run();
	}
}
