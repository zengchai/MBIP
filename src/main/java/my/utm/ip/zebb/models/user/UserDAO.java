package my.utm.ip.zebb.models.user;

import my.utm.ip.zebb.models.product.ProductDAO;

public class UserDAO {
private int id;
private String username;
private String fullname;
private String nickname;
private String password;
private String email;
private String phoneNum;
private String preferredLanguage;
private String category;
private String poscode;
private String address;
private int level;


public UserDAO(int id, String username, String fullname, String nickname, String password, String email, String phoneNum,
        String preferredLanguage, String category, String poscode, String address, int level) {
    this.id = id;
    this.username = username;
    this.fullname = fullname;
    this.nickname = nickname;
    this.password = password;
    this.email = email;
    this.phoneNum = phoneNum;
    this.preferredLanguage = preferredLanguage;
    this.category = category;
    this.poscode = poscode;
    this.address = address;
    this.level = level;
}


public UserDAO() {
    this.id = 0;
}

public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getUsername() {
    return username;
}
public void setUsername(String username) {
    this.username = username;
}
public String getFullname() {
    return fullname;
}
public void setFullname(String fullname) {
    this.fullname = fullname;
}
public String getNickname() {
    return nickname;
}
public void setNickname(String nickname) {
    this.nickname = nickname;
}
public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
public String getPhoneNum() {
    return phoneNum;
}
public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
}
public String getPreferredLanguage() {
    return preferredLanguage;
}
public void setPreferredLanguage(String preferredLanguage) {
    this.preferredLanguage = preferredLanguage;
}
public String getCategory() {
    return category;
}
public void setCategory(String category) {
    this.category = category;
}
public String getPoscode() {
    return poscode;
}
public void setPoscode(String poscode) {
    this.poscode = poscode;
}
public String getAddress() {
    return address;
}
public void setAddress(String address) {
    this.address = address;
}
public int getLevel() {
    return level;
}
public void setLevel(int level) {
    this.level = level;
}
}
