package com.example.abhishekkoranne.engineersbook.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abhishekkoranne.engineersbook.APIManager;
import com.example.abhishekkoranne.engineersbook.Constant;
import com.example.abhishekkoranne.engineersbook.R;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StudentRegistrationActivity extends AppCompatActivity {

    EditText et_enrollment_no, et_first_name, et_last_name, et_date_of_birth, et_address,
            et_contact_no, et_email, et_interests, et_year_of_passing, et_password, et_confirm_password;

    ImageView img_preview;
    Button btn_browse;
    RadioGroup rg_gender;
    RadioButton rb_male, rb_female;

    Spinner dept_spin, col_spin, univ_spin;
    String gender = "0", d, c, u;

    byte[] imgbyte;

    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        img_preview = (ImageView) findViewById(R.id.img_preview);
        btn_browse = (Button) findViewById(R.id.btn_browse);

        et_enrollment_no = (EditText) findViewById(R.id.et_enrollment_no);
        et_first_name = (EditText) findViewById(R.id.et_first_name);
        et_last_name = (EditText) findViewById(R.id.et_last_name);
        et_date_of_birth = (EditText) findViewById(R.id.et_date_of_birth);
        et_address = (EditText) findViewById(R.id.et_address);
        et_contact_no = (EditText) findViewById(R.id.et_contact_no);
        et_email = (EditText) findViewById(R.id.et_email);
        // et_department_name = (EditText) findViewById(R.id.et_department_name);
        //  et_college_name = (EditText) findViewById(R.id.et_college_name);
        //  et_university_name = (EditText) findViewById(R.id.et_university_name);
        et_year_of_passing = (EditText) findViewById(R.id.et_year_of_passing);
        et_interests = (EditText) findViewById(R.id.et_interests);
        et_password = (EditText) findViewById(R.id.et_password);
        et_confirm_password = (EditText) findViewById(R.id.et_confirm_password);

        rg_gender = (RadioGroup) findViewById(R.id.rg_gender);
        rb_male = (RadioButton) findViewById(R.id.rb_male);
        rb_female = (RadioButton) findViewById(R.id.rb_female);

        dept_spin = (Spinner) findViewById(R.id.dept_spin);
        col_spin = (Spinner) findViewById(R.id.col_spin);
        univ_spin = (Spinner) findViewById(R.id.univ_spin);

        btn_browse.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openGallery();
            }
        });


        String dept[] = {"Computer", "IT", "Mechanical", "Electrical",
                "Civil", "MCA", "IC", "Aeronautical", "EC"};
        ArrayAdapter<String> adap = new ArrayAdapter<String>(StudentRegistrationActivity.this, R.layout.spin_item, dept);
        dept_spin.setAdapter(adap);

        String col[] = {"SVIT", "Parul", "GCET"};
        ArrayAdapter<String> adapt = new ArrayAdapter<String>(StudentRegistrationActivity.this, R.layout.spin_item, col);
        col_spin.setAdapter(adapt);

        String univ[] = {"GTU", "MHU", "DU"};
        ArrayAdapter<String> ad = new ArrayAdapter<String>(StudentRegistrationActivity.this, R.layout.spin_item, univ);
        univ_spin.setAdapter(ad);

        dept_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                d = dept_spin.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        col_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                c = col_spin.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        univ_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                u = univ_spin.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        rg_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                if (checkedId == R.id.rb_male) gender = "0";
                else gender = "1";
            }
        });


        // Sending param

       /* String enroll = et_enrollment_no.getText().toString();
        String fname = et_first_name.getText().toString();
        String lname = et_last_name.getText().toString();
        String dob = et_date_of_birth.getText().toString();
        String address = et_address.getText().toString();
        String contact = et_contact_no.getText().toString();
        String email = et_email.getText().toString();
        String yop = et_year_of_passing.getText().toString();
        String interests=et_interests.getText().toString();
        String password=et_password.getText().toString();*/
    }

    public void openGallery() {
        //invoke image galery using implcit intent
        Intent intent = new Intent(Intent.ACTION_PICK);

        //where to find the data
        File pic_dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String pic_path = pic_dir.getPath();

        //get URI representation
        Uri data = Uri.parse(pic_path);

        intent.setDataAndType(data, "image/*");

        //we will invoke this activity and get something back
        startActivityForResult(intent, 20);
/*        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);                     //ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent,
                "Select file to upload "), req_code);*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            //if reached here, all processed successfully
            if (requestCode == 20) {
                //address of image on SD card
                imageUri = data.getData();

                InputStream inputStream;

                try {
                    inputStream = getContentResolver().openInputStream(imageUri);
                    Bitmap image = BitmapFactory.decodeStream(inputStream);

                    img_preview.setImageBitmap(image);
                    img_preview.setVisibility(View.VISIBLE);

                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    image.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

                    imgbyte = byteArrayOutputStream.toByteArray();
                    /*imageToString(image);*/

                } catch (Exception e) {
                    Log.d("error", "File error: " + e.getStackTrace());
                    Toast.makeText(this, "Unable to open image", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //finish();

                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void studreg(View view) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL) // Bas URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //File file = new File(imageUri.getPath());
/*

        RequestBody reqFile = RequestBody.create(MediaType.parse("image"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("upload", file.getName(), reqFile);
        RequestBody name = RequestBody.create(MediaType.parse("text/plain"), "upload_test");
*/

//        Map<String, Object> params = new HashMap<>();
        Map<String, RequestBody> partMap = new HashMap<>();
        if (imageUri.getPath() != null && !imageUri.getPath().isEmpty()) {
            File attachment = new File(imageUri.getPath());
            String fileName = attachment.getName();
            partMap.put("profile_pic" + "\"; filename=\"" + fileName,
                    RequestBody.create(MediaType.parse("file/*"), attachment));
        }
        partMap.put("enroll", RequestBody.create(MediaType.parse("text/plain"), et_enrollment_no.getText().toString()));
        partMap.put("fname", RequestBody.create(MediaType.parse("text/plain"), et_first_name.getText().toString()));
        partMap.put("lname", RequestBody.create(MediaType.parse("text/plain"), et_last_name.getText().toString()));
        partMap.put("gender", RequestBody.create(MediaType.parse("text/plain"), gender));
        partMap.put("dob", RequestBody.create(MediaType.parse("text/plain"), et_date_of_birth.getText().toString()));
        partMap.put("addr", RequestBody.create(MediaType.parse("text/plain"), et_address.getText().toString()));
        partMap.put("contact", RequestBody.create(MediaType.parse("text/plain"), et_contact_no.getText().toString()));
        partMap.put("email", RequestBody.create(MediaType.parse("text/plain"), et_email.getText().toString()));
        partMap.put("dept_name", RequestBody.create(MediaType.parse("text/plain"), d));
        partMap.put("colg_name", RequestBody.create(MediaType.parse("text/plain"), c));
        partMap.put("univ_name", RequestBody.create(MediaType.parse("text/plain"), u));
        partMap.put("interest", RequestBody.create(MediaType.parse("text/plain"), et_interests.getText().toString()));
        partMap.put("yop", RequestBody.create(MediaType.parse("text/plain"), et_year_of_passing.getText().toString()));
        partMap.put("pass", RequestBody.create(MediaType.parse("text/plain"),  et_password.getText().toString()));


//        params.put("profile_pic", "");
/*
        params.put("enroll", et_enrollment_no.getText().toString());
        params.put("fname", et_first_name.getText().toString());
        params.put("lname", et_last_name.getText().toString());
        params.put("gender", gender);
        params.put("dob", et_date_of_birth.getText().toString());
        params.put("addr", et_address.getText().toString());
        params.put("contact", et_contact_no.getText().toString());
        params.put("email", et_email.getText().toString());
        params.put("dept_name", d);
        params.put("colg_name", c);
        params.put("univ_name", u);
        params.put("interest", et_interests.getText().toString());
        params.put("yop", et_year_of_passing.getText().toString());
        params.put("pass", et_password.getText().toString());
*/


        /*Object ob=new Object();*/
        // Initializing APIManager
        APIManager api = retrofit.create(APIManager.class);

        Call<Map<String, RequestBody>> call = api.registerStudent(partMap);
       /* Call<Map<String, Object>> call = api.registerStudent("", enroll, fname, lname,
                gender, dob, address, contact, email, d, c, u, interests, yop, password);
*/
        final ProgressDialog progressDialog = new ProgressDialog(StudentRegistrationActivity.this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();

        call.enqueue(new Callback<Map<String, RequestBody>>() {
            @Override
            public void onResponse(Call<Map<String, RequestBody>> call, Response<Map<String, RequestBody>> response) {
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }

                try {
                    // Read response as follow
                    if (response != null && response.body() != null) {
                        Toast.makeText(StudentRegistrationActivity.this, "Success", Toast.LENGTH_SHORT).show();

                        Log.d("Error", "onResponse: body: " + response.body());

                        // Read response as follow
                        Map<String, RequestBody> content = response.body();
                        startActivity(new Intent(StudentRegistrationActivity.this, LoginActivity.class));

                        //content.get("email").getAsString();
                        //content.get("password").getAsString();

                        // Convert JSONArray to your custom model class list as follow
                        Gson gson = new Gson();
                        //new TypeToken<List<YourModelClass>>(){}.getType());
                    } else {
                        Toast.makeText(StudentRegistrationActivity.this, "No response available.", Toast.LENGTH_SHORT).show();

                        Log.d("Error", "No response available");
                    }
                } catch (Exception e) {
                    Toast.makeText(StudentRegistrationActivity.this, "Error occurred.", Toast.LENGTH_SHORT).show();

                    Log.d("Error", "Error in reading response: " + e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<Map<String, RequestBody>> call, Throwable t) {
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }

                Toast.makeText(StudentRegistrationActivity.this, "Failed", Toast.LENGTH_SHORT).show();

                Log.d("Error", "onFailure: " + t.getMessage());
            }
        });
    }

/*
    private String imageToString(Bitmap bitmap) {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArray);

        byte[] imgbyte=byteArray.toByteArray();
        Base64.encodeToString()
    }
*/

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
