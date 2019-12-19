import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
@@ -35,6 +37,7 @@ public VisitorFragment() {
@Override
public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sharedScore = ViewModelProviders.of(requireActivity()).get(SharedScore.class);
		}

@Override
@@ -54,5 +57,33 @@ public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceStat


		// Tambahkan logic tombol di bagian bawah ini
		sharedScore.getScoreVisitor().observe(requireActivity(), new Observer<Integer>() {
@Override
public void onChanged(Integer score) {
		scoreVisitor.setText(String.valueOf(score));
		scoreDefault = score;
		}
		});

		scoreDuaVisitor.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
		sharedScore.setScoreVisitor(scoreDefault + 2);
		}
		});

		scoreTigaVisitor.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
		sharedScore.setScoreVisitor(scoreDefault + 3);
		}
		});

		scoreSatuVisitor.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
		sharedScore.setScoreVisitor(scoreDefault + 1);
		}
		});
		}
		}