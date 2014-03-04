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
public class TransferSaveCommand extends TargetCommand {

    public TransferSaveCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        
    BankManager manager = Factory.getInstance().getManager();   
    String number = request.getParameter("number");
    AccountIdentifier account = AccountIdentifier.fromString(number);

    request.setAttribute("account", account);
    
    
    String cpr = request.getParameter("cpr");
    CustomerIdentifier customer = CustomerIdentifier.fromString(cpr);
    request.setAttribute("customer", customer);
    
    String amount = request.getParameter("amount");
        try {
            AccountDetail transfer = manager.transferAmount(BigDecimal.ZERO, account, account);
        } catch (NoSuchAccountException ex) {
            Logger.getLogger(TransferSaveCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransferNotAcceptedException ex) {
            Logger.getLogger(TransferSaveCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InsufficientFundsException ex) {
            Logger.getLogger(TransferSaveCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    
     return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
