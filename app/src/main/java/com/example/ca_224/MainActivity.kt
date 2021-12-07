package com.example.ca_224

//import android.Manifest
import android.content.Intent
//import android.content.pm.PackageManager
//import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.provider.MediaStore
//import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

//import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    val email="abc@gmail.com"
    val pass ="1234"
    val url ="https://www.google.com"
    val url1 ="https://www.facebook.com"
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button)
        val em = findViewById<EditText>(R.id.inputEmail)
        val pas = findViewById<EditText>(R.id.inputPassword)
        val lk = findViewById<ImageView>(R.id.googleLogin)
        val lk1 = findViewById<ImageView>(R.id.facebookLogin)
        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            //val PICK_IMAGE=100
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), 285)

        }

        btn.setOnClickListener {
//            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()

            if(em.text.toString()==email && pass==pas.text.toString()) {
                val i = Intent(this, Todo::class.java)
                startActivity(i)
            }else
            {
                Toast.makeText(this@MainActivity, "Wrong Credentials", Toast.LENGTH_SHORT).show()
            }


        }
        lk.setOnClickListener{
            //Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
            val j = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(j)
        }
        lk1.setOnClickListener{
            //Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
            val j = Intent(Intent.ACTION_VIEW, Uri.parse(url1))
            startActivity(j)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imageView = findViewById<ImageView>(R.id.imageView)
        if(requestCode == 285){
            if(data!=null)
            {
                imageView.setImageURI(data.data)
            }
        }
    }
}