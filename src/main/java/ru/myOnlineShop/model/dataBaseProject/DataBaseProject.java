package ru.myOnlineShop.model.dataBaseProject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DataBaseProject {

    Object findElement(String name) throws Exception;


    void dataBaseWrite(HttpServletRequest request, HttpServletResponse response);

    void dataBaseRead(HttpServletRequest request,HttpServletResponse response);

    Object convertStringToBase(String currentLine);

    void exportFromDataBase();

    void importToDataBase();

}