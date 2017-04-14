package com.bupt.common.base;

import org.hibernate.SQLQuery;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by bupt626 on 17-4-13.
 */
public interface QueryExtension<T> {
    void doExtend(SQLQuery sq);
}
