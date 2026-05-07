package student;
import java.util.List;

import bean.Student;
import bean.Teacher;
import dao.ClassNumDAO;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentUpdateFromAction extends Action {

	public void execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		
		
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		String no = request.getParameter("no");

		StudentDAO dao = new StudentDAO();
		Student student = dao.get(no);  // ← これが無いと全部空


        ClassNumDAO classNumDAO = new ClassNumDAO();
        List<String> classNumList = classNumDAO.filter(teacher.getSchool());

		request.setAttribute("student", student);
        request.setAttribute("classNumList", classNumList);
        
		request.getRequestDispatcher("student_update.jsp")
			.forward(request, response);
		
		System.out.println("no=" + no);
	}
	
	
}