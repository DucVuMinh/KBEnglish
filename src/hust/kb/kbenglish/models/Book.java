package hust.kb.kbenglish.models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DucVu
 */
public class Book {
    private int idBook;
    private String namebook;
    private int typeBook;
    private int timeneed;
    private Level levelOfBook;
    

    public Book(int idBook, String namebook, int typeBook, int timeneed) {
        this.idBook = idBook;
        this.namebook = namebook;
        this.typeBook = typeBook;
        this.timeneed = timeneed;
    }

    public Book() {
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getNamebook() {
        return namebook;
    }

    public void setNamebook(String namebook) {
        this.namebook = namebook;
    }

    public int getTypeBook() {
        return typeBook;
    }

    public void setTypeBook(int typeBook) {
        this.typeBook = typeBook;
    }

    public int getTimeneed() {
        return timeneed;
    }

    public void setTimeneed(int timeneed) {
        this.timeneed = timeneed;
    }

    public Level getLevelOfBook() {
        return levelOfBook;
    }

    public void setLevelOfBook(Level levelOfBook) {
        this.levelOfBook = levelOfBook;
    }
    
    /**
     * Add object to database
     * return id object
     */
    
    public int add(){
        return 0;
    }
    /**
     * delete object from data base
     * @return number row delete
     */
    public int delete(){
        return 0;
    }
    /**
     * 
     */
    public static Book getBookById(){
        
        return null;
    }
    
}
