beans{
	myaddress(com.sec01.MyAddress, "박길동")
	
	myaddress02(com.sec01.MyAddress,"양독도","독도","101-234")
	
	myaddress03(com.sec01.MyAddress){
		name="김깅돌"
		addr="김깅돌주소"
		tel="김깅돌번호"
	}
	
	info(com.sec01.AddressInfo){
		address = ref(myaddress03),
		age = 30
	}
}