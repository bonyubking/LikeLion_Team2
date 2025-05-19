package com.test01;

import org.springframework.stereotype.Component;

@Component("mynamePrn")
public class Nic_NamePrn {
	Nic_Name nic_name;

	public void setNic_name(Nic_Name nic_name) {
		this.nic_name = nic_name;
	}

	@Override
	public String toString() {
		return "Nic_NamePrn [nic_name=" + nic_name + "]";
	}

}
