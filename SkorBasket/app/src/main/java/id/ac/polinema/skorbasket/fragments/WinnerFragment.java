import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
@@ -34,6 +36,7 @@ public WinnerFragment() {
@Override
public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sharedScore = ViewModelProviders.of(requireActivity()).get(SharedScore.class);
		}

@Override
@@ -48,5 +51,53 @@ public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceStat
		super.onViewCreated(view, savedInstanceState);
		txtWinner = view.findViewById(R.id.txtWinner);
		btnReset = view.findViewById(R.id.btnReset);

		sharedScore.getScoreVisitor().observe(requireActivity(), new Observer<Integer>() {
@Override
public void onChanged(Integer score) {
		scoreVisitor = score;
		if(scoreVisitor > scoreHome){
		sharedScore.setWinner(2);
		}
		else if(scoreVisitor == scoreHome){
		sharedScore.setWinner(3);
		}
		}
		});

		sharedScore.getScoreHome().observe(requireActivity(), new Observer<Integer>() {
@Override
public void onChanged(Integer score) {
		scoreHome = score;
		if(scoreVisitor < scoreHome){
		sharedScore.setWinner(1);
		}
		else if(scoreVisitor == scoreHome){
		sharedScore.setWinner(3);
		}
		}
		});

		sharedScore.getWinner().observe(requireActivity(), new Observer<Integer>() {
@Override
public void onChanged(Integer winner) {
		if(winner == 1){
		txtWinner.setText("Home WIN");
		}else if(winner == 2){
		txtWinner.setText("Visitor WIN");
		}
		else {
		txtWinner.setText("Score Draw");
		}
		}
		});

		btnReset.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
		sharedScore.setScoreVisitor(0);
		sharedScore.setScoreHome(0);
		}
		});
		}
		}