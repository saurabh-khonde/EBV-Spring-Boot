package com.assimilate.restcontroller;

import static com.assimilate.common.EmployeeConstants.*;

import java.util.List;
import java.util.Random; 
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assimilate.employee.ConfirmationToken;
import com.assimilate.employee.ConfirmationTokenRepository;
import com.assimilate.employee.EmployeeEntity;
import com.assimilate.employee.EmployeeRepository;
import com.assimilate.employee.UserEntity;
import com.assimilate.employee.UserRepository;
import com.assimilate.exception.AlreadyRegistered;
import com.assimilate.exception.InvalidLinkException;
import com.assimilate.exception.RecordNotFoundException;
import com.assimilate.service.EmailSenderService;
import com.assimilate.service.EmployeeService;
import com.assimilate.service.UserService;

@RestController
@RequestMapping(API)
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService; 
	
	@Autowired
	private UserService userService; 

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private EmailSenderService emailSenderService;
    
    		Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);
    								
    
    @PostMapping(POST_EMPLOYEE)			
    public ResponseEntity<?> registerEmployeeEntity(@RequestBody EmployeeEntity employeeEntity) 
    {
    	String str = employeeEntity.getUserEntity().getEmailId();
    	UserEntity user = userService.findByEmailIdIgnoreCase(str);	
    	
    				logger.info(employeeEntity.toString());
       				
        if(user != null)
        {
        	throw new AlreadyRegistered("You are already registerd !!!");
        }
        else
        {     	
        	userService.saveUser(employeeEntity.getUserEntity());	// save userEntity in DB
        	System.out.println("--*** User Saved -***");
        	
        	employeeService.saveEmp(employeeEntity);					// save in EmployeeEntity DB    
        	System.out.println("--*** Employee Saved -***");

            ConfirmationToken confirmationToken = new ConfirmationToken(employeeEntity);
            confirmationTokenRepository.save(confirmationToken);			// save in ConfirmationTokenEntityDB

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(employeeEntity.getUserEntity().getEmailId());
            mailMessage.setSubject("Employee Verification Confirmation!");
            mailMessage.setText("To confirm your email id, please click here : "
            +"http://localhost:8082/api/employee/confirm-account?token="+confirmationToken.getConfirmationToken());

            emailSenderService.sendEmail(mailMessage);					// mail send to given mail id
            
            return new ResponseEntity<String>(" **Please check your mail for Verification !",HttpStatus.OK);
        }

    }
    
    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<String> confirmUserAccount(@RequestParam("token")String confirmationToken)
    {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if(token != null)
        {
        	String str = token.getEmpEntity().getUserEntity().getEmailId();
            UserEntity user = userService.findByEmailIdIgnoreCase(str);
            user.setIsActive(true);
            userService.saveUser(user);
            return new ResponseEntity<String>("Account-Verified, You Can Login Now...",HttpStatus.OK);
        }
        else
        {
        	throw new InvalidLinkException("Link is Invalid !");
        }
    } 
    
    
    @GetMapping(VIEW_ALL)
    public ResponseEntity<?> getAll(){
    	
    	List<EmployeeEntity> employeeEntity=employeeService.getAll();
    	
    	if(!employeeEntity.isEmpty())
    		return new ResponseEntity<List>(employeeEntity, HttpStatus.OK);
    	else
    		throw new RecordNotFoundException(" No Records Availble. ");
    }
    
    
    @PostMapping(FGT_PASS) 
    public ResponseEntity<?> forgotPass(@RequestParam String emailId)
    {
    	
    	UserEntity user = userService.findByEmailIdIgnoreCase(emailId);	    // check enter mail id in DB or not
    	
    	if(user==null)
    	{
    		throw new RecordNotFoundException(" No Records Availble. ");
    	}
    	else
    	{
            Random rand = new Random(); 			// create instance of Random class 
      
            String rand_int1 = String.valueOf(rand.nextInt(10000));    // Generate random integers in range 0 to 999 
            
            user.setPassword(rand_int1);		// update password in DB
            userService.saveUser(user);
            
    		SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getEmailId());
            mailMessage.setSubject("Employee Verification Confirmation for Password !");
            mailMessage.setText("Now you can Login with this new password :  "+rand_int1);
            emailSenderService.sendEmail(mailMessage);	
            
            return new ResponseEntity<String>(" **Please check your mail for new generated Password !",HttpStatus.OK);
    	}

    }
    
    
    

}
