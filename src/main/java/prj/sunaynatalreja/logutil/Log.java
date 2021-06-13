/**
 * 
 */
package prj.sunaynatalreja.logutil;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;

/**
 * @author Sunayna Talreja
*/

public class Log {
	static Logger log = Logger.getLogger(Log.class.getName());
	
		static {

			try {
				Properties props = new Properties();
				InputStream cpr = Log.class.getResourceAsStream("/log4j.properties");
				props.load(cpr);
				PropertyConfigurator.configure(props);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * @param description provide DEBUG Log Description
		 */
		public static void messageDebug(String description) {

			Reporter.log( description );
			
			lsLog4j().log(callerClass(), Level.DEBUG, description, null);

		}
		
		public static void messageInfo(String description) {

			Reporter.log( description );
			
			lsLog4j().log(callerClass(), Level.INFO, description, null);

		}
		public static void messageWarn(String description) {

			Reporter.log( description );
			
			lsLog4j().log(callerClass(), Level.WARN, description, null);

		}
		
		public static void messageError(String description) {

			Reporter.log( description );
			
			lsLog4j().log(callerClass(), Level.ERROR, description, null);

		}
		
		public static void messageFatal(String description) {

			Reporter.log( description );
			
			lsLog4j().log(callerClass(), Level.FATAL, description, null);

		}
		public static String callerClass() {
			return Thread.currentThread().getStackTrace()[2].getClassName();
		}
		
		public static Logger lsLog4j() {
			return Logger.getLogger(Thread.currentThread().getName());
		}
		
		

}
