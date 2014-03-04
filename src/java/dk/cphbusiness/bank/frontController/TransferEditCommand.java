/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.cphbusiness.bank.frontController;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountDetail;
import dk.cphbusiness.bank.contract.dto.AccountIdentifier;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import dk.cphbusiness.bank.contract.dto.TransferSummary;
import dk.cphbusiness.bank.contract.eto.InsufficientFundsException;
import dk.cphbusiness.bank.contract.eto.NoSuchAccountException;
import dk.cphbusiness.bank.contract.eto.TransferNotAcceptedException;
import dk.cphbusiness.bank.view.Factory;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author RidvanGurel denne del er ikke færdig udviklet endnu !!!
 */
public class TransferEditCommand extends TargetCommand {

    public TransferEditCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        
      
    String number = request.getParameter("number");
    AccountIdentifier account = AccountIdentifier.fromString(number);

    request.setAttribute("account", account);
   
    String cpr = request.getParameter("cpr");
        CustomerIdentifier customer = CustomerIdentifier.fromString(cpr);
        request.setAttribute("customer", customer);
        
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
