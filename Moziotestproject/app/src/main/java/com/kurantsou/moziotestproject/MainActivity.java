package com.kurantsou.moziotestproject;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.kurantsou.moziotestproject.databinding.ActivityMainBinding;
import com.kurantsou.moziotestproject.models.Test;
import com.kurantsou.moziotestproject.models.TestAnswers;
import com.kurantsou.moziotestproject.repository.AnswersRpository;
import com.kurantsou.moziotestproject.repository.LocalRepository;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding mBinding;

    AnswersRpository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = new LocalRepository();

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        ArrayAdapter<CharSequence> migrainesAdapter = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item,
                getResources().getTextArray(R.array.answers));

        ArrayAdapter<CharSequence> sexAdapter = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item,
                getResources().getTextArray(R.array.sexes));

        ArrayAdapter<CharSequence> drugsAdapter = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item,
                getResources().getTextArray(R.array.answers));

        mBinding.sMigraines.setAdapter(migrainesAdapter);
        mBinding.sDrugs.setAdapter(drugsAdapter);
        mBinding.sSex.setAdapter(sexAdapter);

        mBinding.btSaveAnsvers.setOnClickListener(this);
        mBinding.btnBack.setOnClickListener(this);

        mBinding.viewFlipper.setInAnimation(this, R.anim.right_in);
        mBinding.viewFlipper.setOutAnimation(this, R.anim.left_out);

        updateValues();
    }

    private void updateValues() {
        if (repository == null)
            return;
        TestAnswers answers = repository.getStoredAnswers(getApplicationContext());
        if (answers == null)
            return;

        mBinding.sMigraines.setSelection(answers.getMigrainesAns() ? 0 : 1);
        mBinding.sSex.setSelection(answers.getSexAns() ? 0 : 1);
        mBinding.etAge.setText(String.valueOf(answers.getAgeAns()));
        mBinding.sDrugs.setSelection(answers.getDrugsAns() ? 0 : 1);

        Toast.makeText(this, R.string.answers_restored, Toast.LENGTH_LONG).show();
    }

    private void storeValues(TestAnswers answers){
        if (repository == null || answers == null)
            return;
        repository.storeAnswers(getApplicationContext(), answers);
        Toast.makeText(this, R.string.answers_stored, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btSaveAnsvers: {
                String ageText = mBinding.etAge.getText().toString();
                if (ageText == null || ageText.isEmpty()) {
                    Toast.makeText(this, R.string.age_not_inputed, Toast.LENGTH_LONG).show();
                    return;
                }
                int age = Integer.parseInt(ageText);
                TestAnswers answers = new TestAnswers();
                answers.setMigrainesAns(mBinding.sMigraines.getSelectedItemPosition() == 0);
                answers.setSexAns(mBinding.sSex.getSelectedItemPosition() == 0);
                answers.setAgeAns(age);
                answers.setDrugsAns(mBinding.sDrugs.getSelectedItemPosition() == 0);
                mBinding.tvResultValue.setText(String.format("%d%s", Test.getResult(answers), "%", Locale.getDefault()));
                mBinding.viewFlipper.showNext();
                storeValues(answers);
            }
            break;
            case R.id.btnBack:
                mBinding.viewFlipper.showPrevious();
                break;
        }
    }
}
