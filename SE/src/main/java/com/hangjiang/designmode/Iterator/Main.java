package com.hangjiang.designmode.Iterator;

/**
 * Created by jianghang on 2017/12/24.
 * 迭代器模式
 */
public class Main {
    public static void main(String[] args){
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("Around"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinderella"));
        bookShelf.appendBook(new Book("Daddy"));
        bookShelf.appendBook(new Book("Ekkk"));

        Iterator iterator = bookShelf.iterator();
        while (iterator.hasNext()){
            Book book = (Book) iterator.next();
            System.out.println(book.getName());
        }
    }
}
