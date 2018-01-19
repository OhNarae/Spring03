package mybatisUtil;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import vo.MemberVO;
import vo.UserVO;

@Service
public class MServiceImpl implements MService {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace ="member";

	public MServiceImpl() {
		System.out.println("MServiceImpl »ý¼ºÀÚ");
	}
	
	/* (non-Javadoc)
	 * @see mService.MService#getMemberList()
	 */
	@Override
	public List<MemberVO> getMemberList() {
		return sqlSession.selectList(namespace+".memberList");
	}

	/* (non-Javadoc)
	 * @see mService.MService#getMember(vo.MemberVO)
	 */
	@Override
	public MemberVO getMember(MemberVO mvo) {
		return sqlSession.selectOne(namespace+".getMember", mvo);
	}

	/* (non-Javadoc)
	 * @see mService.MService#loginCheck(vo.UserVO)
	 */
	@Override
	public UserVO loginCheck(UserVO uvo) {
		return sqlSession.selectOne(namespace+".loginCheck", uvo);
	}

	/* (non-Javadoc)
	 * @see mService.MService#mInert(vo.MemberVO)
	 */
	@Override
	public int mInert(MemberVO mvo) {
		return sqlSession.insert(namespace+".mInert", mvo);
	}

	/* (non-Javadoc)
	 * @see mService.MService#mUpdate(vo.MemberVO)
	 */
	@Override
	public int mUpdate(MemberVO mvo) {
		return sqlSession.insert(namespace+".mUpdate", mvo);
	}

	/* (non-Javadoc)
	 * @see mService.MService#mDelete(vo.UserVO)
	 */
	@Override
	public int mDelete(UserVO uvo) {
		return sqlSession.insert(namespace+".mDelete", uvo);
	}

	@Override
	public int idCheck(MemberVO mvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".idCheck", mvo);
	}
}
