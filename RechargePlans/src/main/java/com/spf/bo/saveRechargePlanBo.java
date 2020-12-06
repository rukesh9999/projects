package com.spf.bo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class saveRechargePlanBo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
		return "saveRechargePlanBo [planName=" + planName + ", planType=" + planType + ", validity=" + validity
				+ ", amount=" + amount + "]";
	}


}
