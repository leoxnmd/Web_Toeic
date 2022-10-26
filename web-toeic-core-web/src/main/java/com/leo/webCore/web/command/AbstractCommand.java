package com.leo.webCore.web.command;

import java.io.Serializable;
import java.util.List;

public class AbstractCommand<T>  {
    protected T pojo;//là một java bean thuần không được extend hay implements nhưng được implements Serializable
    private String crudaction;//dùng để phân biệt các hành động

    public T getPojo() {
        return pojo;
    }

    public void setPojo(T pojo) {
        this.pojo = pojo;
    }

    public String getCrudaction() {
        return crudaction;
    }

    public void setCrudaction(String crudaction) {
        this.crudaction = crudaction;
    }

    private int maxPageItems = 20;
    private int firstItem = 0;//item đầu tiên
    private int totalItems = 0;//toàn bộ item
    private String sortExpression;//sắp xếp biểu thức
    private String sortDirection;//sắp xếp hướng
    private String[] checkList;
    private List<T> listResult;//list kết quả
    private String tableId = "tableList";
    private String messageResponse; //phản hồi tin nhắn
    private int page = 1;

}
