package com.qstm.tabdesign.question;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DBService {
    private SQLiteDatabase db;
    public DBService(){
        db= SQLiteDatabase.openDatabase("/data/data/com.qstm.tabdesign/databases/question.db", null, SQLiteDatabase.OPEN_READONLY);
    }
    public List<Qusetion.Question> getQuestions(){
        List<Qusetion.Question> list=new ArrayList<Qusetion.Question>();
        Cursor cursor=db.rawQuery("select * from question", null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            int count=cursor.getCount();
            for(int i=0;i<count;++i){
                cursor.moveToPosition(i);
                Qusetion.Question question=new Qusetion.Question();
                question.question=cursor.getString(cursor.getColumnIndex("question"));
                question.answerA=cursor.getString(cursor.getColumnIndex("answerA"));
                question.answerB=cursor.getString(cursor.getColumnIndex("answerB"));
                question.answerC=cursor.getString(cursor.getColumnIndex("answerC"));
                question.answerD=cursor.getString(cursor.getColumnIndex("answerD"));
                question.answer=cursor.getInt(cursor.getColumnIndex("answer"));
                question.ID=cursor.getInt(cursor.getColumnIndex("ID"));
                question.explaination=cursor.getString(cursor.getColumnIndex("explaination"));
                question.selectedAnser=-1;
                list.add(question);
            }
        }
        return list;
    }
}
