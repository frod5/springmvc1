package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.stream.Collectors;

/**
 * 1. 파라미터 전송 기능
 * http://localhost:8080/request-param?username=hellog&age=20
 * request.getParameter()는 GET URL 쿼리 파라미터와 POST HTML form 형식 모두 둘다 지원
 * GET URL 쿼리파라미터는 바디 메세지가 없어서. 헤더에 Content-type이 없다.
 * POST HTML form 형식은 바디에 보내기 떄문에 헤더에 Content-type이 application/x-www-form-urlencoded
 */
@WebServlet(name = "requestParamServlet",urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - start");
        request.getParameterNames().asIterator()
                        .forEachRemaining(paramName -> System.out.println(paramName + "=" +request.getParameter(paramName)));
        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();
        System.out.println("[단일 파라미터 조회]");

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        String age = request.getParameter("age");
        System.out.println("age = " + age);

        System.out.println();
        System.out.println("[이름이 같은 복수 파라미터 조회]");

        String[] usernames = request.getParameterValues("username");

        for(String name : usernames) {
            System.out.println("name = " + name);
        }

        response.getWriter().write("OK");
    }
}
