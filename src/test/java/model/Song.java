package model;

/**
 * Created by germanium on 06.12.17.
 */
public class Song {

    private final String author;
    private final String name;

    public Song(String author, String name) {
        this.author = author;
        this.name = name;
    }


    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }


}
