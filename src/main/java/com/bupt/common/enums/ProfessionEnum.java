package com.bupt.common.enums;

/**
 * Created by bupt626 on 17-4-15.
 */
public enum ProfessionEnum {
    JUN_REN(1,"军人"),
    YI_SHENG(2,"医生"),
    GONG_REN(3,"工人"),
    XUE_SHENG(4,"学生");

    private int value;
    private String name;

    ProfessionEnum(final int value, final String name) {
        this.setValue(value);
        this.setName(name);
    }

    // 根据index获取enum对象
    public static ProfessionEnum valueByIndex(int index) {
        for (ProfessionEnum professionEnum : ProfessionEnum.values()) {
            if (index == professionEnum.getValue()) {
                return professionEnum;
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
