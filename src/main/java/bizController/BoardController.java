package bizController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.type.IntegerTypeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mybatisUtil.BService;
import vo.BoardVo;
import vo.PageMVO;
import vo.PageVO;
import vo.UserVO;

@Controller
public class BoardController {

	@Autowired
	private BService bDAO;

	@RequestMapping(value = "/plist.do")
	public ModelAndView plist(HttpServletRequest request, HttpServletResponse response, ModelAndView mav, PageMVO pvo)
			throws Exception {
		int cPage=1;
		if(request.getParameter("cPage") != null) {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		}
		
		int totalCount = bDAO.totalCount();		
		int perPage = pvo.getPerPage();
		
		int skip  = 0;
		if(cPage > 1) {
			skip = (cPage-1)*perPage;
		}
		int fno = skip + 1;
		int tno = (fno + perPage) - 1;
		
		pvo.setFno(fno);
		pvo.setTno(tno);
		List<BoardVo> bList = bDAO.getPageList(pvo);
		
		int totalPage = totalCount / perPage;
		if(totalCount % perPage != 0) totalPage++;
			
/*		PageVO pList = bDAO.pagingList(cPage);		
		int tPage = pList.getTotalCount() / pList.getPerPage() + ((pList.getTotalCount() % pList.getPerPage() == 0) ? 0 : 1);*/
		
		mav.addObject("boardList", bList);
		mav.addObject("totalPage", totalPage);
		mav.addObject("currPage", cPage);
		mav.setViewName("mvcBoard/boardList");
		return mav;
	}
	
	@RequestMapping(value = "/blist.do")
	public ModelAndView mlist(HttpServletRequest request, HttpServletResponse response, ModelAndView mav)
			throws Exception {
		request.removeAttribute("boardList");
		
		List<BoardVo> mList = bDAO.getBoardList();
		mav.addObject("boardList", mList);

		mav.setViewName("mvcBoard/boardList");
		return mav;
	}

	@RequestMapping(value = "/bdelete.do")
	public ModelAndView mdelete(HttpServletRequest request, HttpServletResponse response, ModelAndView mav, BoardVo bvo)
			throws Exception {

		int cnt = bDAO.mDelete(bvo);
		if (cnt > 0) {
			mav.addObject("isDelete", "T");
			mav.addObject("cnt", cnt);
			mav.addObject("deleteSeq", bvo.getSeq());
		} else {
			mav.addObject("isDelete", "F");
		}

		mav.setViewName("redirect:blist.do");
		return mav;
	}

	@RequestMapping(value = "/bdetail.do")
	public ModelAndView mdetail(HttpServletRequest request, HttpServletResponse response
			, ModelAndView mav, BoardVo bvo)
			throws Exception {
		bvo = bDAO.getBoard(bvo);

		//글쓴이와 글보는이(login정보)가 다른 경우 조회수 증가
		//login info 확인을 위해 session 필요
		HttpSession session = request.getSession();
		UserVO uvo = (UserVO)session.getAttribute("loginInfo");
		if(uvo == null || !bvo.getWriter().equals(uvo.getId())) {
			bDAO.viewCount(bvo);
		}
		
		session.setAttribute("seqNo", bvo.getSeq());
		session.setAttribute("proot", bvo.getRoot());
		session.setAttribute("pstep", bvo.getStep());
		session.setAttribute("pindent", bvo.getIndent());
		
		mav.addObject("boardDetail", bvo);
		mav.setViewName("mvcBoard/boardDetailView");

		return mav;
	}

	@RequestMapping(value = "/bcreate.do")
	public ModelAndView mcreate(HttpServletRequest request, HttpServletResponse response, ModelAndView mav, BoardVo bvo)
			throws Exception {

		int cnt = bDAO.mInert(bvo);
		if (cnt > 0) {
			mav.addObject("isCreate", "T");
			mav.addObject("cnt", cnt);
			mav.addObject("createID", bvo.getSeq());
		} else {
			mav.addObject("isCreate", "F");
		}

		mav.setViewName("redirect:blist.do");
		return mav;
	}

	@RequestMapping(value = "/bupdate.do")
	public ModelAndView mupdate(HttpServletRequest request, HttpServletResponse response, ModelAndView mav, BoardVo bvo)
			throws Exception {
		int cnt = bDAO.mUpdate(bvo);
		if (cnt > 0) {
			mav.addObject("isUpdate", "T");
			mav.addObject("cnt", cnt);
			mav.addObject("updateSeq", bvo.getSeq());
		} else {
			mav.addObject("isUpdate", "F");
		}
		
		mav.setViewName("mvcBoard/bFinish");
		return mav;
	}
	
	@RequestMapping(value = "/breplyi.do")
	public ModelAndView breplyi(HttpServletRequest request, HttpServletResponse response, ModelAndView mav, BoardVo bvo)
			throws Exception {
		
		//글쓴이와 글보는이(login정보)가 다른 경우 조회수 증가
		//login info 확인을 위해 session 필요
		HttpSession session = request.getSession();
		int step = Integer.valueOf(session.getAttribute("pstep").toString());
		int indent = Integer.valueOf(session.getAttribute("pindent").toString());

		bvo.setStep(step+1);
		bvo.setIndent(indent+1);

		int cnt = bDAO.InsertReply(bvo);
		if (cnt > 0) {
			mav.addObject("isCreate", "T");
			mav.addObject("cnt", cnt);
			mav.addObject("createID", bvo.getSeq());
		} else {
			mav.addObject("isCreate", "F");
		}

		mav.setViewName("redirect:blist.do");
		return mav;
	}
}
