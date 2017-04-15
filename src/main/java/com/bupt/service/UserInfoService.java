package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.common.enums.EducationEnum;
import com.bupt.common.enums.PositionEnum;
import com.bupt.domain.SiteInfo;
import com.bupt.domain.UserInfo;
import com.bupt.repository.SiteInfoRepository;
import com.bupt.repository.UserInfoRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by bupt626 on 17-4-12.
 */
@Service
@Transactional
public class UserInfoService extends BasePageService<UserInfo,String> {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private SiteInfoService siteInfoService;

    public void save(UserInfo userInfo){
        userInfoRepository.save(userInfo);
    }
    public UserInfo findOne(String id){
        return  userInfoRepository.findOne(id);
    }

    public UserInfo findByName(String name){
        return userInfoRepository.findByUserName(name);
    }


    public void  pageByHql(PageEntity<UserInfo> pageEntity, Map<String,Object> paramaMap){
        StringBuilder sql = new StringBuilder(" from UserInfo where 1=1 ");
        if (paramaMap.containsKey("name")){
            sql.append(" and name like:name ");
        }
        if (paramaMap.containsKey("status")){
            sql.append(" and status =:status ");
        }
        if (paramaMap.containsKey("position")){
            sql.append(" and position =:position ");
        }
        if (paramaMap.containsKey("educational")){
            sql.append(" and educational =:educational ");
        }
        if (paramaMap.containsKey("siteInfoId")){
            sql.append(" and siteInfoId =:siteInfoId ");
        }
        if (paramaMap.containsKey("professional")){
            sql.append(" and professional =:professional ");
        }
        super.pageByHql(sql.toString(),pageEntity,paramaMap);
        translate(pageEntity.getResults());
    }

    private void translate(List<UserInfo> userInfos){
        for (UserInfo userInfo: userInfos ) {
            if (userInfo.getEducational() != null){
                EducationEnum educationEnum = EducationEnum.findByIndex(userInfo.getEducational());
                userInfo.setEducationalName(educationEnum != null ? educationEnum.getName():"");
            }
            if (userInfo.getPosition() != null){
                String positionName = PositionEnum.findNameByIndex(userInfo.getEducational());
                userInfo.setPositionName(positionName);
            }
            if (StringUtils.isNotBlank(userInfo.getSiteInfoId())){
                SiteInfo siteInfo = siteInfoService.findOne(userInfo.getSiteInfoId());
                if (siteInfo != null){
                    userInfo.setSiteCode(siteInfo.getCode());
                    userInfo.setSiteName(siteInfo.getName());
                }
            }
        }
    }
}
