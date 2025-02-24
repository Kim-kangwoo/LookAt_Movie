package com.lookat.vo;

import java.io.Serializable;

public class MembershipVO implements Serializable{
	
	private int membershipId;
	private int memberId;
	private int membershipPoint;
	private String grade;
	
	public MembershipVO() {
		super();
	}

	public MembershipVO(int membershipId, int memberId, int membershipPoint) {
		super();
		this.membershipId = membershipId;
		this.memberId = memberId;
		this.membershipPoint = membershipPoint;
	}
	
	public MembershipVO(int membershipId, int memberId, int membershipPoint, String grade) {
		super();
		this.membershipId = membershipId;
		this.memberId = memberId;
		this.membershipPoint = membershipPoint;
		this.grade = grade;
	}
	
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}


	public int getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(int membershipId) {
		this.membershipId = membershipId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getMembershipPoint() {
		return membershipPoint;
	}

	public void setMembershipPoint(int membershipPoint) {
		this.membershipPoint = membershipPoint;
	}

	@Override
	public String toString() {
		return "MembershipVO [membershipId=" + membershipId + ", memberId=" + memberId + ", membershipPoint="
				+ membershipPoint + ", grade=" + grade + "]";
	}

	
	
	
}
