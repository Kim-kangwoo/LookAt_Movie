package com.lookat.vo;

import java.io.Serializable;

public class MemberAndMembershipVO implements Serializable {
	
	//일반 회원
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
	
	//멤버십
	private int membershipId;
	//private String memberId; 일반회원이랑 중복이니 일단 멤버십에서 주석처리해놓음
	private int membershipPoint;
	
	
	public MemberAndMembershipVO() {
		super();
	}

	public MemberAndMembershipVO(int memberId, String memberName, String memberSex, int memberAge,
			String memberNickname, String memberBirthday, String memberType, String memberLogid, String memberPassword,
			String memberPhonenum, int membershipId, int membershipPoint) {
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
		this.membershipId = membershipId;
		this.membershipPoint = membershipPoint;
	}

	//일반 회원
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
	
	

	//멤버십
	public int getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(int membershipId) {
		this.membershipId = membershipId;
	}

//	public String getMemberId() {
//		return memberId;
//	}
//
//	public void setMemberId(String memberId) {
//		this.memberId = memberId;
//	}

	public int getMembershipPoint() {
		return membershipPoint;
	}

	public void setMembershipPoint(int membershipPoint) {
		this.membershipPoint = membershipPoint;
	}

	@Override
	public String toString() {
		return "MemberAndMembershipVO [memberId=" + memberId + ", memberName=" + memberName + ", memberSex=" + memberSex
				+ ", memberAge=" + memberAge + ", memberNickname=" + memberNickname + ", memberBirthday="
				+ memberBirthday + ", memberType=" + memberType + ", memberLogid=" + memberLogid + ", memberPassword="
				+ memberPassword + ", memberPhonenum=" + memberPhonenum + ", membershipId=" + membershipId
				+ ", membershipPoint=" + membershipPoint + "]";
	}
	
	
	
	
	
	
	
}
