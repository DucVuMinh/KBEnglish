package hust.kb.kbenglish.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RuleCreateLevel {
	private int idRule;
	private int minScore;
	private int maxScore;
	private Level level;
	private String explain;
	private int typeRole;

	public static RuleCreateLevel getRuleByScore(int score) throws SQLException {
		RuleCreateLevel rule = new RuleCreateLevel();
		Statement sm = ConnectDBService.getStatement();
		ResultSet rs = sm.executeQuery(
				"SELECT * FROM `rule_create_level` WHERE min_score < " + score + " and max_score > " + score + " ;");
		if (rs.first()) {
			rule.idRule = rs.getInt("idrule");
			rule.minScore = rs.getInt("min_score");
			rule.maxScore = rs.getInt("max_score");
			Level level = new Level();
			level.setIdLevel(rs.getInt("level"));
			rule.level = level;
			
		}
		return rule;
	}
}
