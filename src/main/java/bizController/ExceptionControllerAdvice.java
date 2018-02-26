package bizController;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


/*@ControllerAdvice("bizController")
public class ExceptionControllerAdvice {

	@ExceptionHandler(Exception.class)
	public ModelAndView exception(Exception e){
		ModelAndView mav = new ModelAndView("eMsg/nlexceptionMessage");
		mav.addObject("exception", e);

		return mav;
	}
}*/