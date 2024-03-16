package ru.muctr.LombokDemo;

/**
 * @author Evgenia Skichko
 */
public class MovieDemo {
    public static void main(String[] args) {
        Movie movie1 = new Movie("matrix","Vachovski");
        Movie movie2 = new Movie("matrix","Vachovski");
        System.out.println(movie1.equals(movie2));
    }
}
