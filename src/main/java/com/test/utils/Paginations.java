package com.test.utils;

public class Paginations {
	int totalCount; //게시물 총 갯수
	int currentPage; //현재 페이지 
	int postSize = 5;   //표시 할 게시물 수
	int totalPage; //총 페이지 수
	int currentBlock;  //현재 블럭 
	int totalBlockSize; //총 블럭 수
	
	boolean prevBtn = true; //이전 게시물 버튼
	boolean nextBtn = true; // 다음 게시물 버튼
	
	
	public void calTotalPage(int totalCount,int postSize) {
		int calPage = totalCount % postSize;
		if (calPage == 0) {
			setTotalPage(calPage);
		}else {
			setTotalPage((int)Math.ceil(calPage));
		}
	}
	
	public void calTotalBlock(int totalPage,int pageSize) {
		int calBlock = totalPage % pageSize;
		if(calBlock == 0) {
			setTotalBlockSize(calBlock);
		} else {
			setTotalBlockSize((int)Math.ceil(calBlock));
		}
	}
	
	public void calBtn(int currentBlock) {
		if(currentBlock == 1) {
			setPrevBtn(false);
			setNextBtn(true);
		}else if(currentBlock == getTotalBlockSize()) {
			setPrevBtn(true);
			setNextBtn(false);
		}else {
			setPrevBtn(true);
			setNextBtn(true);
		}
	}
	
	
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPostSize() {
		return postSize;
	}
	public void setPostSize(int postSize) {
		this.postSize = postSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentBlock() {
		return currentBlock;
	}
	public void setCurrentBlock(int pageSize ,int currentPage) {
		System.out.println((int)Math.ceil(currentPage/pageSize)+1);
		this.currentBlock = (int)Math.ceil(currentPage/pageSize)+1;
	}
	public int getTotalBlockSize() {
		return totalBlockSize;
	}
	public void setTotalBlockSize(int totalBlockSize) {
		this.totalBlockSize = totalBlockSize;
	}
	public boolean isPrevBtn() {
		return prevBtn;
	}
	public void setPrevBtn(boolean prevBtn) {
		this.prevBtn = prevBtn;
	}
	public boolean isNextBtn() {
		return nextBtn;
	}
	public void setNextBtn(boolean nextBtn) {
		this.nextBtn = nextBtn;
	}
	
	
	
	
	
}
