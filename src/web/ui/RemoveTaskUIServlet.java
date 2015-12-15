package web.ui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.formbean.UserSelectTaskFormBean;
import web.formbean.*;
import service.impl.*;
import domain.*;
/**
 * Servlet implementation class RemoveTaskUIServlet
 */
@WebServlet("/RemoveTaskUIServlet")
public class RemoveTaskUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveTaskUIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get userId, selectedTask
		String userId = request.getParameter("userId");
		Task selectedTask = (Task)request.getAttribute("selectedTask");
				
		// construct formbean
		UserSelectTaskFormBean formbean = new UserSelectTaskFormBean();
		formbean.setUserId(userId);
		formbean.setSelectedTask(selectedTask);
		request.setAttribute("formbean", formbean);
				
		// jump to RemoveTask.jsp
		request.getRequestDispatcher("/WEB-INF/RemoveTask.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
