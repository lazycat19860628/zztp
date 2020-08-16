package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Table;


public class CommentResult {
	private String month;
	private String name;
	private String unit;
	private String point;
	private String rankInCenter;
	private String rankInUnit;
	private String grade;
	private String rewardValue;
	private String rewardMatter;
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public String getRankInCenter() {
		return rankInCenter;
	}
	public void setRankInCenter(String rankInCenter) {
		this.rankInCenter = rankInCenter;
	}
	public String getRankInUnit() {
		return rankInUnit;
	}
	public void setRankInUnit(String rankInUnit) {
		this.rankInUnit = rankInUnit;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getRewardValue() {
		return rewardValue;
	}
	public void setRewardValue(String rewardValue) {
		this.rewardValue = rewardValue;
	}
	public String getRewardMatter() {
		return rewardMatter;
	}
	public void setRewardMatter(String rewardMatter) {
		this.rewardMatter = rewardMatter;
	}
	
	
	
}
