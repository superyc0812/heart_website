package com.xupt.util;

import java.util.List;

public class ListState {

	private Integer state;
	private String msg;
	private List<?> list;

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<?> getlist() {
		return list;
	}

	public void setlist(List<?> List) {
		list = List;
	}

}
