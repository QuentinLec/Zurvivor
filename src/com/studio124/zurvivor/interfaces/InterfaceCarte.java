package com.studio124.zurvivor.interfaces;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.studio124.zurvivor.R;

public class InterfaceCarte extends ActionBarActivity implements LocationListener {
	
	private DrawerLayout drawerLayout;
	
    private ActionBarDrawerToggle drawerToggle;
    
	private Intent intent = null;
	
	private LocationManager locationManager;
	
	private Location lastLocation = null ;
	
	private double latitude = 48.8534100 ,
					longitude = 2.3488000;
	
	private GoogleMap gMap;

	private Marker marker;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.interface_carte);
		
		initBoutonsMenuGauche();
		initMenuGauche(R.id.menu_gauche);
		
/**********************************************************************************************************************/
		
//		/** Récupère le locationManager qui gère la localisation */
//	      LocationManager locManager;
//	      locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//	      /** Test si le gps est activé ou non */
//	      if (!locManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
//	          /** on lance notre activity (qui est une dialog) */
//	          Intent localIntent = new Intent(this, PermissionGps.class);
//	          localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//	          startActivity(localIntent);
//	      }
		
	      gMap = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
	      
	      marker = gMap.addMarker(new MarkerOptions().title("Tu veux manger des CHIPS ???")
	    		  										.position(new LatLng(0, 0)));
	      //marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ic_head));
	}
	
	private void initBoutonsMenuGauche() {
		
		/* Bouton Profil */
		final Button boutonProfil = (Button) findViewById(R.id.menu_gauche_bouton_profil);
		
		boutonProfil.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				intent = new Intent(InterfaceCarte.this, InterfaceProfil.class);
				startActivity(intent);
			}
		});
		
		/* Bouton Inventaire */
		final Button boutonInventaire = (Button) findViewById(R.id.menu_gauche_bouton_inventaire);
		
		boutonInventaire.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				intent = new Intent(InterfaceCarte.this, InterfaceInventaire.class);
				startActivity(intent);
			}
		});

		/* Bouton Chat */
		final Button boutonChat = (Button) findViewById(R.id.menu_gauche_bouton_chat);
		
		boutonChat.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				intent = new Intent(InterfaceCarte.this, InterfaceChat.class);
				startActivity(intent);
			}
		});
		
		/* Bouton Options */
		final Button boutonOptions = (Button) findViewById(R.id.menu_gauche_bouton_options);
		
		boutonOptions.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				intent = new Intent(InterfaceCarte.this, InterfaceOptions.class);
				startActivity(intent);
			}
		});
	}
	
	private void initMenuGauche(int id) {
		
		drawerLayout = (DrawerLayout) findViewById(id);
        
        // On crée une instance de la classe prenant pour paramètres :
        // 1. l'activité
        // 2. le drawer layout
        // 3. la ressource graphique
        // 4 et 5. des ressources textuelles permettant d'indiquer l'état du drawer.
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.ic_drawer, R.string.hello_world, R.string.zurvivor);

        // On définit notre ActionBarDrawerToggle comme listener.
        drawerLayout.setDrawerListener(drawerToggle);

        // On précise que l'on souhaite afficher la ressource graphique
        drawerToggle.setDrawerIndicatorEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // On synchronise.
        drawerToggle.syncState();

	}
	
    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if(android.R.id.home == item.getItemId()) {
            if (drawerLayout.isDrawerOpen(Gravity.LEFT) == false) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
            else {
                drawerLayout.closeDrawers();
            }
        }

        return super.onOptionsItemSelected(item);
    }
    
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) 
//    {
//               
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//        	Toast.makeText(InterfaceCarte.this, "Quitter l'appli.", Toast.LENGTH_LONG).show();
//        }
//           return false;
//    }
    
 /*****************************************************************************************************************************/
    
    @Override
	  public void onResume() {
	      super.onResume();

	      //Obtention de la référence du service
	      locationManager = (LocationManager) this.getSystemService(LOCATION_SERVICE);

	      //Si le GPS est disponible, on s'y abonne
	      if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
	          abonnementGPS();
	      }
	  }
	  @Override
	  public void onPause() {
	      super.onPause();

	      //On appelle la méthode pour se désabonner
	      desabonnementGPS();
	  }

	  /**
	   * Méthode permettant de s'abonner à la localisation par GPS.
	   */
	   public void abonnementGPS() {
	       //On s'abonne
	       locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, this);
	   }

	   /**
	   * Méthode permettant de se désabonner de la localisation par GPS.
	   */
	   public void desabonnementGPS() {
	       //Si le GPS est disponible, on s'y abonne
	       locationManager.removeUpdates(this);
	   }

	   @Override
	   public void onLocationChanged(final Location location) {
	       //On affiche dans un Toat la nouvelle Localisation
//	       final StringBuilder msg = new StringBuilder("lat : ");
//	       msg.append(location.getLatitude());
//	       msg.append( "; lng : ");
//	       msg.append(location.getLongitude());
//
//	       Toast.makeText(this, msg.toString(), Toast.LENGTH_SHORT).show();
	       
	       gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 15));
	       
	       marker.setPosition(new LatLng(location.getLatitude(), location.getLongitude()));

	   }

	   @Override
	   public void onProviderDisabled(final String provider) {
	       //Si le GPS est désactivé on se désabonne
	       if("gps".equals(provider)) {
	           desabonnementGPS();
	       }        
	   }

	   @Override
	   public void onProviderEnabled(final String provider) {
	       //Si le GPS est activé on s'abonne
	       if("gps".equals(provider)) {
	           abonnementGPS();
	       }
	   }

	   @Override
	   public void onStatusChanged(final String provider, final int status, final Bundle extras) { }
}
