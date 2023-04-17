package badhabits;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import badhabits.entity.Lamp;
import badhabits.entity.Sleep;
import badhabits.postrequest.PostRequestLamp;
import badhabits.repository.RepositoryLamp;
import badhabits.repository.RepositorySleep;
import jason.asSyntax.Literal;



public class HouseData {
	
    static int status = 0;
    static String timesleep = "23:59:00";
    static String timenow;
    static boolean checkedStatus = false;
    static boolean checkedtimesleep = false;
    static boolean checkedtimenow = false;
    static boolean comparetime = false;
    static int strategygoodnight = 0;
    
    boolean waitingStatus() throws Exception {
    	RepositoryLamp repositoryLamp = new RepositoryLamp();
		
    	Integer maxid = repositoryLamp.maxId();	
    	System.out.println("MAXID: " + maxid);
    	
		Lamp lamp = repositoryLamp.consultaPorId(maxid);
		System.out.println("BDlamp: " + lamp.getLampStatus());
		status = lamp.getLampStatus();
		System.out.println("Status: " + status);
		return true;
	}
    
    boolean checkedStatus() {
    	if (!checkedStatus) {
    		checkedStatus = true;
            return true;
        } else if (checkedStatus) {
        	checkedStatus = false;
            return true;
        }else {
        	return false;
        }
    }
    
    boolean waitingTimeSleep() throws Exception {
    	Date aux;
		RepositorySleep repositorySleep = new RepositorySleep();
		Sleep sleep = repositorySleep.consultaPorId(1);
		aux = sleep.getTimeSleep();
		
		timesleep = new SimpleDateFormat("HH:mm:ss").format(aux);
		
		System.out.println("TIMESLEEP:" + timesleep);

		return true;
	}
    
    boolean checkedTimeSleep() {
    	if (!checkedtimesleep) {
    		checkedtimesleep = true;
            return true;
        }else if (checkedtimesleep) {
        	checkedtimesleep = false;
            return true;
        }else {
        	return false;
        }
    }
    
    boolean timeCheck() {
    	timenow = new SimpleDateFormat("HH:mm:ss").format(new Date());
    	return true;
    }
    
    boolean checkedTimeNow() {
    	if (!checkedtimenow) {
    		checkedtimenow = true;
    		return true;
    	} else if (checkedtimenow) {
    		checkedtimenow = false;
            return true;
        }else {
        	return false;
        }
    }

	boolean compareTime() throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
		Date auxtimesleep = formato.parse(timesleep);
		Date auxtimenow = formato.parse(timenow);
		
		if (auxtimenow.after(auxtimesleep)) {
		    // horario de agora é maior que o horario que o usuario dorme
			// eu acredito que meu usuario está dormindo 
			strategygoodnight = 1;
			comparetime = true;
			System.out.println("MAIOR:");
		} else if (auxtimenow.before(auxtimesleep)) {
		    // horario de agora é menor que o horario que o usuario dorme
			// eu acredito que o usuario está acordado
			strategygoodnight = 2;
			comparetime = true;
			System.out.println("MENOR:");
		} else {
		    // horario de agora é igual o horario que o usuario dorme
			// eu tenho que acionar um plano de rotina
			strategygoodnight = 3;
			System.out.println("IGUAL:");
		}
		
		
		return true;
	}

	boolean postRequestLampOn() throws IOException {
		PostRequestLamp postRequestLamp = new PostRequestLamp();
		postRequestLamp.PostRequestLampOn();
		return true;
	}
	
	boolean postRequestLampOff() throws IOException {
		PostRequestLamp postRequestLamp = new PostRequestLamp();
		postRequestLamp.PostRequestLampOff();
		return true;
	}


}