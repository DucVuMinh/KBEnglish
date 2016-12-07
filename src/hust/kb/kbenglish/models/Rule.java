package hust.kb.kbenglish.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Rule {
	private int idRule;
	private Level currentLevel;
	private Level goalLevel;
	private Book bookNeed;

	public static List<Book> getBooks(Level currentLevel, Level goalLevel) throws SQLException {
		List<Book> books = new ArrayList<Book>();
		Statement sm = ConnectDBService.getStatement();
		while (!currentLevel.greatThan(goalLevel)) {
			ResultSet rs = sm.executeQuery("SELECT * FROM `rule` WHERE current_level = " + currentLevel.getIdLevel() + ";");
			if(rs.first()) {
				Book book = new Book();
				book.setIdBook(rs.getInt("book_need"));
				books.add(book);
				currentLevel.setIdLevel(rs.getInt("goal_level"));
				while (rs.next()) {
					Book bookNext = new Book();
					bookNext.setIdBook(rs.getInt("book_need"));
					books.add(bookNext);
				}
				
			};
		}
		return books;

	}
}