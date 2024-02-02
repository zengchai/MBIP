package my.utm.ip.zebb.models.user;

public class User {
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
private String winner;
private boolean authenticated;

public User(){
 this.authenticated = false;   
}

public User(String username,String email,String password){
    this.username = username;
    this.email = email;
    this.password = password;
    this.authenticated = true;  
   }

   public User( String username, String fullname, String nickname,String email, String phoneNum,
   String preferredLanguage, String category, String poscode, String address){
    this.username = username;
    this.fullname = fullname;
    this.nickname = nickname;
    this.email = email;
    this.phoneNum = phoneNum;
    this.preferredLanguage = preferredLanguage;
    this.category = category;
    this.poscode = poscode;
    this.address = address; 
   }


public User(int id, String username, String fullname, String nickname, String password, String email, String phoneNum,
        String preferredLanguage, String category, String poscode, String address, int level, String winner) {
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
    this.winner = winner;
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
public boolean getAuthenticated() {
    return authenticated;
}
public void setAuthenticated(boolean authenticated) {
    this.authenticated = authenticated;
}

public String getWinner() {
    return winner;
}

public void setWinner(String winner) {
    this.winner = winner;
}

public void fromDAO(final UserDAO dao) {

    this.id = dao.getId();
    this.username = dao.getUsername();
    this.fullname = dao.getFullname();
    this.nickname = dao.getNickname();
    this.password = dao.getPassword();
    this.email = dao.getEmail();
    this.phoneNum = dao.getPhoneNum();
    this.preferredLanguage = dao.getPreferredLanguage();
    this.category = dao.getCategory();
    this.poscode = dao.getPoscode();
    this.address = dao.getAddress();
    this.level = dao.getLevel();
}

    public UserDAO toDAO() {
        UserDAO dao = new UserDAO();
        if (this.id != 0)
        dao.setId(this.id);
        dao.setUsername(this.username);
        dao.setFullname(this.fullname);
        dao.setNickname(this.nickname);
        dao.setPassword(this.password);
        dao.setEmail(this.email);
        dao.setPhoneNum(this.phoneNum);
        dao.setPreferredLanguage(this.preferredLanguage);
        dao.setCategory(this.category);
        dao.setPoscode(this.poscode);
        dao.setAddress(this.address);
        dao.setLevel(this.level);
        return dao;
    }

    public User(final UserDAO dao){
        this.fromDAO(dao);
    }
}
