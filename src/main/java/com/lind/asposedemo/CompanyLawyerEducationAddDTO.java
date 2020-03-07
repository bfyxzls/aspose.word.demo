package com.lind.asposedemo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
 * @author zhangzhanling
 * @description 公司律师教育信息
 * @date 2020/3/4 10:38
 */
@ApiModel("公司律师教育信息")
@Data
public class CompanyLawyerEducationAddDTO {

  /**
   * 学历
   */
  @ApiModelProperty("学历")
  private String education;
  /**
   * 毕业院校
   */
  @ApiModelProperty("毕业院校")
  private String university;
  /**
   * 毕业专业
   */
  @ApiModelProperty("毕业专业")
  private String major;
  /**
   * 就读开始时间
   */
  @ApiModelProperty("就读开始时间")
  private Date studyStartTime;
  /**
   * 就读结束时间
   */
  @ApiModelProperty("就读结束时间")
  private Date studyEndTime;
}
