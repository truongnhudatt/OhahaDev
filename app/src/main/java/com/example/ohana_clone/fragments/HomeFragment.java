package com.example.ohana_clone.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ohana_clone.R;
import com.example.ohana_clone.adapters.ImageIntroAdapter;
import com.example.ohana_clone.adapters.RoomViewAdapter;
import com.example.ohana_clone.adapters.TrendingViewAdapter;
import com.example.ohana_clone.models.Room;
import com.example.ohana_clone.models.Trending;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ViewPager2 imageIntroViewPager;

    private ImageIntroAdapter imageIntroAdapter;

    private List<Integer> listImages = new ArrayList<>();

    private List<Trending> listTrending;

    private List<Room> listRoom;

    private RecyclerView recyclerViewTrending;

    private RecyclerView recyclerViewRoom;

    private RecyclerView recyclerViewRoomMore;

    private CircleIndicator3 circleIndicator3Intro;

    private Handler handler = new Handler();

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if(imageIntroViewPager.getCurrentItem() == listImages.size() - 1){
                imageIntroViewPager.setCurrentItem(0);
            }
            else{
                imageIntroViewPager.setCurrentItem(imageIntroViewPager.getCurrentItem() + 1);
            }
        }
    };

    public HomeFragment() {

        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        listImages.add(R.drawable.image1);
        listImages.add(R.drawable.image1);
        listImages.add(R.drawable.image1);
        imageIntroAdapter = new ImageIntroAdapter(getContext(),listImages);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        imageIntroViewPager = view.findViewById(R.id.imageIntroViewPager);
        circleIndicator3Intro = view.findViewById(R.id.circleIndicator3Intro);
        imageIntroViewPager.setAdapter(imageIntroAdapter);
        circleIndicator3Intro.setViewPager(imageIntroViewPager);

        imageIntroViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 2000);
            }
        });

        setUpTrendingView(view);
        setUpRoomView(view);
        setUpRoomViewMore(view);
        return view;
    }

    private void setUpTrendingView(View view){
        listTrending = new ArrayList<>();
        listTrending.add(new Trending(R.drawable.quanhaibatrung, "Hai Bà Trưng"));
        listTrending.add(new Trending(R.drawable.quancaugiay, "Cầu Giấy"));
        listTrending.add(new Trending(R.drawable.quandongda, "Đống Đa"));
        listTrending.add(new Trending(R.drawable.quannamtuliem, "Nam Từ Liêm"));
        listTrending.add(new Trending(R.drawable.quanbactuliem, "Bắc Từ Liêm"));
        listTrending.add(new Trending(R.drawable.quanhoangmai, "Hoàng Mai"));
        TrendingViewAdapter trendingViewAdapter = new TrendingViewAdapter(getContext(), listTrending);
        recyclerViewTrending = view.findViewById(R.id.recyclerViewTrending);
        recyclerViewTrending.setAdapter(trendingViewAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        recyclerViewTrending.setLayoutManager(gridLayoutManager);

    }


    private void setUpRoomView(View view){
        listRoom = new ArrayList<>();
        listRoom.add(new Room("Phòng cho thuê 82 Yên Lãng, Quận Đống Đa", "82 Yên Lãng, Phường Thịnh Quang, Quận Đống Đa", 1, 3.2, R.drawable.image1));
        listRoom.add(new Room("CHUNG CƯ MINI NGÕ 61 LÊ VĂN LƯƠNG", "Số 37 ngõ 61 Lê Văn Lương, Phường Trung Hoà, Quận Cầu Giấy", 4, 4.3, R.drawable.image1));
        listRoom.add(new Room("NGÃ TƯ SỞ - BAN CÔNG - THOÁNG ĐẸP NHƯ Ý", "Ngõ 1/69 Nhà 8A - Phố Bùi Xương Trạch, Quận Thanh Xuân", 4, 5, R.drawable.image1));
        listRoom.add(new Room("Phòng cho thuê Ngõ 37/32 Bằng Liệt, Linh Đàm", "Ngõ 37/32 số 1 Phố Bàng Liệt, Phường Hoàng Mai, Quận Hoàng Mai", 3, 3.3, R.drawable.image1));
        listRoom.add(new Room("CHUNG CƯ MINI NGÕ 61 LÊ VĂN LƯƠNG", "Số 37 ngõ 61 Lê Văn Lương, Phường Trung Hoà, Quận Cầu Giấy", 4, 3.2, R.drawable.image1));
        listRoom.add(new Room("CHUNG CƯ MINI NGÕ 61 LÊ VĂN LƯƠNG", "Số 37 ngõ 61 Lê Văn Lương, Phường Trung Hoà, Quận Cầu Giấy", 4, 3.2, R.drawable.image1));
        listRoom.add(new Room("CHUNG CƯ MINI NGÕ 61 LÊ VĂN LƯƠNG", "Số 37 ngõ 61 Lê Văn Lương, Phường Trung Hoà, Quận Cầu Giấy", 4, 3.2, R.drawable.image1));
        listRoom.add(new Room("CHUNG CƯ MINI NGÕ 61 LÊ VĂN LƯƠNG", "Số 37 ngõ 61 Lê Văn Lương, Phường Trung Hoà, Quận Cầu Giấy", 4, 3.2, R.drawable.image1));
        listRoom.add(new Room("CHUNG CƯ MINI NGÕ 61 LÊ VĂN LƯƠNG", "Số 37 ngõ 61 Lê Văn Lương, Phường Trung Hoà, Quận Cầu Giấy", 4, 3.2, R.drawable.image1));
        listRoom.add(new Room("CHUNG CƯ MINI NGÕ 61 LÊ VĂN LƯƠNG", "Số 37 ngõ 61 Lê Văn Lương, Phường Trung Hoà, Quận Cầu Giấy", 4, 3.2, R.drawable.image1));
        RoomViewAdapter roomViewAdapter = new RoomViewAdapter(getContext(), listRoom);
        recyclerViewRoom = view.findViewById(R.id.recyclerViewRoom);
        recyclerViewRoom.setAdapter(roomViewAdapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewRoom.setLayoutManager(linearLayoutManager);
        recyclerViewRoom.addItemDecoration(itemDecoration);

    }

    private void setUpRoomViewMore(View view){
        listRoom = new ArrayList<>();
        listRoom.add(new Room("Phòng cho thuê 82 Yên Lãng, Quận Đống Đa", "82 Yên Lãng, Phường Thịnh Quang, Quận Đống Đa", 1, 3.2, R.drawable.image1));
        listRoom.add(new Room("CHUNG CƯ MINI NGÕ 61 LÊ VĂN LƯƠNG", "Số 37 ngõ 61 Lê Văn Lương, Phường Trung Hoà, Quận Cầu Giấy", 4, 4.3, R.drawable.image1));
        listRoom.add(new Room("NGÃ TƯ SỞ - BAN CÔNG - THOÁNG ĐẸP NHƯ Ý", "Ngõ 1/69 Nhà 8A - Phố Bùi Xương Trạch, Quận Thanh Xuân", 4, 5, R.drawable.image1));
        listRoom.add(new Room("Phòng cho thuê Ngõ 37/32 Bằng Liệt, Linh Đàm", "Ngõ 37/32 số 1 Phố Bàng Liệt, Phường Hoàng Mai, Quận Hoàng Mai", 3, 3.3, R.drawable.image1));
        listRoom.add(new Room("CHUNG CƯ MINI NGÕ 61 LÊ VĂN LƯƠNG", "Số 37 ngõ 61 Lê Văn Lương, Phường Trung Hoà, Quận Cầu Giấy", 4, 3.2, R.drawable.image1));
        listRoom.add(new Room("CHUNG CƯ MINI NGÕ 61 LÊ VĂN LƯƠNG", "Số 37 ngõ 61 Lê Văn Lương, Phường Trung Hoà, Quận Cầu Giấy", 4, 3.2, R.drawable.image1));
        listRoom.add(new Room("CHUNG CƯ MINI NGÕ 61 LÊ VĂN LƯƠNG", "Số 37 ngõ 61 Lê Văn Lương, Phường Trung Hoà, Quận Cầu Giấy", 4, 3.2, R.drawable.image1));
        listRoom.add(new Room("CHUNG CƯ MINI NGÕ 61 LÊ VĂN LƯƠNG", "Số 37 ngõ 61 Lê Văn Lương, Phường Trung Hoà, Quận Cầu Giấy", 4, 3.2, R.drawable.image1));
        listRoom.add(new Room("CHUNG CƯ MINI NGÕ 61 LÊ VĂN LƯƠNG", "Số 37 ngõ 61 Lê Văn Lương, Phường Trung Hoà, Quận Cầu Giấy", 4, 3.2, R.drawable.image1));
        listRoom.add(new Room("CHUNG CƯ MINI NGÕ 61 LÊ VĂN LƯƠNG", "Số 37 ngõ 61 Lê Văn Lương, Phường Trung Hoà, Quận Cầu Giấy", 4, 3.2, R.drawable.image1));
        RoomViewAdapter roomViewAdapter = new RoomViewAdapter(getContext(), listRoom, false);
        recyclerViewRoomMore = view.findViewById(R.id.recyclerViewRoomMore);
        recyclerViewRoomMore.setAdapter(roomViewAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerViewRoomMore.setLayoutManager(gridLayoutManager);
    }


    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        handler.postDelayed(runnable, 2000);
    }
}