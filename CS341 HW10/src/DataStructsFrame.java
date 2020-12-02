import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DataStructsFrame extends JFrame {
	public DataStructsFrame(String title, int[] numbers) {
		super(title);

		final JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		final ArrayList<ListItem> list = arrayToList(numbers);

		final ListPanel unorderedList = new ListPanel("Unordered List");
		unorderedList.setDiameter(75);
		unorderedList.addItems(list);

		final ListPanel orderedList = new ListPanel("Ordered List");
		orderedList.setDiameter(100);

		JButton sortButton = new JButton("Sort List");
		sortButton.setSize(30, 10);
		sortButton.setAlignmentX(CENTER_ALIGNMENT);

		sortButton.addActionListener(new ActionListener() {
			int buttonPressed = 0;
			public void actionPerformed(ActionEvent ae) {
				if (buttonPressed == 0) {		//checks if button is already pressed
					//System.out.println(list);
					ArrayList<ListItem> sortedList = IDontLikeListItemSoIamConvertingToIntegersForSorting(numbers);
					//System.out.println(list);
					
					/*
					 * for (int i = 0; i < list.size(); i++) {
					 * System.out.println(list.get(i).getValA()); }
					 */
					orderedList.addItems(sortedList);
					panel.add(orderedList);
					pack();
				}
				buttonPressed = 1;		//button pressed for the first time
			}
		});

		panel.add(unorderedList);
		panel.add(sortButton);
		add(panel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	private ArrayList<ListItem> IDontLikeListItemSoIamConvertingToIntegersForSorting(int[] numbers) {
		Arrays.sort(numbers);
		ArrayList<ListItem> list = new ArrayList<ListItem>();
		
		for (int i = numbers.length-1; i >= 0 ; i--) {	//adding sorted numbers to an ArrayList<ListItems> in descending order
			ListItem item = new ListItem(numbers[i]);
			list.add(item);
		}

		return list;
	}

	private ArrayList<ListItem> arrayToList(int[] numbers) {
		ArrayList<ListItem> list = new ArrayList<ListItem>();

		for (int i = 0; i < numbers.length; i++) {
			ListItem item = new ListItem(numbers[i]);
			list.add(item);
		}

		return list;
	}
}
