package me.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zzc on 2017/12/13.
 */
@WebServlet(urlPatterns = {"/tow"})
public class RedirectServlet extends HttpServlet {
    RequestDispatcher rd;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        rd = request.getRequestDispatcher("/inner_redirect.jsp");
        request.setAttribute("state", "---me--inner_redirect-");
        rd.forward(request, response);
    }


}
