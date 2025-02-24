package com.lookat.dto;

public class MemberDTO {
	
	private String memberLogId;
	private String memberPassword;
	private String memberName;
	private String memberNickname;
	private String memberSex;
	private int memberAge;
	private String memberBirthday;
	private String memberType;
	private String memberPhonenum;
	
	
	public MemberDTO() {
		super();
	}
	public MemberDTO(String memberLogId, String memberPassword, String memberName, String memberNickname,
			String memberSex, int memberAge, String memberBirthday, String memberType, String memberPhonenum) {
		super();
		this.memberLogId = memberLogId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberNickname = memberNickname;
		this.memberSex = memberSex;
		this.memberAge = memberAge;
		this.memberBirthday = memberBirthday;
		this.memberType = memberType;
		this.memberPhonenum = memberPhonenum;
	}
	
	public MemberDTO(String memberLogId, String memberPassword, String memberName, String memberNickname,
			String memberSex, int memberAge, String memberBirthday, String memberPhonenum) {
		super();
		this.memberLogId = memberLogId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberNickname = memberNickname;
		this.memberSex = memberSex;
		this.memberAge = memberAge;
		this.memberBirthday = memberBirthday;
		this.memberPhonenum = memberPhonenum;
	}
	
	public String getMemberLogId() {
		return memberLogId;
	}
	public void setMemberLogId(String memberLogId) {
		this.memberLogId = memberLogId;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberNickname() {
		return memberNickname;
	}
	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}
	public String getMemberSex() {
		return memberSex;
	}
	public void setMemberSex(String memberSex) {
		this.memberSex = memberSex;
	}
	public int getMemberAge() {
		return memberAge;
	}
	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}
	public String getMemberBirthday() {
		return memberBirthday;
	}
	public void setMemberBirthday(String memberBirthday) {
		this.memberBirthday = memberBirthday;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	public String getMemberPhonenum() {
		return memberPhonenum;
	}
	public void setMemberPhoneNum(String memberPhonenum) {
		this.memberPhonenum = memberPhonenum;
	}
	@Override
	public String toString() {
		return "MemberDTO [memberLogId=" + memberLogId + ", memberPassword=" + memberPassword + ", memberName="
				+ memberName + ", memberNickname=" + memberNickname + ", memberSex=" + memberSex + ", memberAge="
				+ memberAge + ", memberBirthday=" + memberBirthday + ", memberType=" + memberType + ", memberPhonenum="
				+ memberPhonenum + "]";
	}
	
	
	
	

}
