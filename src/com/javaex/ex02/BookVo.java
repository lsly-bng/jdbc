package com.javaex.ex02;

public class BookVo {

	// field
	private int bookId;
	private String title;
	private String publ;
	private String publDate;
	private int authorId;
	private String authorName;
	private String authorDesc;

	// constructor
	public BookVo() {
	}

	public BookVo(int bookId) {
		this.bookId = bookId;
	}

	public BookVo(int bookId, String title) {
		this.bookId = bookId;
		this.title = title;
	}

	public BookVo(int bookId, String title, String publ) {
		this.bookId = bookId;
		this.title = title;
		this.publ = publ;
	}

	public BookVo(int bookId, String title, String publ, String publDate) {
		this.bookId = bookId;
		this.title = title;
		this.publ = publ;
		this.publDate = publDate;
	}

	public BookVo(int bookId, String title, String publ, String publDate, int authorId) {
		this.bookId = bookId;
		this.title = title;
		this.publ = publ;
		this.publDate = publDate;
		this.authorId = authorId;
	}

	//
	public BookVo(int bookId, String title, String publ, String publDate, String authorName) {
		this.bookId = bookId;
		this.title = title;
		this.publ = publ;
		this.publDate = publDate;
		this.authorName = authorName;
	}

	public BookVo(int bookId, String title, String publ, String publDate, int authorId, String authorName,
			String authorDesc) {
		this.bookId = bookId;
		this.title = title;
		this.publ = publ;
		this.publDate = publDate;
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorDesc = authorDesc;
	}

	// method - g/s
	public int getBookId() {
		return bookId;
	}

	public String getTitle() {
		return title;
	}

	public String getPubl() {
		return publ;
	}

	public String getPublDate() {
		return publDate;
	}

	public int getAuthorId() {
		return authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public String getAuthorDesc() {
		return authorDesc;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPubl(String publ) {
		this.publ = publ;
	}

	public void setPublDate(String publDate) {
		this.publDate = publDate;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public void setAuthorDesc(String authorDesc) {
		this.authorDesc = authorDesc;
	}

	// method - general
	@Override
	public String toString() {
		return "BookVo [bookId=" + bookId + ", title=" + title + ", publ=" + publ + ", publDate=" + publDate
				+ ", authorId=" + authorId + ", authorName=" + authorName + ", authorDesc=" + authorDesc + "]";
	}
}
