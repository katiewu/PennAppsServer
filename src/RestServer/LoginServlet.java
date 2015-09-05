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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.write("123");
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
	    PrintWriter out = response.getWriter();
	    try {
			JSONObject obj = new JSONObject(requestJSON);
			String phonenumber = obj.getString("phonenumber");
			String password = obj.getString("password");
			User user = DBUser.getUser(phonenumber);
			if(!password.equals(user.getPassword())){
				out.write("User or Password is wrong!");
			}
			else{
				JSONObject userObj = new JSONObject();
				userObj.put("username", user.getUsername());
				userObj.put("phonenumber", user.getPhonenumber());
				userObj.put("venmoid", user.getVenmoid());
				userObj.put("password", user.getPassword());
				String userResponse = userObj.toString();
				out.write(userResponse);
			}
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			out.write("Failed to find user");
		}
			
//			String username = obj.getString("username");
//			String phonenumber = obj.getString("phonenumber");
//			String password = obj.getString("password");
//			String venmoid = obj.getString("venmoid");
//			User user = new User();
//			user.setPhonenumber(phonenumber);
//			user.setPassword(password);
//			user.setUsername(username);
//			user.setVenmoid(venmoid);
//			PrintWriter out = response.getWriter();
//			out.write(request.getParameter("test"));
//			out.write(user.getPhonenumber());
		
	}

}
