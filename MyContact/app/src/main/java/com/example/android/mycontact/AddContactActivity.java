package com.example.android.mycontact;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddContactActivity extends AppCompatActivity {

    EditText edName,edPhone,edEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        edName=(EditText)findViewById(R.id.editName);
        edPhone=(EditText)findViewById(R.id.editPhone);
        edEmail=(EditText)findViewById(R.id.editEmail);
    }
    public void onSave(View v)
    {
        long id=System.currentTimeMillis();
        String name=edName.getText().toString();
        String phone=edPhone.getText().toString();
        String email=edEmail.getText().toString();


        ContactDB contactDB=new ContactDB(this);
        SQLiteDatabase db=contactDB.getWritableDatabase();


      /*  String cmd="insert into contact (id,cname,cphone,cemail) values" +
                "(?,?,?,?)";
        String [] params={""+id,name,phone,email};

        db.rawQuery(cmd,params);
        db.close();*/





        ContentValues cv=new ContentValues();
        //cv.put("Column_name","Column value");
        cv.put("id",id);
        cv.put("cname",name);
        cv.put("cphone",phone);
        cv.put("cemail",email);

        long record= db.insert("contact",null,cv);
        if(record>0)
        {
            Toast.makeText(this,"Contact Saved",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Something went wrong",Toast.LENGTH_SHORT).show();
        }
    }
}
