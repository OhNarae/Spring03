package unitTest_Jsp;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import bizUtil.MemberDAO;
import vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/applicationContext.xml")
public class MDaoTest {

	@Inject
	private MemberDAO dao;
	
	@Test
	public void testLoginMember()throws Exception{
		UserVO uvo = new UserVO();
		uvo.setId("manager");
		uvo.setPassword("12345");
		uvo = dao.loginCheck(uvo);
		if(uvo!=null) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
			return;
		}
	}
}
