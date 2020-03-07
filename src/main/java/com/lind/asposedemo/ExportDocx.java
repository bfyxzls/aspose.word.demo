package com.lind.asposedemo;

import cn.hutool.core.date.DateUtil;
import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;
import com.aspose.words.net.System.Data.DataRow;
import com.aspose.words.net.System.Data.DataTable;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.io.ClassPathResource;

/**
 * @author zhangzhanling
 * @description 导出word模板
 * @date 2020/3/7 9:46
 */
public class ExportDocx {
  private static InputStream license;
  private static InputStream fileInput;
  private static File outputFile;

  public static void generateApproveForm(HttpServletResponse response,
                                         List<CompanyLawyerEducationAddDTO> companyLawyerEducationAddDTOS,
                                         List<CompanyLawyerWorkAddDTO> companyLawyerWorkAddDTOS) {
    // 验证License
    if (!getLicense("templates/companyLawyerApprove.docx")) {
      return;
    }
    try {
      long old = System.currentTimeMillis();
      Document doc = new Document(fileInput);
      String[] Flds = new String[] {"companyName", "username", "sex", "nation", "birthday", "party",
          "highEducation", "idCard", "phoneNumber", "legalCertificateNo", "firstPractisingTime",
          "workTime", "position", "entryTime", "domicile", "currentResidence", "reward", "punishment"};
      String username = "小件";
      String sex = "男";
      String nation = "汉";
      Object[] Vals = new Object[] {"小郭软件@2016", username, sex, nation,"","","","","","","","","","","","","",""};
      doc.getMailMerge().execute(Flds, Vals);

      //教育情况
      DataTable approveTb = new DataTable("edu");
      approveTb.getColumns().add("education");
      approveTb.getColumns().add("university");
      approveTb.getColumns().add("major");
      approveTb.getColumns().add("studyStartTime");
      approveTb.getColumns().add("studyEndTime");
      for (int i = 0; i < companyLawyerEducationAddDTOS.size(); i++) {
        DataRow row = approveTb.newRow();
        row.set(0, companyLawyerEducationAddDTOS.get(i).getEducation());
        row.set(1, companyLawyerEducationAddDTOS.get(i).getUniversity());
        row.set(2, companyLawyerEducationAddDTOS.get(i).getMajor());
        row.set(3, DateUtil.format(companyLawyerEducationAddDTOS.get(i).getStudyStartTime(), "yyyy-MM-dd"));
        row.set(4, DateUtil.format(companyLawyerEducationAddDTOS.get(i).getStudyEndTime(), "yyyy-MM-dd"));
        approveTb.getRows().add(row);
      }
      doc.getMailMerge().executeWithRegions(approveTb);

      //工作经历
      DataTable works = new DataTable("work");
      works.getColumns().add("position");
      works.getColumns().add("workplace");
      works.getColumns().add("workStartTime");
      works.getColumns().add("workEndTime");
      for (int i = 0; i < companyLawyerWorkAddDTOS.size(); i++) {
        DataRow row = works.newRow();
        row.set(0, companyLawyerWorkAddDTOS.get(i).getPosition());
        row.set(1, companyLawyerWorkAddDTOS.get(i).getWorkplace());
        row.set(2, DateUtil.format(companyLawyerWorkAddDTOS.get(i).getWorkStartTime(), "yyyy-MM-dd"));
        row.set(3, DateUtil.format(companyLawyerWorkAddDTOS.get(i).getWorkEndTime(), "yyyy-MM-dd"));
        works.getRows().add(row);
      }
      doc.getMailMerge().executeWithRegions(works);

      response.setHeader("Content-Disposition", "attachment; filename=20200307.pdf");
      response.setContentType("application/octet-stream;charset=UTF-8");

      OutputStream output = response.getOutputStream();
      doc.save(output, SaveFormat.PDF);

      output.flush();
      output.close();

      long now = System.currentTimeMillis();
      System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒\n\n");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 获取license
   *
   * @return
   */
  public static boolean getLicense(String templateName) {
    boolean result = false;
    try {
      license = new ClassPathResource("lib/license.xml").getInputStream();
      fileInput = new ClassPathResource(templateName).getInputStream();

      License aposeLic = new License();
      aposeLic.setLicense(license);
      result = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }
}
