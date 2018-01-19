package mybatisUtil;

import java.util.List;

import vo.BoardVo;
import vo.PageMVO;
import vo.PageVO;

public interface BService {

	List<BoardVo> getBoardList();

	BoardVo getBoard(BoardVo bvo);

	int mInert(BoardVo bvo);

	//수정필요함
	int mUpdate(BoardVo bvo);

	int mDelete(BoardVo bvo);

	int viewCount(BoardVo bvo);
	
	int InsertReply(BoardVo bvo);

	PageVO pagingList(int cPage);
	
	int totalCount();
	
	List<BoardVo> getPageList(PageMVO pvo);
}