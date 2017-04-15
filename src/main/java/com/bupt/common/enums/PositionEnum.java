package com.bupt.common.enums;

/**
 * Created by bupt626 on 17-4-15.
 */
public enum PositionEnum {
    YUAN_GONG(1,"员工"),
    ZHAN_ZHANG(2,"站长");

    private int value;
    private String name;

    PositionEnum(final int value, final String name) {
        this.setValue(value);
        this.setName(name);
    }

    // 根据index获取enum对象
    public static PositionEnum findByIndex(int index) {
        for (PositionEnum positionEnum : PositionEnum.values()) {
            if (index == positionEnum.getValue()) {
                return positionEnum;
            }
        }
        return null;
    }
    // 根据index获取enum对象
    public static String findNameByIndex(int index) {
        for (PositionEnum positionEnum : PositionEnum.values()) {
            if (index == positionEnum.getValue()) {
                return positionEnum.getName();
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
