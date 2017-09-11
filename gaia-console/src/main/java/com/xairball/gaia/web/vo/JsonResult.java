package com.xairball.gaia.web.vo;

public class JsonResult {
	
	public static final String SUCCESS = "0000";
	
	public static final String DEFEAT = "9999";
	
	public JsonResult(String code) {
		this(code, null);
	}
	
	public JsonResult(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	private String code;
	private String msg;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public static JsonResult buildSuccessResult(){
		return buildSuccessResult(null);
	}
	public static JsonResult buildSuccessResult(String msg){
		return new JsonResult(SUCCESS,msg);
	}
	public static JsonResult buildDefeatResult(String msg){
		return new JsonResult(DEFEAT,msg);
	}
	public static JsonResult buildDefeatResult(){
		return buildDefeatResult(null);
	}
}
