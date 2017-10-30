package projects.android.my.filewriting;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    EditText txtMessage;
    //File Name
    String fileName = "Myfile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMessage = (EditText) findViewById(R.id.txtMessage);
    }

    public void SaveData(View view)
    {
        FileOutputStream outputStream;
        try
        {
            //Open file for writting
            outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
            String msg = txtMessage.getText().toString();
            //write the file based on the text entered
            outputStream.write(msg.getBytes());
            //close connetion with the file
            outputStream.close();
        }
        catch (IOException ex)
        {
            Toast.makeText(this,ex.getMessage(),Toast.LENGTH_LONG).show();
        }
        Toast.makeText(this,"File Saved",Toast.LENGTH_LONG).show();

    }

    public void CheckFile(View view)
    {
        // check if file is created
        File file = new File(this.getFilesDir(),fileName);
        if(file.exists())
        {
            // file present
            Toast.makeText(this,"File Exists",Toast.LENGTH_LONG).show();
        }
        else
        {
            //file not present
            Toast.makeText(this,"File Does Not Exists",Toast.LENGTH_LONG).show();
        }
    }
}
