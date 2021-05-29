package com.aurelius.modularmonolithdemo.authors.connectors.events.book.payload;

public class AddBookToAuthorPayload {
    private String bookName;
    private String authorId;

    public String getBookName() {
        return bookName;
    }

    public AddBookToAuthorPayload setBookName(String bookName) {
        this.bookName = bookName;
        return this;
    }

    public String getAuthorId() {
        return authorId;
    }

    public AddBookToAuthorPayload setAuthorId(String authorId) {
        this.authorId = authorId;
        return this;
    }
}
