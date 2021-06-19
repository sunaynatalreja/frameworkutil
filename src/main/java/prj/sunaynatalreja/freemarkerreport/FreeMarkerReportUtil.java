/**
 * 
 */
package prj.sunaynatalreja.freemarkerreport;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;
import freemarker.template.Version;

/**
 * @author Sunayna Talreja
 */
public class FreeMarkerReportUtil {

	/**
	 * This method generates an html report 
	 * based on the List of data 
	 * and <filename>.ctl template provided
	 * The ctl template should have same fields as mentioned in ctl template 
	 * @param reportData
	 * @param templateName
	 * @param outputfile
	 * @throws TemplateNotFoundException
	 * @throws MalformedTemplateNameException
	 * @throws ParseException
	 * @throws IOException
	 */

	private static FreeMarkerReportUtil freemarkerReportUtilInstance;

	private FreeMarkerReportUtil()
	{

	}


	//  method to create instance of Singleton class
	public static FreeMarkerReportUtil getInstance()
	{
		if (freemarkerReportUtilInstance == null)
			freemarkerReportUtilInstance = new FreeMarkerReportUtil();

		return freemarkerReportUtilInstance;
	}	


	/**
	 * Creating freemarker report
	 * @param reportData
	 * @param templateName
	 * @param outputfile
	 * @throws TemplateNotFoundException
	 * @throws MalformedTemplateNameException
	 * @throws ParseException
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	public void createHTMLReport(List reportData,String templateName,String outputfile) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException
	{
		Configuration cfg = new Configuration(new Version("2.3.23"));
		cfg.setClassForTemplateLoading(FreeMarkerReportUtil.class, "/");
		cfg.setDefaultEncoding("UTF-8");
		Template template = cfg.getTemplate(templateName);
		Map<String, Object> reportHelperTemplate = new HashMap<>();
		reportHelperTemplate.put("reportHelper", reportData);
		Writer fileWriter = new FileWriter(new File(outputfile));
		try {
			template.process(reportHelperTemplate, fileWriter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			fileWriter.close();
		}
	}
}
