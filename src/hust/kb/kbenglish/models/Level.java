/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.kb.kbenglish.models;

/**
 *
 * @author DucVu
 */
public class Level {
    private int idLevel;
    private String namelevel;
    private String scoreDescription;

    public Level() {
    }

    public Level(int idLevel, String namelevel, String scoreDescription) {
        this.idLevel = idLevel;
        this.namelevel = namelevel;
        this.scoreDescription = scoreDescription;
    }

    public int getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(int idLevel) {
        this.idLevel = idLevel;
    }

    public String getNamelevel() {
        return namelevel;
    }

    public void setNamelevel(String namelevel) {
        this.namelevel = namelevel;
    }

    public String getScoreDescription() {
        return scoreDescription;
    }

    public void setScoreDescription(String scoreDescription) {
        this.scoreDescription = scoreDescription;
    }
    public static Level getLevelById(int id){
        return null;
    }
}
