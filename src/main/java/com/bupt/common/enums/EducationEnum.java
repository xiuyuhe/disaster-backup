package com.bupt.common.enums;

/**
 * Created by bupt626 on 17-4-15.
 */
public enum EducationEnum {
    XIAO_XUE(1,"小学"),
    CHU_ZHONG(2,"初中"),
    GAO_ZHONG(3,"高中"),
    BEN_KE(4,"本科"),
    SHUO_SHI(5,"硕士"),
    BO_SHI(6,"博士");

    private int value;
    private String name;

    EducationEnum(final int value, final String name) {
        this.setValue(value);
        this.setName(name);
    }

    // 根据index获取enum对象
    public static EducationEnum findByIndex(int index) {
        for (EducationEnum positionEnum : EducationEnum.values()) {
            if (index == positionEnum.getValue()) {
                return positionEnum;
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
