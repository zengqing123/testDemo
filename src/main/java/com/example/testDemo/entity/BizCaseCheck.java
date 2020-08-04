package com.example.testDemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 案件审核表
 * </p>
 *
 * @author luozq
 * @since 2020-07-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("biz_case_check")
@ApiModel(value="BizCaseCheck对象", description="案件审核表")
public class BizCaseCheck implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    private String id;

    @ApiModelProperty(value = "案件编号")
    private String caseNo;

    @ApiModelProperty(value = "案件名称")
    private String caseName;

    @ApiModelProperty(value = "事件编号")
    private String eventNo;

    @ApiModelProperty(value = "场景配置id")
    private String sceneId;

    @ApiModelProperty(value = "案件程度")
    private Integer caseLevel;

    @ApiModelProperty(value = "案件类型")
    private String caseType;

    @ApiModelProperty(value = "图片地址")
    private String alarmPic;

    @ApiModelProperty(value = "摄像头id")
    private String cameraId;

    @ApiModelProperty(value = "车牌号")
    private String license;

    @ApiModelProperty(value = "创建人")
    private String createId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改人")
    private String updateId;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "备注")
    private String note;

    @ApiModelProperty(value = "审核人")
    private String checkId;

    @ApiModelProperty(value = "审核状态（0：准备；1：发现；2：立案；3：派遣；4：处置；5：核查；6：结案）")
    private Integer checkStatus;

    @ApiModelProperty(value = "审核时间")
    private Date checkTime;

    @ApiModelProperty(value = "诚运案件编号")
    private String pdId;

    @ApiModelProperty(value = "案件备注")
    private String caseRemarks;


}
