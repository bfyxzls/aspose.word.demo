package com.lind.asposedemo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
 * @author zhangzhanling
 * @description 公司律师工作信息
 * @date 2020/3/4 10:42
 */
@ApiModel("公司律师工作信息")
@Data
public class CompanyLawyerWorkAddDTO {

  /**
   * 工作开始时间
   */
  @ApiModelProperty("工作开始时间")
  private Date workStartTime;
  /**
   * 工作结束时间
   */
  @ApiModelProperty("工作结束时间")
  private Date workEndTime;
  /**
   * 工作单位
   */
  @ApiModelProperty("工作单位")
  private String workplace;
  /**
   * 职位
   */
  @ApiModelProperty("职位")
  private String position;
}
