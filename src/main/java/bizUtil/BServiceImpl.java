package bizUtil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import vo.BoardVo;
import vo.PageVO;

@Service("bservice")
public class BServiceImpl implements BService {

	@Autowired
	@Qualifier("bdao")
	private BoardDao bDAO;

	public BServiceImpl() {
		System.out.println("BoardService »ý¼ºÀÚ");
	}

	@Override
	public List<BoardVo> getBoardList() {
		// TODO Auto-generated method stub
		return bDAO.getBoardList();
	}

	@Override
	public BoardVo getBoard(BoardVo bvo) {
		// TODO Auto-generated method stub
		return bDAO.getBoard(bvo);
	}

	@Override
	public int mInert(BoardVo bvo) {
		// TODO Auto-generated method stub
		return bDAO.mInert(bvo);
	}

	@Override
	public int mUpdate(BoardVo bvo) {
		// TODO Auto-generated method stub
		return bDAO.mUpdate(bvo);
	}

	@Override
	public int mDelete(BoardVo bvo) {
		// TODO Auto-generated method stub
		return bDAO.mDelete(bvo);
	}

	@Override
	public int viewCount(BoardVo bvo) {
		// TODO Auto-generated method stub
		return bDAO.viewCount(bvo);
	}

	@Override
	public int InsertReply(BoardVo bvo) {
		// TODO Auto-generated method stub
		return bDAO.InsertReply(bvo);
	}

	@Override
	public PageVO pagingList(int cPage) {
		// TODO Auto-generated method stub
		return bDAO.pagingList(cPage);
	}

	@Override
	public int totalCount() {
		// TODO Auto-generated method stub
		return bDAO.totalCount();
	}
}
