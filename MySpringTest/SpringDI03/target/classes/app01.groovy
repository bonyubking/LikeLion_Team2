beans {
	
	myaddress(com.sec01.MyAddress, "박길동")
	
	myaddress02(com.sec01.MyAddress, "최제주도", "JEJU", "111")
	
	myaddress03(com.sec01.MyAddress){
		street = "본엽"
		city = "seol"
		num = "111"
	}
	
	info(com.sec01.AddressInfo) {
		address = ref(myaddress03)
		age = 30
	}
}