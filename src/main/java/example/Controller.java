package example;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingWorker;

public class Controller implements Observer {

	protected Model model;
	protected View view;

	public Controller(Model model, View gui) {
		this.model = model;
		this.view = gui;

		initGui();
		model.addObserver(this);
	}

	private void initGui() {
		view.loadBUtton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
					@Override
					protected Void doInBackground() throws Exception {
						view.mainFrame.setEnabled(false);
						view.progressWindow.setVisible(true);
						model.calculate();
						view.progressText.setText("");
						view.progressWindow.setVisible(false);
						view.mainFrame.setEnabled(true);
						return null;
					}
				};
				worker.execute();
			}
		});
	}

	@Override
	public void update(Observable o, Object arg) {
		view.progressText.append((String) arg + ("\n"));
		// System.out.println(arg);
	}
}
