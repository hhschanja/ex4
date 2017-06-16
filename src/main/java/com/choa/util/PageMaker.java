package com.choa.util;

public class PageMaker {

	private int perPage;
	private int perBlock;
	private int curPage;
	private PageResult pageResult;
	private RowMaker rowMaker;
	
	public PageMaker(int curPage) {
		this(10, curPage);
	}
	public PageMaker(int perPage, int curPage) {
		this(perPage, 5, curPage);
	}
	public PageMaker(int perPage, int perBlock, int curPage){
		this.perPage=perPage;
		this.perBlock=perBlock;
		this.curPage=curPage;
	}
	public PageResult getMakePage(int totalCount) {
		PageResult pageResult = new PageResult();
		pageResult.pageResult(totalCount, curPage, perPage, perBlock);
		return pageResult;
	}
	public RowMaker getRowMaker(String kind, String search) {
		RowMaker rowMaker = new RowMaker();
		rowMaker.setRow(curPage, perPage);
		rowMaker.setKind(kind);
		rowMaker.setSearch(search);
		return rowMaker;
	}
	
}
