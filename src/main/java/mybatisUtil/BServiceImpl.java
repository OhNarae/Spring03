package mybatisUtil;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import vo.BoardVo;
import vo.PageMVO;
import vo.PageVO;

@Service
public class BServiceImpl implements BService {

	@Inject
	private SqlSession sqlSession;

	private static final String namespace ="board";
	
	public BServiceImpl() {
		System.out.println("BoardService »ý¼ºÀÚ");
	}

	@Override
	public List<BoardVo> getBoardList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".getBoardList");
	}
	
	@Override
	public BoardVo getBoard(BoardVo bvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".getBoard", bvo);
	}

	@Override
	public int viewCount(BoardVo bvo) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+".viewCount", bvo);
	}
	
	@Override
	public int mInert(BoardVo bvo) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace+".insert", bvo);
	}

	@Override
	public int mUpdate(BoardVo bvo) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+".update", bvo);
	}

	@Override
	public int mDelete(BoardVo bvo) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace+".delete", bvo);
	}



	@Override
	public int InsertReply(BoardVo bvo) {
		sqlSession.update(namespace+".stepUpdate", bvo);
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace+".insertReply", bvo);
	}

	@Override
	public PageVO pagingList(int cPage) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".pagingList", cPage);
	}

	@Override
	public int totalCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".totalCount");
	}
	
	@Override
	public List<BoardVo> getPageList(PageMVO pvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".getPageList", pvo);
	}
}
