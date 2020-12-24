class Employee {
    constructor(fullName, birthday, cmnd, phone, email, level, position) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.cmnd = cmnd;
        this.phone = phone;
        this.email = email;
        this.level = level;
        this.position = position;
        this.setDepartment();
        this.setBenefit();
        this.setSalary();
    }
    getFullName() {
        return this.fullName;
    }
    setFullName(fullname) {
        this.fullName = fullName;
    }
    getBirthday() {
        return this.birthday;
    }
    setBirthday(birthday) {
        this.birthday = birthday;
    }
    getCmnd() {
        return this.cmnd;
    }
    setCmnd(cmnd) {
        this.cmnd = cmnd;
    }
    getPhone() {
        return this.phone;
    }
    setPhone(phone) {
        this.phone = phone;
    }
    getEmail() {
        return this.email;
    }
    setEmail(email) {
        this.email = email;
    }
    getLevel() {
        return this.level;
    }
    setLevel(level) {
        this.level = level;
    }
    getPosition() {
        return this.position;
    }
    setPosition(position) {
        this.position = position;
    }
    getDepartment() {
        return this.department;
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
        switch (this.position) {
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
    getSalary() {
        return this.salary;
    }
    getBasicSalary() {
        let basicSalary;
        switch (this.position) {
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
}