package com.kosutakimi.kosbakalim.user;

import com.kosutakimi.kosbakalim.FirebaseBridge;

/**
 * Created by Batuhan on 24.04.2017
 */

abstract class Appearances {
    protected int weight = -1;
    protected int height = -1;
    protected String gender = "heli";
    protected int age = -1;
    protected static FirebaseBridge newbridge = new FirebaseBridge();

    public int getAge() {
        if(age == -1){
            //age = newbridge.getAge();
        }
        return age;
    }

    public int getHeight() {
        if(height == -1){
            //height = newbridge.getHeight();
        }
        return height;
    }

    public int getWeight() {
        if(weight == -1){
            //weight = newbridge.getWeight();
        }
        return weight;
    }

    /**
     *
     * @return male, female, heli(if doesn't set)
     */
    public String getGender() {
        if(gender.equals("heli")){
            //gender = newbridge.getGender();
        }
        return gender;
    }

    public void setAge(int age) {
        this.age = age;
        //newbridge.setAge(age);
    }

    public void setGender(String gender) {
        this.gender = gender;
        //newbridge.setGender(gender);
    }

    public void setHeight(int height) {
        this.height = height;
        //newbridge.setHeight(height);
    }

    public void setWeight(int weight) {
        this.weight = weight;
        //newbridge.setWeight(weight);
    }
}
