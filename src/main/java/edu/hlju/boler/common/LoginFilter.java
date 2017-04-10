package edu.hlju.boler.common;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import edu.hlju.boler.controller.UserController;

/**
 * 登录过滤器
 *
 * @author jingqingyun
 */
public class LoginFilter extends OncePerRequestFilter {
    private static final String[] notFilter = new String[] { "/", "/home[.]jsp", "/login", "/home", "/.+[.]js",
            "/.+[.]css", "/.+[.]png", "/.+[.]jpg", "/.+[.]gif", "/.+[.]html" };

    private void loginFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        Object user = request.getSession().getAttribute(UserController.USER_OBJECT);
        if (user == null) {
            // 没有登录就重定位到登录界面
            response.sendRedirect(request.getContextPath() + "/");
        } else {
            // 已经登录就通过
            filterChain.doFilter(request, response);
        }
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        for (String filter : notFilter) {
            Matcher matcher = Pattern.compile(".+" + filter + "$").matcher(request.getRequestURI());
            if (matcher.matches()) {
                // 通过此次过滤，进入过滤链的下一个过滤器
                filterChain.doFilter(request, response);
                return;
            }
        }
        this.loginFilter(request, response, filterChain);
    }

}
