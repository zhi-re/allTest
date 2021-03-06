package org.zhire.jpa;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "user")
@ApiObject // 　JSONDoc注解
@DynamicInsert(true)
@DynamicUpdate(true)
public class User implements Serializable{

    @Id
    @GeneratedValue
    @ApiObjectField(description = "ID") // JSONDoc注解
    private Long id;

    @Column(nullable = false, unique = false)
    @ApiObjectField(description = "姓名")
    private String userName;

    @Column(nullable = false)
    private String passWord;

    @Column(nullable = false, unique = false)
    private String email;

    @Column(nullable = true, unique = false)
    private String nickName;

    @Column(nullable = true, columnDefinition = "tinyint default 0")
    private Integer flag;




}