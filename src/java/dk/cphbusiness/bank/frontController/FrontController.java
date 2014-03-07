package dk.cphbusiness.bank.frontController;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import security.SecurityRole;

@WebServlet(name = "FrontController", urlPatterns = {"/Controller"})
public class FrontController extends HttpServlet {
  private final Map<String, Command> commands = new HashMap<>();

  public FrontController() {
    commands.put("back", new TargetCommand("main.jsp", Arrays.asList(SecurityRole.All)));
    commands.put("main", new TargetCommand("main.jsp", Arrays.asList(SecurityRole.All)));
    commands.put("list-customer-accounts", new ListAccountsCommand("account-list.jsp", Arrays.asList(SecurityRole.All)));
    commands.put("list-customers", new ListCustomersCommand("customer-list.jsp", Arrays.asList(SecurityRole.Employee, SecurityRole.SuperEmployee)));
    commands.put("show-account-detail", new ShowAccountDetailCommand("account-detail.jsp", Arrays.asList(SecurityRole.Customer)));
    commands.put("prepare-transfer", new TransferEditCommand("transfer-edit.jsp", Arrays.asList(SecurityRole.Customer)));
    commands.put("save-transfer", new TransferSaveCommand("account-list.jsp", Arrays.asList(SecurityRole.Customer)));
    commands.put("create-customer", new AddCustomerCommand("customer-edit.jsp", Arrays.asList(SecurityRole.SuperEmployee)));
    commands.put("save-customer", new SaveCustomerCommand("customer-edit.jsp", Arrays.asList(SecurityRole.SuperEmployee)));
    
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
