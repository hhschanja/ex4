package com.choa.util;

public class RowMaker {
	private int startRow;
	private int lastRow;
	
	public void setRow(int curPage, int perPage){
		startRow = (curPage - 1) * perPage + 1;
		lastRow = curPage * perPage;
	}
	
	
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getLastRow() {
		return lastRow;
	}
	public void setLastRow(int lastRow) {
		this.lastRow = lastRow;
	}
	
}
