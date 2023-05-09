package com.lfz.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("title_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TitleType {
    @TableId(value = "type_id",type = IdType.AUTO)
    private Long typeId;
    @TableField("type_name")
    private String typeName;
}
