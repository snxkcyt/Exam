package subject;

import bean.Subject;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class SubjectUpdateAction extends Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

	    String name = request.getParameter("name");

	    String cd = request.getParameter("cd");
	    
	    String school = request.getParameter("school");


	    // Studentにセット
	    Subject subject = new Subject();
	    subject.setCd(cd);
	    subject.setName(name);
	    subject.setSchool(school);

	    // DAOで登録
	    SubjectDAO dao = new SubjectDAO();
	    int count = dao.update(subject);

	    if (count > 0) {
	        request.getRequestDispatcher("subject_update_done.jsp")
	               .forward(request, response);
	    } else {
	        request.setAttribute("message", "更新失敗");
	        request.getRequestDispatcher("subject_update.jsp")
	               .forward(request, response);
	    }
	}
}