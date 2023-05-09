package com.lfz.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Title {
    @TableId(value = "title_id", type = IdType.AUTO)
    private Long titleId;
    @TableField("type_id")
    private Long typeId;
    @TableField("title_name")
    private String titleName;
    @TableField("title_text")
    private String titleText;
    @TableField("title_time")
    private String titleTime;
}
