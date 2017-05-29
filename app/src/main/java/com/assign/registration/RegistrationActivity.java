package com.assign.registration;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.soundcloud.android.crop.Crop;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author Raj
 */
public class RegistrationActivity extends BaseActivity {

    private static final int REQUEST_CAPTURE = 100;
    private static final int RESULT_LOAD_IMAGE = 359;
    private static final String TAG = "RegistrationActivity";
    private String strProfileImageBase64;
    private Bitmap bmProfilePicture;

    private EditText mEditTextFirstName;
    private EditText mEditTextLastName;
    private EditText mEditTextPhoneNumber;
    private EditText mEditTextEmailAddress;
    private EditText mEditTextAddress;

    private AutoCompleteTextView mAutoCompleteJobType;
    private AutoCompleteTextView mAutoCompleteQualifation;
    private AutoCompleteTextView mAutoCompleteGender;

    private TextView mTvChangePicture;

    private ImageView mIvProfilePicture;

    private static final String[] GENDER = new String[]{
            "Male", "Female"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // initialize view.
        initLayout();

        fetchInformationForUI();

    }

    /**
     * This method helps to fetch the qualification type and other details.
     */
    private void fetchInformationForUI() {

    }

    /**
     * This method helps to initialize the view.
     */
    private void initLayout() {

        // EditText
        mEditTextFirstName = (EditText) findViewById(R.id.et_user_name);
        mEditTextLastName = (EditText) findViewById(R.id.et_last_name);
        mEditTextPhoneNumber = (EditText) findViewById(R.id.et_phone_number);
        mEditTextEmailAddress = (EditText) findViewById(R.id.et_email_address);
        mEditTextAddress = (EditText) findViewById(R.id.et_address);

        //AutoComplete TextView
        mAutoCompleteJobType = (AutoCompleteTextView) findViewById(R.id.act_job_type);
        mAutoCompleteQualifation = (AutoCompleteTextView) findViewById(R.id.act_qualification);
        mAutoCompleteGender = (AutoCompleteTextView) findViewById(R.id.act_gender);
        updateGenderAutoCompleteTextView();

        // ImageView
        mIvProfilePicture = (ImageView) findViewById(R.id.iv_profilePicture);

        //TextView
        mTvChangePicture = (TextView) findViewById(R.id.tv_changePicture);
        mTvChangePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionToChoosePicture();
            }
        });
    }

    /**
     * Method helps to update gender field.
     */
    private void updateGenderAutoCompleteTextView() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, GENDER);
        mAutoCompleteGender.setAdapter(adapter);
    }

    /**
     * This method shows an alert dialog to pick an image from gallery
     * or take a picture.
     */
    private void showOptionToChoosePicture() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        CharSequence options[] = new CharSequence[]{"Camera", "Gallery"};

        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        getImageFromCamera();
                        break;

                    case 1:
                        getImageFromGallery();
                        break;

                    default:
                }
            }
        });
        builder.show();
    }

    /**
     * This method helps to take a snap from camera.
     */
    private void getImageFromCamera() {
        try {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, REQUEST_CAPTURE);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage().toString());
            showToast(getResources().getString(R.string.camera_permission));
        }
    }

    /**
     * This method helps to fetch image from gallery.
     */
    private void getImageFromGallery() {
        try {
            Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i, RESULT_LOAD_IMAGE);
        } catch (Exception e) {
            showToast(getResources().getString(R.string.storagepermission));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK) return;

        switch (requestCode) {

            case REQUEST_CAPTURE:
                bmProfilePicture = (Bitmap) data.getExtras().get("data");
                displayProfilePicture(bmProfilePicture);
                break;

            case RESULT_LOAD_IMAGE:
                try {
                    bmProfilePicture = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                    showToast("Could not load image");
                }
                break;

            default:
        }
    }

    /**
     * This method helps to display the image and convert it to base 64.
     *
     * @param bmProfilePicture
     */
    private void displayProfilePicture(Bitmap bmProfilePicture) {
        mIvProfilePicture.setImageBitmap(bmProfilePicture);

        // convert image to base 64 and store.
        strProfileImageBase64 = ImageUtils.encodeToBase64(bmProfilePicture);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registration, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
