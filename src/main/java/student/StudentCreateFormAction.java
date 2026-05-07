package student;
import java.util.List;

import bean.Teacher;
import dao.ClassNumDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentCreateFormAction extends Action {

	public void execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		
		
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher) session.getAttribute("teacher");

        ClassNumDAO classNumDAO = new ClassNumDAO();
        List<String> classNumList = classNumDAO.filter(teacher.getSchool());

        request.setAttribute("classNumList", classNumList);
        
		request.getRequestDispatcher("student_create.jsp")
			.forward(request, response);
	}
	
	
}