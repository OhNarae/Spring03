package bizUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import vo.BoardVo;
import vo.PageVO;

@Repository("bdao")
public class BoardDao{
	private Connection CN;
	private PreparedStatement PST;
	private ResultSet RS;
	
	public List<BoardVo> getBoardList(){
		List<BoardVo> mlist = null;

		String sql = "select * from board order by root desc, step asc"; // All 출력위해 >= 사용
		try {
			CN = JDBCUtil.getConnection();
			PST = CN.prepareStatement(sql);
			RS = PST.executeQuery();
			if (RS.next()) {
				mlist = new ArrayList<>();
				do {
					BoardVo boardVo = new BoardVo();
					boardVo.setSeq(RS.getInt("seq"));
					boardVo.setTitle(RS.getString("title"));
					boardVo.setWriter(RS.getString("writer"));
					boardVo.setContent(RS.getString("content"));
					boardVo.setRegdate(RS.getString("regdate"));
					boardVo.setCnt(RS.getInt("cnt"));
					boardVo.setRoot(RS.getInt("root"));
					boardVo.setIndent(RS.getInt("indent"));

					mlist.add(boardVo);
				} while (RS.next());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally { JDBCUtil.close(RS,  PST, CN); }

		return mlist;
	}
	
	public BoardVo getBoard(BoardVo bvo) {
		BoardVo boardVo = null;

		String sql = "select * from board where seq = ?"; // All 출력위해 >= 사용
		try {
			CN = JDBCUtil.getConnection();
			PST = CN.prepareStatement(sql);
			PST.setInt(1, bvo.getSeq());
			
			RS = PST.executeQuery();
			if (RS.next()) {				
				boardVo = new BoardVo();
				boardVo.setSeq(RS.getInt("seq"));
				boardVo.setTitle(RS.getString("title"));
				boardVo.setWriter(RS.getString("writer"));
				boardVo.setContent(RS.getString("content"));
				boardVo.setRegdate(RS.getString("regdate"));
				boardVo.setCnt(RS.getInt("cnt"));
				boardVo.setRoot(RS.getInt("root"));
				boardVo.setStep(RS.getInt("step"));
				boardVo.setIndent(RS.getInt("indent"));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally { JDBCUtil.close(RS,  PST, CN); }

		return boardVo;
	}
	
	public int viewCount(BoardVo bvo) {
		int cnt = 0;

		String sql = "update board set cnt = cnt + 1 where seq = ?";
		try {
			CN = JDBCUtil.getConnection();
			PST = CN.prepareStatement(sql);
			PST.setInt(1, bvo.getSeq());
			
			cnt = PST.executeUpdate();
			if (cnt > 0) {
				System.out.println("*** cnt 수정이 성공하였습니다. ");
			} else {
				System.out.println("*** cnt 수정된 자료가 없습니다. ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(PST, CN);
		}

		return cnt;
	}
	
	public int mInert(BoardVo bvo) {
		int cnt = 0;
		
		String sql = "insert into board values((select nvl(max(seq), 0)+1 from board), ?, ?, ?, sysdate, 0"
				+ ", (select nvl(max(seq), 0)+1 from board), 0, 0)";
		try {
			CN = JDBCUtil.getConnection();
			PST = CN.prepareStatement(sql);
			PST.setString(1, bvo.getTitle());
			PST.setString(2, bvo.getWriter());
			PST.setString(3, bvo.getContent());

			cnt = PST.executeUpdate();
			if (cnt > 0) {
				System.out.println(cnt + "개의 자료가 저장되었습니다. ");
			} else {
				System.out.println("*** 저장된 자료가 없습니다. ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(PST, CN);
		}

		return cnt;
	}

	public int mUpdate(BoardVo bvo) {
		int cnt = 0;

		String sql = "update board set title = ?, writer = ?, content = ?, regdate = ?, cnt = ? where seq = ?";
		try {
			CN = JDBCUtil.getConnection();
			PST = CN.prepareStatement(sql);
			PST.setString(1, bvo.getTitle());
			PST.setString(2, bvo.getWriter());
			PST.setString(3, bvo.getContent());
			PST.setString(4, bvo.getRegdate());			
			PST.setInt(5, bvo.getCnt());
			PST.setInt(6, bvo.getSeq());
			
			cnt = PST.executeUpdate();
			if (cnt > 0) {
				System.out.println("*** 수정이 성공하였습니다. ");
			} else {
				System.out.println("*** 수정된 자료가 없습니다. ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(PST, CN);
		}

		return cnt;
	}

	public int mDelete(BoardVo bvo) {
		int cnt = 0;
		
		String sql = "delete board where root = ?";
		try {
			CN = JDBCUtil.getConnection();
			PST = CN.prepareStatement(sql);
			PST.setInt(1, bvo.getSeq());

			cnt = PST.executeUpdate();
			if (cnt > 0) {
				System.out.println("*** 삭제가 성공하였습니다. ");
			} else {
				System.out.println("*** 삭제된 자료가 없습니다. ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(PST, CN);
		}

		return cnt;
	}
	
	private void stepUpdate(BoardVo bvo) {
		int cnt = 0;
		
		String sql = "update board set step = step+1 where root = ? and step >= ?";
		try {
			CN = JDBCUtil.getConnection();
			PST = CN.prepareStatement(sql);
			PST.setInt(1, bvo.getRoot());
			PST.setInt(2, bvo.getStep());
			
			cnt = PST.executeUpdate();
			if (cnt > 0) {
				System.out.println("*** 수정이 성공하였습니다. ");
			} else {
				System.out.println("*** 수정된 자료가 없습니다. ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(PST, CN);
		}
	}
	
	public int InsertReply(BoardVo bvo) {
		int cnt = 0;
		
		stepUpdate(bvo);
		String sql = "insert into board values((select nvl(max(seq), 0)+1 from board), ?, ?, ?, sysdate, 0, ?, ?, ?)";
		
		try {
			CN = JDBCUtil.getConnection();
			PST = CN.prepareStatement(sql);
			PST.setString(1, bvo.getTitle());
			PST.setString(2, bvo.getWriter());
			PST.setString(3, bvo.getContent());
			PST.setInt(4, bvo.getRoot());
			PST.setInt(5, bvo.getStep());
			PST.setInt(6, bvo.getIndent());

			cnt = PST.executeUpdate();
			if (cnt > 0) {
				System.out.println(cnt + "개의 자료가 저장되었습니다. ");
			} else {
				System.out.println("*** 저장된 자료가 없습니다. ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(PST, CN);
		}

		return cnt;
	}
	
	public PageVO pagingList(int cPage){
		List<BoardVo> mlist = new ArrayList<BoardVo>();
		PageVO pvo = new PageVO();
		int totalCount = totalCount();

		String sql = "select * from board order by root desc, step asc"; // All 출력위해 >= 사용
		try {
			CN = JDBCUtil.getConnection();
			PST = CN.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			RS = PST.executeQuery();
			
			int perPage = pvo.getPerPage();
			int skip = (cPage-1)*perPage;
			if(skip > 0) {
				RS.absolute(skip);
			}
			
			for (int i = 0 ; i < perPage && RS.next() ; i++) {
					BoardVo boardVo = new BoardVo();
					boardVo.setSeq(RS.getInt("seq"));
					boardVo.setTitle(RS.getString("title"));
					boardVo.setWriter(RS.getString("writer"));
					boardVo.setContent(RS.getString("content"));
					boardVo.setRegdate(RS.getString("regdate"));
					boardVo.setCnt(RS.getInt("cnt"));
					boardVo.setRoot(RS.getInt("root"));
					boardVo.setIndent(RS.getInt("indent"));
					mlist.add(boardVo);
			}
			pvo.setList(mlist);
			pvo.setTotalCount(totalCount);
			pvo.setCurPage(cPage);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally { JDBCUtil.close(RS,  PST, CN); }

		return pvo;
	}
	
	public int totalCount(){
		int totalCount = 0;

		String sql = "select count(seq) count from board"; // All 출력위해 >= 사용
		try {
			CN = JDBCUtil.getConnection();
			PST = CN.prepareStatement(sql);
			RS = PST.executeQuery();
			if (RS.next()) {
				totalCount = RS.getInt("count");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally { JDBCUtil.close(RS,  PST, CN); }

		return totalCount;
	}
}
