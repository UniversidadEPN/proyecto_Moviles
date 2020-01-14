package com.epn.proyectomoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class activity_navegation : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  , AdapterView.OnItemClickListener{


    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView
    private lateinit var listView: ListView
    private lateinit var imagen_Adapter2 : ImageAdapter2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navegation)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)

        listView()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_tutoles -> {
                Toast.makeText(this, "Tus Tutores", Toast.LENGTH_SHORT).show()

                var detalleSer : Intent = Intent(this, DetalleServicio::class.java)
                startActivity(detalleSer)


            }
            R.id.nav_servicios -> {
                Toast.makeText(this, "Tus Servicios", Toast.LENGTH_SHORT).show()
                var servi : Intent = Intent(this, ServiciosRealizados::class.java)
                startActivity(servi)
            }
            R.id.nav_configuracion -> {
                Toast.makeText(this, "Configuracion", Toast.LENGTH_SHORT).show()
            }

        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    fun listView(){

        listView = findViewById(R.id.idListaBib)
        listView.setOnItemClickListener(this)
        imagen_Adapter2  = ImageAdapter2(this)
        listView!!.adapter = imagen_Adapter2
        imagen_Adapter2.notifyDataSetChanged()

    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val intent = Intent(this, bibliotecas::class.java)
        startActivity(intent)

    }
}
