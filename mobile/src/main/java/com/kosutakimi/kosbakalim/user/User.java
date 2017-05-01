package com.kosutakimi.kosbakalim.user;
import com.kosutakimi.kosbakalim.FirebaseBridge;

/**
 * Created by Batuhan on 24.04.2017
 */

public class User extends Appearances{
    private String email;
    private boolean sign = false;
    private String nickname = "";


    /**
     * creates new user with email nickname and password
     * @param email
     * @param nickname
     * @param password
     * @param rePassword
     * @return 1 if passwords matches else -1, 0 if database error
     */
    public int signUp(String email,String nickname,  String password, String rePassword){
        if(password.equals(rePassword)){
            if(newbridge.createUserEP(email, password)) {
                this.email = email;
                setNickname(nickname);
                sign = true;
                return 1;
            }
            return 0;
        }
        return -1;
    }

    public boolean isSigned(){return sign;}

    /**
     *
     * @param email
     * @param password
     * @return true if operation was successful else false
     */
    public boolean login(String email, String password){
        if(newbridge.sigInEP(email, password)){
            sign = true;
            return true;
        }
        return false;
    }

    /**
     * sign outs user and clears data
     */
    public void logout(){
        sign = false;
        clearData();
    }

    /**
     * clears all variables except email
     */
    public void clearData(){
        age = -1;
        weight = -1;
        height = -1;
        gender = "heli";
        nickname = "";
    }

    public String getNickname() {
        if(nickname.equals("")){
            //nickname = newbridge.getNickname();
        }
        return nickname;
    }

    public void setNickname(String nickname) {
        //newbridge.setNickname(nickname);
        this.nickname = nickname;
    }
}
