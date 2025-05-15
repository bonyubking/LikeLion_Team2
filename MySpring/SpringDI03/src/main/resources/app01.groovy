import com.sec01.AddressInfo
import com.sec01.MyAddress

beans {
    myAddress(MyAddress, "박길동")
    myAddress02(MyAddress, "최제주도", "제주도", "010-0000-0000")
    myAddress03(MyAddress) {
        name = "김길동"
        addr = "김길동주소"
        tel = "김길동전화번호"
    }

    info(AddressInfo) {
        myAddress = ref(myAddress)
        age = 30
    }
}