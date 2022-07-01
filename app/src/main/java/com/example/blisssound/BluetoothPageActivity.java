package com.example.blisssound;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Set;


public class BluetoothPageActivity extends AppCompatActivity {
    public static final int REQUEST_ENABLE_BT = 0;
    Button onbutton;
    Button offbutton;
    Button pairedbutton;
    ImageView onoffimg;
    TextView pairedtext;
    BluetoothAdapter mBlueAdapter;

    private void showToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bluetooth_page);
        onbutton = findViewById(R.id.onbutton);
        offbutton = findViewById(R.id.offbutton);
        pairedbutton = findViewById(R.id.pairedbutton);
        pairedtext = (TextView) findViewById(R.id.pairedtext);
        onoffimg = findViewById(R.id.onoffimg);
        mBlueAdapter = BluetoothAdapter.getDefaultAdapter();


        if (mBlueAdapter.isEnabled()) {
            onoffimg.setImageResource(R.drawable.connected);
        } else {
            onoffimg.setImageResource(R.drawable.disconnected);
        }


        onbutton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                if (!mBlueAdapter.isEnabled()) {
                    showToast("Turning on Bluetooth..");
                    onoffimg.setImageResource(R.drawable.connected);
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(intent, REQUEST_ENABLE_BT);
                } else {
                    showToast("Bluetooth is already on");
                }
            }
        });


        offbutton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                if (mBlueAdapter.isEnabled()) {
                    mBlueAdapter.disable();
                    showToast("Turning Bluetooth off");
                    onoffimg.setImageResource(R.drawable.disconnected);
                } else {
                    showToast("Bluetooth is already off");
                }
            }
        });

        pairedbutton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                Set<BluetoothDevice> devices = mBlueAdapter.getBondedDevices();
                if (devices.size() > 0) {
                    findViewById(R.id.pairedtext).setVisibility(View.VISIBLE);
                    for (BluetoothDevice device : devices) {

                        pairedtext.setText(device.getName() + "\n" + device.getAddress());
                    }
                }
                else {
                    pairedtext.setText("No connected devices");
                }
            }
        });
    }


}
