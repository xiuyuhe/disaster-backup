package com.bupt.repository;

import com.bupt.domain.TaskInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bupt626 on 17-4-13.
 */
public interface TaskInfoRepository extends JpaRepository<TaskInfo, String>  {
}
