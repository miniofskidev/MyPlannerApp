package ir.cdesign.planner.model;

/**
 * Created by amin pc on 13/09/2016.
 */
public class Tasks {

    //private variables
    int _id;
    String _body;
    String _title;

    // Empty constructor
    public Tasks(){

    }
    // constructor
    public Tasks(int id, String name, String _title){
        this._id = id;
        this._body = name;
        this._title = _title;
    }

    // constructor
    public Tasks(String name, String title){
        this._body = name;
        this._title = title;
    }
    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getTitle(){
        return this._body;
    }

    // setting name
    public void setTitle(String name){
        this._body = name;
    }

    // getting phone number
    public String getBody(){
        return this._title;
    }

    // setting phone number
    public void setBodu(String phone_number){
        this._title = phone_number;
    }

}
