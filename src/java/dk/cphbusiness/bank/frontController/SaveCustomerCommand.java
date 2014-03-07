package dk.cphbusiness.bank.frontController;

import javax.servlet.http.HttpServletRequest;
import dk.cphbusiness.bank.view.Factory;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.CustomerDetail;

import java.util.List;
import security.SecurityRole;

/**
 * @author Lars Mortensen
 */
public class SaveCustomerCommand extends TargetCommand {

  public SaveCustomerCommand(String target, List<SecurityRole> roles) {
    super(target, roles);
  }

  @Override
  public String execute(HttpServletRequest request) {
    BankManager manager = Factory.getInstance().getManager();
    
    String cpr = request.getParameter("cpr");
    String title = request.getParameter("title");
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String street = request.getParameter("street");
    String postalCode = request.getParameter("postalCode");
    String postalDistrict = request.getParameter("postalDistrict");
    String phone = request.getParameter("phone");
    String email = request.getParameter("email");
    CustomerDetail cust = new CustomerDetail(cpr, title, firstName, lastName, street, postalCode, postalDistrict, phone, email);
    manager.saveCustomer(cust);
    return super.execute(request); 
  }
}
