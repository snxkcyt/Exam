package subject;

import bean.Subject;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class SubjectDeleteAction extends Action {

    public void execute(HttpServletRequest request,
                        HttpServletResponse response) throws Exception {

        String cd = request.getParameter("cd");

        if (cd != null) {

            Subject subject = new Subject();
            subject.setCd(cd);

            SubjectDAO dao = new SubjectDAO();
            dao.delete(subject);
        }

        response.sendRedirect("subject_delete_done.jsp");
    }
}