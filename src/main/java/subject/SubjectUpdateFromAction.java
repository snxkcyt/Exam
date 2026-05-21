package subject;
import bean.Subject;
import bean.Teacher;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectUpdateFromAction extends Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        Teacher teacher = (Teacher) session.getAttribute("teacher");

        // 更新する科目コードを取得
        String cd = request.getParameter("cd");

        SubjectDAO dao = new SubjectDAO();
        Subject subject = dao.get(cd);

        request.setAttribute("subject", subject);

        request.getRequestDispatcher("subject_update.jsp")
               .forward(request, response);

        System.out.println("cd=" + cd);
    }
}

