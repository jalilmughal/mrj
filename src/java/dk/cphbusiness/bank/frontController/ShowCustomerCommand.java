package dk.cphbusiness.bank.frontController;

import dk.cphbusiness.bank.contract.BankManager;
import javax.servlet.http.HttpServletRequest;
import dk.cphbusiness.bank.view.Factory;
import dk.cphbusiness.bank.contract.dto.CustomerDetail;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import dk.cphbusiness.bank.contract.eto.NoSuchCustomerException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import security.SecurityRole;

/**
 * @author Lars Mortensen
 */
public class ShowCustomerCommand extends TargetCommand{

  public ShowCustomerCommand(String target, List<SecurityRole> roles) {
    super(target, roles);
  }

  @Override
  public String execute(HttpServletRequest request) {
//       BankManager manager = Factory.getInstance().getManager();
//      
//    String cpr = request.getParameter("cpr");
//    long id = Long.parseLong(cpr);
//    CustomerDetail cust = new CustomerDetail(cpr, cpr, cpr, cpr, cpr, cpr, cpr, cpr, cpr);
//      try {
//          manager.showCustomer(cust);
//      } catch (NoSuchCustomerException ex) {
//          Logger.getLogger(ShowCustomerCommand.class.getName()).log(Level.SEVERE, null, ex);
//      }
//    request.setAttribute("customer", cust);
//    return super.execute(request); 
      
      BankManager manager = Factory.getInstance().getManager();
      try {
          manager.showCustomer(CustomerIdentifier.fromString("cpr"));
      } catch (NoSuchCustomerException ex) {
          Logger.getLogger(ShowCustomerCommand.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      String idAsStr = request.getParameter("cpr");

    request.setAttribute("cpr", idAsStr);
    return super.execute(request); 
  }
}
