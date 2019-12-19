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
        "addr":"XX村",
		"remark": ""
	}]
}
```

| 属性名             | 含义                                   | 备注                 |
| ------------------ | -------------------------------------- | -------------------- |
| addr               | 地址                                   | 传全部地址           |
| inputUser          | 录入人                                 |                      |
| inputDate          | 录入日期                               |                      |
| pointManNo         | 指示者编号                             |                      |
| name               | 名称                                   |                      |
| sex                | 性别                                   |                      |
| healthy            | 健康状况                               | 直接传健在、去世即可 |
| inCurrentCountry   | 是否从本村迁出                         | 直接传是否即可       |
| birthDate          | 出生日期                               |                      |
| currentAddr        | 现住址                                 |                      |
| idCardNo           | 身份证号码                             |                      |
| mobilePhone        | 手机                                   |                      |
| isOtherPointmanRel | 该指示者与本村其他指示者是否有亲缘关系 | 直接传是否           |
| otherPointmanName  | 其他指示者明                           |                      |
| otherPointmanRel   | 与其他指示者具体关系                   |                      |
| inKinShips         | 居住本村的其他指示者信息               | 具体内容参照下表     |
| outKinShips        | 居住外村的其他指示者信息               | 具体内容参照下表     |

| 属性名      | 含义         | 备注 |
| ----------- | ------------ | ---- |
| kinshipCode | 亲缘关系代码 |      |
| name        | 名称         |      |
| sex         | 性别         |      |
| birthdate   | 出生日期     |      |
| idcardNo    | 身份证号码   |      |
| remark      | 备注         |      |

3.查询

```javascript
GET localhost:8050/qs/api/v1/querypm?page=1&pageSize=2&field=name
```

| 属性名   | 含义     | 备注 |
| -------- | -------- | ---- |
| page     | 当前页   |      |
| pageSize | 页大小   |      |
| field    | 排序字段 |      |

4.删除

```javascript
POST localhost:8050/qs/api/v1/deletepm?pmid=329e303825e540a1854657778b056be3
```

  

| 属性名 | 含义     | 备注               |
| ------ | -------- | ------------------ |
| pmid   | 指示者ID | 查询的时候会返回id |



4.下载数据

```javascript
GET localhost:8050/qs/download
```

