package test;

import java.util.List;

import bean.Student;
import bean.Subject;
import bean.Teacher;
import bean.TestListStudent;
import dao.ClassNumDAO;
import dao.StudentDAO;
import dao.SubjectDAO;
import dao.TestListStudentDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TestListStudentExecuteAction extends Action {
	public void execute(
			HttpServletRequest request, HttpServletResponse response
			) throws Exception {
		
				Teacher teacher = new Teacher();
				StudentDAO studentdao = new StudentDAO();
				SubjectDAO subjectdao = new SubjectDAO();
				TestListStudentDao dao = new TestListStudentDao();
				ClassNumDAO classnumdao = new ClassNumDAO();
				List<TestListStudent> list  = null;
				
				HttpSession session=request.getSession();
				teacher = (Teacher)session.getAttribute("teacher");
				
				
				String studentNo = request.getParameter("studentNo");
				String studentName = "";
				

				List<Student> students = studentdao.filter(teacher.getSchool(), false);
				
				for (Student s : students) {
				    if (s.getNo().equals(studentNo)) {
				        studentName = s.getName();
				        break;
				    }
				}

				
				list = dao.filter(teacher.getSchool(), studentNo);
				System.out.println("studentNo=" + studentNo);
				System.out.println("list size=" + list.size());


				
				List<String> classnum = classnumdao.filter(teacher.getSchool());
				List<Subject> subjectnum = subjectdao.filter(teacher.getSchool());
				System.out.println("school=" + teacher.getSchool());
				request.setAttribute("classnum", classnum);
				request.setAttribute("subjectnum", subjectnum);
				request.setAttribute("list", list);
				request.setAttribute("studentName", studentName);
				
				request.getRequestDispatcher("test_list_student.jsp").forward(request, response);
				
	
	
	


}
}