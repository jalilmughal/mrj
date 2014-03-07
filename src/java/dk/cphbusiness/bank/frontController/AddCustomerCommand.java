/*
 */

package dk.cphbusiness.bank.frontController;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 * @author Lars Mortensen
 */
public class AddCustomerCommand extends TargetCommand {

  public AddCustomerCommand(String target, List<SecurityRole> roles) {
    super(target, roles);
  }

  @Override
  public String execute(HttpServletRequest request) {
    return super.execute(request); //To change body of generated methods, choose Tools | Templates.
  }
  

}
