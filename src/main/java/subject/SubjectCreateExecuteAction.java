package subject;
import bean.Subject;
import bean.Teacher;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectCreateExecuteAction extends Action {

	public void execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		
		
		HttpSession session = request.getSession();
		Teacher teacher = new Teacher();
		teacher = (Teacher) session.getAttribute("teacher");
		String school = teacher.getSchool();

        SubjectDAO subjectdao = new SubjectDAO();
        
        String cd = request.getParameter("cd");
        String name = request.getParameter("name");
        
        Subject sub = new Subject();
        sub.setCd(cd);
        sub.setName(name);
        sub.setSchool(school);
        
        int line = subjectdao.insert(sub);
        
        if (line > 0) {
        	request.getRequestDispatcher("subject_create_done.jsp")
			.forward(request, response);
        } else {
        	request.getRequestDispatcher("subject_create.jsp")
			.forward(request, response);
        }
        
		
	}
	
	
}