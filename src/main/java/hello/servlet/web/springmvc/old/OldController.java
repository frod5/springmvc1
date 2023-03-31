package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//HandlerMapping
// 0 = RequestMappingHandlerMapping : 애노테이션 기반의 컨트롤러인 @RequestMapping에서 사용
// 1 = BeanNameUrlHandlerMapping : 스프링 빈의 이름으로 핸들러를 찾는다.

//HandlerAdapter
// 0 = RequestMappingHandlerAdapter : 애노테이션 기반의 컨트롤러인 @RequestMapping에서 사용
// 1 = HttpRequestHandlerAdapter : HttpRequestHandler 처리
// 2 = SimpleControllerHandlerAdapter : Controller 인터페이스(애노테이션X, 과거에 사용) 처리

@Component("/springmvc/old-controller") // BeanNameUrlHandlerMapping 사용
public class OldController implements Controller { // SimpleControllerHandlerAdapter 사용
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");
        return new ModelAndView("new-form"); // 뷰 리졸버
        //1 = BeanNameViewResolver : 빈 이름으로 뷰를 찾아서 반환한다. (예: 엑셀 파일 생성 기능에 사용)
        //2 = 2 = InternalResourceViewResolver : JSP를 처리할 수 있는 뷰를 반환한다.
        // ..등등 많다.

        //현재는 JSTL 라이브러리가 있어서 실제로는 JstlView 반환 (InternalResourceViewResolver를 상속받고있음).
    }
}
