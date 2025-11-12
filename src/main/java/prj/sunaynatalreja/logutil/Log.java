/**
 * 
 */
package prj.sunaynatalreja.logutil;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import org.apache.logging.log4j.LogManager;

/**
 * @author Sunayna Talreja
*/

public class Log {
	static Logger log = LogManager.getLogger(Log.class);
	/**
	 * @param description provide DEBUG Log Description
	 */
	public static void setMessageDebug(String description) {
		Reporter.log( description );
		log.log(Level.DEBUG, description);
	}
	
	public static void setMessageInfo(String description) {

		Reporter.log( description );
		log.log(Level.INFO, description);

	}
	public static void setMessageWarn(String description) {
		Reporter.log( description );
		log.log(Level.WARN, description);
	}
	
	public static void setMessageError(String description) {
		Reporter.log( description );
		log.log(Level.ERROR, description);

	}
	
	public static void setMessageFatal(String description) {
		Reporter.log( description );
		log.log(Level.FATAL, description);

	}
}
