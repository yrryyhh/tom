package com.thesis.chat_project.utils;


import java.lang.reflect.Field;

/**
 *@description:   判断Vo对象中的属性是否为空
 *@author:        zhushubiao
 *@email:         617374631@qq.com
 *@date:          2020/2/7
 *@time:          15:32
 */
public class VoUtilsTool {
    /****
     * @param object 对象
     * @return 如果对象不为空，且没有空值。返回false，对象为空或者有空值，返回true
     * */
    public static boolean checkObjFieldIsNull(Object object){
        boolean flag = false;
        if(null!=object){
            for(Field field : object.getClass().getDeclaredFields()){
                //在用反射时访问私有变量（private修饰变量）
                field.setAccessible(true);
                try {
                    if(field.get(object) == null || field.get(object).equals("")){
                        flag = true;
                        return flag;
                    }
                    if(field.get(object) != null&&field.get(object).toString().trim().equals("")){
                        flag = true;
                        return flag;
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }else{
            flag=true;
        }
        return flag;
    }
}
