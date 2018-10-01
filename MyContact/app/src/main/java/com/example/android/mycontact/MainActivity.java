package com.example.android.mycontact;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout contact_container;

    ArrayList<ContactData> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar ab=getSupportActionBar();
        ab.hide();

        dataList=new ArrayList<>();


        contact_container=(LinearLayout)findViewById(R.id.contact_container);
        loadData();
        /*int count=cr.getCount();
        if(count>0)
        {
           for(int i=0;i<count;i++)
           {
               boolean b=cr.move(i);
               long id=cr.getLong(0);
               String name=cr.getString(1);
               String phone=cr.getString(2);
               String email=cr.getString(3);

               View view=inflater.inflate(R.layout.item_contact,null);
               TextView tvName=(TextView)view.findViewById(R.id.textName);
               TextView tvNumber=(TextView)view.findViewById(R.id.textNumber);
               tvName.setText(name);
               tvNumber.setText(phone);
               contact_container.addView(view);


           }
        }*/
        //Toast.makeText(this,"Count: "+count,Toast.LENGTH_LONG).show();




        /*for(int i=0;i<100;i++)
        {
            View view=inflater.inflate(R.layout.item_contact,null);
            TextView tvName=(TextView)view.findViewById(R.id.textName);
            TextView tvNumber=(TextView)view.findViewById(R.id.textNumber);
            tvName.setText("Name "+i);
            tvNumber.setText("Number "+i);
            contact_container.addView(view);
        }*/
    }
    public void onAdd(View v)
    {
        Intent intent=new Intent(this,AddContactActivity.class);
        startActivity(intent);
        //finish();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        loadData();
    }
    private void loadData()
    {
        contact_container.removeAllViews();
        dataList.clear();

        LayoutInflater inflater=getLayoutInflater();
        ContactDB contactDB=new ContactDB(this);
        SQLiteDatabase db=contactDB.getReadableDatabase();

        Cursor cr=db.query("contact",null,null,null,null,null,"cname DESC");
        if(cr.moveToFirst())
        {
            do {

                long id=cr.getLong(0);
                String name=cr.getString(1);
                String phone=cr.getString(2);
                String email=cr.getString(3);

                ContactData cd=new ContactData();
                cd.setId(id);
                cd.setName(name);
                cd.setEmail(email);
                cd.setPhone(phone);
                dataList.add(cd);



                View view=inflater.inflate(R.layout.item_contact,null);
                TextView tvName=(TextView)view.findViewById(R.id.textName);
                TextView tvNumber=(TextView)view.findViewById(R.id.textNumber);
                ImageButton btnMail=(ImageButton)view.findViewById(R.id.btn_mail);
                ImageButton btnCall=(ImageButton)view.findViewById(R.id.btn_call);
                tvName.setText(name);
                tvNumber.setText(phone);
                if(email.equals(""))
                {
                    btnMail.setVisibility(View.GONE);
                }
                btnCall.setOnClickListener(this);
                btnMail.setOnClickListener(this);
                contact_container.addView(view);
            }while (cr.moveToNext());
        }
        db.close();
    }

    @Override
    public void onClick(View view)
    {
        int id=view.getId();
        if(id==R.id.btn_call)
        {
           doCall(view);
        }
        else if(id==R.id.btn_mail)
        {

        }
    }
    private void doCall(View view)
    {
         for (int i=0;i<contact_container.getChildCount();i++)
         {
             View item=contact_container.getChildAt(i);
             ImageButton btn=(ImageButton)item.findViewById(R.id.btn_call);
             if(view.equals(btn))
             {
                 //Toast.makeText(this,phoneList.get(i),Toast.LENGTH_LONG).show();
                 //contact_container.removeView(item);
                 contact_container.removeViewAt(i);
                 ContactData cd=dataList.get(i);
                 dataList.remove(i);

                 ContactDB contactDB=new ContactDB(this);
                 SQLiteDatabase db=contactDB.getWritableDatabase();
                 String [] args={""+cd.getId()};
                 db.delete("contact","id=?",args);
                 db.close();
                 break;
             }

         }
    }
}
