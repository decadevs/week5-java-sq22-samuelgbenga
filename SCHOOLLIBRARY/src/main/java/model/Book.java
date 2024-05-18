package model;

public record Book(String title, String author, int isbn) {
    @Override
    public String toString(){
        return (title+","+author+","+isbn);
    }
}

