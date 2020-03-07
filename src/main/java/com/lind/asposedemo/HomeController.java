package com.lind.asposedemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangzhanling
 * @description
 * @date 2020/3/7 10:13
 */
@RestController
public class HomeController {
  @RequestMapping(value = "/download")
  public void downloadApprovalForm(HttpServletRequest request, HttpServletResponse response) throws ParseException {
    CompanyLawyerEducationAddDTO companyLawyerEducationAddDTO = new CompanyLawyerEducationAddDTO();
    companyLawyerEducationAddDTO.setEducation("本科");
    companyLawyerEducationAddDTO.setMajor("计算机");
    companyLawyerEducationAddDTO.setUniversity("北大");
    companyLawyerEducationAddDTO.setStudyStartTime(new SimpleDateFormat("yyyy-MM-dd").parse("2007-01-01"));
    companyLawyerEducationAddDTO.setStudyEndTime(new SimpleDateFormat("yyyy-MM-dd").parse("2010-01-01"));

    CompanyLawyerWorkAddDTO companyLawyerWorkAddDTO = new CompanyLawyerWorkAddDTO();
    companyLawyerWorkAddDTO.setPosition("工程师");
    companyLawyerWorkAddDTO.setWorkplace("北大英华");
    companyLawyerWorkAddDTO.setWorkStartTime(new SimpleDateFormat("yyyy-MM-dd").parse("2019-11-11"));
    companyLawyerWorkAddDTO.setWorkEndTime(new SimpleDateFormat("yyyy-MM-dd").parse("2022-11-11"));
    CompanyLawyerWorkAddDTO companyLawyerWorkAddDTO2 = new CompanyLawyerWorkAddDTO();
    companyLawyerWorkAddDTO2.setPosition("架构师");
    companyLawyerWorkAddDTO2.setWorkplace("清大世纪");
    companyLawyerWorkAddDTO2.setWorkStartTime(new SimpleDateFormat("yyyy-MM-dd").parse("2011-09-26"));
    companyLawyerWorkAddDTO2.setWorkEndTime(new SimpleDateFormat("yyyy-MM-dd").parse("2017-06-27"));
    ExportDocx.generateApproveForm(response, Arrays.asList(companyLawyerEducationAddDTO), Arrays.asList(companyLawyerWorkAddDTO, companyLawyerWorkAddDTO2));
  }
}
