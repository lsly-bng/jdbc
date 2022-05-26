package com.javaex.ex04;

import java.util.List;

public class BookApp {

	public static void main(String[] args) {

		BookDao bookDao = new BookDao();

		BookVo vo01 = new BookVo("우리들의 일그러진 영웅", "다림", "22-FEB-1998", 1);
		BookVo vo02 = new BookVo("삼국지", "민음사", "01-MAR-2002", 1);
		BookVo vo03 = new BookVo("토지", "마로니에북스", "15-AUG-2012", 2);
		BookVo vo04 = new BookVo("자바프로그래밍 입문", "위키북스", "01-APR-2015", 3);
		BookVo vo05 = new BookVo("패션왕", "중앙북스(books)", "22-FEB-2012", 4);
		BookVo vo06 = new BookVo("순정만화", "재미주의", "03-AUG-2011", 5);
		BookVo vo07 = new BookVo("오직두사람", "문학동네", "04-MAY-2017", 6);
		BookVo vo08 = new BookVo("26년", "재미주의", "04-FEB-2012", 5);
		BookVo vo09 = new BookVo("상실의시대", "문학사상사", "20-JUL-2010", 7);

		bookDao.bookInsert(vo01);
		bookDao.bookInsert(vo02);
		bookDao.bookInsert(vo03);
		bookDao.bookInsert(vo04);
		bookDao.bookInsert(vo05);
		bookDao.bookInsert(vo06);
		bookDao.bookInsert(vo07);
		bookDao.bookInsert(vo08);
		bookDao.bookInsert(vo09);

		/*
		 * bookDao.bookDelete(6);
		 */

		BookVo uVo = new BookVo("1Q84", "문학동네", "25-AUG-2009", 7, 4);
		bookDao.bookUpdate(uVo);

		List<BookVo> bookList = bookDao.bookSelect();
		for (int i = 0; i < bookList.size(); i++) {

			/*
			 * int bookId = bookList.get(i).getBookId(); String title =
			 * bookList.get(i).getTitle(); String publ = bookList.get(i).getPubl(); String
			 * publDate = bookList.get(i).getPublDate(); String authorName =
			 * bookList.get(i).getAuthorName();
			 * 
			 * System.out.println(bookId + "," + title + "," + publ + "," + publDate + "," +
			 * authorName);
			 */

			BookVo bookVo = bookList.get(i);
			System.out.println(bookVo.getBookId() + "," + bookVo.getTitle() + "," + bookVo.getPubl() + ","
					+ bookVo.getPublDate() + "," + bookVo.getAuthorName());

			/*
			 * System.out.println(bookList.get(i).getBookId() + "," +
			 * bookList.get(i).getTitle() + "," + bookList.get(i).getPubl() + "," +
			 * bookList.get(i).getPublDate() + "," + bookList.get(i).getAuthorName());
			 */
		}
	}
}
