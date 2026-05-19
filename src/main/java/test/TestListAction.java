package test;

import java.util.List;

import bean.Subject;
import bean.Teacher;
import dao.ClassNumDAO;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TestListAction extends Action {
	public void execute(
			HttpServletRequest request, HttpServletResponse response
			) throws Exception {
				/*StudentDao dao = new StudentDao();
		
				//学生情報をすべて表示する
				List<Student> list = dao.all();
				request.setAttribute("student_list", list);
				request.getRequestDispatcher("student_list.jsp") 
					.forward(request, response);*/
				
				Teacher teacher = new Teacher();
				SubjectDAO subjectdao = new SubjectDAO();
				ClassNumDAO classnumdao = new ClassNumDAO();
				
				HttpSession session=request.getSession();
				teacher = (Teacher)session.getAttribute("teacher");
				
				
				List<String> classnum = classnumdao.filter(teacher.getSchool());
				List<Subject> subjectnum = subjectdao.filter(teacher.getSchool());
				System.out.println("school=" + teacher.getSchool());
				request.setAttribute("classnum", classnum);
				System.out.println("school=" + teacher.getSchool());
				request.setAttribute("subjectnum", subjectnum);
				System.out.println(subjectnum);
				
				request.getRequestDispatcher("test_list.jsp").forward(request, response);
				
	
	
	


}
}