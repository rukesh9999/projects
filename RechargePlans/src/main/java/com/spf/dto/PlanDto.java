package com.spf.dto;

public class PlanDto {
	protected int planNo;
	protected String planName;
	protected int validity;
	protected String plantype;
	protected float amount;

	public PlanDto(int planNo, String planName, int validity, String plantype, float amount) {
		this.planNo = planNo;
		this.planName = planName;
		this.validity = validity;
		this.plantype = plantype;
		this.amount = amount;
	}

	public int getPlanNo() {
		return planNo;
	}

	public void setPlanNo(int planNo) {
		this.planNo = planNo;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	public String getPlantype() {
		return plantype;
	}

	public void setPlantype(String plantype) {
		this.plantype = plantype;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PlanDto [planNo=" + planNo + ", planName=" + planName + ", validity=" + validity + ", plantype="
				+ plantype + ", amount=" + amount + "]";
	}

	
	
	
}
