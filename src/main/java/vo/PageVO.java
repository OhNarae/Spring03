package vo;

import java.util.List;

public class PageVO {

	private List<BoardVo> list; // 목록리스트 저장
	private int curPage; // 현재 페이지번호
	private int perPage = 5; // 페이지당 보여줄 갯수
	private int totalCount; // 전체 레코드갯수

	@Override
	public String toString() {
		return "PageVO [list=" + list + ", curPage=" + curPage + ", perPage=" + perPage + ", totalCount=" + totalCount
				+ "]";
	}

	public List<BoardVo> getList() {
		return list;
	}

	public void setList(List<BoardVo> list) {
		this.list = list;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

}
