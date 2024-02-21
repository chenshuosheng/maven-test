package com.css.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: TODO
 * @Author: CSS
 * @Date: 2024/2/20 10:49
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer age;

    private String name;

    private Character sex;
}
