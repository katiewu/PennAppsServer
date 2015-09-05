package RestServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import DBUtils.DBUser;
import DBUtils.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
	    BufferedReader reader = request.getReader();
	    try {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            sb.append(line);
	        }
	    } finally {
	        reader.close();
	    }
	    String requestJSON = new String(sb);
	    JSONObject obj;
	    PrintWriter out = response.getWriter();
		try {
			obj = new JSONObject(requestJSON);
			String username = obj.getString("username");
			String phonenumber = obj.getString("phonenumber");
			String password = obj.getString("password");
			String venmoid = obj.getString("venmoid");
			
			User user = new User();
			user.setPhonenumber(phonenumber);
			user.setPassword(password);
			user.setUsername(username);
			user.setVenmoid(venmoid);
			DBUser.addUser(user);
			out.write("successfully created user");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.write("failed to create user");
		}
		
	}

}
