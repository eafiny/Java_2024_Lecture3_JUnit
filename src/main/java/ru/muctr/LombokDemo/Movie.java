package ru.muctr.LombokDemo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movie implements Comparable<Movie>{
    private String title;
    private String producer;

    @Override
    public int compareTo(Movie o) {
        return getTitle().compareToIgnoreCase(o.getTitle());
    }
}


