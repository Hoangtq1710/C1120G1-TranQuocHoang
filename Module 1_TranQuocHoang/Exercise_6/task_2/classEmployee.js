class Employee {
    constructor(emName,emId,emDob,emPhone,emEmail,emLevel,emPosition) {
        this.emName = emName;
        this.emId = emId;
        this.emDob = emDob;
        this.emPhone = emPhone;
        this.emEmail = emEmail;
        this.emLevel = emLevel;
        this.emPosition = emPosition;
        this.setDepartment();
        this.setBenefit();
        this.setSalary();
    }
    setEmName(emName){
        this.emName = emName;
    }
    getEmName(){
        return this.emName;
    }
    setEmId(emId){
        this.emId = emId;
    }
    getEmId(){
        return this.emId;
    }
    setEmDob(emDob){
        this.emDob = emDob;
    }
    getEmDob(){
        return this.emDob;
    }
    setEmPhone(emPhone){
        this.emPhone = emPhone;
    }
    getEmPhone(){
        return this.emPhone;
    }
    setEmEmail(emEmail){
        this.emEmail = emEmail;
    }
    getEmEmail(){
        return this.emEmail;
    }
    setEmLevel(emLevel){
        this.emLevel = emLevel;
    }
    getEmLevel(){
        return this.emLevel;
    }
    setEmPosition(emPosition){
        this.emPosition = emPosition;
    }
    getEmPosition(){
        return this.emPosition;
    }
    setDepartment() {
        switch (this.position) {
            case "Receptionist":
            case "Service staff":
                this.department = "Service";
                break;
            case "Specialist":
                this.department = "Sale-Marketing";
                break;
            case "Supervisor":
                this.department = "Administration";
                break;
            case "Manager":
            case "Director":
                this.department = "Management";
                break;
        }
    }
    getBenefit() {
        return this.benefit;
    }
    setBenefit() {
        switch (this.emPosition) {
            case "Receptionist":
            case "Service staff":
                this.benefit = 100;
                break;
            case "Specialist":
                this.benefit = 200;
                break;
            case "Supervisor":
                this.benefit = 300;
                break;
            case "Manager":
                this.benefit = 400;
                break;
            case "Director":
                this.benefit = 500;
                break;
        }
    }
    getBasicSalary() {
        let basicSalary;
        switch (this.emPosition) {
            case "Receptionist":
                basicSalary = 1000;
                break;
            case "Service staff":
                basicSalary = 1200;
                break;
            case "Specialist":
                basicSalary = 2200;
                break;
            case "Supervisor":
                basicSalary = 2500;
                break;
            case "Manager":
                basicSalary = 3000;
                break;
            case "Director":
                basicSalary = 4000;
                break;
        }
        return basicSalary;
    }
    setSalary() {
        this.setBenefit();
        this.salary = this.benefit + this.getBasicSalary();
    }
    getSalary() {
        return this.salary;
    }
}