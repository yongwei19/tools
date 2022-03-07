package com.test.tools.entity;

import com.test.tools.validation.Insert;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Md5Entity implements java.io.Serializable{

    @NotBlank(message = "字符串不能为空",groups = Insert.class)
    @NotNull(message = "字符串不能为空",groups = Insert.class)
    protected String md5;

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }
}
