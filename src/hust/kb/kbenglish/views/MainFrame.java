package hust.kb.kbenglish.views;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import hust.kb.kbenglish.models.Book;
import hust.kb.kbenglish.models.Level;
import hust.kb.kbenglish.models.Rule;
import hust.kb.kbenglish.models.RuleCreateLevel;
import javax.swing.JLabel;

public class MainFrame extends JFrame {
	public static String TITLE = "Hệ tư vấn học tiếng anh";
	public static String INPUT_TITLE = "Thông tin đầu vào";
	public static String INPUT_CURRENT_READ = "Điểm đọc hiện tại";
	public static String INPUT_CURRENT_LISTEN = "Điểm nghe hiện tại";
	public static String INPUT_TARGET_LEVER = "Mục tiêu muốn đạt";
	public static String INPUT_TARGET_TIME = "Thời gian cần đạt mục tiêu";
	public static String INPUT_CANCEL = "Hủy";
	public static String INPUT_NEXT = "Tiếp theo";

	public static String OUTPUT_TITLE = "Kết quả";
	public static String OUTPUT_LIST_BOOK = "Danh sách các sách cần đọc";
	public static String[] OUTPUT_BOOK_COLUMN = { "STT", "Tên sách", "Thời gian cần đọc xong" };
	public static String OUTPUT_POSSIBILITY = "Tính khả thi";
	public static String OUTPUT_AGAIN = "Làm lại";
	public static String OUPUT_EXIT = "Kết thúc";

	private JFrame main;
	private Container cp;
	private JPanel inputPanel;
	private JPanel outputPanel;
	private JTextField currentRead, currentListen, targetLever, targetTime;
	private JButton cancel, next, again, exit;
        private JLabel lbHeader = new javax.swing.JLabel();


	public MainFrame() {
		main = this;
                
                lbHeader.setIcon(new javax.swing.ImageIcon("/home/ducvu/Desktop/logo-bk-rgb.png")); 
		// Panel input =======================================
		inputPanel = new JPanel();
		inputPanel.setBorder(new TitledBorder(INPUT_TITLE));
		inputPanel.setLayout(new GridLayout(5, 2));

		inputPanel.add(new Label(INPUT_CURRENT_LISTEN));
		currentListen = new JTextField(10);
		inputPanel.add(currentListen);

		inputPanel.add(new Label(INPUT_CURRENT_READ));
		currentRead = new JTextField(10);
		inputPanel.add(currentRead);

		inputPanel.add(new Label(INPUT_TARGET_LEVER));
		targetLever = new JTextField(10);
		inputPanel.add(targetLever);

		inputPanel.add(new Label(INPUT_TARGET_TIME));
		targetTime = new JTextField(10);
		inputPanel.add(targetTime);

		cancel = new JButton(INPUT_CANCEL);
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				main.dispose();
			}
		});
		inputPanel.add(cancel);

		next = new JButton(INPUT_NEXT);
		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				inputClickNext();
			}
		});
		inputPanel.add(next);

		// Panel output =======================================

		outputPanel = new JPanel();
		outputPanel.setBorder(new TitledBorder(OUTPUT_TITLE));
		outputPanel.setLayout(new BorderLayout());

		outputPanel.add(new Label(OUTPUT_LIST_BOOK), BorderLayout.NORTH);
		/*String[][] table = new String[0][3];
		JTable listBook = new JTable(table, OUTPUT_BOOK_COLUMN);
		
		outputPanel.add(listBook, BorderLayout.CENTER);*/

		JPanel southPanel = new JPanel(new GridLayout(2, 2));
		String possibility = "70%";
		southPanel.add(new Label(OUTPUT_POSSIBILITY));
		southPanel.add(new Label(possibility));

		again = new JButton(OUTPUT_AGAIN);
		again.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				outputClickAgain();
			}
		});
		southPanel.add(again);

		exit = new JButton(OUPUT_EXIT);
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				main.dispose();
			}
		});
		southPanel.add(exit);
		outputPanel.add(southPanel, BorderLayout.SOUTH);
                
                
		cp = getContentPane();
                cp.add(lbHeader);
		cp.setLayout(new FlowLayout());
		cp.add(inputPanel);
		cp.add(outputPanel);
		outputPanel.setVisible(false);
		pack();
		setTitle(TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void inputClickNext() {
		int scoreReading = Integer.parseInt(currentRead.getText());
		int scoreWriting = Integer.parseInt(currentListen.getText());
		int scoreSum = scoreReading + scoreWriting;
                
		try {
			Level levelReading = RuleCreateLevel.getRuleByScore(scoreReading, RuleCreateLevel.TYPE_READING).getLevel();
			Level levelWriting = RuleCreateLevel.getRuleByScore(scoreWriting, RuleCreateLevel.TYPE_LISTENING).getLevel();
			Level levelSum = RuleCreateLevel.getRuleByScore(scoreSum, RuleCreateLevel.TYPE_SUM).getLevel();
			Level levelTarget = RuleCreateLevel.getRuleByScore(Integer.parseInt(targetLever.getText()), RuleCreateLevel.TYPE_SUM).getLevel();
			Level targetReading = levelTarget.getReadingLevel();
			Level targetWriting = levelTarget.getWritingLevel();
			List<Book> books = Rule.getBooks(levelSum, levelTarget);
			books.addAll(Rule.getBooks(levelReading, targetReading));
			books.addAll(Rule.getBooks(levelWriting, targetWriting));
			for (Book book : books) 
				book.loadData();
			JTable listBook = new JTable(Book.createBookTable(books), OUTPUT_BOOK_COLUMN);
			outputPanel.add(listBook, BorderLayout.CENTER);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inputPanel.setVisible(false);
		outputPanel.setVisible(true);
		pack();
	}

	public void outputClickAgain() {
		outputPanel.setVisible(false);
		inputPanel.setVisible(true);
		cp.add(inputPanel);
		pack();
	}

}
