package com.spf.form;
public class SaveRechargePlanForm {
	protected int planNo;
	protected String planName;
	protected String planType;
	protected int validity;
	protected float amount;
	
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
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	public int getValidity() {
		return validity;
	}
	public void setValidity(int validity) {
		this.validity = validity;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "SearchForm [planName=" + planName + ", planType=" + planType + ", validity=" + validity + ", amount="
				+ amount + "]";
	}
    

}
