package com.lookat.vo;

import java.io.Serializable;

public class MemberVO implements Serializable {
	
	private int memberId;
	private String memberName;
	private String memberSex;
	private int memberAge;
	private String memberNickname;
	private String memberBirthday;
	private String memberType;
	private String memberLogid;
	private String memberPassword;
	private String memberPhonenum;
	
	public MemberVO() {
		super();
	}
	
	public MemberVO(int memberId, String memberName, String memberSex, int memberAge, String memberNickname,
			String memberBirthday, String memberType, String memberLogid, String memberPassword, String memberPhonenum) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberSex = memberSex;
		this.memberAge = memberAge;
		this.memberNickname = memberNickname;
		this.memberBirthday = memberBirthday;
		this.memberType = memberType;
		this.memberLogid = memberLogid;
		this.memberPassword = memberPassword;
		this.memberPhonenum = memberPhonenum; 
	}
	
	
	
	public String getMemberPhonenum() {
		return memberPhonenum;
	}

	public void setMemberPhonenum(String memberPhonenum) {
		this.memberPhonenum = memberPhonenum;
	}

	public int getMemberId() {
		return memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public String getMemberSex() {
		return memberSex;
	}
	public int getMemberAge() {
		return memberAge;
	}
	public String getMemberNickname() {
		return memberNickname;
	}
	public String getMemberBirthday() {
		return memberBirthday;
	}
	public String getMemberType() {
		return memberType;
	}
	public String getMemberLogid() {
		return memberLogid;
	}
	public String getMemberPassword() {
		return memberPassword;
	}

	
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public void setMemberSex(String memberSex) {
		this.memberSex = memberSex;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}

	public void setMemberBirthday(String memberBirthday) {
		this.memberBirthday = memberBirthday;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public void setMemberLogid(String memberLogid) {
		this.memberLogid = memberLogid;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	@Override
	public String toString() {
		return "MemberVO [memberId=" + memberId + ", memberName=" + memberName + ", memberSex=" + memberSex
				+ ", memberAge=" + memberAge + ", memberNickname=" + memberNickname + ", memberBirthday="
				+ memberBirthday + ", memberType=" + memberType + ", memberLogid=" + memberLogid + ", memberPassword="
				+ memberPassword + ", memberPhonenum=" + memberPhonenum + "]";
	}
	
	
	
	
}
