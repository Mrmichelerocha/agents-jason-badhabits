package badhabits;


import jason.asSyntax.*;
import jason.asSemantics.*;
import jason.environment.Environment;

import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Logger;

public class HouseEnv extends Environment {

    // common literals
	public static final Literal ws  = Literal.parseLiteral("waiting(status)");
	public static final Literal cs  = Literal.parseLiteral("checked(status)");
	public static final Literal fs  = Literal.parseLiteral("finish(status)");
	public static final Literal ts  = Literal.parseLiteral("waiting(timesleep)");
	public static final Literal cts  = Literal.parseLiteral("checked(timesleep)");
	public static final Literal fts  = Literal.parseLiteral("finish(timesleep)");
	public static final Literal tn  = Literal.parseLiteral("timecheck(timenow)");
	public static final Literal ctn  = Literal.parseLiteral("checked(timenow)");
	public static final Literal ftn  = Literal.parseLiteral("finish(timenow)");
	public static final Literal ctnts  = Literal.parseLiteral("comparetime(timenow, timesleep)");
	public static final Literal rplon  = Literal.parseLiteral("postRequestLampOn");
	public static final Literal rploff  = Literal.parseLiteral("postRequestLampOff");
	
	
	static int status = 0;

	private Logger logger = Logger.getLogger("HouseEnv.mas2j."+HouseEnv.class.getName());

	HouseData database;
	
	/** Chamado antes da execução do MAS com os args informados em .mas2j */
    @Override
    public void init(String[] args) {
    	database = new HouseData();
    }

    /** creates the agents percepts based on the HouseModel */
    void updatePercepts() {
    	
    	
    	if (database.checkedStatus) { 
    		if (database.status == 1) {
    			removePercept("lamp", Literal.parseLiteral("status(luz, 0)"));
    		}else {
    			removePercept("lamp", Literal.parseLiteral("status(luz, 1)"));
    		}
            addPercept("lamp", Literal.parseLiteral("status(luz, " + database.status + ")"));
        } 
    	if (database.checkedtimesleep) {
    		addPercept("sleep", Literal.parseLiteral("horary_user_sleep(\"" + database.timesleep + "\")"));
        }
    	if (database.checkedtimenow) {
        	addPercept("horary", Literal.parseLiteral("horary_now(\"" + database.timenow + "\")"));    		
        }
    	if (database.comparetime) {
    		if (database.strategygoodnight == 1) {
    			addPercept("sleep", Literal.parseLiteral("user(sleep)"));
    			
    		}else if (database.strategygoodnight == 2) {
    			addPercept("sleep", Literal.parseLiteral("user(wake)"));
    			
    		}else if (database.strategygoodnight == 3) {
    			addPercept("sleep", Literal.parseLiteral("teste."));
    		}else {
    			System.out.println("ocorreu um erro");
    		}
    	}
    	
    }


    @Override
    public boolean executeAction(String ag, Structure action) {
    	System.out.println("["+ag+"] doing: "+action);
    	boolean result = false;
    	if (action.equals(ws)) {
			try {
				result = database.waitingStatus();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (action.equals(cs)) {
			result = database.checkedStatus();
		} else if (action.equals(fs)) {
			result = database.checkedStatus();
		}else if (action.equals(ts)) {
			try {
				result = database.waitingTimeSleep();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (action.equals(cts)) {
			result = database.checkedTimeSleep();
		}else if (action.equals(fts)) {
			result = database.checkedTimeSleep();
		}else if (action.equals(tn)) {
			result = database.timeCheck();
		}else if (action.equals(ctn)) {
			result = database.checkedTimeNow();
		}else if (action.equals(ftn)) {
			result = database.checkedTimeNow();
		}else if (action.equals(ctnts)) {
			try {
				result = database.compareTime();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}else if (action.equals(rplon)) {
			try {
				result = database.postRequestLampOn();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (action.equals(rploff)) {
			try {
				result = database.postRequestLampOff();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
		    logger.info("executing: "+action+", but not implemented!");
		    return false;
		}
    	
    	if (result) {
            updatePercepts();
            try {
                Thread.sleep(100);
            } catch (Exception e) {}
        }
        return result;
    }
    
    
    /** Called before the end of MAS execution */
    @Override
    public void stop() {
      super.stop();
    }
}