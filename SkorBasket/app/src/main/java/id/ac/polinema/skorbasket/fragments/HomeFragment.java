import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
@@ -35,6 +37,7 @@ public HomeFragment() {
@Override
public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sharedScore = ViewModelProviders.of(requireActivity()).get(SharedScore.class);
		}

@Override
@@ -53,5 +56,33 @@ public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceStat
		scoreSatuHome = view.findViewById(R.id.scoreSatuHome);

		// Tambahkan logic tombol di bagian bawah ini
		sharedScore.getScoreHome().observe(requireActivity(), new Observer<Integer>() {
@Override
public void onChanged(Integer score) {
		scoreHome.setText(String.valueOf(score));
		scoreDefault = score;
		}
		});

		scoreDuaHome.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
		sharedScore.setScoreHome(scoreDefault + 2);
		}
		});

		scoreTigaHome.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
		sharedScore.setScoreHome(scoreDefault + 3);
		}
		});

		scoreSatuHome.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
		sharedScore.setScoreHome(scoreDefault + 1);
		}
		});
		}
		}