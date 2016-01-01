package example;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

public class View extends JFrame {
	private static final long serialVersionUID = -1008301631861757647L;

	protected JFrame mainFrame = new JFrame();
	protected JTextArea mainText = new JTextArea("Autoscroll example.");
	protected JButton loadBUtton = new JButton("Start");
	protected JDialog progressWindow = new JDialog();
	protected JTextArea progressText = new JTextArea();
	protected JScrollPane progressTextSrollPane = new JScrollPane(progressText,
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	public View() {
		createGui();
	}

	public void createGui() {
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainText.setPreferredSize(new Dimension(300, 100));
		mainText.setFont(new Font("Arial", 0, 30));
		mainFrame.setLayout(new BorderLayout());
		mainFrame.add(mainText, BorderLayout.CENTER);
		mainFrame.add(loadBUtton, BorderLayout.SOUTH);

		DefaultCaret caret = (DefaultCaret) progressText.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		progressTextSrollPane.setPreferredSize(new Dimension(100, 100));

		progressWindow.setLayout(new BorderLayout());
		progressWindow.add(progressTextSrollPane);
		progressWindow.pack();
	}

	public void run() {
		mainFrame.pack();
		mainFrame.setVisible(true);
	}

}
