package dk.cphbusiness.bank.frontController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FrontController", urlPatterns = {"/Controller"})
public class FrontController extends HttpServlet {
  private final Map<String, Command> commands = new HashMap<>();

  public FrontController() {
    commands.put("list-customer-accounts", new ListAccountsCommand("account-list.jsp"));
    commands.put("list-customers", new ListCustomersCommand("customer-list.jsp"));
    commands.put("show-account-detail", new ShowAccountDetailCommand("account-detail.jsp"));
    commands.put("prepare-transfer", new TransferEditCommand("transfer-edit.jsp"));
    commands.put("save-transfer", new TransferSaveCommand("account-list.jsp"));
    commands.put("back", new TargetCommand("main.jsp"));
    commands.put("main", new TargetCommand("main.jsp"));
    }
  
  @Override
  protected void service(
      HttpServletRequest request,
      HttpServletResponse response
      ) throws ServletException, IOException {
    String key = request.getParameter("command");
    if (key == null) key = "main";
    Command command = commands.get(key);
    String target = command.execute(request);
    RequestDispatcher dispatcher = request.getRequestDispatcher(target);
    dispatcher.forward(request, response);
    }

  

}
