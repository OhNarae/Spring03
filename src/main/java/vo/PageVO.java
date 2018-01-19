package vo;

import java.util.List;

public class PageVO {

	private List<BoardVo> list; // ��ϸ���Ʈ ����
	private int curPage; // ���� ��������ȣ
	private int perPage = 5; // �������� ������ ����
	private int totalCount; // ��ü ���ڵ尹��

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
