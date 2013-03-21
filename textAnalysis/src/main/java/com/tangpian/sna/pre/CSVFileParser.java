package com.tangpian.sna.pre;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.tangpian.sna.model.Item;

public class CSVFileParser implements Parser {

	private static int count = 0;

	/**
	 * 
	 * line:
	 * CREATED_AT:2013-02-15 20:08:32, MID:3546060268353796,
	 * URL:http://weibo.com/1915869207/zjkeKz3cE, 转发:0, 评论:0, 赞:0,
	 * User:7NA_IKNO, TEXT:中国移动//@受基用户20100609:牙膏//@牙牙牙牙牙牙罒皿罒: 内裤//@新垣结裤:
	 * 海产品广告//@愛胖達的鯉U: 臭豆腐→_→//@世上最好李珍基_豆腐:保险……//@柒允_赵荣旻弘益人间:
	 * 豆腐店=-=//@世上最好李珍基_豆腐: 高档住宅小区【诶？//@嵐湘凱: 紅豆麵包=A=//@_Booooow__: 夜店//@_KNK:
	 * 調酒名//@sekil
	 */
	public Item parse(String line) {
		Item origin = new Item();

		// try {
		// origin.setTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
		// .parse(line.substring(11, line.indexOf(", MID:"))));
		// } catch (ParseException e) {
		// origin.setTime(new Date());
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		origin.setTime(line.substring(11, line.indexOf(", MID:")));
		origin.setCode(line.substring(line.indexOf(", MID:") + 6,
				line.indexOf(", URL:")));
		origin.setUrl(line.substring(line.indexOf(", URL:") + 6,
				line.indexOf(", 转发:")));
		origin.setForwordNumber(Integer.parseInt(line.substring(
				line.indexOf(", 转发:") + 5, line.indexOf(", 评论:"))));
		origin.setCommentNumber(Integer.parseInt(line.substring(
				line.indexOf(", 评论:") + 5, line.indexOf(", 赞:"))));
		origin.setLikeNumber(Integer.parseInt(line.substring(
				line.indexOf(", 赞:") + 4, line.indexOf(", User:"))));
		origin.setUser(line.substring(line.indexOf(", User:") + 7,
				line.indexOf(", TEXT:")));
		origin.setContent(line.substring(line.indexOf(", TEXT:") + 7));

		count++;

		return origin;
	}

}
