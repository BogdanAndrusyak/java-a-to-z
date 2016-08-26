package andrusyak.servlets;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * TODO: comment.
 * Created by Bogdan on 8/20/2016.
 */
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        String uri = ((HttpServletRequest) req).getRequestURI();
        HttpServletRequest request = (HttpServletRequest) req;

        if (uri.contains("/view") || uri.contains("/auth") || uri.contains("/carfilter") || uri.contains("resources/") || uri.contains("/login") ||
                uri.contains("/register")|| uri.contains("/json")) {
            chain.doFilter(req, resp);
            return;
        } else {
            HttpSession session = request.getSession();
            synchronized (session) {
                if (session.getAttribute("user") == null) {
                    ((HttpServletResponse) resp).sendRedirect(String.format("%s/auth", request.getContextPath()));
                    return;
                }
            }
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {
    }
}
