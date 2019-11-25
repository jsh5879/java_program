import javax.swing.*;
import java.awt.event.*;

public class Swing {
	public static void main(String[] args) {
		ActionFrame frame = new ActionFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}

class ActionFrame extends JFrame {
	public ActionFrame() {
		setTitle("HW11_Swing_201524561_�弮ȯ");
		setVisible(true);
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		ActionPanel panel = new ActionPanel();
		add(panel);
	}
	public static final int DEFAULT_WIDTH = 600;
	public static final int DEFAULT_HEIGHT = 200;
}

class ActionPanel extends JPanel{
	public ActionPanel() {

		Action addButton = new MyAction("Add");
		add(new JButton(addButton));

		Action removeFirstButton = new MyAction("Remove First");
		add(new JButton(removeFirstButton));

		Action removeLastButton = new MyAction("Remove Last");
		add(new JButton(removeLastButton));

		Action removeAllButton = new MyAction("Remove All");
		add(new JButton(removeAllButton));

		Action quitButton = new MyAction("Quit");
		add(new JButton(quitButton));

	}
}

class MyAction extends AbstractAction{
	public MyAction(String name) {
		putValue(Action.NAME, name);
		putValue(Action.SHORT_DESCRIPTION, "To " + name);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println(event);

		String cmd = event.getActionCommand();

		JOptionPane.showMessageDialog(null, cmd);

		if(cmd.equals("Quit")) {
			System.exit(0);
		}

	}
}
