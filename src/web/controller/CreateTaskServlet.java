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
		User user = (new IUserServiceImpl()).getUser(form.getUserId());
		
		switch(form.getThisType()) {
		case IfThis.thisReceiveMailTypeValue : { 
			IfThisReceiveMail this_ = new IfThisReceiveMail(user.getUserEmailAddr(), user.getUserEmailPwd()); 
			
			// that
			if(form.getThatType() == ThenThat.thatSendMailTypeValue) {
				ThenThatSendMail that_ = new ThenThatSendMail(user.getUserEmailAddr(), user.getUserEmailPwd(), 
						form.getDestMailAddr(), form.getSendContent());
				
				// add a task
				IUserServiceImpl service = new IUserServiceImpl();
				service.addTask(user, IdGenerator.makeId(), form.getTaskName(), this_, that_);
			}
			else if( form.getThatType() == ThenThat.thatSendWeiboTypeValue) {
				ThenThatSendWeibo that_ = new ThenThatSendWeibo(user.getUserWeiboId(), user.getUserWeiboAccessToken(), 
						user.getUserWeiboPwd(), form.getSendContent());
				
				// add a task
				IUserServiceImpl service = new IUserServiceImpl();
				service.addTask(user, IdGenerator.makeId(), form.getTaskName(), this_, that_);
			}
			break;
		}
		case IfThis.thisTimeTypeValue : {
            IfThisTime this_ = new IfThisTime(form.getGoalTime()); 
			
			// that
			if(form.getThatType() == ThenThat.thatSendMailTypeValue) {
				ThenThatSendMail that_ = new ThenThatSendMail(user.getUserEmailAddr(), user.getUserEmailPwd(), 
						form.getDestMailAddr(), form.getSendContent());
				
				// add a task
				IUserServiceImpl service = new IUserServiceImpl();
				service.addTask(user, IdGenerator.makeId(), form.getTaskName(), this_, that_);
			}
			else if( form.getThatType() == ThenThat.thatSendWeiboTypeValue) {
				ThenThatSendWeibo that_ = new ThenThatSendWeibo(user.getUserWeiboId(), user.getUserWeiboAccessToken(), 
						user.getUserWeiboPwd(), form.getSendContent());
				
				// add a task
				IUserServiceImpl service = new IUserServiceImpl();
				service.addTask(user, IdGenerator.makeId(), form.getTaskName(), this_, that_);
			}
			
			break;
		}
		case IfThis.thisListenWeiboTypeValue : {
            IfThisListenWeibo this_ = new IfThisListenWeibo(form.getListenWbId(), form.getListenWbText(), form.getListenTimeLen()); 
			
			// that
			if(form.getThatType() == ThenThat.thatSendMailTypeValue) {
				ThenThatSendMail that_ = new ThenThatSendMail(user.getUserEmailAddr(), user.getUserEmailPwd(), 
						form.getDestMailAddr(), form.getSendContent());
				
				// add a task
				IUserServiceImpl service = new IUserServiceImpl();
				service.addTask(user, IdGenerator.makeId(), form.getTaskName(), this_, that_);
			}
			else if( form.getThatType() == ThenThat.thatSendWeiboTypeValue) {
				ThenThatSendWeibo that_ = new ThenThatSendWeibo(user.getUserWeiboId(), user.getUserWeiboAccessToken(), 
						user.getUserWeiboPwd(), form.getSendContent());
				
				// add a task
				IUserServiceImpl service = new IUserServiceImpl();
				service.addTask(user, IdGenerator.makeId(), form.getTaskName(), this_, that_);
			}
			break;
		}
	  }
		
	  // construct form
		UserTasksFormBean formbean = new UserTasksFormBean();
		formbean.setUserId(user.getId());
		formbean.setUserTasks(user.getUserTasks());
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
