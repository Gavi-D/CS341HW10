import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DataStructsFrame extends JFrame {
	public DataStructsFrame(String title, HashMap<Integer, Integer> numbers) {
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
	
	private ArrayList<ListItem> IDontLikeListItemSoIamConvertingToIntegersForSorting(HashMap<Integer, Integer> numbers) {
		/*
		 * Set<Integer> keySet = numbers.keySet(); Set<Integer> valueSet =
		 * (Set<Integer>) numbers.values();
		 */
		
		/*
		 * int keyArr[] = null; int i = 0; for (int x: keySet) { keyArr[i] = x; }
		 * 
		 * int valuesArr[] = null; int j = 0; for (int y: valueSet) { valuesArr[j] = y;
		 * }
		 */
		
		Object[] valuesArr = numbers.values().toArray();
		Object[] keyArr = numbers.keySet().toArray();
		
		Arrays.sort(valuesArr);
		ArrayList<ListItem> list = new ArrayList<ListItem>();
		
		for (int k = numbers.size()-1; k >= 0 ; k--) {	//adding sorted numbers to an ArrayList<ListItems> in descending order
			ListItem item = new ListItem((int)keyArr[k], (int)valuesArr[k]);
			list.add(item);
		}

		return list;
	}

	private ArrayList<ListItem> arrayToList(HashMap<Integer, Integer> numbers) {
		ArrayList<ListItem> list = new ArrayList<ListItem>();
		/*
		 * Set<Integer> keySet = numbers.keySet(); Set<Integer> valueSet =
		 * (Set<Integer>) numbers.values();
		 * 
		 * int keyArr[] = null; int i = 0; for (int x: keySet) { keyArr[i] = x; }
		 * 
		 * int valuesArr[] = null; int j = 0; for (int y: valueSet) { valuesArr[j] = y;
		 * }
		 */
		
		Object[] valuesArr = numbers.values().toArray();	//making an array of values (A values)
		Object[] keyArr = numbers.keySet().toArray(); //making an array of keys (B values)
		
		/*
		 * int keyArr[] = null; int i = 0; for (Object x: keyObj) { keyArr[i] = (int) x;
		 * }
		 */
		
		
		
		for (int k = 0; k < numbers.size(); k++) {
			ListItem item = new ListItem((int)keyArr[k], (int)valuesArr[k]);
			list.add(item);
		}

		return list;
	}
}
