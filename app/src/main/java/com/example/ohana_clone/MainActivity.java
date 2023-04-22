package com.example.ohana_clone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.os.StrictMode;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.ohana_clone.fragments.FavoriteFragment;
import com.example.ohana_clone.fragments.GroupFragment;
import com.example.ohana_clone.fragments.HomeFragment;
import com.example.ohana_clone.fragments.MessageFragment;
import com.example.ohana_clone.fragments.UserFragment;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
public class MainActivity extends AppCompatActivity {

    private MeowBottomNavigation bottomNavigation;

    private final static int HOME = 3;
    private final static int GROUP = 1;
    private final static int FAVORITE = 2;
    private final static int CHAT = 4;
    private final static int MANAGE_ACCOUNTS = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpBottomNavigation();
    }

    private void setUpBottomNavigation(){
        bottomNavigation = findViewById(R.id.bottomNavigation);
        bottomNavigation.add(new MeowBottomNavigation.Model(GROUP, R.drawable.baseline_group_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(FAVORITE, R.drawable.baseline_favorite_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(HOME, R.drawable.baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(CHAT, R.drawable.baseline_chat_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(MANAGE_ACCOUNTS, R.drawable.baseline_manage_accounts_24));
        bottomNavigation.show(HOME, true);
        LoadAndReplaceFragment(new HomeFragment());
        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                switch (model.getId()){
                    case HOME:
                        LoadAndReplaceFragment(new HomeFragment());
                        break;
                    case GROUP:
                        LoadAndReplaceFragment(new GroupFragment());
                        break;
                    case FAVORITE:
                        LoadAndReplaceFragment(new FavoriteFragment());
                        break;
                    case CHAT:
                        LoadAndReplaceFragment(new MessageFragment());
                        break;
                    case MANAGE_ACCOUNTS:
                        LoadAndReplaceFragment(new UserFragment());
                        break;
                    default:
                        LoadAndReplaceFragment(new HomeFragment());
                }
                return null;
            }
        });

        bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                return null;
            }
        });

    }

    private void LoadAndReplaceFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment, null)
                .commit();
    }

}