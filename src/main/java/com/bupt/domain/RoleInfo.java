package com.bupt.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by hexiuyu on 2017/4/13.
 */
@Entity
@Table(name = "role_info", schema = "disaster-recovery")
public class RoleInfo {
    private String id;
    private String roleName;
    private String authority;
    private String code;

    @Id
    @Column(name = "ID", nullable = false, length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ROLE_NAME", nullable = true, length = 16)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "CODE", nullable = true, length = 16)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "AUTHORITY", nullable = true, length = 16)
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleInfo roleInfo = (RoleInfo) o;

        if (id != null ? !id.equals(roleInfo.id) : roleInfo.id != null) return false;
        if (roleName != null ? !roleName.equals(roleInfo.roleName) : roleInfo.roleName != null) return false;
        if (authority != null ? !authority.equals(roleInfo.authority) : roleInfo.authority != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (authority != null ? authority.hashCode() : 0);
        return result;
    }
}
