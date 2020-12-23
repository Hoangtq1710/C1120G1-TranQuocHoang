class Customer {
    constructor(full_name,id_number,day_of_birth,email,address,province,vip,discount,adult,child,rent_days,service,room_type) {
        this.full_name = full_name;
        this.id_number = id_number;
        this.day_of_birth = day_of_birth;
        this.email = email;
        this.address = address;
        this.province = province;
        this.vip = vip;
        this.discount = discount;
        this.adult = adult;
        this.child = child;
        this.rent_days = rent_days;
        this.service = service;
        this.room_type = room_type;
    }
    setFullName(full_name) {
        this.full_name = full_name;
    }
    getFullName(){
        return this.full_name;
    }
    setIdNumber(id_number){
        this.id_number = id_number;
    }
    getIdNumber(){
        return this.id_number;
    }
    setDob(day_of_birth){
        this.day_of_birth = day_of_birth;
    }
    getDob(){
        return this.day_of_birth;
    }
    setEmail(email){
        this.email = email;
    }
    getEmail(){
        return this.email;
    }
    setAddress(address){
        this.address = address;
    }
    getAddress(){
        return this.address;
    }
    setProvince(province){
        this.province = province;
    }
    getProvince(){
        return this.province;
    }
    setVip(vip){
        this.vip = vip;
    }
    getVip(){
        return this.vip;
    }
    setDiscount(discount){
        this.discount = discount;
    }
    getDiscount(){
        return this.discount;
    }
    setAdult(adult){
        this.adult = adult;
    }
    getAdult(){
        return this.adult;
    }
    setChild(child){
        this.child = child;
    }
    getChild(){
        return this.child;
    }
    setRentDays(rent_days){
        this.rent_days = rent_days;
    }
    getRentDays(){
        return this.rent_days;
    }
    setService(service){
        this.service = service;
    }
    getService(){
        return this.service;
    }
    setRoomType(room_type){
        this.room_type = room_type;
    }
    getRoomType(){
        return this.room_type;
    }
    payout(){
        let sv;
        switch (this.getService()) {
            case "Villa": sv = 500;
                break;
            case "House": sv = 300;
                break;
            case "Room": sv = 100;
                break;
        }
        return (this.rent_days*sv*(1-this.discount/100));
    }
}