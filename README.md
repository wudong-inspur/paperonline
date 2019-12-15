1.用户登录
接口：POST localhost:8050/qs/api/v1/login
body:
{
"username":"lvjingjing",
"password":"lvjingjing"
}
2.新增：
接口：POST 	localhost:8050/qs/api/v1/addpm
body:
{
"addr":"乳山市乳山口乡镇秦家庄村",
"inputUser":"王竹梅",
"inputDate":"2019-11-23",
"pointManNo":"1329",
"name":"秦晓丽",
"sex": "女",
"healthy":"健在",
"inCurrentCountry":"否",
"birthDate":"1967-07-18",
"currentAddr":"乳山口秦家庄",
"idCardNo":"370630196707184520",
"mobilePhone":"15065109865",
"isOtherPointmanRel":"否",
"otherPointmanName":null,
"otherPointmanRel":null,
"inKinShips":[
	{
		"kinshipCode":"03",
		"name":"秦少卓",
		"sex":"男",
		"birthdate":"1955-07-31",
		"idcardNo":"370630195507314533",
		"remark":""
	}
	],
	"outKinShips":[
	{
		"kinshipCode":"04",
		"name":"秦双双",
		"sex":"女",
		"birthdate":"1994-01-12",
		"idcardNo":"37108319940112542X",
		"remark":""
	}
	]
}
------------------------------------------------------------
/** 主键. */
	private String id;

	/** 地址：乳山市 乡镇 村（居委会） */
	private String addr;

	/** 填表人. */
	private String inputUser;

	/** 填表日期. */
	private Date inputDate;

	/** 指示者编号. */
	private String pointManNo;

	/** 姓名. */
	private String name;

	/** 性别. */
	private String sex;

	/** 健康状况. */
	private String healthy;

	/** 是否从本村迁出. */
	private String inCurrentCountry;

	/** 出生日期. */
	private String birthDate;

	/** 现住址. */
	private String currentAddr;

	/** 身份证号码. */
	private String idCardNo;

	/** 电话号码. */
	private String mobilePhone;

	/** 是否和其他指示者有亲属关系. */
	private String isOtherPointmanRel;

	/** 其他指示者名称. */
	private String otherPointmanName;

	/** 与其他指示者亲属关系. */
	private String otherPointmanRel;

	/** 本村亲缘关系. */
	private List<Kinship> inKinShips;

	
	/** 外村亲缘关系. */
	private List<Kinship> outKinShips;
	
	
	

