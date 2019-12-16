# 接口说明

1.登录

```javascript
POST localhost:8050/qs/api/v1/login
BODY:
{
    "username":"lvjingjing", 
    "password":"lvjingjing" 
}
```

| 属性名   | 含义   | 备注            |
| -------- | ------ | --------------- |
| username | 用户名 |                 |
| password | 密码   | 后台使用MD5加密 |

2.新增

```json
POST
localhost:8050/qs/api/v1/addpm 
BODY：
{
	"addr": "乳山市乳山口乡镇秦家庄村",
	"inputUser": "王竹梅",
	"inputDate": "2019-11-23",
	"pointManNo": "1329",
	"name": "秦晓丽",
	"sex": "女",
	"healthy": "健在",
	"inCurrentCountry": "否",
	"birthDate": "1967-07-18",
	"currentAddr": "乳山口秦家庄",
	"idCardNo": "370630196707184520",
	"mobilePhone": "15065109865",
	"isOtherPointmanRel": "否",
	"otherPointmanName": null,
	"otherPointmanRel": null,
	"inKinShips": [{
		"kinshipCode": "03",
		"name": "秦少卓",
		"sex": "男",
		"birthdate": "1955-07-31",
		"idcardNo": "370630195507314533",
		"remark": ""
	}],
	"outKinShips": [{
		"kinshipCode": "04",
		"name": "秦双双",
		"sex": "女",
		"birthdate": "1994-01-12",
		"idcardNo": "37108319940112542X",
		"remark": ""
	}]
}
```

| 属性名    | 含义     | 备注       |
| --------- | -------- | ---------- |
| addr      | 地址     | 传全部地址 |
| inputUser | 录入人   |            |
| inputDate | 录入日期 |            |

