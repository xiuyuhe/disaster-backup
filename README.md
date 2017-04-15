# disaster-backup
##分页方法
```
{
  "data": {
    "results": [
      {
        "id": "123123",
        "userName": "123456",
        "password": "$2a$10$4yHXKpJMSWwc4DvZKI/b9eBlMJLJrydYQD0/S65B1Lhx2CrgjPbYS",
        "name": "hexiuyu",
        "status": "1",
        "roleInfo": {
          "id": "1",
          "roleName": "ROLE_ADMIN"
        }
      },
      {
        "id": "123456",
        "userName": "1",
        "password": "$2a$10$4yHXKpJMSWwc4DvZKI/b9eBlMJLJrydYQD0/S65B1Lhx2CrgjPbYS",
        "name": "hehe",
        "roleInfo": {
          "id": "2",
          "roleName": "ROLE_MEMBER"
        }
      },
      {
        "id": "858585ef5b65c17f015b65c27ad70000",
        "userName": "1325656",
        "password": "$2a$10$4yHXKpJMSWwc4DvZKI/b9eBlMJLJrydYQD0/S65B1Lhx2CrgjPbYS",
        "name": "ycliu",
        "status": "1",
        "roleInfo": {
          "id": "1",
          "roleName": "ROLE_ADMIN"
        }
      },
      {
        "id": "858585f55b65dd59015b65e548190000",
        "userName": "1325652",
        "password": "$2a$10$4yHXKpJMSWwc4DvZKI/b9eBlMJLJrydYQD0/S65B1Lhx2CrgjPbYS",
        "name": "ycliu",
        "status": "0",
        "roleInfo": {
          "id": "1",
          "roleName": "ROLE_ADMIN"
        }
      }
    ],
    "totalResults": 4,
    "totalPages": 1,
    "start": 0,
    "pageSize": 10,
    "currentPageLength": 4,
    "currentPage": 0
  },
  "message": "SUCCESS",
  "status": "true"
}
```
##人员下拉框对应值
###职业
```$xslt
    YUAN_GONG(1,"员工"),
    ZHAN_ZHANG(2,"站长");
```
###教育
```$xslt
    XIAO_XUE(1,"小学"),
    CHU_ZHONG(2,"初中"),
    GAO_ZHONG(3,"高中"),
    BEN_KE(4,"本科"),
    SHUO_SHI(5,"硕士"),
    BO_SHI(6,"博士");
``````
###职务
```$xslt
    JUN_REN(1,"军人"),
    YI_SHENG(2,"医生"),
    GONG_REN(3,"工人"),
    XUE_SHENG(4,"学生");

```