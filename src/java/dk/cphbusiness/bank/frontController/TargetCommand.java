/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.bank.frontController;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author hsty
 */


public class TargetCommand implements Command { //gør sådan så man går på den side man vil til
    private final String target;
    List<SecurityRole> roles;

    public List<SecurityRole> getRoles() {
        return roles;
    }

    
    
    public TargetCommand(String target, List <SecurityRole> roles) {
        this.target = target;
        this.roles = roles;
    }

    @Override
    public String execute(HttpServletRequest request) {
        return target;
    }
    
    
    
}
