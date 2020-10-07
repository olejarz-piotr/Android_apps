package com.example.mylibrary;

import java.util.ArrayList;

public class Util {

    private static ArrayList<Book>allBooks;
    private static ArrayList<Book>currentlyReadingBooks;
    private static ArrayList<Book>wantToReadBooks;
    private static ArrayList<Book>alreadyReadBooks;
    private static int id=0;

    public Util() {
        if(allBooks==null){
            allBooks=new ArrayList<>();
            initAllBooks();
        }

        if (currentlyReadingBooks==null){
            currentlyReadingBooks=new ArrayList<>();
        }

        if(wantToReadBooks==null){
            wantToReadBooks=new ArrayList<>();
        }

        if (alreadyReadBooks==null){
            alreadyReadBooks=new ArrayList<>();
        }

    }



    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public boolean addCurrentlyReadingBook(Book book){
    return currentlyReadingBooks.add(book);
    }

    public boolean addWantToReadBook(Book book){
        return wantToReadBooks.add(book);
    }
    public boolean addAlreadyReadBook(Book book){
        return alreadyReadBooks.add(book);
    }

    public boolean removeCurrentlyReadingBook(Book book){
        return currentlyReadingBooks.remove(book);
    }
    public boolean removeWanttoReadBook(Book book){
        return wantToReadBooks.remove(book);
    }
    public boolean removeAlreadyReadBook(Book book){
        return alreadyReadBooks.remove(book);
    }



    private static void initAllBooks(){

        //TODO: initialize all books array list

        String name="";
        String author = "";
        int pages=0;
        String imageUrl="";
        String description="";

        id++;
        name="Pride and Prejudice";
        author="Jane Austen";
        pages=279;
        imageUrl="https://images-na.ssl-images-amazon.com/images/I/41fCKej5blL._SX331_BO1,204,203,200_.jpg";
        description = " is a romantic novel of manners written by Jane Austen in 1813. The novel follows the character development of Elizabeth Bennet, the dynamic protagonist of the book who learns about the repercussions of hasty judgments and comes to appreciate the difference between superficial goodness and actual goodness. Its humour lies in its honest depiction of manners, education, marriage, and money during the Regency era in Great Britain.";
        allBooks.add(new Book(id,name,author,pages,imageUrl,description));


        id++;
        name = "1984";
        author = "George Orwell";
        pages = 237;
        imageUrl="https://www.bookoff.pl/pol_pl_1984-by-George-Orwell-106309_1.jpg";
        description = "A Novel, often published as 1984, is a dystopian novel by English novelist George Orwell. It was published in June 1949 by Secker & Warburg as Orwell's ninth and final book completed in his lifetime. The story was mostly written at Barnhill, a farmhouse on the Scottish island of Jura, at times while Orwell suffered from severe tuberculosis";
        allBooks.add(new Book(id,name,author,pages,imageUrl,description));


        id++;
        name = "The Night Watchman";
        author="Louise Erdrich";
        pages=464;
        imageUrl ="https://images-na.ssl-images-amazon.com/images/I/41r3ymNjZ3L._SX329_BO1,204,203,200_.jpg";
description="Based on the extraordinary life of National Book Award-winning author Louise Erdrich’s  grandfather who worked as a night watchman and carried the fight against Native dispossession from rural North Dakota all the way to Washington, D.C., this powerful novel explores themes of love and death with lightness and gravity and unfolds with the elegant prose, sly humor, and depth of feeling of a master craftsman.";
        allBooks.add(new Book(id,name,author,pages,imageUrl,description));


        id++;
        name="Every Drop of Blood: The Momentous Second Inauguration of Abraham Lincoln";
        author="Edward Achorn";
        pages=532;
        imageUrl="https://images-na.ssl-images-amazon.com/images/I/415uaaziW-L.jpg";
        description="A brilliantly conceived and vividly drawn story—Washington, D.C. on the eve of Abraham Lincoln’s historic second inaugural address as the lens through which to understand all the complexities of the Civil War";
        allBooks.add(new Book(id,name,author,pages,imageUrl,description));


        id++;
        name="The Guardians: A Novel";
        author="John Grisham";
        pages=371;
        imageUrl="https://images-na.ssl-images-amazon.com/images/I/51U2hIUQgqL.jpg";
        description="In this instant #1 New York Times bestseller, John Grisham delivers a classic legal thriller—with a twist.\n" +
                "\n" +
                "“Terrific…affecting…Grisham has done it again.”—Maureen Corrigan, The Washington Post\n" +
                " \n" +
                "“A suspenseful thriller mixed with powerful themes.”—Associated Press\n";

        allBooks.add(new Book(id,name,author,pages,imageUrl,description));

        id++;
        name="Bad Blood";
        author="M. Malone";
        pages=226;
        imageUrl="https://images-na.ssl-images-amazon.com/images/I/41juuCgQq3L._SX326_BO1,204,203,200_.jpg";
        description="Georgina Kingsley is off-limits. It’s better this way, really. Her brother is my best friend and business partner, the closest thing I have to family. Plus, she’s engaged to another man, one better for her than I could ever be.";
        allBooks.add(new Book(id,name,author,pages,imageUrl,description));


        id++;
        name="The Girl on the Train";
        author="Paula Hawkins";
        pages=336;
        imageUrl="https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1574805682l/22557272.jpg";
        description="Rachel catches the same commuter train every morning. She knows it will wait at the same signal each time, overlooking a row of back gardens. She’s even started to feel like she knows the people who live in one of the houses. “Jess and Jason,” she calls them. Their life—as she sees it—is perfect. If only Rachel could be that happy. And then she sees something shocking. It’s only a minute until the train moves on, but it’s enough. Now everything’s changed. Now Rachel has a chance to become a part of the lives she’s only watched from afar. Now they’ll see; she’s much more than just the girl on the train...";
        allBooks.add(new Book(id,name,author,pages,imageUrl,description));


        id++;
        name="Gone Girl";
        author="Gillian Flynn";
        pages=415;
        imageUrl="https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1554086139l/19288043.jpg";
        description="On a warm summer morning in North Carthage, Missouri, it is Nick and Amy Dunne’s fifth wedding anniversary. Presents are being wrapped and reservations are being made when Nick’s clever and beautiful wife disappears from their rented McMansion on the Mississippi River. Husband-of-the-Year Nick isn’t doing himself any favors with cringe-worthy daydreams about the slope and shape of his wife’s head, but passages from Amy's diary reveal the alpha-girl perfectionist could have put anyone dangerously on edge";
        allBooks.add(new Book(id,name,author,pages,imageUrl,description));




    }

}
