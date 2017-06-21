package com.choa.util;

public class ListInfo {
	
	private Integer curPage; //null이 올 수도 있으니 Integer
	private String search;
	private String kind;
	private Integer perPage;
	private int startRow;
	private int lastRow;
	private int curBlock;
	private int totalBlock;
	private int startNum;
	private int lastNum;
	
	public int getCurBlock() {
		return curBlock;
	}
	public int getTotalBlock() {
		return totalBlock;
	}
	public int getStartNum() {
		return startNum;
	}
	public int getLastNum() {
		return lastNum;
	}
	public int getStartRow() {
		return startRow;
	}
	public int getLastRow() {
		return lastRow;
	}
	public Integer getPerPage() {
		if(perPage==null){
			perPage=10;
		}
		return perPage;
	}
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	public Integer getCurPage() { //여기서 null처리를 해주는거야
		if(curPage==null){
			curPage = 1;
		}
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public String getSearch() {
		return "%"+search+"%";
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public void setRow(){
		startRow = (this.getCurPage() - 1) * this.getPerPage() + 1; //미리 받아온 놈으로 계산을 할건데 null이 올수도 있으니...
		lastRow = this.getCurPage() * this.getPerPage();
	}
	
	public void pageResult(int totalCount){
		//1. totalPage구하기
		
		int totalPage=0;
		int perBlock=5;
		
		if(totalCount%this.getPerPage()==0){
			totalPage = totalCount/this.getPerPage();
		}else {
			totalPage = totalCount/this.getPerPage()+1;
		}
		//2.totalBlock
		if(totalPage%perBlock==0){
			this.totalBlock = totalPage/perBlock;
		}else {
			this.totalBlock = totalPage/perBlock+1;
		}
		//3.curBlock
		if(this.getCurPage()%perBlock==0){
			this.curBlock = this.getCurPage()/perBlock;
		}else {
			this.curBlock = this.getCurPage()/perBlock+1;
		}
		//4.startnum, lastnum
		this.startNum = (this.curBlock-1)*perBlock+1;
		this.lastNum = this.curBlock*perBlock;
		//
		if(this.curBlock==this.totalBlock){
			this.lastNum=totalPage;
		}
		
	}
	
	
}
