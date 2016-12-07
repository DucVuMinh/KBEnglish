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
	public static int TYPE_SUM = 1;
	public static int TYPE_READING = 2;
	public static int TYPE_LISTENING = 3;

	public static RuleCreateLevel getRuleByScore(int score, int typeRole) throws SQLException {
		RuleCreateLevel rule = new RuleCreateLevel();
		Statement sm = ConnectDBService.getStatement();
		ResultSet rs = sm.executeQuery(
				"SELECT * FROM `rule_create_level` WHERE min_score < " + score + " and max_score > " + score + " and type_role = " + typeRole + ";");
		if (rs.first()) {
			rule.idRule = rs.getInt("idrule");
			rule.minScore = rs.getInt("min_score");
			rule.maxScore = rs.getInt("max_score");
			Level level = new Level();
			level.setIdLevel(rs.getInt("level"));
			rule.level = level;
			rule.typeRole = typeRole;
		}
		return rule;
	}
	
	public Level getLevel() {
		return level;
	}
}
