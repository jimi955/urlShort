package com.xiaoxin.urlshorter.entity;


import javax.persistence.*;

//使用JPA注解配置映射关系
@Entity //告诉JPA这是一个实体类（和数据表映射的类）
@Table(name = "url") //@Table来指定和哪个数据表对应;如果省略默认表名就是user；
public class UrlShort {
    @Id //这是一个主键
    private long number;

    @Column(name = "longer", length = 255) //这是和数据表对应的一个列
    private String longer;

    @Column(name = "shorter", length = 255) //省略默认列名就是属性名
    private String shorter;

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getLonger() {
        return longer;
    }

    public void setLonger(String longer) {
        this.longer = longer;
    }

    public String getShorter() {
        return shorter;
    }

    public void setShorter(String shorter) {
        this.shorter = shorter;
    }
}
