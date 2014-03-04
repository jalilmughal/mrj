/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.cphbusiness.bank.frontController;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountDetail;
import dk.cphbusiness.bank.contract.dto.AccountIdentifier;
import dk.cphbusiness.bank.view.Factory;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author RidvanGurel
 */
public class ShowAccountDetailCommand extends TargetCommand {

    public ShowAccountDetailCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        
    BankManager manager = Factory.getInstance().getManager();   
    String number = request.getParameter("number");
    AccountIdentifier id = AccountIdentifier.fromString(number);
    AccountDetail account = manager.showAccountHistory(id);

   // request.setAttribute("transfers", accounts);
    request.setAttribute("account", account);
        
    return super.execute(request); 
    
    }
    
}
