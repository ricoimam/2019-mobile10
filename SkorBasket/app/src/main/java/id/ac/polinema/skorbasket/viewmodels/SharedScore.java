package id.ac.polinema.skorbasket.viewmodels;

public class SharedScore {
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

    public class SharedScore extends AndroidViewModel {

        private MutableLiveData<Integer> scoreHome;
        private MutableLiveData<Integer> scoreVisitor;
        private MutableLiveData<Integer> winner;

        public SharedScore(@NonNull Application application) {
            super(application);
            scoreHome = new MutableLiveData<>();
            scoreVisitor = new MutableLiveData<>();
            winner = new MutableLiveData<>();
        }

        public void setScoreHome(Integer score){
            scoreHome.setValue(score);
        }

        public LiveData<Integer> getScoreHome(){
            return scoreHome;
        }

        public void setScoreVisitor(Integer score){
            scoreVisitor.setValue(score);
        }

        public LiveData<Integer> getScoreVisitor(){
            return scoreVisitor;
        }

        public void setWinner(Integer result){
            winner.setValue(result);
        }

        public LiveData<Integer> getWinner(){
            return winner;
        }
    }