package com.tangpian.sna.model;

import java.util.Date;

/**
 * 
 * CREATED_AT:2013-02-15 20:08:32, MID:3546060268353796,
 * URL:http://weibo.com/1915869207/zjkeKz3cE, 转发:0, 评论:0, 赞:0, User:7NA_IKNO,
 * TEXT:中国移动//@受基用户20100609:牙膏//@牙牙牙牙牙牙罒皿罒: 内裤//@新垣结裤: 海产品广告//@愛胖達的鯉U:
 * 臭豆腐→_→//@世上最好李珍基_豆腐:保险……//@柒允_赵荣旻弘益人间: 豆腐店=-=//@世上最好李珍基_豆腐: 高档住宅小区【诶？//@嵐湘凱:
 * 紅豆麵包=A=//@_Booooow__: 夜店//@_KNK: 調酒名//@sekil
 * 
 * @author shydow
 * 
 */
public class Item {
	private int id;

	private String code;
	private String user;
	private String content;
	private String time;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	private String other;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	private String url;
	private int forwordNumber;
	private int commentNumber;
	private int likeNumber;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getForwordNumber() {
		return forwordNumber;
	}

	public void setForwordNumber(int forwordNumber) {
		this.forwordNumber = forwordNumber;
	}

	public int getCommentNumber() {
		return commentNumber;
	}

	public void setCommentNumber(int commentNumber) {
		this.commentNumber = commentNumber;
	}

	public int getLikeNumber() {
		return likeNumber;
	}

	public void setLikeNumber(int likeNumber) {
		this.likeNumber = likeNumber;
	}
	
	@Override
	public String toString() {
		return id+"";
	}
}
