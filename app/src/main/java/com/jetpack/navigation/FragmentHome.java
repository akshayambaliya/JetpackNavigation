package com.jetpack.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class FragmentHome extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Change default value of arg1
        final Bundle bundle = new Bundle();
        bundle.putString("arg1", "Value Change");

        //Take a default value of arg1 from navigationGraph
        Toast.makeText(getActivity().getApplicationContext(), "Bundle args " + getArguments().getString("arg1"), Toast.LENGTH_SHORT).show();
        final NavController navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);


        Button button = view.findViewById(R.id.button_frag1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_firstFragment_to_secondFragment, bundle);
            }
        });
    }

}
