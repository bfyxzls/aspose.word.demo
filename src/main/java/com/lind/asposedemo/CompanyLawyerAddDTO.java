package com.lind.asposedemo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
 * @author zhangzhanling
 * @description 公司律师申请
 * @date 2020/3/4 10:22
 */
@Data
@ApiModel("公司律师申请")
public class CompanyLawyerAddDTO {
  /**
   * 编号
   */
  @ApiModelProperty(value = "编号")
  private String id;
  /**
   * 姓名
   */
  @ApiModelProperty("姓名")
  private String username;
  /**
   * 所在公司
   */
  @ApiModelProperty("所在公司")
  private String companyId;
  /**
   * 职位
   */
  @ApiModelProperty("职位")
  private String position;
  /**
   * 入职时间
   */
  @ApiModelProperty("入职时间")
  private Date entryTime;
  /**
   * 性别
   */
  @ApiModelProperty("性别")
  private String sex;
  /**
   * 出生年月
   */
  @ApiModelProperty("出生年月")
  private Date birthday;
  /**
   * 民族
   */
  @ApiModelProperty("民族")
  private String nation;
  /**
   * 党派
   */
  @ApiModelProperty("党派")

  private String party;
  /**
   * 最高学历
   */
  @ApiModelProperty("最高学历")
  private String highEducation;
  /**
   * 身份证号码
   */
  @ApiModelProperty("身份证号码")
  private String idCard;
  /**
   * 法律执业资格证书号
   */
  @ApiModelProperty("法律执业资格证书号")
  private String legalCertificateNo;
  /**
   * 首次执业时间
   */
  @ApiModelProperty("首次执业时间")
  private Date firstPractisingTime;
  /**
   * 参加工作时间
   */
  @ApiModelProperty("参加工作时间")
  private Date workTime;
  /**
   * 户籍地
   */
  @ApiModelProperty("户籍地")
  private String domicile;
  /**
   * 现居住地
   */
  @ApiModelProperty("现居住地")
  private String currentResidence;
  /**
   * 手机号码
   */
  @ApiModelProperty("手机号码")
  private String phoneNumber;
  /**
   * 受过何种奖励
   */
  @ApiModelProperty("受过何种奖励")
  private String reward;
  /**
   * 受过何种处分
   */
  @ApiModelProperty("受过何种处分")
  private String punishment;
}
