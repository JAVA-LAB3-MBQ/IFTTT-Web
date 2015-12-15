package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.formbean.*;
import service.impl.*;
import domain.*;
import util.*;
import util.*;
/**
 * Servlet implementation class CreateTaskServlet
 */
@WebServlet("/CreateTaskServlet")
public class CreateTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ATaskFormBean form = WebUtils.request2Bean(request, ATaskFormBean.class);
		String userId = form.getUserId();
		
		int thisType = -1, thatType = -1;
		try {
			thisType = form.getThisTypeInt();
			thatType = form.getThatTypeInt();
		} catch( NumberFormatException e ) {
			
		}
 		IfThis this_ = null;
		ThenThat that_ = null;
		
		// this
		switch(thisType) {
		case IfThis.thisReceiveMailTypeValue : { 
			this_ = new IfThisReceiveMail(userId); 
			break;
		}
		case IfThis.thisTimeTypeValue : {
            this_ = new IfThisTime(form.getGoalTime()); 
			break;
		}
		case IfThis.thisListenWeiboTypeValue : {
             this_ = new IfThisListenWeibo(form.getListenWbId(), form.getListenWbText(), form.getListenTimeLen()); 
			 break;
		}
		 default: System.out.println("Unknown ThisType");
		}
		
	 // that
	  switch(thatType) {
	  case ThenThat.thatSendMailTypeValue: {
		  that_ = new ThenThatSendMail(userId, form.getDestMailAddr(), form.getSendContent());
		  break;
	  }
	  case ThenThat.thatSendWeiboTypeValue: {
		  that_ = new ThenThatSendWeibo(userId, form.getSendContent());
		  break;
	  }
	  default: System.out.println("Unknown ThatType");
	  }
	  
	  // this_ and that_ 's id
	  this_.setThisId(IdGenerator.makeId());
	  that_.setThatId(IdGenerator.makeId());
	  
	  // add a task
	  IUserServiceImpl service = new IUserServiceImpl();
	  service.addTask(userId, IdGenerator.makeId(), form.getTaskName(), this_, that_);
		
	  // construct form
		UserTasksFormBean formbean = new UserTasksFormBean();
		formbean.setUserId(userId);
		formbean.setUserTasks(service.getUserTasks(userId));
		request.setAttribute("formbean", formbean);
		
		// jump to UserTasks.jsp
		request.getRequestDispatcher("/WEB-INF/UserTasks.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
