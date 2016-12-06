/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.kb.kbenglish.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author DucVu
 */
public class Level {

    private int idLevel;
    private String namelevel;
    private String scoreDescription;
    private static String queryGetLevelById = "SELECT * FROM knowledgebasedsystem.level where id=?";

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

    public static Level getLevelById(int id) {
        Connection cn = ConnectDBService.getConnection();
        try {
            PreparedStatement pstmt
                    = cn.prepareStatement(queryGetLevelById);
            //set id for select sql java
            pstmt.setInt(1, id);
            ResultSet rs=pstmt.executeQuery();
            if(!rs.first()){
                return null;
            }else{
                return new Level(rs.getInt("id"), rs.getString("namelevel"), rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return null;
    }
//    public static void main(String args[]){
//        Level temp=getLevelById(1);
//        System.out.println(temp.getNamelevel());
//    }
}
